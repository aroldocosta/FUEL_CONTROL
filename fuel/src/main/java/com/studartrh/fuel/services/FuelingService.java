package com.studartrh.fuel.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

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
		try {
			Fueling fueling = new Fueling(data);			
			String today = LocalDateTime.now().toString();
			
			Pump pump = pumpRepository.findById(Long.valueOf(data.pumpId())).get();
			BigDecimal tax = pump.getTank().getTax();
			BigDecimal value = data.payment();
			BigDecimal unitPrice = pump.getTank().getUnitPrice(); 
			BigDecimal quantity  = value.divide(unitPrice, 2, RoundingMode.HALF_UP);
			BigDecimal taxation  = fueling.calculateTaxation(value, tax);
					
			fueling.setPayment(value);
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
		return ResponseEntity.ok(new FuelingDTO(null, null, null, null, null, null, null, null, null, null, message));
	}
	
	public ResponseEntity<FuelingDTO> update(FuelingDTO dto) {
		String message = "";
		try {
			Fueling fueling = new Fueling(dto);
			FuelingDTO resp = new FuelingDTO(repository.save(fueling));
			message = "Ok";
			return ResponseEntity.ok(resp);
		} catch (DataIntegrityViolationException e) {
			message = e.getMessage();
		} catch (Exception e) {
			message = e.getMessage();
		}
		return ResponseEntity.ok(new FuelingDTO(null, null, null, null, null,  null, null, null, null, null, message));
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
		return ResponseEntity.ok(new FuelingDTO(null, null, null, null, null, null, null, null, null, null, message));
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
		
		BigDecimal gTodayPayment = fuelings.stream()
				.filter(f -> f.isGasoline())
				.filter(f -> f.isThisDay())				
				.map(f -> f.getPayment())
				.reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
		
		BigDecimal gMonthPayment = fuelings.stream()
				.filter(f -> f.isGasoline())
				.filter(f -> f.isThisMonth())
				.map(f -> f.getPayment())
				.reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
		
		BigDecimal gYearPayment = fuelings.stream()
				.filter(f -> f.isGasoline())
				.filter(f -> f.isThisYear())				
				.map(f -> f.getPayment())
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
		
		BigDecimal dTodayPayment = fuelings.stream()
				.filter(f -> f.isDiesel())
				.filter(f -> f.isThisDay())
				.map(f -> f.getPayment())
				.reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
		
		BigDecimal dMonthPayment = fuelings.stream()
				.filter(f -> f.isDiesel())
				.filter(f -> f.isThisMonth())
				.map(f -> f.getPayment())
				.reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
		
		BigDecimal dYearPayment = fuelings.stream()
				.filter(f -> f.isDiesel())
				.filter(f -> f.isThisYear())
				.map(f -> f.getPayment())
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
			gTodayPayment, 
			gMonthPayment, 
			gYearPayment, 
			dTodayPayment, 
			dMonthPayment, 
			dYearPayment,
			gUnitPrice,
			dUnitPrice
		);
			
		return ResponseEntity.ok(totals);
	}	
	
	public void generateDbLoad() {
		int counter = 16;
		for(int i =0; i < counter; i++) {
			Random rand = new Random();
			Integer pump_id = ( i % 2 ) + 3;
			
			int qty = rand.nextInt((50 - 10) + 1) + 10;
			BigDecimal quantity = BigDecimal.valueOf(qty);
			BigDecimal unitPrice = BigDecimal.valueOf(10);
			BigDecimal tax = BigDecimal.valueOf(13);

			
			BigDecimal payValue = quantity.multiply(unitPrice);
			BigDecimal taxation = tax.multiply(payValue).divide(BigDecimal.valueOf(100));
			String query = "insert into fueling (quantity, pay_value, taxation, pump_id, date) values (__QUANTITY__, __PAY_VALUE__, __TAXATION__, __PUMP_ID__, '2023-10-02T00:00:00');";
			query = query.replace("__QUANTITY__", quantity.toString() );
			query = query.replace("__PAY_VALUE__", payValue.toString());
			query = query.replace("__TAXATION__", taxation.toString() );
			query = query.replace("__PUMP_ID__", pump_id.toString() );
			System.out.println(query);	
		}
	}
}
