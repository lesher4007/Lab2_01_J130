package exercise1;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class OrderItemsRepositoryImpl implements OrderItemsRepository {
    String url = "jdbc:mysql://localhost:3306/dev_j130_1lab";
    String user = "root";
    String password = "Pavlov081192";

    @Override
    public List<OrderItems> getAll() {
        return null;
    }

    @Override
    public OrderItems findByArticleAndId(Integer id,String article) {
        OrderItems orderItems=null;
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery("select  * from  order_items  where order_entry_code = "+id+" and product_article ="+article);
            rs.next();
            OrderRepository orderRepository = new OrderRepositoryImpl();
            Order orderEntryCode = orderRepository.findById(id);
            ProductRepository productRepository = new ProductRepositoryImpl();
            Product productArticle = productRepository.findByArticle(article);
            Integer price = rs.getInt("price");
            Integer amount = rs.getInt("amount");
            orderItems = new OrderItems(orderEntryCode,productArticle,price,amount);


        }catch (SQLException e){
        }
        return orderItems;
    }

    @Override
    public OrderItems update(OrderItems orderItems) {
        return null;
    }

    @Override
    public void remove(String article) {

    }

    @Override
    public void createOrder(String customer,String phone,String email,String address,String productArticle, Integer amount) {
        OrderRepository orderRepository = new OrderRepositoryImpl();
        Order order = null;
        if (orderRepository.findByCustomerPhoneEmailAddress(customer,phone,email,address)==null) {
            order = new Order();
            order.setDateOfCreation(new Date(124, 1, 25));
            order.setCustomer(customer);
            order.setPhone(phone);
            order.setEmail(email);
            order.setAddress(address);
            order.setOrderStatus("P");
            orderRepository.create(order);
        }else {
            order=orderRepository.findByCustomerPhoneEmailAddress(customer,phone,email,address);
        }
            String sql = "insert into order_items (order_entry_code, product_article, price, amount) value (?,?,?,?)";
            try (Connection connection =getConnection();
                 PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1,order.getId());
                ps.setString(2,productArticle);
                ProductRepository productRepository = new ProductRepositoryImpl();
                ps.setInt(3,productRepository.findByArticle(productArticle).getPrice());
                ps.setInt(4,amount);

                ps.execute();
                System.out.println("Ордер "+ order.getId()+" создан");


            }catch (SQLException e){

            }



    }

    private Connection getConnection ()throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }
}
