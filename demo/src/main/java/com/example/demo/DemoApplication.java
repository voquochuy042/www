package com.example.demo;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.xml.catalog.Catalog;
import java.util.Random;

@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;
//    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {

            Faker faker = new Faker();
            Random random = new Random();
            for (int i=1;i<=10;i++){
                long id = random.nextInt(3)+1;
                Category category = Category.builder().id(id)
                        .name(faker.cannabis().categories())
                                .build();
                categoryRepository.save(category);
                Product product = Product.builder()
                        .name(faker.commerce().productName())
                        .price(Double.parseDouble((faker.commerce().price())))
                        .category(category)
                        .build();

                productRepository.save(product);
            }

        };
    }
}
