package com.store.mapper;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.store.dto.SkuDTO;

@Mapper
public interface SkuMapper {
//	 Member findByUserIdAndPassword(Map<String, String> params);
//	Member findByUsername(String userid);
//	int insertMember(Member member);
//	Member registerNewMember(@Valid Member member);
//	@Select("SELECT * FROM member")
    List<SkuDTO> findAll(int limit, String wishIdx);
    List<SkuDTO> findByType(int skutypeIdx, int limit, String wishIdx);
    List<SkuDTO> findAllOnePlus(int limit, String wishIdx);
    List<SkuDTO> findByTypeOnePlus(int skutypeIdx, int limit, String wishIdx);
    List<SkuDTO> findAllTwoPlus(int limit, String wishIdx);
    List<SkuDTO> findByTypeTwoPlus(int skutypeIdx, int limit, String wishIdx);
}

