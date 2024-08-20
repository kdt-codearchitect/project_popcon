package com.store.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.QnaDTO;
import com.store.entity.CustomerQna;
import com.store.service.QnaService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class QnaController {

	QnaService qnaService;
	
	public QnaController(QnaService qnaService
			) {
		this.qnaService = qnaService;
	}

	
//	문의 수정하기
	@PutMapping("/asks/{customerIdx}")
	public ResponseEntity<?> EditMyQna(@PathVariable int customerIdx, 
									   @Valid @RequestBody CustomerQna qna,
									   BindingResult bindingResult){
				// 유효성 검사 결과 확인
				if(bindingResult.hasErrors()) {
				// 오류가 있을 경우, 에러 메시지를 반환
				StringBuilder errorMessage = new StringBuilder("문의내역 확인 : ");
				bindingResult.getFieldErrors().forEach(error->
					errorMessage.append(error.getDefaultMessage()).append(""));
				return ResponseEntity.badRequest().body(errorMessage.toString());
				};
		
		qna = qnaService.EditMyQna(customerIdx, qna);
		log.info("editMyQna qnaDTO : {}", qna); 
		
		//유효성 검사 통과시 DB 저장
		return ResponseEntity.ok(qna);
	}

	
//	문의 삭제하기
	@PutMapping("/myinquiry{customerIdx}")
	public ResponseEntity<?> DeleteMyQna(@PathVariable int customerIdx, 
										 @Valid @RequestBody CustomerQna qna,
										 BindingResult bindingResult){
				// 유효성 검사 결과 확인
				if(bindingResult.hasErrors()) {
				// 오류가 있을 경우, 에러 메시지를 반환
				StringBuilder errorMessage = new StringBuilder("문의내역 확인 : ");
				bindingResult.getFieldErrors().forEach(error->
				errorMessage.append(error.getDefaultMessage()).append(""));
				return ResponseEntity.badRequest().body(errorMessage.toString());
				};

		qna = qnaService.DeleteMyQna(customerIdx, qna);
		log.info("postMyQna qnaDTO : {}", qna); 

		//유효성 검사 통과시 DB 저장
		return ResponseEntity.ok(qna);
		}
	
//	문의 신청하기	
<<<<<<< Upstream, based on Project_Popcon/main
	@PostMapping("/ask")
	public ResponseEntity<?> PostMyQna(@Valid @RequestBody CustomerQna qna,
<<<<<<< Upstream, based on Project_Popcon/main
<<<<<<< Upstream, based on Project_Popcon/main
//									   @RequestParam String userid,
												  BindingResult bindingResult) {
=======
	@PostMapping("/ask/{CustomerIdx}")
	public ResponseEntity<?> PostMyQna(@PathVariable int CustomerIdx, 
								  	   @Valid @RequestBody CustomerQna qna,
									  BindingResult bindingResult) {
>>>>>>> a7ca03e feature/POP-29 문의내역 회원 연결
		
		// 유효성 검사 결과 확인
		if(bindingResult.hasErrors()) {
			// 오류가 있을 경우, 에러 메시지를 반환
			StringBuilder errorMessage = new StringBuilder("문의내역 확인 : ");
			bindingResult.getFieldErrors().forEach(error->
				errorMessage.append(error.getDefaultMessage()).append(""));
			return ResponseEntity.badRequest().body(errorMessage.toString());
		};
		
=======
=======
//									   @RequestParam String userid,
>>>>>>> f98704b fix/문의내역 타임스탬프 버그 수정
												  BindingResult bindingResult) {
		
		// 유효성 검사 결과 확인
		if(bindingResult.hasErrors()) {
			// 오류가 있을 경우, 에러 메시지를 반환
			StringBuilder errorMessage = new StringBuilder("문의내역 확인 : ");
			bindingResult.getFieldErrors().forEach(error->
				errorMessage.append(error.getDefaultMessage()).append(""));
			return ResponseEntity.badRequest().body(errorMessage.toString());
		};
<<<<<<< Upstream, based on Project_Popcon/main
		//유효성 검사 통과시 DB 저장
>>>>>>> 120f1d8 POP-47-ask-001 : 자주묻는질문 FAQ 페이지 로직 완료, 주석 추가
=======
		
>>>>>>> f98704b fix/문의내역 타임스탬프 버그 수정
		qna = qnaService.PostMyQna(qna);
		log.info("postMyQna qnaDTO : {}", qna); 
		
		//유효성 검사 통과시 DB 저장
		return ResponseEntity.ok(qna);
	}
	
// 나의문의내역 조회
	@GetMapping("/myinquiry/{CustomerIdx}")
	public ResponseEntity<List<QnaDTO>> find(@PathVariable String CustomerIdx){
		
		int idx = Integer.parseInt(CustomerIdx);
		//유저의 문의 내역 불러오기 
		List<QnaDTO> myQnaList = qnaService.findMyQna(idx);
		return ResponseEntity.ok(myQnaList);
		}
	
	}