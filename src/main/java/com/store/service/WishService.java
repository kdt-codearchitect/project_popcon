package com.store.service;

import java.util.List;
import com.store.dto.WishDTO;
import com.store.dto.WishItemDTO;
import com.store.entity.WishItemEntity;

public interface WishService {
	WishDTO createWish(WishDTO wishDTO);
	WishItemDTO updateWishItemQuantity(int wishItemIdx);
	public void deleteWishItem(int wishItemIdx);

	void moveWishToCart(int wishItemIdx, int cartIdx);
	List<WishDTO> getWishesByCustomerIdx(int customerIdx);
	WishItemEntity addToWish(WishItemDTO wishItemDTO);
	List<WishItemDTO> findAll();
	
	void deleteByWishIdxAndSkuIdx(int wishIdx, int skuIdx);
	

}
