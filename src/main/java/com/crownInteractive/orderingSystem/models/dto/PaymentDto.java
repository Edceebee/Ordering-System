package com.crownInteractive.orderingSystem.models.dto;

import lombok.Data;

@Data
public class PaymentDto {

    private String paymentMethod;

    private int amount;
}
