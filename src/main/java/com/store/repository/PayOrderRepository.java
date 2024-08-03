package com.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.entity.PayOrder;

@Repository
public interface PayOrderRepository extends JpaRepository<PayOrder, Integer> {
	
}
