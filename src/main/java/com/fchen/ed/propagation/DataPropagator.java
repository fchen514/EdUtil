package com.fchen.ed.propagation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.fchen.ed.miner.dao.CommodityDao;
import com.fchen.ed.miner.model.Commodity;
import com.fchen.ed.miner.parser.CommodityDeserializer;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class DataPropagator {
	public static void doPropagation() {
		propagateCommodities();
	}
	
	public static void propagateCommodities() {
		FileReader reader = null;

		GsonBuilder gsonBuilder = new GsonBuilder();
	    gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
	    gsonBuilder.registerTypeAdapter(List.class, new CommodityDeserializer());
	    Gson gson = gsonBuilder.create();
	    
		try {
			reader = new FileReader("src/main/resources/commodities.json");
		    Set<Commodity> commodities = gson.fromJson(reader, Set<Commodity>.class);
		    
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
