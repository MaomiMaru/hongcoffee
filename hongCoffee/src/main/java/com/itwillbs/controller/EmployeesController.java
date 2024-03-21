package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.domain.StoreDTO;
import com.itwillbs.service.EmployeesService;

@Controller
public class EmployeesController {
	
@Inject
private EmployeesService employeesService;

	
//지점 목록
@GetMapping("/sawon/jijum")
public String jijumList(HttpServletRequest request, Model model) {
	System.out.println("jijumList");
	
	List<StoreDTO> jijumList = employeesService.getJijumList();
	
		model.addAttribute("jijumList",jijumList);
	
		return "sawon/jijum";
	}//jijumList
	
//	@GetMapping("/sawon/jijum")
//	public String jijum(){
//		return "sawon/jijum";
//	}
	
	
}

