package com.store.service;

import com.store.dto.CartDTO;
import com.store.entity.CartEntity;
import com.store.entity.CartItemEntity;
import com.store.entity.Customer;
import com.store.entity.Sku;
import com.store.mapper.CartMapper;
import com.store.repository.CartItemRepository;
import com.store.repository.CartRepository;
import com.store.repository.CustomerRepository;
import com.store.repository.SkuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

	private final CartMapper cartMapper;
	private final CartRepository cartRepository;
	private final CustomerRepository customerRepository;
	private final SkuRepository skuRepository;

	private final CartItemRepository cartItemRepository;

	@Override
	public CartDTO findById(Integer id) {
		// onetomany, manytoone 관계보다는, 로직에서 따로 CRUD 하여 조합하여 처리하는 방식으로 현업에서 더 사용.
		// 이유는, 성능 이슈 (JPA N+1 문제)가 발생할 수 있기 때문입니다.
		CartEntity cartEntity = cartRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Invalid cart ID: " + id));
		List<CartItemEntity> cartItemEntities = cartItemRepository.findByCartIdx(id);

		// 이제부터는, 프리젠테이션 레이어에서 사용할 DTO로 변환하는 작업을 해야 합니다.
		return CartDTO.of(cartEntity, cartItemEntities);
	}

	@Override
	public List<CartDTO> findAll() {
		List<CartDTO> carts = cartMapper.findAll();
		if (carts == null) {
			throw new NullPointerException("Cart list is null");
		}
		return carts;
	}


	@Override
	public CartEntity addToCart(CartDTO cartDto) {
		CartEntity cartEntity = convertToEntity(cartDto);
		return cartRepository.save(cartEntity);
	}

	@Override
	public CartEntity updateCart(CartDTO cartDto) {
		CartEntity existingCartEntity = cartRepository.findById(cartDto.getCartIdx())
			.orElseThrow(() -> new IllegalArgumentException("Invalid cart ID: " + cartDto.getCartIdx()));

		existingCartEntity.setSkuValue(cartDto.getSkuValue());

		Customer customer = customerRepository.findById(cartDto.getCustomerIdx())
			.orElseThrow(() -> new IllegalArgumentException("Invalid customer ID: " + cartDto.getCustomerIdx()));
		Sku sku = skuRepository.findById(cartDto.getSkuIdx())
			.orElseThrow(() -> new IllegalArgumentException("Invalid SKU ID: " + cartDto.getSkuIdx()));

		existingCartEntity.setCustomer(customer);
		existingCartEntity.setSku(sku);

		return cartRepository.save(existingCartEntity);
	}

	@Override
	public void deleteFromCart(int cartIdx) {
		cartRepository.deleteById(cartIdx);
	}

	private CartEntity convertToEntity(CartDTO cartDto) {
		CartEntity cartEntity = new CartEntity();

		Customer customer = customerRepository.findById(cartDto.getCustomerIdx())
			.orElseThrow(() -> new IllegalArgumentException("Invalid customer ID: " + cartDto.getCustomerIdx()));
		Sku sku = skuRepository.findById(cartDto.getSkuIdx())
			.orElseThrow(() -> new IllegalArgumentException("Invalid SKU ID: " + cartDto.getSkuIdx()));

		cartEntity.setCustomer(customer);
		cartEntity.setSku(sku);
		cartEntity.setSkuValue(cartDto.getSkuValue());

		return cartEntity;
	}


}
	

	

