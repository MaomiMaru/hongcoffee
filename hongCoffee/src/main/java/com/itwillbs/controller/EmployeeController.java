package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.domain.EmployeeDTO;
import com.itwillbs.domain.ItemDTO;
import com.itwillbs.domain.OrderDTO;
import com.itwillbs.domain.ReceiveDTO;
import com.itwillbs.domain.StoreDTO;
import com.itwillbs.service.EmployeeService;

@Controller
@RequestMapping("/emp/*")
public class EmployeeController {
	
@Inject
private EmployeeService employeesService;


//로그인
@PostMapping("main")
public String main() {
	System.out.println();
	return "emp/main";
}

	
//지점 목록
@GetMapping("store_list")
public String store_list(HttpServletRequest request, Model model) {
	System.out.println("store_list");
	
	List<StoreDTO> storeList = employeesService.getStoreList();
	
		model.addAttribute("storeList",storeList);
	
		return "emp/store_list";
	}//jijumList
	

//재료 목록
@GetMapping("ingredient")
public String jeryoList(HttpServletRequest request, Model model) {
	System.out.println("ingredient");
	
		List<ItemDTO> ingredientList = employeesService.getIngredientList();
	
		model.addAttribute("ingredientList",ingredientList);
	
		return "emp/ingredient";
	}//jijumList

	

//수주 목록
@GetMapping("order")
public String sujuList(HttpServletRequest request, Model model) {
	System.out.println("order");
	
		List<OrderDTO> orderList = employeesService.getOrderList();
	
		model.addAttribute("orderList",orderList);
	
		return "emp/order";
	}//sujuList


//출하 목록
@GetMapping("/emp/shipment")
public String shipmentList(HttpServletRequest request, Model model) {
	System.out.println("shipmentList");
	
		List<ReceiveDTO> shipmentList = employeesService.getShipmentList();
	
		model.addAttribute("shipmentList",shipmentList);
	
		return "emp/shipment";
	}//chulhaList



//수주 목록
@GetMapping("/emp/list")
public String empList(HttpServletRequest request, Model model) {
	System.out.println("empList");
	
		List<EmployeeDTO> empList = employeesService.getEmpList();
	
		model.addAttribute("empList",empList);
	
		return "emp/list";
	}//sawonList
}

