package com.gaida.omikuji;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class HomeController {
	
	//member variable
	Map<String,String> tempmap = new HashMap<String,String>();

	@GetMapping("/")
	public String sendHome() {
		return "redirect:/Omikuji";
	}
	
	@GetMapping("/Omikuji")
	public String home(){
		return "index.jsp";
	}

	@PostMapping("/prepOmikuji")
	public String prepOmikuji(HttpSession session, 
			@RequestParam Map<String,String> allParams, Model model) {
				tempmap=allParams;
			if( Integer.parseInt(allParams.get("years"))>25 ){
				allParams.replace("years", "25");
			}
		
			if( Integer.parseInt(allParams.get("years"))<5){
				allParams.replace("years", "5");
			}
			
			session.setAttribute("years", allParams.get("years"));
			session.setAttribute("city", allParams.get("city"));
			session.setAttribute("person", allParams.get("person"));
			session.setAttribute("hobby", allParams.get("hobby"));
			session.setAttribute("thing", allParams.get("thing"));
			session.setAttribute("blurb", allParams.get("blurb"));

		return "redirect:/Omikuji/Show";
		
	}
	
	@GetMapping("/Omikuji/Show")
	public String show(){
		System.out.println(tempmap);
		return "index2.jsp";
	}

}