package com.masivian.roulette.data.model;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("bet")
public class Bet {
	
	private String id;
	
	@Indexed
	private String rouletteId;
	
	@Indexed
	private int number;
	
	@Indexed
	private Double amountMoney;
	
	@Indexed
	private String color;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRouletteId() {
		return rouletteId;
	}

	public void setRouletteId(String rouletteId) {
		this.rouletteId = rouletteId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Double getAmountMoney() {
		return amountMoney;
	}

	public void setAmountMoney(Double amountMoney) {
		this.amountMoney = amountMoney;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
