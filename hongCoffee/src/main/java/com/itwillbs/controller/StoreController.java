package com.itwillbs.controller;


import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwillbs.domain.ItemDTO;
import com.itwillbs.domain.OrderDTO;
import com.itwillbs.domain.ReceiveDTO;
import com.itwillbs.domain.ResultDTO;
import com.itwillbs.domain.StockDTO;
import com.itwillbs.domain.StoreDTO;
import com.itwillbs.service.StoreService;

@Controller
@RequestMapping("/store/*")
public class StoreController {
	
@Inject
private StoreService storeService;

	//로그인
	@GetMapping("/login")
	public String login() {
		System.out.println("StoreController login()");
		
		return "store/login";
	}
	
	//로그인 Process
	@PostMapping("/loginPro")
	public String loginPro(StoreDTO storeDTO, HttpSession session) {
		System.out.println("StoreController loginPro()");
		
		StoreDTO storeDTO1 = storeService.userCheck(storeDTO);
		if(storeDTO1 != null) {
			session.setAttribute("num", storeDTO1.getNum());
			session.setAttribute("boss", storeDTO1.getBoss());
			session.setAttribute("state", storeDTO1.getState());
			return "redirect:/store/main";
		} else {
			return "/store/msg";
		}
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("StoreController logout()");
		session.invalidate();
		return "redirect:/store/login";
	}

	//대시보드
	@GetMapping("/main")
	public String main() {
		System.out.println("StoreController main()");
		return "store/main";
	}

	//기준 정보 관리 - 재료 관리
	@GetMapping("/item")
	public String itemList(HttpServletRequest request, Model model) {
		System.out.println("StoreController itemList()");
		
			List<ItemDTO> itemList = storeService.getitemList();
		
			model.addAttribute("itemList",itemList);
		
			return "store/item";
		}//itemList


	//3. 물류 관리
	//3-1. 재고 관리
	@GetMapping("/stock")
	public String stockList(HttpServletRequest request, Model model) {
		System.out.println("StoreController stock()");
		
			List<StockDTO> stockList = storeService.getStockList();
		
			model.addAttribute("stockList",stockList);
		
			return "store/stock";
	}//stockList
	
	//3-1-1 재고 관리 - 추가
	@GetMapping("/popup/stock_insert")
	public String stock_insert() {
		System.out.println("StoreController stock_insert()");
		
		return "/store/popup/stock_insert";
	}
	
	
	@PostMapping("/popup/stock_insertPro")
	public String stock_insertPro(StockDTO stockDTO) {
		System.out.println("StoreController stock_insertPro()");
		
		int item_num = storeService.getItemNum(stockDTO.getItem_name());
		stockDTO.setItem_num(item_num);
		storeService.stockInsert(stockDTO);
		
		return "/store/popup/close";
	}
	
	//3-1-2 재고 관리 - 수정
	@GetMapping("/popup/stock_update")
	public String stock_update(HttpServletRequest request, Model model) {
		System.out.println("StoreController stock_update()");
		
		int stock_num = Integer.parseInt(request.getParameter("stock_num"));
		StockDTO stockDTO = new StockDTO();
		stockDTO = storeService.getStock(stock_num);
		model.addAttribute("stockDTO", stockDTO);
		
		return "/store/popup/stock_update";
	}
	
	//3-2. 발주 관리
	@GetMapping("/order")
	public String orderList(HttpServletRequest request, Model model) {
		System.out.println("order");
		
			List<OrderDTO> orderList = storeService.getOrderList();
		
			model.addAttribute("orderList",orderList);
		
			return "store/order";
	}//orderList


	//3-3. 입고 관리
	@GetMapping("/receive")
	public String receiveList(HttpServletRequest request, Model model) {
		System.out.println("receive");
		
			List<ReceiveDTO> receiveList = storeService.getReceiveList();
		
			model.addAttribute("receiveList",receiveList);
		
			return "store/receive";
	}//receiveList
	
	//3-3-1. 물류 관리 -  입고 추가
	@GetMapping("/popup/receive_insert")
	public String receive_insert(HttpServletRequest request, Model model) {
		System.out.println("StoreController  receive_insert");

		int od_num = Integer.parseInt(request.getParameter("od_num"));
		model.addAttribute("receiveDTO", storeService.getReceive(od_num));
		
		return "store/popup/receive_insert";
	}//receive_insert
	
	
	@PostMapping("/popup/receive_insertPro")
	public String receive_insertPro(ReceiveDTO receiveDTO) {
		System.out.println("StoreController receive_insertPro");
		
		receiveDTO.setItem_num(storeService.getItemNum(receiveDTO.getItem_name()));
		storeService.receiveInsert(receiveDTO);
		
		return "store/popup/close";
	}//receive_insertPro

	//3-3-1. 물류 관리 -  발주 추가
	@GetMapping("/popup/order_insert")
	public String order_insert() {
		System.out.println("StoreController order_insert()");
		
		return "store/popup/order_insert";
	}
	
	@PostMapping("/popup/order_insertPro")
	public String order_insertPro(OrderDTO orderDTO) {
		System.out.println("StoreController order_insertPro()");
		
		int item_num = storeService.getItemNum(orderDTO.getItem_name());
		orderDTO.setItem_num(item_num);
		storeService.orderInsert(orderDTO);
		
		
		return "store/popup/close";
	}
	
	//3-3-2. 물류 관리 - 발주 수정
	@GetMapping("/popup/order_update")
	public String order_update(HttpServletRequest request, Model model) {
		System.out.println("StoreController order_update()");
		
		int od_num = Integer.parseInt(request.getParameter("od_num"));
		model.addAttribute("orderDTO", storeService.getOrder(od_num));
		
		return "store/popup/order_update";
	}
	
	@PostMapping("/popup/order_updatePro")
	public String order_updatePro(OrderDTO orderDTO) {
		System.out.println("StoreController order_updatePro()");
		
		storeService.orderUpdate(orderDTO);
		
		return "store/popup/close";
	}
	
	//3-3-1 입고 관리 - 수정
	@GetMapping("/popup/receive_update")
	public String receive_update(HttpServletRequest request, Model model) {
		System.out.println("StoreController receive_update()");
		
		int od_num = Integer.parseInt(request.getParameter("od_num"));
		model.addAttribute("receiveDTO", storeService.getReceive(od_num));
		
		return "store/popup/receive_update";
	}
	
	@PostMapping("/popup/receive_updatePro")
	public String receive_updatePro(ReceiveDTO receiveDTO) {
		System.out.println("StoreController receive_updatePro()");
		
		storeService.receiveUpdate(receiveDTO);
		
		return "store/popup/close";
	}

	//4. 영업 관리 - 실적 관리
	@GetMapping("/result")
	public String resultList(HttpServletRequest request, Model model) {
		System.out.println("result");
		
			List<ResultDTO> resultList = storeService.getResultList();
		
			model.addAttribute("resultList",resultList);
		
			return "store/result";
	}//resultList


	
	
	
	//창 닫기
	@GetMapping("popup/close")
	public String close() {
		System.out.println("close()");
		return "/emp/popup/close";
	}

}

