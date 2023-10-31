package com.studartrh.fuel.entity;

import java.math.BigDecimal;

import com.studartrh.fuel.dto.FuelingDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "fueling")
@Entity(name = "fueling")
public class Fueling {
	
	public static final BigDecimal tax = BigDecimal.valueOf(13.0);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "quantity")
	private BigDecimal quantity;
		
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pump_id")
	private Pump pump;	
	
	public Fueling() {
		
	}
	
	public Fueling(FuelingDTO dto) {
		this.date = dto.date();
		this.quantity = dto.quantity();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public Pump getPump() {
		return pump;
	}
	public void setPump(Pump pump) {
		this.pump = pump;
	}
}
