package com.meli.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meli.domain.Stat;
import com.meli.dto.StatDTO;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/stat")
public class StatController {
	
	@Autowired
	private Stat stat;
	
	@RequestMapping(value="/", method= GET)
	public StatDTO getStat() {
		
		return this.stat.getStat();
			
	}

}
