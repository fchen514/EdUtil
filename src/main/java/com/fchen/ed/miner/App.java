package com.fchen.ed.miner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.fchen.ed.miner.model.Station;
import com.fchen.ed.miner.parser.StationDeserializer;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		FileReader reader = null;

		GsonBuilder gsonBuilder = new GsonBuilder();
	    gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
	    gsonBuilder.registerTypeAdapter(List.class, new StationDeserializer());
	    Gson gson = gsonBuilder.create();
	    
		try {
			reader = new FileReader("src/main/resources/stations.json");
		    List<Station> stations = gson.fromJson(reader, List.class);

			for (Station station : stations) {
				System.out.println(station.getName());
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
