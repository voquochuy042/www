package com.fit.se;

import com.fit.se.models.Category;
import com.fit.se.models.Product;
import com.fit.se.repositories.CategoryRepository;
import com.fit.se.repositories.ProductRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class CkCoHaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CkCoHaApplication.class, args);
	}

	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ProductRepository productRepository;

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return args -> {
			Faker faker = new Faker();
			Random random = new Random();
			for (int i = 1; i <= 10; i++) {
				long categoryId = random.nextInt(3) + 1; // Generate a random category id in the range [1, 3]

				Category category = Category.builder().id(categoryId).name(faker.commerce().productName()).build();
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
