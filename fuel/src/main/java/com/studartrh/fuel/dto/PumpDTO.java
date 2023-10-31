package com.studartrh.fuel.dto;

import com.studartrh.fuel.entity.Pump;

public record PumpDTO(String name, Integer tank, String message) {

	public PumpDTO(Pump pump) {
		this(pump.getName(), pump.getTank(), "Ok");
	}
}
