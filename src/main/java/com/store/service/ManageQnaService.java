package com.store.service;

import java.util.List;

import org.springframework.security.core.userdetails.User;

import com.store.dto.QnaDTO;
import com.store.entity.ManagerQna;

public interface ManageQnaService {
	
		public List<QnaDTO> findAllQna(); // 모든 문의내역 불러오기
//		public User findTheManager(String CustomerId); //관리자 권한 부여
		public ManagerQna createAns(int qnaIdx, ManagerQna managerQna); //문의내역 관리자 답변 
}
