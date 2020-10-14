package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.models.Employee;
import com.service.EmployeeIndexService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeIndexService eis;
	
	@GetMapping("/employees/index")
	public String index(Model model /*, @RequestParam("page")int page */) {
		/*
		model.addAttribute("page",eis.getPage(page));
		*/
		model.addAttribute("el", eis.getEmployees());
		model.addAttribute("ec", eis.getEmployeesCount());
		return "employees/index";
	}
	
	
	@GetMapping("/employees/new")
	public String neww(Model model) {
		model.addAttribute("employee", new Employee());
		return "employees/new";
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	
}
