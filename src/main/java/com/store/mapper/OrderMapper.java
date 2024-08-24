package com.store.mapper;

import com.store.dto.OrderDTO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    void insertOrder(OrderDTO orderDTO);
    
    //주문내역 검색
    OrderDTO selectOrderById(@Param("orderIdx") int orderIdx);
    
    //유저 주문내역 전체 조회
    List<OrderDTO> findOrderByCustomerId(@Param("customerIdx") int customerIdx);
}
