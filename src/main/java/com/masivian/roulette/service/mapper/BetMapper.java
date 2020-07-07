package com.masivian.roulette.service.mapper;

import org.mapstruct.Mapper;

import com.masivian.roulette.data.model.Bet;
import com.masivian.roulette.service.dto.BetDTO;

@Mapper(componentModel = "spring")
public interface BetMapper extends MapperBase<BetDTO, Bet>{

}
