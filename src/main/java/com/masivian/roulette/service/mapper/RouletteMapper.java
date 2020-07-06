package com.masivian.roulette.service.mapper;

import org.mapstruct.Mapper;

import com.masivian.roulette.data.model.Roulette;
import com.masivian.roulette.service.dto.RouletteDTO;

@Mapper(componentModel = "spring")
public interface RouletteMapper extends MapperBase<RouletteDTO, Roulette>{

}
