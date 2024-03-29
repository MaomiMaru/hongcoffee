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
	
	//2. 기준 정보 관리
	//2-1. 지점 관리
	@GetMapping("/store")
	public String store(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController store()");
		
		List<StoreDTO> storeList = employeeService.getStoreList();
		
			model.addAttribute("storeList",storeList);
		
			return "/emp/store";
	}//jijumList

	//2-2. 재료 관리
	@GetMapping("/item")
	public String item(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController item()");
		
			List<ItemDTO> itemList = employeeService.getItemList();
		
			model.addAttribute("itemList",itemList);
		
			return "/emp/item";
	}//jijumList


	//3. 영업 관리
	//3-1. 수주 목록
	@GetMapping("/order")
	public String order(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController order()");
		
			List<OrderDTO> orderList = employeeService.getOrderList();
		
			model.addAttribute("orderList",orderList);
		
			return "/emp/order";
	}//sujuList


	//3-2. 출하 관리
	@GetMapping("/shipment")
	public String shipment(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController shipment()");
		
			List<ReceiveDTO> shipmentList = employeeService.getShipmentList();
		
			model.addAttribute("shipmentList",shipmentList);
		
			return "/emp/shipment";
	}//chulhaList



	//4. 사원 관리
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

	
	
	
	

