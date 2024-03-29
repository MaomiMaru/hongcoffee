package com.itwillbs.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		if (employeeDTO1 != null) {
			session.setAttribute("emp_num", employeeDTO1.getEmp_num());
			session.setAttribute("emp_name", employeeDTO1.getEmp_name());
			session.setAttribute("emp_right", employeeDTO1.getEmp_right());
			return "redirect:/emp/main";
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

		model.addAttribute("storeList", storeList);

		return "/emp/store";
	}//jijumList
	
	
	//2-2. 기준 정보 관리 - 지점 필터링 목록
	@PostMapping("/storeSearch")
	public String storeSearch(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController storeSearch()");

		StoreDTO storeDTO = new StoreDTO();
		
		String name = request.getParameter("name");
		storeDTO.setName(name);
		
		String boss = request.getParameter("boss");
		storeDTO.setBoss(boss);
		
		String address = request.getParameter("address");
		storeDTO.setAddress(address);
		
		String phone = request.getParameter("phone");
		storeDTO.setPhone(phone);
		
		String sState = request.getParameter("state");
		
		try {
			storeDTO.setState(sState != null ? Integer.parseInt(sState) : 100);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		List<StoreDTO> storeList;
		
		if (name == "" && boss == "" && address == "" && phone == "" && sState == null) {
			storeList = employeeService.getStoreList();
		} else {
			storeList = employeeService.searchStoreList(storeDTO);
		}

		model.addAttribute("storeList", storeList);

		return "/emp/store";
	}//storeSearch

	
	//2-3. 기준 정보 관리 - 재료 목록
	@GetMapping("/item")
	public String item(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController item()");

		List<ItemDTO> itemList = employeeService.getItemList();

		model.addAttribute("itemList", itemList);

		return "/emp/item";
	}//jijumList

	
	//2-4. 기준 정보 관리 - 재료 필터링 목록
	@PostMapping("/itemSearch")
	public String itemSearch(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController itemSearch()");

		ItemDTO itemDTO = new ItemDTO();

		String item_sType = request.getParameter("item_type");
		int item_type = 100;

		String item_sPrice = request.getParameter("item_price");
		int item_price = 0;

		try {
			if (item_sType != null || item_sType != "") {
				item_type = Integer.parseInt(item_sType);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		try {
			if (item_sPrice != null || item_sPrice != "") {
				item_price = Integer.parseInt(item_sPrice);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		itemDTO.setItem_type(item_type);
		itemDTO.setItem_price(item_price);
		System.out.println(item_type);

		String item_name = request.getParameter("item_name");
		itemDTO.setItem_name(item_name);

		List<ItemDTO> itemList;

		if (item_type == 100 && item_name == null && item_price == 0) {
			itemList = employeeService.getItemList();
		} else {
			itemList = employeeService.searchItemList(itemDTO);
		}

		model.addAttribute("itemList", itemList);

		return "/emp/item";
	}//itemSearch

	
	//3-1. 영업 관리 - 수주 목록
	@GetMapping("/order")
	public String order(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController order()");

		List<OrderDTO> orderList = employeeService.getOrderList();

		model.addAttribute("orderList", orderList);

		return "/emp/order";
	}//sujuList

	
	//3-2. 영업 관리 - 수주 필터링 목록
	@PostMapping("/orderSearch")
	public String orderSearch(HttpServletRequest request, Model model) throws Exception {
		System.out.println("EmployeeController orderSearch()");

		OrderDTO orderDTO = new OrderDTO();

		String name = request.getParameter("name");
		orderDTO.setName(name);

		String item_name = request.getParameter("item_name");
		orderDTO.setItem_name(item_name);

		String item_sPrice = request.getParameter("item_price");
		int item_price = 0;

		try {
			if (item_sPrice != "") {
				item_price = Integer.parseInt(item_sPrice);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		orderDTO.setItem_price(item_price);

		String od_time = request.getParameter("od_time");

		if (od_time != "") {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date d1 = format.parse(od_time);
			Timestamp date1 = new Timestamp(d1.getTime());
			orderDTO.setOd_time(date1);
		}

		String received_sNot = request.getParameter("received_not");

		try {
			orderDTO.setReceived_not(received_sNot != null ? Integer.parseInt(received_sNot) : 100);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		List<OrderDTO> orderList;

		if (name == "" && item_name == "" && od_time == "" && received_sNot == null) {
			orderList = employeeService.getOrderList();
		} else {
			orderList = employeeService.searchOrderList(orderDTO);
		}

		model.addAttribute("orderList", orderList);

		return "/emp/order";
	}//orderSearch

	
	//3-3. 영업관리 - 출하 목록
	@GetMapping("/shipment")
	public String shipment(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController shipment()");

		List<ReceiveDTO> shipmentList = employeeService.getShipmentList();

		model.addAttribute("shipmentList", shipmentList);

		return "/emp/shipment";
	}//chulhaList

	
	//3-4. 영업관리 - 출하 필터링 목록
	@PostMapping("/shipmentSearch")
	public String shipmentSearch(HttpServletRequest request, Model model) throws Exception {
		System.out.println("EmployeeController shipmentSearch()");

		ReceiveDTO receiveDTO = new ReceiveDTO();

		String name = request.getParameter("name");
		receiveDTO.setName(name);

		String item_name = request.getParameter("item_name");
		receiveDTO.setItem_name(item_name);

		String rc_time = request.getParameter("rc_time");

		if (rc_time != "") {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date d1 = format.parse(rc_time);
			Timestamp date1 = new Timestamp(d1.getTime());
			receiveDTO.setRc_time(date1);
		}

		List<ReceiveDTO> shipmentList;

		if (name == "" && item_name == "" && rc_time == "") {
			shipmentList = employeeService.getShipmentList();
		} else {
			shipmentList = employeeService.searchShipmentList(receiveDTO);
		}

		model.addAttribute("shipmentList", shipmentList);

		return "/emp/shipment";
	}//shipmentSearch

	
	//4-1. 사원 관리 - 사원 목록
	@GetMapping("/emp")
	public String emp(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController emp()");

		List<EmployeeDTO> empList = employeeService.getEmpList();

		model.addAttribute("empList", empList);

		return "/emp/emp";
	}//sawonList

	
	//4-2. 사원 관리 - 사원 필터링 목록
	@PostMapping("/empSearch")
	public String empSearch(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController empSearch()");
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		String emp_sDept = request.getParameter("emp_dept");
		
		try {
			employeeDTO.setEmp_dept(emp_sDept != null ? Integer.parseInt(emp_sDept) : 100);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		String emp_sRank = request.getParameter("emp_rank");
		
		try {
			employeeDTO.setEmp_rank(emp_sRank != null ? Integer.parseInt(emp_sRank) : 100);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		String emp_sNum = request.getParameter("emp_num");

		try {
			employeeDTO.setEmp_num(emp_sNum != "" ? Integer.parseInt(emp_sNum) : 0);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		String emp_name = request.getParameter("emp_name");
		employeeDTO.setEmp_name(emp_name);
		
		List<EmployeeDTO> empList;
		
		if (emp_sDept == null && emp_sRank == null && emp_sNum == "" && emp_name == "") {
			empList = employeeService.getEmpList();
		} else {
			empList = employeeService.searchEmpList(employeeDTO);
		}
		
		model.addAttribute("empList", empList);
		
		return "/emp/emp";
	}//empSearch
	
	
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

