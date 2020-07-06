package com.masivian.roulette.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.masivian.roulette.service.RouletteService;
import com.masivian.roulette.service.dto.RouletteDTO;

@RestController
public class RouletteApiImpl implements RouletteApi {
	@Autowired
	private RouletteService rouletteService;

	@Override
	public ResponseEntity<String> create(RouletteDTO rouletteDTO) {
		RouletteDTO rouletteResponse = rouletteService.create(rouletteDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(rouletteResponse.getId());
	}
}
