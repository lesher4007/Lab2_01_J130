package exercise1;

import java.util.Objects;

public class OrderItems {
    private Order order;
    private Product product;
    private Integer price;
    private Integer amount;

    public OrderItems(Order order, Product product, Integer price, Integer amount) {
        this.order = order;
        this.product = product;
        this.price = price;
        this.amount = amount;
    }

    public OrderItems() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItems that = (OrderItems) o;
        return order.equals(that.order) && product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }

    @Override
    public String toString() {
        return "id = " + order.getId() +
                ", " + product +
                ", price=" + price +
                ", amount=" + amount +
                ' ';
    }
}
