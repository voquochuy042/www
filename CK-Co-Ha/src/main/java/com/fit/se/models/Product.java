package com.fit.se.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(
                name = "Product.findAllByCategory",
                query = "select p from Product p where p.category.id =: id"
        )
})
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "product_name",nullable = false)
    @NotEmpty
    private String name;
    @Min(0)
    private double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
