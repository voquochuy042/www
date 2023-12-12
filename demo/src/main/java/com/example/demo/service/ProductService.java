package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public List<Product> getAllProductByCategory(long id){
        return productRepository.getAllByCategoryId(id);
    }
    public void insert(Product product){productRepository.save(product);}
    public void deleteProduct(long id){productRepository.deleteById(id);}
    public void updateProduct(Product p) {productRepository.save(p);}
}
