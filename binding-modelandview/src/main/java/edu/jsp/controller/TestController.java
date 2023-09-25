package edu.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	
	@GetMapping("/info")
	public ModelAndView getInfo() {
		
		ModelAndView mav=new ModelAndView("info.jsp");
		mav.addObject("KingName", "David");
		mav.addObject("QueenName", "Priya");
		
		return mav;
	}
}