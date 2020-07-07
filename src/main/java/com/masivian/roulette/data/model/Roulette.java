package com.masivian.roulette.data.model;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import com.masivian.roulette.data.model.enums.RouletteState;

@RedisHash("Roulette")
public class Roulette {
	private String id;

	@Indexed
	private RouletteState state;
	
	public RouletteState getState() {
		return state;
	}

	public void setState(RouletteState state) {
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
