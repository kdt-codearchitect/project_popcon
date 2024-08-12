package com.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.store.dto.PromotionDTO;

@Mapper
public interface EventCalendarMapper {

	public List<PromotionDTO> findAll();
}
