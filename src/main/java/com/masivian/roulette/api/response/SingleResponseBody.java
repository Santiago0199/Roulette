package com.masivian.roulette.api.response;

import java.util.HashMap;
import java.util.Map;

import com.masivian.roulette.data.model.enums.OperationState;

public class SingleResponseBody {
	private OperationState state;
	private Map<String, Object> payload;
	
	public SingleResponseBody() {
		payload = new HashMap<>();
	}
	
	public SingleResponseBody(OperationState state) {
		payload = new HashMap<>();
		this.state = state;
	}
	
	public void addToPayload(String key, Object value) {
		this.payload.put(key, value);
	}

	public OperationState getState() {
		return state;
	}

	public void setState(OperationState state) {
		this.state = state;
	}

	public Map<String, Object> getPayload() {
		return payload;
	}

	public void setPayload(Map<String, Object> payload) {
		this.payload = payload;
	}
}
