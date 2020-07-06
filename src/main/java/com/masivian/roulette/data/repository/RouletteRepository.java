package com.masivian.roulette.data.repository;

import org.springframework.stereotype.Repository;
import com.masivian.roulette.data.model.Roulette;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface RouletteRepository extends CrudRepository<Roulette, String>{

}
