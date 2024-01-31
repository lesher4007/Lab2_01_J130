package exercise1;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository{
    String url = "jdbc:mysql://localhost:3306/dev_j130_1lab";
    String user = "root";
    String password = "Pavlov081192";

    @Override
    public List<Product> getAll() {
        List<Product> products = new LinkedList<>();
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("select * from products");
            while (resultSet.next()){
                String article = resultSet.getString("article");
                String productName = resultSet.getString("product_Name");
                String color = resultSet.getString("color");
                Integer price = resultSet.getInt("price");
                Integer balanceInStock = resultSet.getInt("balance_In_Stock");
                products.add(new Product(article,productName,color,price,balanceInStock));
            }
        }catch (SQLException e){
        }
        return products;
    }

    @Override
    public Product findByArticle(String article) {
        Product product=null;
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("select * from products where article="+ article);
            resultSet.next();
            String productName = resultSet.getString("product_Name");
            String color = resultSet.getString("color");
            Integer price = resultSet.getInt("price");
            Integer balanceInStock = resultSet.getInt("balance_In_Stock");
            product = new Product(article,productName,color,price,balanceInStock);
        }catch (SQLException e){
        }
        return product;
    }

    @Override
    public Product update(Product product) {
        String sql ="update products set color=?,price=?,balance_in_stock=? where  article=?";
        try(Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(4, product.getArticle());
            ps.setString(1, product.getColor());
            ps.setInt(2, product.getPrice());
            ps.setInt(3, product.getBalanceInStock());
            ps.execute();
        }catch (SQLException e){
        }
        return findByArticle(product.getArticle());

    }

    @Override
    public void remove(String article) {

    }

    @Override
    public Product create(Product product) {
        return null;
    }

    private Connection getConnection ()throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }
}
