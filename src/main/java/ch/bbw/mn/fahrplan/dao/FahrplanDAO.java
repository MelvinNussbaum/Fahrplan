package ch.bbw.mn.fahrplan.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import ch.bbw.mn.fahrplan.model.ConnectionResponse;
import com.google.gson.Gson;

import ch.bbw.mn.fahrplan.model.StationboardResponse;
import com.google.gson.GsonBuilder;

public class FahrplanDAO {
	
	private final Logger logger = Logger.getGlobal();

	public StationboardResponse getStationboard(String station) {
		
		try {
			URL url = new URL("http://transport.opendata.ch/v1/stationboard?station=" + station + "&fields[]=stationboard/name&fields[]=stationboard/to");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String jsonResponse = reader.lines().collect(Collectors.joining());
				logger.log(Level.INFO, "Sent request to '"  + url.toString() + "' [HTTP " + con.getResponseCode() + "]:\n" + jsonResponse);
				Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
				return gson.fromJson(jsonResponse, StationboardResponse.class);
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String errorString = reader.lines().collect(Collectors.joining());
				logger.log(Level.SEVERE, errorString);
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage() + "\n" + e.getStackTrace());
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ConnectionResponse getConnection(String from, String to) {
		
		try {
			URL url = new URL("http://transport.opendata.ch/v1/connections?from=" + from + "&to=" + to + "&fields[]=connections/from/station/name&fields[]=connections/to/station/name&fields[]=connections/from/departure&fields[]=connections/from/platform");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String jsonResponse = reader.lines().collect(Collectors.joining());
				logger.log(Level.INFO, "Sent request to '"  + url.toString() + "' [HTTP " + con.getResponseCode() + "]:\n" + jsonResponse);
				Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
				return gson.fromJson(jsonResponse, ConnectionResponse.class);
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String errorString = reader.lines().collect(Collectors.joining());
				logger.log(Level.SEVERE, errorString);
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage() + "\n" + e.getStackTrace());
			e.printStackTrace();
		}
		
		return null;
	}
}
