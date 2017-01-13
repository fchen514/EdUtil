package com.fchen.ed.miner.model;

public enum LandingPadSize {
	MEDIUM("M"), LARGE("L");

	private String value;

	LandingPadSize(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
