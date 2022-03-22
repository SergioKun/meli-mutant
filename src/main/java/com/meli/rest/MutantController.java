package com.meli.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meli.domain.Human;
import com.meli.dto.DnaDTO;
import com.meli.dto.MutantDTO;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/mutant")
public class MutantController {
	
	@Autowired
	private Human human;
	
	
	@RequestMapping(value="/", method= POST)
	public ResponseEntity<MutantDTO> IsMutant(@RequestBody DnaDTO dnaDTO) {
		
		if(!this.human.validateLengthElement(dnaDTO.getDns())) {
			return new ResponseEntity<>(new MutantDTO(false,"Invalid array, check the length of the elements"),HttpStatus.BAD_REQUEST);
		}
			
		if(!this.human.validateLetters(dnaDTO.getDns())) {
			return new ResponseEntity<>(new MutantDTO(false,"The allowed letters are: A,T,C,G"),HttpStatus.BAD_REQUEST);
		}
			
		if(this.human.isMutant(dnaDTO.getDns())) {
			return new ResponseEntity<>(new MutantDTO(true,""),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new MutantDTO(false,""),HttpStatus.FORBIDDEN);
		}
	}

}
