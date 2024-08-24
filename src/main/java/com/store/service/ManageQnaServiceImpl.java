package com.store.service;

import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.store.dto.QnaDTO;
import com.store.entity.CustomerQna;
import com.store.entity.ManagerQna;
import com.store.exception.ResourceNotFoundException;
import com.store.mapper.ManageQnaMapper;
import com.store.repository.ManagerRepository;
import com.store.repository.QnaRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ManageQnaServiceImpl implements ManageQnaService {

	ManageQnaMapper manageQnaMapper;
	ManagerRepository managerRepository;
	QnaRepository qnaRepository;
	
	public ManageQnaServiceImpl(ManageQnaMapper manageQnaMapper,
								ManagerRepository managerRepository,
								QnaRepository qnaRepository) {
		
								this.manageQnaMapper = manageQnaMapper;
								this.managerRepository = managerRepository;
								this.qnaRepository = qnaRepository;
	}

	//매니저 관리자 권한 부여
//	@Override
//	public User findTheManager(String CustomerId) throws UsernameNotFoundException {
//		     
//		
//				User user = manageQnaMapper.findTheManager(CustomerId);
//		        if (user == null) {
//		            throw new UsernameNotFoundException("존재하지 않은 사용자입니다.");
//		        }
//		        
//		        //권한 설정
//		        GrantedAuthority authorities;
//		        if (CustomerId.equals("1")) {
//		            authorities = new SimpleGrantedAuthority("ROLE_ADMIN");
//		        } else {
//		            authorities = new SimpleGrantedAuthority("ROLE_USER");
//		        }
//		        
//		        return new org.springframework.security.core.userdetails.User
//			        			(user.getUsername(), 
//								 user.getPassword(), 
//								 Collections.singleton(authorities));
//				}

	// 모든 문의내역 조회
	@Override
	public List<QnaDTO> findAllQna() {
		return manageQnaMapper.findAllQna();
				}
	
	// 문의내역 답변 등록
//	@Transactional
	@Override
	public ManagerQna createAns(int qnaIdx, ManagerQna managerQna) {
		
	    // CustomerQna를 찾기
	    CustomerQna customerQna = qnaRepository.findById(qnaIdx)	
	            .orElseThrow(() -> new ResourceNotFoundException("문의 내역을 찾을 수 없습니다."));
	    
	    // 기존 ManagerQna를 찾기, 없으면 새로운 객체 생성
	    ManagerQna existingManagerQna = managerRepository.findByCustomerQna(customerQna);
	    if(existingManagerQna==null) {
	            existingManagerQna = new ManagerQna();};

	    existingManagerQna.setCustomerQna(customerQna); // 회원의 문의내역 설정
	    existingManagerQna.setQnaAns(managerQna.getQnaAns()); // 관리자 답변 등록

	    // 변경된 CustomerQna 저장
	    qnaRepository.save(customerQna);
	    
	    // 문의내역 상태 업데이트
	    customerQna.setQnaState(managerQna.getQnaStated());
	    customerQna.setFaqtypeIdx(managerQna.getFaqtypeIdxed());

	    // 기존 객체를 업데이트하거나 새로운 객체로 저장
	    return managerRepository.save(existingManagerQna);
	}


//	    managerQna.setCustomerQna(customerQna); //회원의 문의내역 불러오기
//	    managerQna.setQnaAns(managerQna.getQnaAns()); // 관리자 답변 등록
//	    managerRepository.save(managerQna);

	
	
	
}
