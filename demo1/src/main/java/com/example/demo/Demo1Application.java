package com.example.demo;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;
//    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            Faker faker = new Faker();
            Random random = new Random();
            for (int i=1;i<30;i++){
                long id = random.nextInt(3)+1;
                Category category = Category.builder().id(id)
                        .name(faker.commerce().productName())
                        .build();
                categoryRepository.save(category);
                Product product = Product.builder()
                        .name(faker.commerce().productName())
                        .price(Double.parseDouble(faker.commerce().price()))
                        .category(category)
                        .build();
                productRepository.save(product);
            }
        };
    }
}
