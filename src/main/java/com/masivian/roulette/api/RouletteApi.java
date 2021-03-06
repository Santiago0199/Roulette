package com.masivian.roulette.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.masivian.roulette.api.response.SingleResponseBody;
import com.masivian.roulette.service.dto.BetDTO;
import com.masivian.roulette.service.dto.RouletteDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/api/roulette")
@Api(value = "api roulette")
public interface RouletteApi {
    @ApiOperation(
            value = "create roulette",
            response = SingleResponseBody.class,
            notes = "create-roulette",
            produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "When every thing went OK")})
    @PostMapping
    ResponseEntity<SingleResponseBody> createRoulette();
    
    @ApiOperation(
            value = "open roulette",
            response = SingleResponseBody.class,
            notes = "open-roulette",
            produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "When every thing went OK")})
    @PutMapping("/{rouletteId}")
    ResponseEntity<SingleResponseBody> openRoulette(@PathVariable String rouletteId);
    
    @ApiOperation(
            value = "create bet",
            response = SingleResponseBody.class,
            notes = "create bet",
            produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "When every thing went OK")})
    @PostMapping("/bet")
    ResponseEntity<SingleResponseBody> bet(@RequestHeader String userId,@RequestBody BetDTO bet);
    
    @ApiOperation(
            value = "Close bets",
            response = SingleResponseBody.class,
            notes = "Close bets",
            produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "When every thing went OK")})
    @PutMapping("/close")
    ResponseEntity<List<BetDTO>> closeBets(@PathVariable String rouletteId);
    
    @ApiOperation(
            value = "get all roulettes",
            response = RouletteDTO.class,
            notes = "get all roulettes",
            produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "When every thing went OK")})
    @GetMapping
    ResponseEntity<List<RouletteDTO>> getAllRoulettes();
}
