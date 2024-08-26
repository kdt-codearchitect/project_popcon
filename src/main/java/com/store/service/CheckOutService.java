package com.store.service;

import java.util.List;

import com.store.dto.CartItemDTO;
import com.store.dto.CheckOutDTO;

public interface CheckOutService {
	
	List<CheckOutDTO> findCustomer(int customerIdx);  //유저 정보불러오기
	List<CartItemDTO> findCart(int customerIdx, List<Integer> skuIdxList);
	
}
