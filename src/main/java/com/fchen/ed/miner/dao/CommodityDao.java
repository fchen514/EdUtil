package com.fchen.ed.miner.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fchen.ed.miner.model.Commodity;

public class CommodityDao {

	private static CommodityDao instance = null;
	private HashSet<Commodity> commodities;
	private Map<String, Commodity> commoditiesNameSearchMap;

	protected CommodityDao() {
		commodities = new HashSet<Commodity>();
		commoditiesNameSearchMap = new HashMap<String, Commodity>();
	}

	public static CommodityDao getInstance() {
		if (instance == null) {
			instance = new CommodityDao();
		}

		return instance;
	}

	public Set<Commodity> getAll() {
		return commodities;
	}

	private void updateSearchMap() {
		commoditiesNameSearchMap.clear();

		for (Commodity commodity : commodities) {
			commoditiesNameSearchMap.put(commodity.getName(), commodity);
		}
	}

	public void addAll(Set<Commodity> commodities) {
		this.commodities.addAll(commodities);
		updateSearchMap();
	}

	public void add(Commodity commodity) {
		commodities.add(commodity);
		updateSearchMap();
	}

	public Commodity getCommodityByName(String name) {
		return commoditiesNameSearchMap.get(name);
	}
}
