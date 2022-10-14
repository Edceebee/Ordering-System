package com.crownInteractive.orderingSystem.services;

import com.crownInteractive.orderingSystem.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(Integer pageNo, Integer pageSize);

}
