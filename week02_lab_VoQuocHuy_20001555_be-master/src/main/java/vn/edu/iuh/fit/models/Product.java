package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.enums.ProductStatus;

import java.util.List;

@Entity
@Table(name = "product")
@NamedQuery(
        name = "Order.getAll",
        query = "SELECT p FROM Product p"
)
@NamedQuery(
        name = "Product.updateStatus",
        query = "UPDATE Product p SET p.status = :status WHERE p.id = :id"
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    private String description;
    @Column(name = "manufacturer_name",columnDefinition = "varchar(100)")
    private String manufacturer;
    @Column(columnDefinition = "varchar(150)")
    private String name;
    @Column(columnDefinition = "int(11)")
    private ProductStatus status;
    private String unit;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<ProductPrice> productPriceList;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<ProductImage> productImageList;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetailList;

    public Product(Long id, String description, String manufacturer,
                   String name, ProductStatus status, String unit,
                   List<ProductPrice> productPriceList, List<ProductImage> productImageList,
                   List<OrderDetail> orderDetailList) {
        this.id = id;
        this.description = description;
        this.manufacturer = manufacturer;
        this.name = name;
        this.status = status;
        this.unit = unit;
        this.productPriceList = productPriceList;
        this.productImageList = productImageList;
        this.orderDetailList = orderDetailList;
    }

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<ProductPrice> getProductPriceList() {
        return productPriceList;
    }

    public void setProductPriceList(List<ProductPrice> productPriceList) {
        this.productPriceList = productPriceList;
    }

    public List<ProductImage> getProductImageList() {
        return productImageList;
    }

    public void setProductImageList(List<ProductImage> productImageList) {
        this.productImageList = productImageList;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
