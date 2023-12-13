package com.example.ontapshoppingapp;

import com.example.ontapshoppingapp.model.Product;
import com.example.ontapshoppingapp.repository.ProductRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OntapShoppingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OntapShoppingAppApplication.class, args);
	}
	@Autowired
	ProductRepository productRepository;
//	@Bean
	CommandLineRunner commandLineRunner(){
		Faker faker = new Faker();
		return args->{
			for (int i=0;i<20;i++){
				Product product =Product.builder()
						.name(faker.commerce().productName())
						.price(Double.parseDouble(faker.commerce().price()))
						.build();
				productRepository.save(product);

			}
		};
	}
}
