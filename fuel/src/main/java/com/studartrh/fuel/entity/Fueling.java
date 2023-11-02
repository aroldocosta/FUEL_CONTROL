package com.studartrh.fuel.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime ld = getLocalDateTime();
		return fmt.format(ld);
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
	
	private BigDecimal getTax() {
		return pump.getTank().getTax();
	}
	private BigDecimal getPrice() {
		return pump.getTank().getUnitPrice();
	}
	private BigDecimal getValue() {
		BigDecimal price = getPrice();
		return this.quantity.multiply(price);
	}
	public BigDecimal getTaxation() {
		BigDecimal tax = getTax();
		BigDecimal value = getValue();		
		BigDecimal taxation = value.multiply(tax).divide(BigDecimal.valueOf(100.0));
		return (taxation);
	}
	
	public BigDecimal getAmount() {
		BigDecimal value = getValue();
		BigDecimal taxation = getTaxation();
		BigDecimal total = value.add(taxation);
		return (total) ;
	}
	
	public String getTankName() {
		return pump.getTank().getFuel();
	}
	
	public BigDecimal getUnitPrice() {
		return pump.getTank().getUnitPrice();
	}
	
	public LocalDateTime getLocalDateTime() {		
		LocalDateTime localdate = LocalDateTime.parse(date);
		return localdate;
	}
	
	public Boolean isGasoline() {
		return this.getPump().getTank().equals(Tank.GASOLINA);
	}
	
	public Boolean isDiesel() {
		return this.getPump().getTank().equals(Tank.DIESEL);
	}
	
	public Boolean isThisDay() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime date = this.getLocalDateTime();
		return ( isThisMonth() && now.getDayOfMonth() == date.getDayOfMonth());
	}
	
	public Boolean isThisMonth() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime date = this.getLocalDateTime();
		return ( isThisYear() && now.getMonth() == date.getMonth());
				
	}
	
	public Boolean isThisYear() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime date = this.getLocalDateTime();
		return ( now.getYear() == date.getYear());
	}
}





