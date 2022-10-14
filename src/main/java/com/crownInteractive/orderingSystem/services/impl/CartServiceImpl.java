package com.crownInteractive.orderingSystem.services.impl;

import com.crownInteractive.orderingSystem.models.Cart;
import com.crownInteractive.orderingSystem.models.Product;
import com.crownInteractive.orderingSystem.models.dto.ProductDto;
import com.crownInteractive.orderingSystem.repositories.CartRepo;
import com.crownInteractive.orderingSystem.repositories.ProductRepo;
import com.crownInteractive.orderingSystem.services.CartService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CartServiceImpl implements CartService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    CartRepo cartRepo;

    @Autowired
    ModelMapper modelMapper;


    /**
     * method to create a cart
     * @param cartName used in creating a cart
     * @return created cart
     */
    @Override
    public Cart createCart(String cartName) {
        Cart newCart = Cart.builder().CartName(cartName).build();
        cartRepo.save(newCart);
        return newCart;
    }


    /**
     * method to retrieve cart with id given
     * @param cartId used for retrieving cart
     * @return found cart
     */
    @Override
    public Cart getCartById(Long cartId) {
       Cart foundCarts = cartRepo.findById(cartId).orElseThrow(() -> new RuntimeException("cart with "+cartId+" not found"));
       return foundCarts;
    }


    /**
     * method to add a list of product to a cart
     * @param cartId used for identifying cart to save to
     * @param productDtos used for identifying products to be added to cart
     * @return found cart
     */
    @Override
    public Cart addProductToCart(Long cartId, List<ProductDto> productDtos) {

        Cart foundCart = cartRepo.findById(cartId).orElseThrow(() -> new RuntimeException("Cart with "+cartId+" not present"));

        List<Product> productList = foundCart.getProductList();

        productList = productDtos.stream().map(productDto -> modelMapper.map(productDto, Product.class))
                .collect(Collectors.toList());

        productDtos.forEach(productDto -> {
                 Product foundProduct = productRepo.findByProductName(productDto.getProductName()).
                          orElseThrow(() -> new RuntimeException("Product "+productDto.getProductName()+" not found"));
                 log.info("found product --> {}", foundProduct);
                 modelMapper.map(productDto, foundProduct);
                }
            );

        foundCart.setProductList(productList);
        foundCart.setSizeOfCart(productDtos.size());
        cartRepo.save(foundCart);
        return foundCart;

    }

    }
