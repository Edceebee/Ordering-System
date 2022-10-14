package com.crownInteractive.orderingSystem.services;

import com.crownInteractive.orderingSystem.models.Payment;
import com.crownInteractive.orderingSystem.models.dto.PaymentDto;

public interface PaymentService {

    String makePayment(Payment payment, Long cartId);
}
