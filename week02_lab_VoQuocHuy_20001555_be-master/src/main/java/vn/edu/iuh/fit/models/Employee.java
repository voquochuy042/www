package vn.edu.iuh.fit.models;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
import vn.edu.iuh.fit.enums.EmployeeStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employee")
//@NamedQueries({
//        @NamedQuery(name = "Employee.getAll", query = "FROM Employee"),
//
//})
@NamedQuery(
        name = "Employee.selectStatus",
        query = "SELECT e.status FROM Employee e WHERE e.id = :id"
)

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id",columnDefinition = "BIGINT(20)")
    private Long id;
    @Column(name = "address",length = 250,nullable = false)
    private String address;
    @Column(name = "dob",nullable = false)
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDateTime dob;
    @Column(name = "email",unique = true,length = 150)
    private String email;
    @Column(name = "full_name",columnDefinition = "varchar(150)")
    private String fullName;
    @Column(name = "phone",length = 15,nullable = false)
    private String phone;
    @Column(name = "status", columnDefinition = "int(11)")
    @Enumerated(EnumType.ORDINAL)

    private EmployeeStatus status;
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Order> orderList;

    public Employee() {
    }

    public Employee(Long id, String address, LocalDateTime dob, String email, String fullName, String phone, EmployeeStatus status, List<Order> orderList) {
        this.id = id;
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.status = status;
        this.orderList = orderList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", orderList=" + orderList +
                '}';
    }
}
