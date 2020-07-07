package com.masivian.roulette.service;

import java.util.List;

import com.masivian.roulette.exception.BussinesException;
import com.masivian.roulette.service.dto.BetDTO;
import com.masivian.roulette.service.dto.RouletteDTO;

public interface RouletteService {
	RouletteDTO createRoulette();
	
	RouletteDTO openRoulette(String rouletteDTO) throws BussinesException;
	
	BetDTO bet(BetDTO betDTO) throws BussinesException;
	
	List<RouletteDTO> getAllRoulettes();
}
