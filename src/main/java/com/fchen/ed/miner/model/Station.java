package com.fchen.ed.miner.model;

import java.util.Date;
import java.util.List;

public class Station {
	private long id;
	private String name;
	private System system;
	private Date updatedAt;
	private LandingPadSize landingPadSize;
	private int distanceToStar;
	private Government government;
	private Faction allegiance;
	private boolean hasBlackMarket;
	private boolean hasRefuel;
	private boolean hasRepair;
	private boolean hasRearm;
	private boolean hasOutfitting;
	private boolean hasShipyard;
	private boolean hasCommodities;

	private List<Commodity> importCommodities;
	private List<Commodity> exportCommodities;
	private List<Commodity> prohibitedCommodities;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public LandingPadSize getLandingPadSize() {
		return landingPadSize;
	}

	public void setLandingPadSize(LandingPadSize landingPadSize) {
		this.landingPadSize = landingPadSize;
	}

	public int getDistanceToStar() {
		return distanceToStar;
	}

	public void setDistanceToStar(int distanceToStar) {
		this.distanceToStar = distanceToStar;
	}

	public Government getGovernment() {
		return government;
	}

	public void setGovernment(Government government) {
		this.government = government;
	}

	public Faction getAllegiance() {
		return allegiance;
	}

	public void setAllegiance(Faction allegiance) {
		this.allegiance = allegiance;
	}

	public boolean isHasBlackMarket() {
		return hasBlackMarket;
	}

	public void setHasBlackMarket(boolean hasBlackMarket) {
		this.hasBlackMarket = hasBlackMarket;
	}

	public boolean isHasRefuel() {
		return hasRefuel;
	}

	public void setHasRefuel(boolean hasRefuel) {
		this.hasRefuel = hasRefuel;
	}

	public boolean isHasRepair() {
		return hasRepair;
	}

	public void setHasRepair(boolean hasRepair) {
		this.hasRepair = hasRepair;
	}

	public boolean isHasRearm() {
		return hasRearm;
	}

	public void setHasRearm(boolean hasRearm) {
		this.hasRearm = hasRearm;
	}

	public boolean isHasOutfitting() {
		return hasOutfitting;
	}

	public void setHasOutfitting(boolean hasOutfitting) {
		this.hasOutfitting = hasOutfitting;
	}

	public boolean isHasShipyard() {
		return hasShipyard;
	}

	public void setHasShipyard(boolean hasShipyard) {
		this.hasShipyard = hasShipyard;
	}

	public boolean isHasCommodities() {
		return hasCommodities;
	}

	public void setHasCommodities(boolean hasCommodities) {
		this.hasCommodities = hasCommodities;
	}

	public List<Commodity> getImportCommodities() {
		return importCommodities;
	}

	public void setImportCommodities(List<Commodity> importCommodities) {
		this.importCommodities = importCommodities;
	}

	public List<Commodity> getExportCommodities() {
		return exportCommodities;
	}

	public void setExportCommodities(List<Commodity> exportCommodities) {
		this.exportCommodities = exportCommodities;
	}

	public List<Commodity> getProhibitedCommodities() {
		return prohibitedCommodities;
	}

	public void setProhibitedCommodities(List<Commodity> prohibitedCommodities) {
		this.prohibitedCommodities = prohibitedCommodities;
	}

}
