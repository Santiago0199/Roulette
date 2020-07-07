package com.masivian.roulette.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masivian.roulette.data.model.Roulette;
import com.masivian.roulette.data.model.enums.OperationState;
import com.masivian.roulette.data.model.enums.RouletteState;
import com.masivian.roulette.data.repository.RouletteRepository;
import com.masivian.roulette.exception.RouletteNotFoundException;
import com.masivian.roulette.service.RouletteService;
import com.masivian.roulette.service.dto.RouletteDTO;
import com.masivian.roulette.service.mapper.RouletteMapper;

@Service
public class RouletteServiceImpl implements RouletteService {

	@Autowired
	private RouletteRepository rouletteRepository;

	@Autowired
	private RouletteMapper rouletteMapper;

	@Override
	public RouletteDTO createRoulette() {
		Roulette roulette = new Roulette();
		roulette.setState(RouletteState.CLOSE);
		rouletteRepository.save(roulette);
		return rouletteMapper.toDto(roulette);
	}

	@Override
	public RouletteDTO openRoulette(String rouletteId) throws RouletteNotFoundException {
		Roulette roulette = rouletteRepository.findById(rouletteId)
				.orElseThrow(() -> new RouletteNotFoundException(OperationState.FAILED.getValue()));
		roulette.setState(RouletteState.OPEN);
		rouletteRepository.save(roulette);
		return rouletteMapper.toDto(roulette);
	}

	@Override
	public List<RouletteDTO> getAllRoulettes() {
		Iterable<Roulette> roulettesIterable = rouletteRepository.findAll();
		List<RouletteDTO> roulettes = StreamSupport.stream(roulettesIterable.spliterator(), false)
				.map(rouletteMapper::toDto).collect(Collectors.toList());
		return roulettes;
	}
}
