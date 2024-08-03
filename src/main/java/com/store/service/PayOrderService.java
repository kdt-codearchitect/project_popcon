package com.store.service;

import java.util.List;

import com.store.dto.PayOrderDTO;
import com.store.entity.PayOrder;

public interface PayOrderService {
	List<PayOrderDTO> findAll();
	PayOrder save(PayOrder payOrder);
    void deleteById(int id);
	
}
