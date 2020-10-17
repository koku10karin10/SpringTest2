package com.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.models.Employee;
import com.service.EmployeeCreateService;
import com.service.EmployeeIndexService;
import com.service.EmployeeShowService;
import com.utility.EncryptUtil;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeIndexService eis;
	@Autowired
	private EmployeeCreateService ecs;
	@Autowired
	private EmployeeShowService ess;

	//	private Pepper pepper;

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

	@ModelAttribute
	public Employee setUp() {
		Employee e = new Employee();
		e.setCode("code");
		e.setName("name");
		e.setPassword(
				EncryptUtil.getPasswordEncrypt(
						"password", "6Ab3mtmG"

						)
				);
		try {
			e.setAdmin_flag(Integer.parseInt("admin_flag"));}
		catch(NumberFormatException n) {
			e.setAdmin_flag(0);
		};
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		e.setCreated_at(currentTime);
		e.setUpdated_at(currentTime);
		e.setDelete_flag(0);
		return e;
	}

	@PostMapping("/employees/create")
	public String create(Employee e) {
		System.out.println(e.getName());
		ecs.createEmployee(e);
		return "redirect:/employees/index";

	}

	@GetMapping("/employees/show")
	public String show(Model model,@RequestParam int id){
		try {
			model.addAttribute("e",ess.show(id));
			return "employees/show";
		}catch(NullPointerException npe) {
			return "redirect:/employees/index";
		}
	}

	@GetMapping("/test")
	public String test() {
		return "test";
	}


}
