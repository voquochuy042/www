package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@NamedQuery(
        name = "Product.getAll",
        query = "SELECT o FROM Order o"
)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id",columnDefinition = "bigint(20)")
    private Long id;
    private LocalDateTime orderDate;
    @ManyToOne
    @JoinColumn(name = "employee_id",columnDefinition = "BIGINT(20)")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;
    public Order() {
    }

    public Order(Long id, LocalDateTime orderDate, Employee employee, Customer customer) {
        this.id = id;
        this.orderDate = orderDate;
        this.employee = employee;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
