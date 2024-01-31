package exercise1;

import java.util.List;
import java.util.Objects;

public class Product {
    private String article;
    private String productName;
    private String color;
    private Integer price;
    private Integer balanceInStock;

    private List<OrderItems> orderItems;

    public Product() {
    }

    public Product(String article, String productName, String color, Integer price, Integer balanceInStock) {
        this.article = article;
        this.productName = productName;
        this.color = color;
        this.price = price;
        this.balanceInStock = balanceInStock;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getBalanceInStock() {
        return balanceInStock;
    }

    public void setBalanceInStock(Integer balanceInStock) {
        this.balanceInStock = balanceInStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(article, product.article) && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article, productName);
    }

    @Override
    public String toString() {
        return "{" +
                "article=" + article +
                ", productName='" + productName + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", balanceInStock=" + balanceInStock +
                '}';
    }
}
