package exercise1;

import java.util.List;

public interface OrderRepository {

    List<Order> getAll();

    Order findById(Integer id);

    Order findByCustomerPhoneEmailAddress(String customer,String phone,String email,String address);

    List<OrderItems> findItemsByOrder(Integer article);

    void create(Order order);

    void remove(String article);


}
