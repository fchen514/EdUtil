package com.fchen.ed.miner.parser;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class IntegerBooleanTypeAdapter implements JsonDeserializer<Boolean> {

	@Override
	public Boolean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext arg2)
			throws JsonParseException {
		int intBool = json.getAsInt();

		return intBool == 1 ? true : false;
	}
}
