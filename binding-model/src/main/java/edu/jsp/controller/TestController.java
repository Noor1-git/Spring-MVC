package edu.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("/getmessage")
	public String getMessage(Model model) {
		model.addAttribute("myName", "Noor");
		
		
		return "message.jsp";
	}
}