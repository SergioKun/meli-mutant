package com.meli.dto;

public class DnaDTO {
	
	private String[] dna;
	
	public DnaDTO() {
		
	}

	public DnaDTO(String[] dns) {
		super();
		this.dna = dns;
	}

	public String[] getDns() {
		return dna;
	}

	public void setDns(String[] dna) {
		this.dna = dna;
	}

}
