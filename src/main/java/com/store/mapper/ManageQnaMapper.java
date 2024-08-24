package com.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.User;

import com.store.dto.QnaDTO;

@Mapper
public interface ManageQnaMapper {
	public List<QnaDTO>findAllQna();
	public User findTheManager(String CustomerId);
}
