package com.gaida.daikicki;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	
	@RequestMapping("")
	public String home() {
		return "Welcome";
	}
	
	@RequestMapping("/today")
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}

	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return"Tomorrow, and opportunity will arise, so be sure to be open to new ideas";
	}
	
	@RequestMapping("/rando")
	public String reqP(@RequestParam(value="searchVal", required=false) String searchVal) {
		
		return String.format("When you add to rando ?searchVal=something this will show that something %s", searchVal);
	}
	
	@RequestMapping("/travel/{local}")
	public String travel(@PathVariable("local") String location) {
		
		return String.format("Congradulations you are going to %s", location);
		
	}
	
	@RequestMapping("/lotto/{lotNum}")
	public String lotto(@PathVariable("lotNum") int num) {
		String response = "You will take a grand journey in the near future";
		if(num%2!=0) {
			response = "You have enjoyed the fruits of your labor but now is a great time to spend with family and friends";
		}
		return response;
	}
}
