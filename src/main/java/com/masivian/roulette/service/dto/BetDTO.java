package com.masivian.roulette.service.dto;

public class BetDTO {
	
	private String rouletteId;
	
	private int number;
	
	private Double amountMoney;
	
	private String color;

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
