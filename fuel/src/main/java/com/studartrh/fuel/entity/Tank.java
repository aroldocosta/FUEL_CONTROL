package com.studartrh.fuel.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@RequestMapping("tanks")
public class Tank implements Serializable{

	private static final long serialVersionUID = -6684051812621881457L;
	public static final String DIESEL = "DIESEL";
	public static final String GASOLINA = "GASOLINA";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fuel")
	private String fuel;
	
	@Column(name = "tax")
	private BigDecimal tax;
	
	@OneToMany(mappedBy = "tank", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Pump> pumps;
	
	@Column(name = "unit_price")
	private BigDecimal unitPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

}
