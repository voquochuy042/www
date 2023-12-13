package com.example.ontapshoppingapp.repository;

import com.example.ontapshoppingapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
