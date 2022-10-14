package com.crownInteractive.orderingSystem.services.impl;

import com.crownInteractive.orderingSystem.models.Cart;
import com.crownInteractive.orderingSystem.models.Product;
import com.crownInteractive.orderingSystem.repositories.CartRepo;
import com.crownInteractive.orderingSystem.repositories.ProductRepo;
import com.crownInteractive.orderingSystem.services.CartService;
import com.crownInteractive.orderingSystem.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private CartService cartService;

    /**
     * method to list products in batches.
     * @return a list of Product
     */
    @Override
    public List<Product> getProducts(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Product> foundResult = productRepo.findAll(paging);

        if(foundResult.hasContent()) {
            return foundResult.getContent();
        } else {
            throw new RuntimeException("page not found");
        }
    }



}
