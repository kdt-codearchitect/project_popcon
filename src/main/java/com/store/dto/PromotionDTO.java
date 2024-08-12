package com.store.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Alias("PromotionDTO")
public class PromotionDTO {
	private int promotionIdx;
	private String promotionType;
	private Date promotionStart;
	private Date promotionEnd;
	private int skuIdx;
	
}
