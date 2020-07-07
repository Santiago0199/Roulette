package com.masivian.roulette.data.model.enums;

public enum OperationState {
	SUCCSESS("SUCCESS"), FAILED("FAILED");
	
	private String value;

	private OperationState(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}
