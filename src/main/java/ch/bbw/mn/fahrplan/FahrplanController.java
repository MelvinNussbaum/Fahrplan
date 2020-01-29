package ch.bbw.mn.fahrplan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ch.bbw.mn.fahrplan.model.ConnectionResponseObject;
import ch.bbw.mn.fahrplan.model.StationboardResponseObject;

@Controller
public class FahrplanController {

	private String from;
	private String to;
	private String location;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/requestConnection")
	public String getRequestConnection(Model model) {
		model.addAttribute("from", from);
		model.addAttribute("to", to);
		return "connection";
	}
	
	@PostMapping("/requestConnection")
	public String postRequestConnection(@ModelAttribute ConnectionResponseObject connectionResponseObject) {
		return "connection";
	}

	@GetMapping("/requestStationboard")
	public String getRequestStationboard(Model model) {
		model.addAttribute("location", location);
		return "stationboard";
	}

	@PostMapping("/requestStationboard")
	public String postRequestStationboard(@ModelAttribute StationboardResponseObject stationboardResponseObject) {
		return "stationboard";
	}

}
