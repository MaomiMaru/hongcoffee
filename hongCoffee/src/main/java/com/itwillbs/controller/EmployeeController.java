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

	//0. login 진행 과정
	//로그인 과정
	@PostMapping("/loginPro")
	public String loginPro(EmployeeDTO employeeDTO, HttpSession session) {
		System.out.println("EmployeeService loginPro()");
		
		EmployeeDTO employeeDTO1 = employeeService.userCheck(employeeDTO);
		if(employeeDTO1 != null) {
			session.setAttribute("emp_num", employeeDTO1.getEmp_num());
			session.setAttribute("emp_name", employeeDTO1.getEmp_name());
			session.setAttribute("emp_right", employeeDTO1.getEmp_right());
			return "redirect:/emp/main";
		} else {
			return "/emp/msg";
		}
	}

	@GetMapping("/login")
	public String login() {
		System.out.println("EmployeeService login()");
		
		return "/emp/login";
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
	
	//5. 로그아웃
	@GetMapping("/emp/logout")
	public String logout(HttpSession session) {
		System.out.println("EmployeeController logout()");
		session.invalidate();
		return "redirect:/emp/login";
	}
	
	//팝업 주소 매핑
	//2-1-1. 지점 관리 - 추가 팝업
	@GetMapping("/popup/store_insert")
	public String store_insert() {
		System.out.println("EmployeeController store_insert()");

		return "/emp/popup/store_insert";
	}
	
	@PostMapping("/popup/store_insertPro")
	public String store_insertPro(StoreDTO storeDTO) {
		System.out.println("EmployeeController store_insertPro()");
		
		employeeService.storeInsert(storeDTO);
		
		return "redirect:/emp/popup/close";
	}
	
	//2-1-2. 지점 관리 - 수정 팝업
	@GetMapping("popup/store_update")
	public String store_update() {
		System.out.println("EmployeeController store_update()");
		
		return "/emp/popup/store_update";
	}
	
	@PostMapping("/popup/store_updatePro")
	public String store_updatePro(StoreDTO storeDTO) {
		System.out.println("EmployeeController store_updatePro()");
		
		employeeService.storeUpdate(storeDTO);
		
		return "redirect:/emp/popup/close";
	}
	

	//2-2-1. 재료 관리 - 추가 팝업 
	@GetMapping("popup/item_insert")
	public String item_insert() {
		System.out.println("EmployeeController item_insert()");
		
		return "/emp/popup/item_insert";
	}
	
	//2-2-2 재료 관리 - 수정 팝업
	@GetMapping("popup/item_update")
	public String item_update() {
		System.out.println("EmployeeController item_update()");
		
		return "/emp/popup/item_update";
	}
	
	//4-1-1. 사원 관리 - 추가 팝업
	@GetMapping("popup/emp_insert")
	public String emp_insert() {
		System.out.println("EmployeeController emp_insert()");
		
		return "/emp/popup/emp_insert";
	}
	
	@PostMapping("popup/emp_insertPro")
	public String emp_insertPro(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeController emp_insertPro()");
		
		employeeService.employeeInsert(employeeDTO);
		return "redirect:/emp/popup/close";
	}
	
	//4-1-2. 사원 관리 - 수정 팝업(관리자)
	@GetMapping("popup/emp_update_admin")
	public String emp_update_admin() {
		System.out.println("EmployeeController emp_update_admin()");
		
		return "/emp/popup/emp_update_admin";
	}
	
	@PostMapping("popup/emp_updatePro1")
	public String emp_updatePro1(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeController emp_updatePro_admin()");
		
		employeeService.employeeUpdate1(employeeDTO);
		return "redirect:/emp/popup/close";
	}
	
	
	//4-1-3. 사원 관리 - 수정 팝업(일반)
	@GetMapping("popup/emp_update")
	public String emp_update() {
		System.out.println("EmployeeController emp_update()");
		
		return "/emp/popup/emp_update";
	}
	
	@PostMapping("popup/emp_update")
	public String emp_update(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeCOntroller emp_update()");
		
		employeeService.employeeUpdate(employeeDTO);
		return "redirect:/emp/popup/close";
	}
	
	//창 닫기
	@GetMapping("popup/close")
	public String close() {
		System.out.println("close()");
		return "/emp/popup/close";
	}
	
}

	
	
	
	

