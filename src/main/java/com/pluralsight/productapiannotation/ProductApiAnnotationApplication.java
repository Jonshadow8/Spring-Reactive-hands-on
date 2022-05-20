package com.pluralsight.productapiannotation;

import com.pluralsight.productapiannotation.model.Product;
import com.pluralsight.productapiannotation.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ProductApiAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApiAnnotationApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ProductRepository productRepository) {
		return args -> {
			Flux.just(new Product(null, "JPMC Big Latte", 5.99),
							new Product(null, "JPMC Hot Chocolate", 2.49),
							new Product(null, "JPMC Green Tea", 8.99))
					.flatMap(productRepository::save)
					.subscribe();
		};
	}

}
