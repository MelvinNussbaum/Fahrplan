package ch.bbw.mn.fahrplan.dao;

import ch.bbw.mn.fahrplan.model.StationboardResponse;
import ch.bbw.mn.fahrplan.model.WeatherResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * WeatherDAO.java
 *
 * @author Melvin Nussbaum
 * @project fahrplan
 * @date 30.01.2020
 */
public class WeatherDAO {
    private final Logger logger = Logger.getGlobal();
    
    public WeatherResponse getWeather(String location) {
        
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=e8fcb414a8c549ced15e22f3e45dea6d");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String jsonResponse = reader.lines().collect(Collectors.joining());
                logger.log(Level.INFO, "Sent request to '"  + url.toString() + "' [HTTP " + con.getResponseCode() + "]:\n" + jsonResponse);
                Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                return gson.fromJson(jsonResponse, WeatherResponse.class);
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
