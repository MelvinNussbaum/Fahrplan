package ch.bbw.mn.fahrplan.controller;

import ch.bbw.mn.fahrplan.dao.FahrplanDAO;
import ch.bbw.mn.fahrplan.dao.WeatherDAO;
import ch.bbw.mn.fahrplan.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FahrplanController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/requestStationboard")
	public String getRequestStationboard(Model model) {
		model.addAttribute("stationboard", new StationboardRequest());
		return "stationboard";
	}
	
	@PostMapping("/requestStationboard")
	public String postRequestStationboard(@ModelAttribute("stationboard") StationboardRequest stationboard, Model model) {
		FahrplanDAO fahrplanDAO = new FahrplanDAO();
		WeatherDAO weatherDAO = new WeatherDAO();
		StationboardResponse stationboardResponse = fahrplanDAO.getStationboard(stationboard.getLocation());
		WeatherResponse weatherResponse = weatherDAO.getWeather(stationboard.getLocation());
		model.addAttribute("stationboardResponse", stationboardResponse);
		model.addAttribute("weatherResponse", weatherResponse);
		return "stationboardResults";
	}
	
	@GetMapping("/requestConnection")
	public String getRequestConnection(Model model) {
		model.addAttribute("connection", new ConnectionRequest());
		return "connection";
	}
	
	@PostMapping("/requestConnection")
	public String postRequestConnection(@ModelAttribute("connection") ConnectionRequest connection, Model model) {
		FahrplanDAO fahrplanDAO = new FahrplanDAO();
		WeatherDAO weatherDAO = new WeatherDAO();
		ConnectionResponse connectionResponse = fahrplanDAO.getConnection(connection.getFrom(), connection.getTo());
		WeatherResponse weatherResponse = weatherDAO.getWeather(connection.getTo());
		model.addAttribute("connectionResponse", connectionResponse);
		model.addAttribute("weatherResponse", weatherResponse);
		return "connectionResults";
	}
}
