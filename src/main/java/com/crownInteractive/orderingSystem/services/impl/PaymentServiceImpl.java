package com.crownInteractive.orderingSystem.services.impl;

import com.crownInteractive.orderingSystem.models.Cart;
import com.crownInteractive.orderingSystem.models.Payment;
import com.crownInteractive.orderingSystem.repositories.CartRepo;
import com.crownInteractive.orderingSystem.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    CartRepo cartRepo;

    /** this method is for making payment.
     * @param payment object for making payment
     * @return successful
     */
    @Override
    public String makePayment(Payment payment, Long cartId) {

        Cart cart = cartRepo.findById(cartId).orElseThrow(() -> new RuntimeException("Cart with id "+cartId+" does not exist"));
        List<Integer> productPrices = Collections.singletonList(cart.getProductList().stream().findAny().get().getProductPrice());
        int sum = 0;
        for (Integer i : productPrices)
            sum += i;

        if (payment.getAmount() < sum) {
            throw new RuntimeException("Money no reach my guy, stuffs in your cart is worth "+sum);
        }
        return "Payment made successfully";
    }
}
