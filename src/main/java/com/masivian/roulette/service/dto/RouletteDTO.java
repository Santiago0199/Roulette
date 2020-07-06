package com.masivian.roulette.service.dto;

import java.io.Serializable;

public class RouletteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
