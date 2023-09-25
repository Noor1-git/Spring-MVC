package edu.jsp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/info")
	public String getInfo(ModelMap map) {
		
		map.addAttribute("Model", "S23 Ultra");
		map.addAttribute("Manufacturer", "Samsung");
		
		
		Map<String , Double> map2=new HashMap<String, Double>();
		map2.put("Ram", 12.0);
		map2.put("Memory", 256.0);
		map2.put("Price", 125000.0);
		
		map.addAllAttributes(map2);
		
		return "info.jsp";
	}
}