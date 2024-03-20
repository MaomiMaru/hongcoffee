package com.itwillbs.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.service.EmployeesService;

@Controller
public class EmployeesController {
	
//	@Inject
//	private EmployeesService employeeService;

	@GetMapping("/main/main")
	public String main() {
		System.out.println("main");
		return "main/main";
	}
	
	@GetMapping("/include_employee")
	public String include_employee() {
		System.out.println("include_employee");
		return "include_employee";
	}
	
	@GetMapping("/sawon/jijum")
	public String sawon_jijum() {
		System.out.println("sawon_jijum");
		return "sawon/jijum";
	}
	
	
}

