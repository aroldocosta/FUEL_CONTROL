package com.studartrh.fuel.dto;

import java.math.BigDecimal;

import com.studartrh.fuel.entity.Fueling;


public record FuelingDTO(String pump, BigDecimal quantity, String fuel, String tankName, BigDecimal unitPrice, BigDecimal amount, BigDecimal taxation, BigDecimal total, String date, String message) {
	public FuelingDTO(Fueling fueling) {
		this(
			fueling.getPump().getName(), 
			fueling.getQuantity(),  
			fueling.getFuel(),
			fueling.getTankName(),
			fueling.getUnitPrice(),
			fueling.getAmount(),
			fueling.getTaxation(),
			fueling.getAmount(),		
			fueling.getDate(),
			"Ok");
	}
}
