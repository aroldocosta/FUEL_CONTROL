package com.studartrh.fuel.dto;

import java.math.BigDecimal;

import com.studartrh.fuel.entity.Fueling;

public record FuelingDTO(String pump, BigDecimal quantity, String date, String message) {
	public FuelingDTO(Fueling fueling) {
		this(fueling.getPump().getName(), fueling.getQuantity(), fueling.getDate(), "Ok");
	}
}
