package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itwillbs.domain.EmployeeDTO;
import com.itwillbs.domain.ItemDTO;
import com.itwillbs.domain.OrderDTO;
import com.itwillbs.domain.ReceiveDTO;
import com.itwillbs.domain.StoreDTO;
import com.itwillbs.service.EmployeesService;

@Controller
public class EmployeesController {
	
@Inject
private EmployeesService employeesService;

	
//지점 목록
@GetMapping("/emp/jijum")
public String jijumList(HttpServletRequest request, Model model) {
	System.out.println("jijumList");
	
	List<StoreDTO> jijumList = employeesService.getJijumList();
	
		model.addAttribute("jijumList",jijumList);
	
		return "emp/jijum";
	}//jijumList
	

//재료 목록
@GetMapping("/emp/jeryo")
public String jeryoList(HttpServletRequest request, Model model) {
	System.out.println("jeryoList");
	
		List<ItemDTO> jeryoList = employeesService.getJeryoList();
	
		model.addAttribute("jeryoList",jeryoList);
	
		return "emp/jeryo";
	}//jijumList

	

//수주 목록
@GetMapping("/emp/suju")
public String sujuList(HttpServletRequest request, Model model) {
	System.out.println("sujuList");
	
		List<OrderDTO> sujuList = employeesService.getSujuList();
	
		model.addAttribute("sujuList",sujuList);
	
		return "emp/suju";
	}//sujuList


//수주 목록
@GetMapping("/emp/chulha")
public String chulhaList(HttpServletRequest request, Model model) {
	System.out.println("chulhaList");
	
		List<ReceiveDTO> chulhaList = employeesService.getChulhaList();
	
		model.addAttribute("chulhaList",chulhaList);
	
		return "emp/chulha";
	}//chulhaList



//수주 목록
@GetMapping("/emp/sawon")
public String sawonList(HttpServletRequest request, Model model) {
	System.out.println("sawonList");
	
		List<EmployeeDTO> sawonList = employeesService.getSawonList();
	
		model.addAttribute("sawonList",sawonList);
	
		return "emp/sawon";
	}//sawonList
}

