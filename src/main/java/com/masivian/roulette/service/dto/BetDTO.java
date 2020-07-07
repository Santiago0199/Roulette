package com.masivian.roulette.service.dto;

import com.masivian.roulette.data.model.enums.ResultBet;

public class BetDTO {
	
	private String rouletteId;
	
	private int number;
	
	private Double amountMoney;
	
	private String color;
	
	private ResultBet result;

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

	public ResultBet getResult() {
		return result;
	}

	public void setResult(ResultBet result) {
		this.result = result;
	}
}
