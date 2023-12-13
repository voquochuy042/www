package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id",columnDefinition = "BIGINT(20)")
    private Long id;
    private String address;
    @Column(name = "email",unique = true,length = 150)
    private String email;
    @Column(name = "cust_name",unique = true,length = 150)
    private String name;
    @Column(name = "phone",unique = true,columnDefinition = "varchar(15)")
    private String phone;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Order> orderList;

    public Customer() {
    }

    public Customer(Long id, String address, String email, String name, String phone, List<Order> orderList) {
        this.id = id;
        this.address = address;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.orderList = orderList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", orderList=" + orderList +
                '}';
    }
}
