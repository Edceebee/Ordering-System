package com.crownInteractive.orderingSystem.repositories;

import com.crownInteractive.orderingSystem.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {
}
