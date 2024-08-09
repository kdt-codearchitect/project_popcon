package com.store.mapper;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.store.dto.CartDTO;
import com.store.dto.CheckOutDTO;
import com.store.dto.SkuDTO;

@Mapper
public interface CheckOutMapper {
	
	 List<CheckOutDTO> findCustomer(int customerIdx);
	 List<CheckOutDTO> findCart(int customerIdx);
}

