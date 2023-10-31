package com.studartrh.fuel.entity;

import java.util.List;

import com.studartrh.fuel.dto.PumpDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "pump")
@Entity(name = "pump")
public class Pump {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "tank")
	private Integer tank;
	
	@OneToMany(mappedBy = "pump", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Fueling> fuelings;
	
	public Pump() {
		
	}
	
	public Pump(PumpDTO dto) {
		this.name = dto.name();
		this.tank = dto.tank();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTank() {
		return tank;
	}

	public void setTank(Integer tank) {
		this.tank = tank;
	}

	public List<Fueling> getFuelings() {
		return fuelings;
	}

	public void setFuelings(List<Fueling> fuelings) {
		this.fuelings = fuelings;
	}
		
	
}
