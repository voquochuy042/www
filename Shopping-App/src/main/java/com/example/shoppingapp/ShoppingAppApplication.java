package com.example.shoppingapp;

import com.example.shoppingapp.model.Product;
import com.example.shoppingapp.repository.ProductRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShoppingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingAppApplication.class, args);
    }

//    @Autowired
//    ProductRepository productRepository;
//    @Bean
//    CommandLineRunner commandLineRunner(){
//        Faker faker = new Faker();
//        return args -> {
//            for(int i = 0;i<10;i++){
//                Product product = Product.builder()
//                        .name(faker.commerce().productName())
//                        .price(Double.parseDouble(faker.commerce().price()))
//                        .build();
//                productRepository.save(product);
//            }
//        };
//    }
}
