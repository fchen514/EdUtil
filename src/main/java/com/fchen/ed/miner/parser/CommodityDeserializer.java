package com.fchen.ed.miner.parser;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.fchen.ed.miner.dao.CommodityCategoryDao;
import com.fchen.ed.miner.model.Commodity;
import com.fchen.ed.miner.model.CommodityCategory;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class CommodityDeserializer implements JsonDeserializer<Set<Commodity>> {
	CommodityCategoryDao commodityCategoryDao = CommodityCategoryDao.getInstance();

	public Set<Commodity> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		final JsonArray masterArray = json.getAsJsonArray();

		Iterator<JsonElement> masterIterator = masterArray.iterator();

		Set<Commodity> commodities = new HashSet<Commodity>();

		while (masterIterator.hasNext()) {
			JsonElement currentMasterElement = masterIterator.next();
			commodities.add(deserializeMasterObject(currentMasterElement.getAsJsonObject()));
		}

		return commodities;
	}

	private Commodity deserializeMasterObject(JsonObject object) {
		Commodity currentCommodity = new Commodity();

		currentCommodity.setId(object.get("id").getAsLong());
		currentCommodity.setName(object.get("name").getAsString());
		currentCommodity.setAveragePrice(object.get("average_price").getAsInt());
		currentCommodity.setRare(object.get("is_rare").getAsBoolean());

		JsonObject categoryObject = object.get("category").getAsJsonObject();
		long categoryId = categoryObject.get("id").getAsLong();
		String categoryName = categoryObject.get("name").getAsString();

		CommodityCategory currentCategory = new CommodityCategory(categoryId, categoryName);
		commodityCategoryDao.add(currentCategory);
		currentCommodity.setCategory(currentCategory);

		return currentCommodity;
	}
}
