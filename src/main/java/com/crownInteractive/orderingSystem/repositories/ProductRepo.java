package com.crownInteractive.orderingSystem.repositories;

import com.crownInteractive.orderingSystem.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    Page<Product> findAll(Pageable pageable);

    Optional<Product> findByProductName(String productName);

}
