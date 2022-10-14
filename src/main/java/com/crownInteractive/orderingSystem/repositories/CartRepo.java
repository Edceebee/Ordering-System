package com.crownInteractive.orderingSystem.repositories;

import com.crownInteractive.orderingSystem.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {


}
