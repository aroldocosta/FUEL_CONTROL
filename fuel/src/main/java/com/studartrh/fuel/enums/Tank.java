package com.studartrh.fuel.enums;

import java.math.BigDecimal;

public enum Tank {
	
	DIESEL(1, "DIESEL", BigDecimal.valueOf(5.99)),
	GASOLINE(2, "GASOLINE", BigDecimal.valueOf(5.82));

	private Integer id;
	private String name;
	private BigDecimal unitPrice;
	
	Tank(Integer id, String name, BigDecimal unitPrice) {
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
}
