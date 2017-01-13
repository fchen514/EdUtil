package com.fchen.ed.miner.model;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

public class System {
	private long id;
	private long edsmId;
	private String name;
	private Vector3D coordinate;
	private long population;
	private boolean isPopulated;
	private Government government;
	private Faction allegiance;
	private StateType state;
	
}
