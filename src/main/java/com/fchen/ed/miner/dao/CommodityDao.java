package com.fchen.ed.miner.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fchen.ed.miner.model.Commodity;
import com.fchen.ed.miner.model.CommodityCategory;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class CommodityDao extends GenericStaticTypeDaoImpl<Commodity> {

	private static CommodityDao instance = null;
	private Map<String, Commodity> nameSearchMap;
	private Multimap<CommodityCategory, Commodity> categorySearchMap;

	protected CommodityDao() {
		nameSearchMap = new HashMap<String, Commodity>();
		categorySearchMap = ArrayListMultimap.create();
	}

	public static CommodityDao getInstance() {
		if (instance == null) {
			instance = new CommodityDao();
		}

		return instance;
	}

	protected void updateSearchMap() {
		nameSearchMap.clear();

		for (Commodity commodity : masterSet) {
			nameSearchMap.put(commodity.getName(), commodity);
		}
	}

	public Commodity getCommodityByName(String name) {
		return nameSearchMap.get(name);
	}

	public List<Commodity> getByCategory(CommodityCategory category) {
		return (List<Commodity>) categorySearchMap.get(category);
	}
}
