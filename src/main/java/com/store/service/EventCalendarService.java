package com.store.service;

import java.util.List;

import com.store.dto.PromotionDTO;

public interface EventCalendarService {
	List<PromotionDTO> findAll();
}
