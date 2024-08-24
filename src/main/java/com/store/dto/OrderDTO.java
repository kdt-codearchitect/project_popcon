package com.store.dto;

import java.time.LocalDateTime;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Alias("OrderDTO")
public class OrderDTO {

    private int orderIdx;
    private int deliveryIdx;
    private int customerIdx;
    private int orderStatusIdx;
    private int cartIdx;
    private LocalDateTime orderTime;
    private String paymentId;
    private String orderStatus;
    private String deliveryStatus;
    private int totalSumPrice;
    
}
