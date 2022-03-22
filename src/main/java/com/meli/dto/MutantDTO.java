package com.meli.dto;

public class MutantDTO {

	private boolean isMutant;
	private String AditionalMenssage;

	public boolean isMutant() {
		return isMutant;
	}

	public void setMutant(boolean isMutant) {
		this.isMutant = isMutant;
	}

	public String getAditionalMenssage() {
		return AditionalMenssage;
	}

	public void setAditionalMenssage(String aditionalMenssage) {
		AditionalMenssage = aditionalMenssage;
	}

	public MutantDTO() {
	}

	public MutantDTO(boolean isMutant, String aditionalMenssage) {
		super();
		this.isMutant = isMutant;
		AditionalMenssage = aditionalMenssage;
	}

}
