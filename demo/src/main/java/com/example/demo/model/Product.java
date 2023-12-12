package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NamedQueries(
    @NamedQuery(
    name="Product.getAllByCategoryId",
    query ="select p from Product p where p.category.id =:id"
    )
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Min(0)
    private double price;
    @ManyToOne
    private Category category;
}
