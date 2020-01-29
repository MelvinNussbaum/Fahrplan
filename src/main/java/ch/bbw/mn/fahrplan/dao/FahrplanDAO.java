package ch.bbw.mn.fahrplan.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;

import ch.bbw.mn.fahrplan.model.StationboardResponseObject;

public class FahrplanDAO {
	
	private final Logger logger = Logger.getGlobal();

	public StationboardResponseObject getStationboard(String station) {

		StationboardResponseObject stationboard = null;
	
		try {
			URL url = new URL("http://example.com");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				Gson gson = new Gson();
				stationboard = gson.fromJson(reader, StationboardResponseObject.class);
				return stationboard;
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				logger.log(Level.SEVERE, reader.toString());
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage() + "\n" + e.getStackTrace());
			e.printStackTrace();
		}
		
		return stationboard;
	}
}
