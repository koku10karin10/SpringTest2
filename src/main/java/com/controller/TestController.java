package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.models.Test;
import com.service.TestService;

@Controller
public class TestController {
	@Autowired
	private TestService ts;
	
	@GetMapping("/test2")
	public String test(Model model) {
		List<Test> tl = ts.getTests();
		
		model.addAttribute("tl" , tl);
		return "test2";
		
	}

}
