package com.masivian.roulette.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.masivian.roulette.api.response.SingleResponseBody;
import com.masivian.roulette.data.model.enums.OperationState;
import com.masivian.roulette.service.RouletteService;
import com.masivian.roulette.service.dto.RouletteDTO;

@RestController
public class RouletteApiImpl implements RouletteApi {
	@Autowired
	private RouletteService rouletteService;

	@Override
	public ResponseEntity<SingleResponseBody> createRoulette() {
		RouletteDTO rouletteResponse = rouletteService.createRoulette();
		SingleResponseBody responseBody = new SingleResponseBody(OperationState.SUCCSESS);
		responseBody.addToPayload("rouletteId", rouletteResponse.getId());
		return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
	}

	@Override
	public ResponseEntity<SingleResponseBody> openRoulette(String rouletteId) {
		rouletteService.openRoulette(rouletteId);
		SingleResponseBody responseBody = new SingleResponseBody(OperationState.SUCCSESS);
		return ResponseEntity.ok(responseBody);
	}

	@Override
	public ResponseEntity<List<RouletteDTO>> getAllRoulettes() {
		return ResponseEntity.ok(rouletteService.getAllRoulettes());
	}
}
