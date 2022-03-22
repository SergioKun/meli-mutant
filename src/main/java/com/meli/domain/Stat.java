package com.meli.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.meli.dto.StatDTO;
import com.meli.repository.StatRepository;

@Component
public class Stat {
	
	@Autowired
	private StatRepository repositorySatate;
	
	
	public Stat() {
			
	}
	
	public Stat(StatRepository repositorySatate) {
		this.repositorySatate = repositorySatate;
	}
	
	public StatDTO getStat() {		
	
		int countIsMutant = this.repositorySatate.countByIsMutant(true);
		
		double countRecords =  this.repositorySatate.count();
			
		return new StatDTO(countIsMutant, (int)(Math.abs(countRecords - countIsMutant)), countIsMutant/countRecords );
		
		
	}

}
