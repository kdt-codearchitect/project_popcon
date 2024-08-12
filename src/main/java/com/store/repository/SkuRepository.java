package com.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.entity.Customer;
import com.store.entity.Sku;

@Repository
public interface SkuRepository extends JpaRepository<Sku, Integer> {
	 Optional<Sku> findById(int skuIdx);
}
