package com.studartrh.fuel.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

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
	
	@Column(name = "taxation")
	private BigDecimal taxation;
	
	@Column(name = "payment")
	BigDecimal payment;
		
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pump_id")
	private Pump pump;	
	
	public Fueling() {
		
	}
	
	public Fueling(FuelingDTO dto) {
		Pump pump = new Pump();
		pump.setId(dto.pumpId());
		this.id = dto.id();
		this.pump = pump;
		this.date = dto.date();
		this.quantity = dto.quantity();
		this.payment = dto.payment();
		this.taxation = dto.taxation();
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

	public BigDecimal getTaxation() {
		return taxation;
	}
	
	public void setTaxation(BigDecimal taxation) {
		this.taxation = taxation;
	}

	public BigDecimal getPayment() {
		return payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
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

	public BigDecimal calculateValue() {
		BigDecimal price = getPrice();
		return this.quantity.multiply(price);
	}
	
	public BigDecimal calculateTaxation(BigDecimal value, BigDecimal tax) {	
		BigDecimal taxation = value.multiply(tax).divide(BigDecimal.valueOf(100.0));
		return (taxation);
	}
	
	public BigDecimal calculatePayment(BigDecimal value, BigDecimal tax) {
		BigDecimal taxation = calculateTaxation(value, tax);
		BigDecimal payment = value.add(taxation);
		return (payment) ;
	}
	                  
	public BigDecimal calculateTotal(BigDecimal payment, BigDecimal taxation) {
		BigDecimal total = payment.add(taxation);
		return total;
	}
	
	public String getFuel() {
		return pump.getTank().getFuel();
	}
	public String getTankName() {
		return pump.getTank().getName();
	}
	
	public String getPumpName() {
		return pump.getName();
	}
	
	public BigDecimal getUnitPrice() {
		return pump.getTank().getUnitPrice();
	}
	
	public LocalDateTime getLocalDateTime() {		
		LocalDateTime localdate = LocalDateTime.parse(date);
		return localdate;
	}
	
	public String getReportDate() {
		LocalDateTime ldt = getLocalDateTime();
		int yea = ldt.getYear() - 2000;
		int mon = ldt.getMonthValue();
		int day = ldt.getDayOfMonth();
		String date = ((day > 9) ? ("" + day)  : ( "0" + day)) + 
				      ((mon > 9) ? ("/" + mon) : ("/0" + mon)) + 
				      ((yea > 9) ? ("/" + yea) : ("/0" + yea));
		return date;
	}
	
	public Boolean isGasoline() {
		return Tank.GASOLINA.equals(this.getPump().getTank().getFuel());
	}
	
	public Boolean isDiesel() {
		return Tank.DIESEL.equals(this.getPump().getTank().getFuel());
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
	
//	int counter = 0;
//	for(FuelingDTO f : resp) {
//		Integer pump_id = (counter++) % 4;
//		Tank tank = tankService.findById(Long.valueOf(pump_id) % 2);
//		BigDecimal payment = f.quantity().multiply(tank.getUnitPrice());
//		BigDecimal taxation = tank.getTax().multiply(payment).divide(BigDecimal.valueOf(100));
//		String query = "insert into fueling (quantity, payment, taxation, pump_id, date) values (__QUANTITY__, __PAYMENT__, __TAXATION__, __PUMP_ID__, '2023-10-02T00:00:00');";
//		query = query.replace("__QUANTITY__", f.quantity().toString() );
//		query = query.replace("__PAYMENT__", payment.toString());
//		query = query.replace("__TAXATION__", taxation.toString() );
//		query = query.replace("__PUMP_ID__", pump_id.toString() );
//		System.out.println(query);	
//	}
}
