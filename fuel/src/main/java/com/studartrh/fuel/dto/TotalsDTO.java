package com.studartrh.fuel.dto;

import java.math.BigDecimal;

public record TotalsDTO(
		BigDecimal gTodayQuantity, 
		BigDecimal gMonthQuantity, 
		BigDecimal gYearQuantity, 
		BigDecimal dTodayQuantity, 
		BigDecimal dMonthQuantity, 
		BigDecimal dYearQuantity,	
		BigDecimal gTodayAmount, 
		BigDecimal gMonthAmount, 
		BigDecimal gYearAmount, 
		BigDecimal dTodayAmount, 
		BigDecimal dMonthAmount, 
		BigDecimal dYearAmount,
		BigDecimal gUnitPrice,
		BigDecimal dUnitPrice
	) {
}
