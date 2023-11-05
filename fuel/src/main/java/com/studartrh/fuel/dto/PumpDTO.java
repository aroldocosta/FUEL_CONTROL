package com.studartrh.fuel.dto;

import com.studartrh.fuel.entity.Pump;

public record PumpDTO(Long id, String name, String tank, String message) {

	public PumpDTO(Pump pump) {
		this(pump.getId(), pump.getName(), pump.getTank().getFuel(), "Ok");
	}
}
