package com.fchen.ed.miner.model;

public enum StationState {
	RETREAT("Retreat");
	
	private String name;
	
	StationState(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
