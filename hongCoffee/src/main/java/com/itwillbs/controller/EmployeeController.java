package com.itwillbs.controller;


import java.util.Date;
import java.net.http.HttpRequest;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

import com.itwillbs.domain.ShipmentDTO;
import com.itwillbs.domain.StoreDTO;
import com.itwillbs.service.EmployeeService;

@Controller
@RequestMapping("/emp/*")
public class EmployeeController {
	
	@Inject
	private EmployeeService employeeService;

	//0. 로그인 진행 과정
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

	
	//2. 기준 정보 관리
	//2-1. 지점 관리
	@GetMapping("/store")
	public String store(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController store()");

		List<StoreDTO> storeList = employeeService.getStoreList();

		model.addAttribute("storeList", storeList);

		return "/emp/store";
	}//jijumList
	
	
	//2-1-1. 지점 필터링
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

	
	//2-2. 재료 관리
	@GetMapping("/item")
	public String item(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController item()");

		List<ItemDTO> itemList = employeeService.getItemList();

		model.addAttribute("itemList",itemList);
			
		return "/emp/item";
	}//jeryoList
		
		
	//2-2-1. 재료 필터링
	@PostMapping("/itemSearch")
	public String itemSearch(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController itemSearch()");

		ItemDTO itemDTO = new ItemDTO();

		String item_sType = request.getParameter("item_type");
		int item_type = 100;

		try {
			if (item_sType != null || item_sType != "") {
				item_type = Integer.parseInt(item_sType);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		itemDTO.setItem_type(item_type);
		
		String item_name = request.getParameter("item_name");
		itemDTO.setItem_name(item_name);
		
		String item_sminPrice = request.getParameter("item_minPrice");
		int item_minPrice = 0;
		
		String item_smaxPrice = request.getParameter("item_maxPrice");
		int item_maxPrice = 0;
		
		try {
			if (item_sminPrice != null || item_sminPrice != "") {
				item_minPrice = Integer.parseInt(item_sminPrice);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		try {
			if (item_smaxPrice != null || item_smaxPrice != "") {
				item_maxPrice = Integer.parseInt(item_smaxPrice);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		itemDTO.setItem_minPrice(item_minPrice);
		itemDTO.setItem_maxPrice(item_maxPrice);		

		List<ItemDTO> itemList;

		if (item_type == 100 && item_name == null && item_minPrice == 0 && item_maxPrice == 0) {
			itemList = employeeService.getItemList();
		} else {
			itemList = employeeService.searchItemList(itemDTO);
		}

		model.addAttribute("itemList", itemList);

		return "/emp/item";
	}//itemSearch
	

	//3. 영업 관리
	//3-1. 수주 관리
	@GetMapping("/order")
	public String order(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController order()");
		
			List<OrderDTO> orderList = employeeService.getOrderList();
		
			model.addAttribute("orderList",orderList);
		
			return "/emp/order";
	}//sujuList

	
	//3-1-1. 수주 필터링
	@PostMapping("/orderSearch")
	public String orderSearch(HttpServletRequest request, Model model) throws Exception {
		System.out.println("EmployeeController orderSearch()");

		OrderDTO orderDTO = new OrderDTO();

		String name = request.getParameter("name");
		orderDTO.setName(name);

		String item_name = request.getParameter("item_name");
		orderDTO.setItem_name(item_name);

		String item_sminPrice = request.getParameter("item_minPrice");
		
		String item_smaxPrice = request.getParameter("item_maxPrice");

		try {
			orderDTO.setItem_minPrice(item_sminPrice != null ? Integer.parseInt(item_sminPrice) : 0);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		try {
			orderDTO.setItem_maxPrice(item_smaxPrice != null ? Integer.parseInt(item_smaxPrice) : 0);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

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

		if (name == "" && item_name == "" && item_sminPrice == null && item_smaxPrice == null && od_time == "" && received_sNot == null) {
			orderList = employeeService.getOrderList();
		} else {
			orderList = employeeService.searchOrderList(orderDTO);
		}

		model.addAttribute("orderList", orderList);

		return "/emp/order";
	}//orderSearch

	
	//3-2. 출하 관리
	@GetMapping("/shipment")
	public String shipment(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController shipment()");
				
		List<ShipmentDTO> shipmentList = employeeService.getShipmentList();
				
		model.addAttribute("shipmentList",shipmentList);
				
		return "/emp/shipment";
	}//chulhaList

		
	//3-2-1. 출하 필터링
	@PostMapping("/shipmentSearch")
	public String shipmentSearch(HttpServletRequest request, Model model) throws Exception {
		System.out.println("EmployeeController shipmentSearch()");

		ShipmentDTO shipmentDTO = new ShipmentDTO();

		String name = request.getParameter("name");
		shipmentDTO.setName(name);

		String item_name = request.getParameter("item_name");
		shipmentDTO.setItem_name(item_name);
		
		String item_sminPrice = request.getParameter("item_minPrice");
		
		String item_smaxPrice = request.getParameter("item_maxPrice");

		try {
			shipmentDTO.setItem_minPrice(item_sminPrice != null ? Integer.parseInt(item_sminPrice) : 0);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		try {
			shipmentDTO.setItem_maxPrice(item_smaxPrice != null ? Integer.parseInt(item_smaxPrice) : 0);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		String sh_time = request.getParameter("sh_time");

		if (sh_time != "") {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date d1 = format.parse(sh_time);
			Timestamp date1 = new Timestamp(d1.getTime());
			shipmentDTO.setSh_time(date1);
		}

		List<ShipmentDTO> shipmentList;

		if (name == "" && item_name == "" && item_sminPrice == null && item_smaxPrice == null && sh_time == "") {
			shipmentList = employeeService.getShipmentList();
		} else {
			shipmentList = employeeService.searchShipmentList(shipmentDTO);
		}

		model.addAttribute("shipmentList", shipmentList);

		return "/emp/shipment";
	}//shipmentSearch

	
	//4. 사원 관리
	//4-1. 사원 관리
	@GetMapping("/emp")
	public String emp(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController emp()");

		List<EmployeeDTO> empList = employeeService.getEmpList();

		model.addAttribute("empList", empList);

		return "/emp/emp";
	}//sawonList

	
	//4-1-1. 사원 필터링
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

	
	//5. 로그아웃
	@GetMapping("/emp/logout")
	public String logout(HttpSession session) {
		System.out.println("EmployeeController logout()");
		session.invalidate();
		return "redirect:/emp/login";
	}
	
	
	//팝업 주소 매핑
	//2-1-1. 지점 관리 - 추가
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
	
	//2-1-2. 지점 관리 - 수정

	//2-1-2. 지점 관리 - 수정 팝업
	@GetMapping("popup/store_update")
	public String store_update(HttpServletRequest request, HttpSession session, Model model) {
		System.out.println("EmployeeController store_update()");

		int num = Integer.parseInt(request.getParameter("num"));
		StoreDTO storeDTO = new StoreDTO();
		storeDTO = employeeService.getStore(num);
		model.addAttribute("storeDTO", storeDTO);
		

		return "/emp/popup/store_update";
	}

	
	@PostMapping("/popup/store_updatePro")
	public String store_updatePro(StoreDTO storeDTO) {
		System.out.println("EmployeeController store_updatePro()");
		
		employeeService.storeUpdate(storeDTO);
		
		return "redirect:/emp/popup/close";
	}
	

	//2-2-1. 재료 관리 - 추가
	@GetMapping("popup/item_insert")
	public String item_insert() {
		System.out.println("EmployeeController item_insert()");
		
		return "/emp/popup/item_insert";
	}
	
	@PostMapping("popup/item_insertPro")
	public String item_insertPro(ItemDTO itemDTO) {
		System.out.println("EmployeeController item_insertPro()");
		employeeService.itemInsert(itemDTO);
		
		return "redirect:/emp/popup/close";
	}
	
	//2-2-2 재료 관리 - 수정
	@GetMapping("popup/item_update")
	public String item_update(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController item_update()");
		int item_num = Integer.parseInt(request.getParameter("item_num"));
		ItemDTO itemDTO = new ItemDTO();
		itemDTO = employeeService.getItem(item_num);
		model.addAttribute("itemDTO", itemDTO);
		
		return "/emp/popup/item_update";
	}
	
	@PostMapping("popup/item_updatePro")
	public String item_updatePro(ItemDTO itemDTO) {
		System.out.println("EmployeeController item_updatePro()");
		employeeService.itemUpdate(itemDTO);

		return "redirect:/emp/popup/close";
	}
	
	
	//3-1-1 수주 관리 - 수정
	@GetMapping("popup/order_update")
	public String order_update(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController order_update()");
		int od_num = Integer.parseInt(request.getParameter("od_num"));
		OrderDTO orderDTO = new OrderDTO();
		orderDTO = employeeService.getOrder(od_num);
		model.addAttribute("orderDTO",orderDTO);
		return "/emp/popup/order_update";
	}
	
	@PostMapping("popup/order_updatePro")
	public String order_updatePro(OrderDTO orderDTO) {
		System.out.println("EmployeeController order_updatePro()");
		employeeService.orderUpdate(orderDTO);
		
		return "redirect:/emp/popup/close";
	}
	
	
	//3-1-2 수주 관리 - 출하 추가
	@GetMapping("popup/shipment_insert")
	public String shipment_insert(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController shipment_insert()");
		int od_num = Integer.parseInt(request.getParameter("od_num"));
		OrderDTO orderDTO = employeeService.getOrder(od_num);
		
		model.addAttribute("orderDTO", orderDTO);
		return "/emp/popup/shipment_insert";
	}
	

	@PostMapping("popup/shipment_insertPro")
	public String shipment_insertPro(HttpServletRequest request) {
		System.out.println("EmployeeController shipment_insertPro()");
		ShipmentDTO shipmentDTO = new ShipmentDTO();
		shipmentDTO.setItem_name(request.getParameter("item_name"));
		shipmentDTO.setItem_num(Integer.parseInt(request.getParameter("item_num")));
		shipmentDTO.setItem_price(Integer.parseInt(request.getParameter("item_price")));
		shipmentDTO.setName(request.getParameter("name"));
		shipmentDTO.setNum(Integer.parseInt(request.getParameter("num")));
		shipmentDTO.setOd_num(Integer.parseInt(request.getParameter("od_num")));
		shipmentDTO.setSh_amount(Integer.parseInt(request.getParameter("sh_amount")));
		shipmentDTO.setSh_note(request.getParameter("sh_note"));
		
		String sh_time = request.getParameter("sh_time");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d;
		try {
			d = format.parse(sh_time);
		} catch (ParseException e) {
			d = new Date();
		}
		Timestamp date = new Timestamp(d.getTime());
		if(sh_time != null && sh_time != "") shipmentDTO.setSh_time(date);
		
		System.out.println(shipmentDTO);
		employeeService.shipmentInsert(shipmentDTO);
		
		return "redirect:/emp/popup/close";
	}
	
	
	//3-2-2 출하 관리 - 수정
	@GetMapping("popup/shipment_update")
	public String shipment_update(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController shipment_update()");
		int od_num = Integer.parseInt(request.getParameter("od_num"));
		ShipmentDTO shipmentDTO = employeeService.getShipment(od_num);
		model.addAttribute("shipmentDTO", shipmentDTO);
		
		return "/emp/popup/shipment_update";
	}
	
	@PostMapping("popup/shipment_updatePro")
	public String shipment_updatePro(HttpServletRequest request, ShipmentDTO shipmentDTO) {
		System.out.println("EmployeeController shipment_updatePro()");
		shipmentDTO.setItem_name(request.getParameter("item_name"));
		shipmentDTO.setItem_num(Integer.parseInt(request.getParameter("item_num")));
		shipmentDTO.setItem_price(Integer.parseInt(request.getParameter("item_price")));
		shipmentDTO.setName(request.getParameter("name"));
		shipmentDTO.setNum(Integer.parseInt(request.getParameter("num")));
		shipmentDTO.setOd_num(Integer.parseInt(request.getParameter("od_num")));
		shipmentDTO.setSh_amount(Integer.parseInt(request.getParameter("sh_amount")));
		shipmentDTO.setSh_note(request.getParameter("sh_note"));
		
		
		String sh_time = request.getParameter("sh_time");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d;
		try {
			d = format.parse(sh_time);
		} catch (ParseException e) {
			d = new Date();
		}
		Timestamp date = new Timestamp(d.getTime());
		if(sh_time != null && sh_time != "") { 
			shipmentDTO.setSh_time(date);
			}
		
		employeeService.shipmentUpdate(shipmentDTO);
		
		return "redirect:/emp/popup/close";
	}
	
	
	//4-1-1. 사원 관리 - 추가
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
	
	//4-1-2. 사원 관리 - 수정(관리자)
	@GetMapping("popup/emp_update_admin")
	public String emp_update_admin(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController emp_update_admin()");
		int emp_num = Integer.parseInt(request.getParameter("emp_num"));
		EmployeeDTO employeeDTO = employeeService.getEmployee(emp_num);		
		model.addAttribute("employeeDTO", employeeDTO);
		
				
		return "/emp/popup/emp_update_admin";
	}
	
	@PostMapping("popup/emp_updateProAdmin")
	public String emp_updateProAdmin(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeController emp_updatePro_admin()");
		
		employeeService.employeeUpdate1(employeeDTO);
		return "redirect:/emp/popup/close";
	}
	
	
	//4-1-3. 사원 관리 - 수정(일반)
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
