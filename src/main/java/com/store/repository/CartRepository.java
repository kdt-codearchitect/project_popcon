package com.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.entity.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer> {
	
}
