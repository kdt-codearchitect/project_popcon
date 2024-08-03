package com.store.service;

import java.util.List;

import com.store.dto.WishDTO;
import com.store.entity.Wish;

public interface WishService {
	List<WishDTO> findAll();
	Wish addToWish(WishDTO wish);
    void deleteFromWish(int wishIdx);
}
