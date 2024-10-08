package com.store.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.store.dto.SkuDTO;
import com.store.mapper.SkuMapper;

@Service
public class SkuServiceImpl implements SkuService {

	SkuMapper skuMapper;

	public SkuServiceImpl(SkuMapper skuMapper) {
		this.skuMapper = skuMapper;
	}

	@Override
	public List<SkuDTO> findAll(int limit, String wishIdx) {
		return skuMapper.findAll(limit, wishIdx);
	}

	@Override
	public List<SkuDTO> findByType(int skutypeIdx, int limit, String wishIdx) {
		// TODO Auto-generated method stub
		return skuMapper.findByType(skutypeIdx, limit, wishIdx);
	}

	
	@Override
	public List<SkuDTO> findAllOnePlus(int limit, String wishIdx) {
		return skuMapper.findAllOnePlus(limit, wishIdx);
	}
	
	@Override
	public List<SkuDTO> findByTypeOnePlus(int skutypeIdx, int limit, String wishIdx) {
		// TODO Auto-generated method stub
		return skuMapper.findByTypeOnePlus(skutypeIdx, limit, wishIdx);
	}
	
	
	@Override
	public List<SkuDTO> findAllTwoPlus(int limit, String wishIdx) {
		return skuMapper.findAllTwoPlus(limit, wishIdx);
	}
	
	@Override
	public List<SkuDTO> findByTypeTwoPlus(int skutypeIdx, int limit, String wishIdx) {
		// TODO Auto-generated method stub
		return skuMapper.findByTypeTwoPlus(skutypeIdx, limit, wishIdx);
	}
	


}
