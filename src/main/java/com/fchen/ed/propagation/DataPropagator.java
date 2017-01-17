package com.fchen.ed.propagation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.fchen.ed.miner.dao.CommodityDao;
import com.fchen.ed.miner.model.Commodity;
import com.fchen.ed.miner.parser.IntegerBooleanTypeAdapter;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class DataPropagator {
	public static void doPropagation() {
		System.out.println("Loading commodities...");
		propagateCommodities();
		System.out.println("Finished");
	}

	public static void propagateCommodities() {
		FileReader reader = null;

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(boolean.class, new IntegerBooleanTypeAdapter());
		gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
		Gson gson = gsonBuilder.create();

		try {
			reader = new FileReader("src/main/resources/commodities.json");
			Commodity[] commodities = gson.fromJson(reader, Commodity[].class);

			CommodityDao.getInstance().addAll(commodities);

			for (Commodity commodity : commodities) {
				System.out.println(commodity);
			}

		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
