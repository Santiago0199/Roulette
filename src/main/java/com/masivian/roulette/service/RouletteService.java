package com.masivian.roulette.service;

import java.util.List;

import com.masivian.roulette.exception.RouletteNotFoundException;
import com.masivian.roulette.service.dto.RouletteDTO;

public interface RouletteService {
	RouletteDTO createRoulette();
	
	RouletteDTO openRoulette(String rouletteDTO) throws RouletteNotFoundException;
	
	List<RouletteDTO> getAllRoulettes();
}
