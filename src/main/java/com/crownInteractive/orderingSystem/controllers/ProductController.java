package com.crownInteractive.orderingSystem.controllers;

import com.crownInteractive.orderingSystem.models.Product;
import com.crownInteractive.orderingSystem.responses.ApiResponse;
import com.crownInteractive.orderingSystem.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;



    @GetMapping("/allProducts")
    public ResponseEntity<?> getAllProducts(@RequestParam(defaultValue = "0") Integer pageNo,
                                         @RequestParam(defaultValue = "5") Integer pageSize) {

        try {
            List<Product> products = productService.getProducts(pageNo, pageSize);
            return new ResponseEntity<>(products, HttpStatus.FOUND);
        }
        catch (RuntimeException message) {
            return new ResponseEntity<>(new ApiResponse(message.getMessage()),
                    HttpStatus.NOT_FOUND);
        }
    }
//
//    @PutMapping("/changeQuantity")
//    public ResponseEntity<?> changeProductQuantity(@RequestParam Long productId,
//                                                   @RequestParam int newQuantity) {
//
//        try {
//            Product product = productService.changeProductQuantity(productId, newQuantity);
//            return new ResponseEntity<>(product, HttpStatus.FOUND);
//        }
//        catch (RuntimeException message) {
//            return new ResponseEntity<>(new ApiResponse(message.getMessage()),
//                    HttpStatus.NOT_FOUND);
//        }
//    }

    }
