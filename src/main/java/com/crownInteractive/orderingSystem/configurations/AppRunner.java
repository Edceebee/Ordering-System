package com.crownInteractive.orderingSystem.configurations;

import com.crownInteractive.orderingSystem.models.Product;
import com.crownInteractive.orderingSystem.repositories.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class seeds the database using command line runner.
 */
@Configuration
public class AppRunner {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepo productRepo) {
        return (args) -> {

            Product product1 = Product.builder().productName("Fanta").productDescription("Juicy drink").
                    productPrice(200).productQuantity(0).build();
            Product product2 = Product.builder().productName("Orange").productDescription("sweet fruit").
                    productPrice(50).productQuantity(0).build();
            Product product3 = Product.builder().productName("canvas").productDescription("comfy footwear").
                    productPrice(10000).productQuantity(0).build();
            Product product4 = Product.builder().productName("power bank").productDescription("long lasting charger").
                    productPrice(12000).productQuantity(0).build();
            Product product5 = Product.builder().productName("Hp laptop").productDescription("latest pc").
                    productPrice(200000).productQuantity(0).build();

            productRepo.save(product1);
            productRepo.save(product2);
            productRepo.save(product3);
            productRepo.save(product4);
            productRepo.save(product5);

        };
    }
}
