package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_image")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long imageId;
    private String alternative;
    private String path;
    @Id
    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;

    public ProductImage() {
    }

    public ProductImage(Long imageId, String alternative, String path, Product product) {
        this.imageId = imageId;
        this.alternative = alternative;
        this.path = path;
        this.product = product;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
