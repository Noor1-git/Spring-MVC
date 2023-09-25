package edu.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.ServletRequest;

@Controller
public class TestController {

	@PostMapping("/save")
	public ModelAndView save(ServletRequest request) {
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String gender=request.getParameter("gender");
		
		ModelAndView mav =new ModelAndView("details.jsp");
		mav.addObject("name", name);
		mav.addObject("email", email);
		mav.addObject("contact", contact);
		mav.addObject("gender", gender);
		return mav;
	}
}