package com.store.service;

import com.store.dto.OrderDTO;
import com.store.dto.OrderItemDTO;
import com.store.mapper.OrderMapper;
import com.store.mapper.OrderItemMapper;
import com.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    // 주문 생성
    @Transactional
    @Override
    public OrderDTO placeOrder(OrderDTO orderDTO, List<OrderItemDTO> orderItems) {
        
    	System.out.println("카트에서 가져온 skuIdx:" + orderItems);
    	System.out.println("카트에서 가져온 skuIdx:" + orderDTO);
        orderMapper.insertOrder(orderDTO);

        // 주문 아이템 생성
        for (OrderItemDTO item : orderItems) {
        	  System.out.println("Received SKU IDX: " + item.getSkuIdx()); // SKU IDX 확
            item.setOrderIdx(orderDTO.getOrderIdx()); // 생성된 orderIdx를 설정
            orderItemMapper.insertOrderItem(item);
        }

        return orderDTO;
    }
    
    //주문 검색
    @Override
    public OrderDTO getOrderById(int orderIdx) {
        return orderMapper.selectOrderById(orderIdx);
    }
    
    //유저 주문내역 자세히 보기
    @Override
    public List<OrderItemDTO> getOrderItemsByOrderId(int orderIdx) {
        return orderItemMapper.selectOrderItemsByOrderId(orderIdx);
    }
    
    //유저 주문내역 전체 보기
	@Override
	public List<OrderDTO> getOrderByCustomerId(int customerIdx) {
		
		return orderMapper.findOrderByCustomerId(customerIdx);
	}
}
