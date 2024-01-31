package exercise1;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository{
    String url = "jdbc:mysql://localhost:3306/dev_j130_1lab";
    String user = "root";
    String password = "Pavlov081192";

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public Order findById(Integer id) {
        Order order=null;
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("select * from orders where id="+ id);
            resultSet.next();
            Date dateOfCreation = resultSet.getDate("date_of_creation");
            String customer = resultSet.getString("customer");
            String phone = resultSet.getString("phone");
            String email = resultSet.getString("email");
            String address = resultSet.getString("address");
            String orderStatus = resultSet.getString("order_status");
            Date orderShipmentDate = resultSet.getDate("order_shipment_date");
            order = new Order(id, dateOfCreation, customer, phone, email, address, orderStatus, orderShipmentDate);
        }catch (SQLException e){
        }
        return order;
    }

    @Override
    public Order findByCustomerPhoneEmailAddress(String customer, String phone, String email, String address) {
        Order order=null;
        String sql = "select  * from  orders  where customer= ? and phone =? and email =? and address=?";
        try (Connection connection =getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,customer);
            ps.setString(2,phone);
            ps.setString(3,email);
            ps.setString(4,address);
            ResultSet rs =ps.executeQuery();
            if(rs.next()){
                Integer id = rs.getInt("id");
                String customer1 = rs.getString("customer");
                String phone1 = rs.getString("phone");
                String email1 = rs.getString("email");
                String address1 = rs.getString("address");
                order = new Order(id,customer1,phone1,email1,address1);
            }
        }catch (SQLException e){
        }
        return order;
    }

    @Override
    public List<OrderItems> findItemsByOrder(Integer id) {
        List<OrderItems> orderItems = new LinkedList<>();
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("select  * from  orders join order_items on id=order_entry_code join products on article=product_article where id="+ id);
            while (resultSet.next()) {

                OrderItemsRepository orderItemsRepository = new OrderItemsRepositoryImpl();
                orderItems.add(orderItemsRepository.findByArticleAndId(id,resultSet.getString("product_article")));
            }
        }catch (SQLException e){
        }
        return orderItems;
    }

    @Override
    public void create(Order order) {
        String sql ="insert into orders (date_of_creation,customer, phone, email, address,order_status) value (?,?,?,?,?,?);";
        try(Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setDate(1, order.getDateOfCreation());
            ps.setString(2, order.getCustomer());
            ps.setString(3, order.getPhone());
            ps.setString(4, order.getEmail());
            ps.setString(5, order.getAddress());
            ps.setString(6, order.getOrderStatus());
            ps.execute();
        }catch (SQLException e){
        }
        System.out.println("Клиент создан");
    }

    @Override
    public void remove(String article) {
    }

    private Connection getConnection ()throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }
}
