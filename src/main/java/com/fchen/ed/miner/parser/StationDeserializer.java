package com.fchen.ed.miner.parser;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fchen.ed.miner.dao.CommodityDao;
import com.fchen.ed.miner.model.Station;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class StationDeserializer implements JsonDeserializer<List<Station>> {
	
	private CommodityDao commoditiesDao = CommodityDao.getInstance();
	
	public List<Station> deserialize(JsonElement json, Type typeT, JsonDeserializationContext context)
			throws JsonParseException {
		final JsonArray masterArray = json.getAsJsonArray();

		Iterator<JsonElement> masterIterator = masterArray.iterator();

		List<Station> stations = new ArrayList<Station>();

		while (masterIterator.hasNext()) {
			JsonElement currentMasterElement = masterIterator.next();
			stations.add(deserializeMasterObject(currentMasterElement.getAsJsonObject()));
		}

		return stations;
	}

	private Station deserializeMasterObject(JsonObject object) {
		Station currentStation = new Station();
		
		currentStation.setId(object.get("id").getAsLong());
		currentStation.setName(object.get("name").getAsString());
		
		return currentStation;
	}
}
