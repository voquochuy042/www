package com.fit.se.repositories;

import com.fit.se.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProducts();

    @Query("select  p from  Product p where p.name like %:keyword% or p.description like %:keyword%")
    List<Product> findByKeyWord(@Param("keyword") String keyword);
}
