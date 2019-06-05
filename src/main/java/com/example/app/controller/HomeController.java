package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@GetMapping("//greeting")
	public String home(Model model, @RequestParam(required=false, defaultValue="Jonny") String name) {
		model.addAttribute("name", name);
		return "home";
	}

}
