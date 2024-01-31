package exercise1;

import java.util.List;

public interface ProductRepository {

    List<Product> getAll();

    Product findByArticle(String article);

    Product update(Product product);

    void remove(String article);

    Product create(Product product);

}
