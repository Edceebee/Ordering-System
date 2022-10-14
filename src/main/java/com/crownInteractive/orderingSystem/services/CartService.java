package com.crownInteractive.orderingSystem.services;

import com.crownInteractive.orderingSystem.models.Cart;
import com.crownInteractive.orderingSystem.models.dto.ProductDto;

import javax.transaction.Transactional;
import java.util.List;

public interface CartService {

    Cart createCart(String cartName);

    Cart getCartById(Long cartId);

    Cart addProductToCart(Long cartId, List<ProductDto> productDtos);
}
