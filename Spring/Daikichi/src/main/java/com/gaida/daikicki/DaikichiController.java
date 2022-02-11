package com.gaida.daikicki;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaikichiController {
	
	@RequestMapping("/daikichi")
	public String home() {
		return "Welcome";
	}
	
	@RequestMapping("/daikichi/today")
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}

	@RequestMapping("/daikichi/tomorrow")
	public String tomorrow() {
		return"Tomorrow, and opportunity will arise, so be sure to be open to new ideas";
	}
}
