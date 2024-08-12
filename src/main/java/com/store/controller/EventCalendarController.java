package com.store.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.PromotionDTO;
import com.store.service.EventCalendarService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class EventCalendarController {

	EventCalendarService eventcalserv;
	
	
	public EventCalendarController(EventCalendarService eventcalserv) {
		this.eventcalserv = eventcalserv;
	}


	@GetMapping("/event-calendar")
    public ResponseEntity<List<PromotionDTO>> findAll() {
		log.info("test");
        List<PromotionDTO> list = eventcalserv.findAll();
        return ResponseEntity.ok(list);
    }
}
