package ch.bbw.mn.fahrplan.controller;

import ch.bbw.mn.fahrplan.dao.FahrplanDAO;
import ch.bbw.mn.fahrplan.model.ConnectionRequest;
import ch.bbw.mn.fahrplan.model.ConnectionResponse;
import ch.bbw.mn.fahrplan.model.StationboardRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ch.bbw.mn.fahrplan.model.StationboardResponse;

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
		StationboardResponse stationboardResponse = fahrplanDAO.getStationboard(stationboard.getLocation());
		model.addAttribute("stationboardResponse", stationboardResponse);
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
		ConnectionResponse connectionResponse = fahrplanDAO.getConnection(connection.getFrom(), connection.getTo());
		model.addAttribute("connectionResponse", connectionResponse);
		return "connectionResults";
	}
}
