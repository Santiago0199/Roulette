package com.masivian.roulette.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("roulette")
public class ValidationConfig {
	private int maxNumberBet;
	private int minNumberBet;
	private int maxAmountBet;
	private String msgAmountInvalid;
	private String msgNumberInvalid;
	private String msgBetInvalid;
	
	public int getMaxNumberBet() {
		return maxNumberBet;
	}
	public void setMaxNumberBet(int maxNumberBet) {
		this.maxNumberBet = maxNumberBet;
	}
	public int getMinNumberBet() {
		return minNumberBet;
	}
	public void setMinNumberBet(int minNumberBet) {
		this.minNumberBet = minNumberBet;
	}
	public int getMaxAmountBet() {
		return maxAmountBet;
	}
	public void setMaxAmountBet(int maxAmountBet) {
		this.maxAmountBet = maxAmountBet;
	}
	public String getMsgAmountInvalid() {
		return msgAmountInvalid;
	}
	public void setMsgAmountInvalid(String msgAmountInvalid) {
		this.msgAmountInvalid = msgAmountInvalid;
	}
	public String getMsgNumberInvalid() {
		return msgNumberInvalid;
	}
	public void setMsgNumberInvalid(String msgNumberInvalid) {
		this.msgNumberInvalid = msgNumberInvalid;
	}
	public String getMsgBetInvalid() {
		return msgBetInvalid;
	}
	public void setMsgBetInvalid(String msgBetInvalid) {
		this.msgBetInvalid = msgBetInvalid;
	}
}
