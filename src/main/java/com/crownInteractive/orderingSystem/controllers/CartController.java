package com.crownInteractive.orderingSystem.controllers;

import com.crownInteractive.orderingSystem.models.Cart;
import com.crownInteractive.orderingSystem.models.dto.ProductDto;
import com.crownInteractive.orderingSystem.responses.ApiResponse;
import com.crownInteractive.orderingSystem.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CartController {

    @Autowired
    CartService cartService;


    @PostMapping("/createCart")
    public ResponseEntity<?> createCart(@RequestParam String cartName) {
        try {
            Cart createCart = cartService.createCart(cartName);
            return new ResponseEntity<>(createCart, HttpStatus.CREATED);

        } catch (RuntimeException message) {
            return new ResponseEntity<>(new ApiResponse(message.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/addToCart")
    public ResponseEntity<?> addProductToCart(@RequestParam Long cartId,
                                              @RequestBody List<ProductDto> productDto) {
        try {
            Cart createCart = cartService.addProductToCart(cartId, productDto);
            return new ResponseEntity<>(createCart, HttpStatus.OK);

        } catch (RuntimeException message) {
            return new ResponseEntity<>(new ApiResponse(message.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/cartById")
    public ResponseEntity<?> getCartById(@RequestParam Long cartId) {
        try {
            Cart allCarts = cartService.getCartById(cartId);
            return new ResponseEntity<>(allCarts, HttpStatus.OK);

        } catch (RuntimeException message) {
            return new ResponseEntity<>(new ApiResponse(message.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
