package com.meli.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String dna;
	private boolean isMutant;
	
	
	
	public Stat(String dna, boolean isMutant) {
		super();
		this.dna = dna;
		this.isMutant = isMutant;
	}
	public String getDna() {
		return dna;
	}
	public void setDna(String dna) {
		this.dna = dna;
	}
	public boolean isMutant() {
		return isMutant;
	}
	public void setMutant(boolean isMutant) {
		this.isMutant = isMutant;
	}
}
