package com.store.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.CustomerDTO;
import com.store.entity.Customer;
import com.store.service.MemService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@AllArgsConstructor
public class CustomerController {

	
	private final MemService memService;

	
	@GetMapping("/{customerIdx}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable int customerIdx) {
        CustomerDTO customerDTO = memService.findById(customerIdx);
        return ResponseEntity.ok(customerDTO);
    }
	
    @PostMapping("/signup")
    public ResponseEntity<?> registerMem(@RequestBody Customer mem) {
    	
    	LocalDateTime time = LocalDateTime.now();
    	Timestamp t = Timestamp.valueOf(time);
    	log.info(mem.getCustomerId());
    	log.info(mem.getCustomerAdd());
    	mem.setCustomerGender(1);
    	mem.setCustomerTime(t);
    	String ecrptPW = new BCryptPasswordEncoder().encode(mem.getCustomerPw());
		mem.setCustomerPw(ecrptPW);
    	System.out.println(mem);
        try {
            Customer registeredMember = memService.registerMem(mem);
            return ResponseEntity.ok(registeredMember);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
//    	return ResponseEntity.ok(null);
    }
    
}