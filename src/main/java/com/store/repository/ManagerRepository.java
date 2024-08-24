package com.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.entity.CustomerQna;
import com.store.entity.ManagerQna;

@Repository
public interface ManagerRepository extends JpaRepository<ManagerQna, Integer>{

	ManagerQna findByCustomerQna(CustomerQna customerQna);
}
