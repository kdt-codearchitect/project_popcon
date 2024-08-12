package com.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.store.dto.PromotionDTO;
import com.store.mapper.EventCalendarMapper;

@Service
public class EventCalendarServiceImpl implements EventCalendarService {

	 private final EventCalendarMapper eventmapper;
	 
	public EventCalendarServiceImpl(EventCalendarMapper eventmapper) {
		this.eventmapper = eventmapper;
	}

	@Override
	public List<PromotionDTO> findAll() {
		return eventmapper.findAll();
	}

}
