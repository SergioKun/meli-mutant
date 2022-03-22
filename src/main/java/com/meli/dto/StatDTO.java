package com.meli.dto;

public class StatDTO {

	private int countMutant;
	private int countHuman;
	private double ratio;
	
	public StatDTO() {}

	public StatDTO(int countMutant, int countHuman, double ratio) {
		super();
		this.countMutant = countMutant;
		this.countHuman = countHuman;
		this.ratio = ratio;
	}

	public int getCountMutant() {
		return countMutant;
	}

	public void setCountMutant(int countMutant) {
		this.countMutant = countMutant;
	}

	public int getCountHuman() {
		return countHuman;
	}

	public void setCountHuman(int countHuman) {
		this.countHuman = countHuman;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

}
