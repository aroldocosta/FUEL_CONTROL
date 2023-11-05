package com.studartrh.fuel.dto;

import java.math.BigDecimal;

import com.studartrh.fuel.entity.Fueling;


public record FuelingDTO(Long id, Long pumpId, String pumpName, BigDecimal quantity, String fuel, String tankName, BigDecimal unitPrice, BigDecimal payment, BigDecimal taxation, String date, String message) {
	public FuelingDTO(Fueling fueling) {
		this(
			fueling.getId(),	
			fueling.getPump().getId(), 
			fueling.getPump().getName(),
			fueling.getQuantity(),  
			fueling.getFuel(),
			fueling.getTankName(),
			fueling.getUnitPrice(),
			fueling.getPayment(),
			fueling.getTaxation(),	
			fueling.getDate(),
			"Ok");
	}
}
