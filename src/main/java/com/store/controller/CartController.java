package com.store.controller;


import com.store.dto.CartDTO;
import com.store.entity.CartEntity;
import com.store.service.CartService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private final CartService cartService;

	@GetMapping("/Cart/{cartIdx}")
	public CartDTO getCart(@RequestParam Integer cartIdx) {
		return cartService.findById(cartIdx);
	}

	@PostMapping("/Cart")
	public ResponseEntity<CartDTO> createCart(@RequestBody CartDTO cartDto) {
		return null;
	}

	@PutMapping("/Cart/{cartIdx}/add")
	public ResponseEntity<CartEntity> addToCart(@RequestBody List<CartDTO.CartItemDTO> cartItemDTOList) {
		// delete and create : 기존 리스트 삭제 후 새로운 리스트 추가  -->  이 방법 추천
		// update : 기존 리스트와 비교해서, 갱신하는 방법

		return null;
	}
}













