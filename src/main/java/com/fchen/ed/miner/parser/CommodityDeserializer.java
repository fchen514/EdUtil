package com.fchen.ed.miner.parser;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.fchen.ed.miner.model.Commodity;
import com.fchen.ed.miner.model.Station;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class CommodityDeserializer implements JsonDeserializer<Set<Commodity>> {

	public Set<Commodity> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		final JsonArray masterArray = json.getAsJsonArray();

		Iterator<JsonElement> masterIterator = masterArray.iterator();

		List<Commodity> commodities = new ArrayList<Commodity>();

		while (masterIterator.hasNext()) {
			JsonElement currentMasterElement = masterIterator.next();
			Commodity.add(deserializeMasterObject(currentMasterElement.getAsJsonObject()));
		}

		return commodities;
	}

	private Commodity deserializeMasterObject(JsonObject object) {
		Commodity currentCommodity = new Commodity();
		
		currentCommodity.setId(object.get("id").getAsLong());
		currentCommodity.setName(object.get("name").getAsString());
		currentCommodity.setCategory(category);
		
		return currentCommodity;
	}
}
