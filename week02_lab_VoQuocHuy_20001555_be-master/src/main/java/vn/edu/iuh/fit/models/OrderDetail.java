package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
    private String note;
    private Double price;
    private Double quantity;
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Id
    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;

    public OrderDetail() {
    }

    public OrderDetail(String note, Double price, Double quantity, Order order, Product product) {
        this.note = note;
        this.price = price;
        this.quantity = quantity;
        this.order = order;
        this.product = product;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
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
}
