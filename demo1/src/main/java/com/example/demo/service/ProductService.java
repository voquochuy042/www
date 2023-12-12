package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public List<Product> getAllByCategoryId(long id){
        return productRepository.getAllByCategoryId(id);
    }
    public void insertProduct(Product product){
         productRepository.save(product);
    }
    public void deleteProduct(long id){
        productRepository.deleteById(id);
    }
    public void updateProduct(Product product){
        productRepository.save(product);
    }
}
