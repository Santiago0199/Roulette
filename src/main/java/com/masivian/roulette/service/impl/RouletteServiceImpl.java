package com.masivian.roulette.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masivian.roulette.data.model.Roulette;
import com.masivian.roulette.data.repository.RouletteRepository;
import com.masivian.roulette.service.RouletteService;
import com.masivian.roulette.service.dto.RouletteDTO;
import com.masivian.roulette.service.mapper.RouletteMapper;

@Service
public class RouletteServiceImpl implements RouletteService{

	@Autowired
	private RouletteRepository rouletteRepository;
	
	@Autowired
	private RouletteMapper rouletteMapper;
	
	@Override
	public RouletteDTO create(RouletteDTO rouletteDTO) {
		Roulette roulette = rouletteMapper.toEntity(rouletteDTO);
		rouletteRepository.save(roulette);
		return rouletteMapper.toDto(roulette);
	}

}
