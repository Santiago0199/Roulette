package com.masivian.roulette.data.repository;

import org.springframework.stereotype.Repository;

import com.masivian.roulette.data.model.Bet;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface BetRepository extends CrudRepository<Bet, String>{
	List<Bet> findByRouletteId(String rouletteId);
}
