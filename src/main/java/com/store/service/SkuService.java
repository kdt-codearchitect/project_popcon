package com.store.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;



import com.store.dto.SkuDTO;

public interface SkuService {
	List<SkuDTO> findAll(int limit, String wishIdx);
	List<SkuDTO> findByType(int skutypeIdx, int limit, String wishIdx);
	List<SkuDTO> findAllOnePlus(int limit, String wishIdx);
	List<SkuDTO> findByTypeOnePlus(int skutypeIdx, int limit, String wishIdx);
	List<SkuDTO> findAllTwoPlus(int limit, String wishIdx);
	List<SkuDTO> findByTypeTwoPlus(int skutypeIdx, int limit, String wishIdx);
}
