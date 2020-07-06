package com.masivian.roulette.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.masivian.roulette.service.dto.RouletteDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/api/roulette")
@Api(value = "api roulette")
public interface RouletteApi {
    @ApiOperation(
            value = "create-roulette",
            response = String.class,
            notes = "create-roulette",
            produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "When every thing went OK")})
    @PostMapping
    ResponseEntity<String> create(@RequestBody RouletteDTO rouletteDTO);
}
