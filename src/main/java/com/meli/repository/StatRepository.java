package com.meli.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StatRepository extends JpaRepository<Stat, Long> {
	
	int countByIsMutant(boolean isMutant);

}
