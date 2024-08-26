package com.store.service;

import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.store.dto.CustomerDTO;
import com.store.entity.Customer;

@Service
public interface MemService {
	 Customer registerMem(Customer mem);
	 public CustomerDTO registerCustomer(CustomerDTO customerDTO);
	 CustomerDTO findById(@Param("customerIdx") int customerIdx);
	 Customer findByUserID(String id);
	 Optional<Customer> updateCustomer(int customerIdx, Customer updatedCustomer);

	 
    }

