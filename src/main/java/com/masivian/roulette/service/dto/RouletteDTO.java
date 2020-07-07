package com.masivian.roulette.service.dto;

import java.io.Serializable;

import com.masivian.roulette.data.model.enums.RouletteState;

public class RouletteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private RouletteState state;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RouletteState getState() {
		return state;
	}

	public void setState(RouletteState state) {
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
