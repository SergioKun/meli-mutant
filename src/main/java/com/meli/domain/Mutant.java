package com.meli.domain;

import java.util.Arrays;
import java.util.List;

public abstract class Mutant {
	
	private static final List<String> DNA_LETTERS = Arrays.asList("A","T","C","G");
	
	public abstract boolean isMutant(String[] dna);
	
	public boolean validateLetters(String[] dna) {
		for (String item : dna) {
			
			String[] lettersDna = item.split("");
			
			for (String letter : lettersDna) {
				if(!DNA_LETTERS.contains(letter)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	public boolean validateLengthElement(String[] dna) {
		
		if(dna.length == 0) {
			return false;
		}
		
		List<String> elementsDna = Arrays.asList(dna);
		
		return elementsDna.stream().allMatch(s -> s.length() == dna[0].length());
		
	}

}
