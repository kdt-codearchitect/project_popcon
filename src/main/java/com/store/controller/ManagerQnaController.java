package com.store.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.QnaDTO;
import com.store.entity.ManagerQna;
import com.store.service.ManageQnaService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ManagerQnaController {

	ManageQnaService manageQnaService;
	
	public ManagerQnaController(ManageQnaService manageQnaService) {
		this.manageQnaService = manageQnaService;
	}


	// 모든 문의내역 조회
	@GetMapping("/allinquiries")
	public ResponseEntity<?> FindAllQna(){
		//유저들의 문의 내역 불러오기 
		List<QnaDTO> QnaList = manageQnaService.findAllQna();
		return ResponseEntity.ok(QnaList);
	}
	
	@PutMapping("/ans/{CustomerId}/{qnaIdx}")
	public ResponseEntity<?> PostMyAns(
									   @PathVariable String CustomerId,
									   @PathVariable int qnaIdx, 
		  	   						   @Valid @RequestBody ManagerQna qna,
		  	   						   BindingResult bindingResult) {
		
		// 유효성 검사 결과 확인
		if(bindingResult.hasErrors()) {
		// 오류가 있을 경우, 에러 메시지를 반환
		StringBuilder errorMessage = new StringBuilder("문의내역 확인 : ");
		bindingResult.getFieldErrors().forEach(error->
		errorMessage.append(error.getDefaultMessage()).append(""));
		return ResponseEntity.badRequest().body(errorMessage.toString());
		};
		
		
		//유효성 검사 통과시 DB 저장
		qna = manageQnaService.createAns(qnaIdx, qna);
		log.info("qna: {}",qna);

		return ResponseEntity.ok(qna);
}
	
	
	
}