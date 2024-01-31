package exercise1;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nОпределите класс модели для товара; загрузите список продуктов и выведите его на экран;\n");
        ProductRepository productRepository = new ProductRepositoryImpl();
        productRepository.getAll().forEach(System.out::println);
        System.out.println("\nЗагрузка и печать списка наименований товаров заказов с заданными id; наименование товара должно включать цвет, если он задан\n");
        OrderRepository orderRepository = new OrderRepositoryImpl();
        orderRepository.findItemsByOrder(3).forEach(System.out::println);
        System.out.println("\nРегистрации заказа; атрибуты заказа задаются параметрами метода; при регистрации задаются следующие параметры:\n");
        OrderItemsRepository orderItemsRepository = new OrderItemsRepositoryImpl();
        orderItemsRepository.createOrder("Юлия Миронова","(987)812-13-14","mironova92@list.com","ул. Школьная, 34-09-2","3251616",3);
        orderItemsRepository.createOrder("Юлия Миронова","(987)812-13-14","mironova92@list.com","ул. Школьная, 34-09-2","3251620",2);
        orderItemsRepository.createOrder("Юлия Миронова","(987)812-13-14","mironova92@list.com","ул. Школьная, 34-09-2","3251619",1);
































        //        String url = "jdbc:mysql://localhost:3306/dev_j130_1lab";
//        String user = "root";
//        String password = "Pavlov081192";
//
//        try {
//            Connection connection = DriverManager.getConnection(url,user,password);
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select  * from  orders join order_items on id=order_entry_code join products on article=product_article;");
//
//            while (resultSet.next()){
//
//                System.out.print(resultSet.getString("article"));
//                System.out.print(" "+ resultSet.getString(2));
//                System.out.print(" "+ resultSet.getString(3));
//                System.out.print(" "+ resultSet.getString(4));
//                System.out.println(" "+ resultSet.getString(5));
//
//            }
//
//        } catch (SQLException e){
//            e.printStackTrace();
//        }





    }
}
