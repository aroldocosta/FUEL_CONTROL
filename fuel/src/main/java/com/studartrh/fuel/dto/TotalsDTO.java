package com.studartrh.fuel.dto;

import java.math.BigDecimal;

public record TotalsDTO(
		BigDecimal gTodayQuantity, 
		BigDecimal gMonthQuantity, 
		BigDecimal gYearQuantity, 
		BigDecimal dTodayQuantity, 
		BigDecimal dMonthQuantity, 
		BigDecimal dYearQuantity,	
		BigDecimal gTodayPayment, 
		BigDecimal gMonthPayment, 
		BigDecimal gYearPayment, 
		BigDecimal dTodayPayment, 
		BigDecimal dMonthPayment, 
		BigDecimal dYearPayment,
		BigDecimal gUnitPrice,
		BigDecimal dUnitPrice
	) {
}
