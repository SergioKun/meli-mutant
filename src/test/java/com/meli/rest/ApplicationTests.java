package com.meli.rest;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.meli.domain.Dna;
import com.meli.domain.Human;
import com.meli.dto.StatDTO;
import com.meli.repository.StatRepository;

import static org.junit.Assert.assertEquals;


@SpringBootTest
class ApplicationTests {
	
	 @Mock
     private StatRepository statRepository;
	 

	@Test
	void testDnaWithArrayValues() {
		testDna(new String[] {"TGTGTA","CAGAGC","TTACGT","AGACGG","TCCCTA","TCACTG"},false,"Ninguna coincidencia de 4 letras seguidas");
		testDna(new String[] {"TTTTAA","CAGAGC","TTACGT","AGACGG","TCCCTA","TCATTG"},false,"Solo 1 coincidencia de 4 letras en la fila 1");
		testDna(new String[] {"CTTTAA","CAGAGC","TTACGT","AGACGG","TCCCTA","TCACTG"},false,"Solo 1 coincidencia de 4 letras en la columna 1");
		testDna(new String[] {"CTTTAA","CCGAGC","TTCCGT","AGACGG","TCCCTA","TCATTG"},false,"Solo 1 coincidencia en la diagonal principal");
		testDna(new String[] {"CTTTTA","CCGAGC","TTCCGT","AGACGG","TCCCTA","TCATTG"},true,"2 coincidencia de 4 letras en la fila 1 y diagonal principal");
		testDna(new String[] {"CTTTAA","CCGAAC","TTCCAT","AGACAG","TCCCTA","TCATTG"},true,"2 coincidencia de 4 letras en la columna 5 y diagonal principal");
		testDna(new String[] {"CTTTAA","CCGAAC","TTCCAT","AGACAG","TCCCTA","TTTTAG"},true,"3 coincidencia de 4 letras en la fila 6, columna 5 y diagonal principal");
		testDna(new String[] {"ATTTAA","CCGAAC","TTCCAT","AGACTG","TCCCTA","ATTTAG"},false,"3 coincidencia de 3 letras en la fila 6, columna 5 y diagonal principal");
		
	}
	
	public void testDna(String[] dna, boolean expected, String message) {
		
		Dna dnaTest = new Dna(dna);
		
		assertEquals(message,dnaTest.IsMutantValidate(), expected);
	}
	
	@Test
	void testStatRatio() {
		
		long countRecords = 40;
		double resulExpected = 0.75;
		
		StatRepository statRepository = Mockito.mock(StatRepository.class);
		Mockito.when(statRepository.count()).thenReturn(countRecords);
		Mockito.when(statRepository.countByIsMutant(true)).thenReturn(30);	
		com.meli.domain.Stat statDomain = new com.meli.domain.Stat(statRepository);
       
        
        StatDTO result =  statDomain.getStat();
        
        
        assertEquals(result.getRatio(), resulExpected,0);
	}
	
	@Test
	void testLettersNotAllowed() {
	
		Human human = new Human();
		String[] dna = new String[] {"CTTTTA","CCGAGC","TTCCGZ","AGACGG","TCCCTA","TCATTG"};
		
		boolean  result = human.validateLetters(dna);
		
		assertEquals(result,false);
	
	}
	
	@Test
	void testLettersAllowed() {
	
		Human human = new Human();
		String[] dna = new String[] {"CTTTTA","CCGAGC","TTCCGG","AGACGG","TCCCTA","TCATTG"};
		
		boolean  result = human.validateLetters(dna);
		
		assertEquals(result,true);
	
	}
	
	@Test
	void testWrongArrayLength() {
	
		Human human = new Human();
		String[] dna = new String[] {"CTTTTA","CCG","TTCCGG","AGACGG","TCCCTA","TCATTG"};
		
		boolean  result = human.validateLengthElement(dna);
		
		assertEquals(result,false);
	
	}
	
	@Test
	void testCorrectArrayLength() {
		
		Human human = new Human();
		String[] dna = new String[] {"CTTTTA","CCGGTG","TTCCGG","AGACGG","TCCCTA","TCATTG"};
		
		boolean  result = human.validateLengthElement(dna);
		
		assertEquals(result,true);
	
	}
	
	@Test
	void testCorrectArrayEmpty() {
		
		Human human = new Human();
		String[] dna = new String[0];
		
		boolean  result = human.validateLengthElement(dna);
		
		assertEquals(result,false);
	
	}

}
