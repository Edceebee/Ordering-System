package com.crownInteractive.orderingSystem.repositories;

import com.crownInteractive.orderingSystem.models.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepo extends JpaRepository<Checkout, Long> {
}
