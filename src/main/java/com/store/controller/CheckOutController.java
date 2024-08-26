package com.store.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.CartDTO;
import com.store.dto.CartItemDTO;
import com.store.dto.CheckOutDTO;
import com.store.dto.SkuDTO;
import com.store.service.CartService;
import com.store.service.CheckOutService;
import com.store.service.SkuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
public class CheckOutController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private  CheckOutService checkOutService;
	
	    @Autowired
	    public CheckOutController(CheckOutService checkOutService) {
	        this.checkOutService = checkOutService;
	    }
	
		//유저 정보 불러오기

	    @GetMapping("/findCustomer/{customerIdx}")
	    public List<CheckOutDTO> findCustomer(@PathVariable int customerIdx) {
	        return checkOutService.findCustomer(customerIdx);
	    }
	    
	    // 장바구니 불러오기
	    @GetMapping("/findCart/{customerIdx}")
	    public List<CartItemDTO> findCart(@PathVariable int customerIdx, @RequestParam(required = false) List<Integer> skuIdxList) {
	        List<CartItemDTO> cartItems = checkOutService.findCart(customerIdx, skuIdxList);
	        return cartItems;
	    }
	 

}













