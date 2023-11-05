package com.studartrh.fuel.dto;

import java.math.BigDecimal;

import com.studartrh.fuel.entity.Tank;

public record TankDTO(Long id, String fuel, BigDecimal tax, BigDecimal unitPrice) {
	
	public TankDTO(Tank tank) {
		this(tank.getId(), tank.getFuel(), tank.getTax(), tank.getUnitPrice());
	}
}
