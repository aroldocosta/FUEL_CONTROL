package com.studartrh.fuel.dto;

import java.math.BigDecimal;

import com.studartrh.fuel.entity.Tank;

public record TankDTO(String fuel, BigDecimal tax, BigDecimal unitPrice) {
	
	public TankDTO(Tank tank) {
		this(tank.getFuel(), tank.getTax(), tank.getUnitPrice());
	}
}
