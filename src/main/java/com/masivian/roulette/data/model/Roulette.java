package com.masivian.roulette.data.model;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Roulette")
public class Roulette {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
