package com.fchen.ed.miner.model;

public class Commodity {
	private long id;
	private String name;
	private CommodityCategory category;
	private int averagePrice;
	private boolean isRare;
	
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
	public CommodityCategory getCategory() {
		return category;
	}
	public void setCategory(CommodityCategory category) {
		this.category = category;
	}
	public int getAveragePrice() {
		return averagePrice;
	}
	public void setAveragePrice(int averagePrice) {
		this.averagePrice = averagePrice;
	}
	public boolean isRare() {
		return isRare;
	}
	public void setRare(boolean isRare) {
		this.isRare = isRare;
	}
	@Override
	public String toString() {
		return "Commodity [id=" + id + ", name=" + name + ", category=" + category + ", averagePrice=" + averagePrice
				+ ", isRare=" + isRare + "]";
	}
}
