package com.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.dto.PayOrderDTO;
import com.store.entity.PayOrder;
import com.store.mapper.PayOrderMapper;
import com.store.repository.PayOrderRepository;

@Service
public class PayOrderServiceImpl implements PayOrderService{

	  private final PayOrderRepository payOrderRepository;
	    private final PayOrderMapper payOrderMapper;

	    @Autowired
	    public PayOrderServiceImpl(PayOrderRepository payOrderRepository, PayOrderMapper payOrderMapper) {
	        this.payOrderRepository = payOrderRepository;
	        this.payOrderMapper = payOrderMapper;
	    }

	    @Override
	    public List<PayOrderDTO> findAll() {
	        return payOrderMapper.findAll();
	    }

	    @Override
	    public PayOrder save(PayOrder payOrder) {
	        return payOrderRepository.save(payOrder);
	    }

	    @Override
	    public void deleteById(int id) {
	        payOrderRepository.deleteById(id);
	    }
		
}
	

	

