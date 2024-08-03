package com.store.service;

import java.util.List;

import com.store.dto.CartDTO;
import com.store.entity.CartEntity;

public interface CartService {
	List<CartDTO> findAll();

	CartDTO findById(final Integer id);


	CartEntity addToCart(CartDTO cart);
    CartEntity updateCart(CartDTO cart);
    void deleteFromCart(int cartIdx);
}
