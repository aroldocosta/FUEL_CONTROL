package com.studartrh.fuel.dto;

import com.studartrh.fuel.entity.Pump;

public record PumpDTO(String name, String tank, String message) {

	public PumpDTO(Pump pump) {
		this(pump.getName(), pump.getTank().getFuel(), "Ok");
	}
}
