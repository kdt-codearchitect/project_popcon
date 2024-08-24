package com.store.service;

import com.store.dto.OrderDTO;
import com.store.dto.OrderItemDTO;

import java.util.List;

public interface OrderService {
	
	//주문내역 생성
    OrderDTO placeOrder(OrderDTO orderDTO, List<OrderItemDTO> orderItems);
    
    //주문내역 검색
    OrderDTO getOrderById(int orderIdx);
    
    //주문내역 주문 자세히 보기
    List<OrderItemDTO> getOrderItemsByOrderId(int orderIdx);
    
    //유저 주문조회
    List<OrderDTO> getOrderByCustomerId(int customerIdx);
}
