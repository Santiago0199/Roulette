package com.masivian.roulette.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masivian.roulette.conf.ValidationConfig;
import com.masivian.roulette.data.model.Bet;
import com.masivian.roulette.data.model.Roulette;
import com.masivian.roulette.data.model.enums.OperationState;
import com.masivian.roulette.data.model.enums.ResultBet;
import com.masivian.roulette.data.model.enums.RouletteState;
import com.masivian.roulette.data.repository.BetRepository;
import com.masivian.roulette.data.repository.RouletteRepository;
import com.masivian.roulette.exception.BetInvalidException;
import com.masivian.roulette.exception.BussinesException;
import com.masivian.roulette.exception.RouletteNotFoundException;
import com.masivian.roulette.service.RouletteService;
import com.masivian.roulette.service.dto.BetDTO;
import com.masivian.roulette.service.dto.RouletteDTO;
import com.masivian.roulette.service.mapper.BetMapper;
import com.masivian.roulette.service.mapper.RouletteMapper;
import com.masivian.roulette.util.RandomUtil;

@Service
public class RouletteServiceImpl implements RouletteService {

	@Autowired
	private RouletteRepository rouletteRepository;
	
	@Autowired
	private BetRepository betRepository;

	@Autowired
	private RouletteMapper rouletteMapper;
	
	@Autowired
	private BetMapper betMapper;
	
	@Autowired
	private ValidationConfig validationConfig;

	@Override
	public RouletteDTO createRoulette() {
		Roulette roulette = new Roulette();
		roulette.setState(RouletteState.CLOSE);
		rouletteRepository.save(roulette);
		return rouletteMapper.toDto(roulette);
	}

	@Override
	public RouletteDTO openRoulette(String rouletteId) throws BussinesException {
		Roulette roulette = rouletteRepository.findById(rouletteId)
				.orElseThrow(() -> new RouletteNotFoundException(OperationState.FAILED.getValue()));
		roulette.setState(RouletteState.OPEN);
		rouletteRepository.save(roulette);
		return rouletteMapper.toDto(roulette);
	}
	
	@Override
	public BetDTO bet(BetDTO betDTO) throws BussinesException{
		if(!validateNumberBet(betDTO.getNumber())) {
			throw new BetInvalidException(validationConfig.getMsgNumberInvalid());
		}
		
		if(!validateAmountMoney(betDTO.getAmountMoney())) {
			throw new BetInvalidException(validationConfig.getMsgAmountInvalid());
		}
		
		Roulette roulette = rouletteRepository.findById(betDTO.getRouletteId())
				.orElseThrow(() -> new RouletteNotFoundException(OperationState.FAILED.getValue()));
		
		if(!roulette.getState().equals(RouletteState.OPEN)) {
			throw new BetInvalidException(validationConfig.getMsgBetInvalid());
		}
		
		Bet bet = betMapper.toEntity(betDTO);
		betRepository.save(bet);
		return betMapper.toDto(bet);
	}
	
	@Override
	public List<BetDTO> closeBets(String rouletteId) {
		Roulette roulette = rouletteRepository.findById(rouletteId)
				.orElseThrow(() -> new RouletteNotFoundException(OperationState.FAILED.getValue()));
		
		roulette.setState(RouletteState.CLOSE);
		rouletteRepository.save(roulette);
		
		List<Bet> betsByRoulette = betRepository.findByRouletteId(rouletteId);
		List<BetDTO> bets = betsByRoulette.stream().map(betMapper::toDto).collect(Collectors.toList());
		
		bets = bets.stream().map(bet -> {
			bet.setResult(isWinner() ? ResultBet.WIN : ResultBet.LOSE);
			return bet;
		}).collect(Collectors.toList());
		return bets;
	}

	@Override
	public List<RouletteDTO> getAllRoulettes() {
		Iterable<Roulette> roulettesIterable = rouletteRepository.findAll();
		List<RouletteDTO> roulettes = StreamSupport.stream(roulettesIterable.spliterator(), false)
				.map(rouletteMapper::toDto).collect(Collectors.toList());
		return roulettes;
	}
	
	private boolean validateNumberBet(int number) {
		return number >= validationConfig.getMinNumberBet() && number <= validationConfig.getMaxNumberBet();
	}
	
	private boolean validateAmountMoney(Double amount) {
		return amount <= validationConfig.getMaxAmountBet();
	}
	
	private boolean isWinner() {
		return RandomUtil.getNumRandom() == 1;
	}
}
