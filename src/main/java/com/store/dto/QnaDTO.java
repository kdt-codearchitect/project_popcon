package com.store.dto;

import javax.validation.constraints.NotEmpty;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Alias("QnaDTO")
public class QnaDTO {

	private int qnaIdx;
	private int faqtypeIdx;
	private int customerIdx;
	
	@NotEmpty(message="제목을 입력하세요.")
	String qnaTitle;
	@NotEmpty(message="내용을 입력하세요.")
	String qnaText;
	String qnaDate;
	String qnaPicture;
<<<<<<< Upstream, based on Project_Popcon/main
	String qnaImage;
<<<<<<< Upstream, based on Project_Popcon/main
	
=======
>>>>>>> 200aee9 fix/문의내역 조회 : QnaDTO 버그 수정
=======
	String qnaImage;	
	String qnaState;
	String qnaClearDate;
	String qnaDel;
>>>>>>> b840904 POP-48 문의하기 이미지 저장 버그 수정
	
	
}