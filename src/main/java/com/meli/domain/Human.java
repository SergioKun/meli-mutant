package com.meli.domain;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.meli.repository.Stat;
import com.meli.repository.StatRepository;

@Component
public class Human extends Mutant {
	
	@Autowired
	private StatRepository repositorySatate;
	
	private Dna dna;
	
	public Human() {
		
		
		
	}

	@Override
	public boolean isMutant(String[] dna) {
		
		this.dna = new Dna(dna);
		
		boolean resultMutant = this.dna.IsMutantValidate();
		
		this.repositorySatate.save(new Stat(Arrays.toString(dna), resultMutant));
		
		return resultMutant;
	}

}
