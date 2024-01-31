package exercise1;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class Order {
    private Integer id;
    private Date dateOfCreation;
    private String customer;
    private String phone;
    private String email;
    private String address;
    private String orderStatus;
    private Date orderShipmentDate;
    private List<OrderItems> orderItems;

    public Order(Integer id, Date dateOfCreation, String customer, String phone, String email, String address, String orderStatus, Date orderShipmentDate, List<OrderItems> orderItems) {
        this.id = id;
        this.dateOfCreation = dateOfCreation;
        this.customer = customer;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.orderStatus = orderStatus;
        this.orderShipmentDate = orderShipmentDate;
        this.orderItems = orderItems;
    }

    public Order(Integer id, Date dateOfCreation, String customer, String phone, String email, String address, String orderStatus, Date orderShipmentDate) {
        this.id = id;
        this.dateOfCreation = dateOfCreation;
        this.customer = customer;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.orderStatus = orderStatus;
        this.orderShipmentDate = orderShipmentDate;
    }

    public Order(Integer id, String customer, String phone, String email, String address) {
        this.id = id;
        this.customer = customer;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderShipmentDate() {
        return orderShipmentDate;
    }

    public void setOrderShipmentDate(Date orderShipmentDate) {
        this.orderShipmentDate = orderShipmentDate;
    }

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(customer, order.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateOfCreation=" + dateOfCreation +
                ", customer='" + customer + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderShipmentDate=" + orderShipmentDate +
                '}';
    }
}
