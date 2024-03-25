package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
private EmployeeService employeeService;
	
	//기본 페이지 매핑

	//0. login 진행 과정
	//로그인 과정
	@PostMapping("/loginPro")
	public String loginPro(EmployeeDTO employeeDTO, HttpSession session) {
		System.out.println("EmployeeService loginPro()");
		
		EmployeeDTO employeeDTO1 = employeeService.userCheck(employeeDTO);
		if(employeeDTO1 != null) {
			session.setAttribute("id", employeeDTO1.getEmp_num());
			session.setAttribute("emp_name", employeeDTO1.getEmp_name());
			session.setAttribute("emp_right", employeeDTO1.getEmp_right());
			return "redirect/emp/main";
		} else {
			return "/emp/msg";
		}
	}
	
	//1. 대시 보드
	@GetMapping("/main")
	public String main() {
		System.out.println("EmployeeController main()");
		
		return "/emp/main";
	}
	
	//2-1. 기준 정보 관리 - 지점 목록
	@GetMapping("/store")
	public String store(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController store()");
		
		List<StoreDTO> storeList = employeeService.getStoreList();
		
			model.addAttribute("storeList",storeList);
		
			return "/emp/store";
		}//jijumList
	

	//2-2. 기준 정보 관리 - 재료 목록
	@GetMapping("/ingredient")
	public String ingredient(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController ingredient()");
		
			List<ItemDTO> ingredientList = employeeService.getIngredientList();
		
			model.addAttribute("ingredientList",ingredientList);
		
			return "/emp/ingredient";
		}//jijumList


	//3-1. 영업 관리 - 수주 목록
	@GetMapping("/order")
	public String order(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController order()");
		
			List<OrderDTO> orderList = employeeService.getOrderList();
		
			model.addAttribute("orderList",orderList);
		
			return "/emp/order";
		}//sujuList


	//3-2. 영업관리 - 출하 목록
	@GetMapping("/shipment")
	public String shipment(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController shipment()");
		
			List<ReceiveDTO> shipmentList = employeeService.getShipmentList();
		
			model.addAttribute("shipmentList",shipmentList);
		
			return "/emp/shipment";
		}//chulhaList



	//4. 사원 관리 - 사원 목록
	@GetMapping("/emp")
	public String emp(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController emp()");
		
			List<EmployeeDTO> empList = employeeService.getEmpList();
		
			model.addAttribute("empList",empList);
		
			return "/emp/emp";
		}//sawonList
	
	
	//팝업 주소 매핑
	//2-1-1. 지점 관리 - 추가 팝업
	@GetMapping("popup/store_insert")
	public String store_insert() {
		System.out.println("EmployeeController store_insert()");

		return "/emp/popup/store_insert";
	}
	
	
	//2-1-2. 지점 관리 - 수정 팝업
	@GetMapping("popup/store_update")
	public String store_update() {
		System.out.println("EmployeeController store_update()");
		
		return "/emp/popup/store_update";
	}
	

	
	
	
	
	
	
}

