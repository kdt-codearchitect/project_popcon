package com.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString(exclude="customerQna")
@Entity
public class ManagerQna {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="mqna_idx")
	int mqnaIdx;
	
	@Column(name="qna_ans")
	String qnaAns;
	
	@Column(name="qna_stated")
	String qnaStated;
	
	@Column(name="faqtype_idxed")
	Integer faqtypeIdxed;
	
	@OneToOne
	@JoinColumn(name="qna_idx", referencedColumnName = "qna_idx") // CustomerQna의 기본 키와 연결
	private CustomerQna customerQna;

}
