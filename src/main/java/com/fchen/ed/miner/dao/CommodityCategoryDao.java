package com.fchen.ed.miner.dao;

import java.util.HashMap;
import java.util.Map;

import com.fchen.ed.miner.model.CommodityCategory;

public class CommodityCategoryDao extends GenericStaticTypeDaoImpl<CommodityCategory> {
	private static CommodityCategoryDao instance = null;
	private Map<String, CommodityCategory> commoditiesNameSearchMap;

	protected CommodityCategoryDao() {
		commoditiesNameSearchMap = new HashMap<String, CommodityCategory>();
	}

	public static CommodityCategoryDao getInstance() {
		if (instance == null) {
			instance = new CommodityCategoryDao();
		}

		return instance;
	}

	protected void updateSearchMap() {
		for (CommodityCategory commodityCategory : masterSet) {
			commoditiesNameSearchMap.put(commodityCategory.getName(), commodityCategory);
		}
	}
}
