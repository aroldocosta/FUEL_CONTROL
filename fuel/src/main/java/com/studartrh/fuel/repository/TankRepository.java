package com.studartrh.fuel.repository;

import com.studartrh.fuel.entity.Tank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TankRepository extends JpaRepository<Tank, Long> {
	public Tank findByFuel(String fuel);
}
