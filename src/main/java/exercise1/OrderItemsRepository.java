package exercise1;

import java.util.List;

public interface OrderItemsRepository {

    List<OrderItems> getAll();

    OrderItems findByArticleAndId(Integer id,String article);

    OrderItems update(OrderItems orderItems);

    void remove(String article);

    void createOrder(String customer,String phone,String email,String address,String productArticle, Integer amount);
}
