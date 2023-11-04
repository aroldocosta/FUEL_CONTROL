package com.studartrh.fuel.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.studartrh.fuel.dto.FuelingDTO;
import com.studartrh.fuel.dto.TotalsDTO;
import com.studartrh.fuel.entity.Fueling;
import com.studartrh.fuel.entity.Pump;
import com.studartrh.fuel.entity.Tank;
import com.studartrh.fuel.repository.FuelingRepository;
import com.studartrh.fuel.repository.PumpRepository;

@Service
public class FuelingService {
	
	@Autowired
	private FuelingRepository repository;
	
	@Autowired
	private TankService tankService;
	
	@Autowired
	private PumpRepository pumpRepository;
	
	public ResponseEntity<List<FuelingDTO> > getAll() {
	
		try {
			List<FuelingDTO> resp = repository.findAll().stream().map(FuelingDTO::new).toList();
			return ResponseEntity.ok(resp);
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
	
	public List<Fueling> reportAll() {
		return repository.findAll();
	}
	
	public ResponseEntity<FuelingDTO> get(Long id) {	
		
		try {
			FuelingDTO resp = repository.findById(id).stream().map(FuelingDTO::new).findAny().get();
			return ResponseEntity.ok(resp);
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
	
	public ResponseEntity<FuelingDTO> save(FuelingDTO data) {
		
		String message = "";
		System.out.println("Pump: " + data.pump() + " Value: " + data.amount());
		try {
			Fueling fueling = new Fueling(data);			
			String today = LocalDateTime.now().toString();
			
			Pump pump = pumpRepository.findById(Long.valueOf(data.pump())).get();
			BigDecimal tax = pump.getTank().getTax();
			BigDecimal value = data.amount();
			BigDecimal unitPrice = pump.getTank().getUnitPrice(); 
			BigDecimal quantity  = value.divide(unitPrice, 2, RoundingMode.HALF_UP);
			BigDecimal taxation  = fueling.calculateTaxation(value, tax);
			BigDecimal amount    = fueling.calculateAmount(value, tax);
					
			fueling.setAmount(amount);
			fueling.setTaxation(taxation);
			fueling.setQuantity(quantity);
			fueling.setPump(pump);
			fueling.setDate(today);

			FuelingDTO resp = new FuelingDTO(repository.save(fueling));	
			message = "Ok";
			return ResponseEntity.ok(resp);
		} catch (DataIntegrityViolationException e) {
			message = e.getMessage();
		} catch (Exception e) {
			message = e.getMessage();
		}
		return ResponseEntity.ok(new FuelingDTO(null, null, null, null, null, null, null, null, null, message));
	}
	
	public ResponseEntity<FuelingDTO> update(Long id) {
		String message = "";
		try {
			Fueling fueling = repository.findById(id).get();
			FuelingDTO resp = new FuelingDTO(repository.save(fueling));
			message = "Ok";
			return ResponseEntity.ok(resp);
		} catch (DataIntegrityViolationException e) {
			message = e.getMessage();
		} catch (Exception e) {
			message = e.getMessage();
		}
		return ResponseEntity.ok(new FuelingDTO(null, null, null, null, null, null, null, null, null, message));
	}
	
	public ResponseEntity<FuelingDTO> delete(Long id) {
		String message = "";
		try {
			Fueling fueling = repository.findById(id).get();
			repository.delete(fueling);
			message = "Ok";
			return ResponseEntity.ok(new FuelingDTO(fueling));
		} catch (Exception e) {
			message = e.getMessage();
		}
		return ResponseEntity.ok(new FuelingDTO(null, null, null, null, null, null, null, null, null, message));
	}	
	
	public ResponseEntity<TotalsDTO> totals() {
		
		List<Fueling> fuelings = repository.findAll();
		
		BigDecimal gTodayQuantity = fuelings.stream()
				.filter(f -> f.isGasoline())
				.filter(f -> f.isThisDay())				
				.map(f -> f.getQuantity())
				.reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
		
		BigDecimal gMonthQuantity = fuelings.stream()
				.filter(f -> f.isGasoline())
				.filter(f -> f.isThisMonth())
				.map(f -> f.getQuantity())
				.reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
		
		BigDecimal gYearQuantity = fuelings.stream()
				.filter(f -> f.isGasoline())
				.filter(f -> f.isThisYear())
				.map(f -> f.getQuantity())
				.reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
		
		BigDecimal gTodayAmount = fuelings.stream()
				.filter(f -> f.isGasoline())
				.filter(f -> f.isThisDay())				
				.map(f -> f.getAmount())
				.reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
		
		BigDecimal gMonthAmount = fuelings.stream()
				.filter(f -> f.isGasoline())
				.filter(f -> f.isThisMonth())
				.map(f -> f.getAmount())
				.reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
		
		BigDecimal gYearAmount = fuelings.stream()
				.filter(f -> f.isGasoline())
				.filter(f -> f.isThisYear())				
				.map(f -> f.getAmount())
				.reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
				
		BigDecimal dTodayQuantity = fuelings.stream()
				.filter(f -> f.isDiesel())
				.filter(f -> f.isThisDay())
				.map(f -> f.getQuantity())
				.reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
		
		BigDecimal dMonthQuantity = fuelings.stream()
				.filter(f -> f.isDiesel())
				.filter(f -> f.isThisMonth())
				.map(f -> f.getQuantity())
				.reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
		
		BigDecimal dYearQuantity = fuelings.stream()
				.filter(f -> f.isDiesel())
				.filter(f -> f.isThisYear())
				.map(f -> f.getQuantity())
				.reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
		
		BigDecimal dTodayAmount = fuelings.stream()
				.filter(f -> f.isDiesel())
				.filter(f -> f.isThisDay())
				.map(f -> f.getAmount())
				.reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
		
		BigDecimal dMonthAmount = fuelings.stream()
				.filter(f -> f.isDiesel())
				.filter(f -> f.isThisMonth())
				.map(f -> f.getAmount())
				.reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
		
		BigDecimal dYearAmount = fuelings.stream()
				.filter(f -> f.isDiesel())
				.filter(f -> f.isThisYear())
				.map(f -> f.getAmount())
				.reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
		
		BigDecimal gUnitPrice = tankService.findByFuel(Tank.GASOLINA).getUnitPrice();
		BigDecimal dUnitPrice = tankService.findByFuel(Tank.DIESEL).getUnitPrice();

		TotalsDTO totals = new TotalsDTO(
			gTodayQuantity, 
			gMonthQuantity, 
			gYearQuantity, 
			dTodayQuantity, 
			dMonthQuantity, 
			dYearQuantity,
			gTodayAmount, 
			gMonthAmount, 
			gYearAmount, 
			dTodayAmount, 
			dMonthAmount, 
			dYearAmount,
			gUnitPrice,
			dUnitPrice
		);
			
		return ResponseEntity.ok(totals);
	}	
}
