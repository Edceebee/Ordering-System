package com.crownInteractive.orderingSystem.controllers;

import com.crownInteractive.orderingSystem.models.Payment;
import com.crownInteractive.orderingSystem.models.dto.PaymentDto;
import com.crownInteractive.orderingSystem.responses.ApiResponse;
import com.crownInteractive.orderingSystem.services.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/makePayment")
    public ResponseEntity<?> makePayment(@RequestBody PaymentDto paymentDto,
                                         @RequestParam Long cartId) {

        try {
            Payment paymentMapper = modelMapper.map(paymentDto, Payment.class);
            String pay = paymentService.makePayment(paymentMapper, cartId);
            return new ResponseEntity<>(pay, HttpStatus.OK);
        }
        catch (RuntimeException message) {
            return new ResponseEntity<>(new ApiResponse(message.getMessage()),
                    HttpStatus.EXPECTATION_FAILED);
        }
    }
}
