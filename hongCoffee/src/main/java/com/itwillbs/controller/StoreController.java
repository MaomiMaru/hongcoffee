package com.itwillbs.controller;


import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.domain.ItemDTO;
import com.itwillbs.domain.OrderDTO;
import com.itwillbs.domain.ReceiveDTO;
import com.itwillbs.domain.ResultDTO;
import com.itwillbs.domain.SalesDTO;
import com.itwillbs.domain.StockDTO;
import com.itwillbs.domain.StoreDTO;
import com.itwillbs.service.StoreService;

@Controller
@RequestMapping("/store/*")
public class StoreController {
	
@Inject
private StoreService storeService;

	//0. 로그인 진행 과정
	//로그인
	@GetMapping("/login")
	public String login() {
		System.out.println("StoreController login()");
		
		return "store/login";
	}
	
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

	//1. 대시보드
	@GetMapping("/store/main")
	public String main() {
		System.out.println();
		return "store/main";
	}
	
	
	//1-1. 13일의 금요일 제이슨
	@GetMapping("/mainJson")
	public ResponseEntity<List<StockDTO>> mainJson(HttpSession session) {
		System.out.println("StoreController mainJson");
		int num = (int)session.getAttribute("num");
		List<StockDTO> stockList = storeService.getStock6(num);
		ResponseEntity<List<StockDTO>> entity = new ResponseEntity<List<StockDTO>>(stockList, HttpStatus.OK);
		return entity;
	}
	
	
	//1-2. 홍현희 남편 제이슨
	@GetMapping("/mainJson2")
	public ResponseEntity<List<ResultDTO>> mainJson2(HttpSession session) {
		System.out.println("StoreController mainJson2");
		int num = (int)session.getAttribute("num");
		List<ResultDTO> resultList = storeService.getResultMain(num);
		ResponseEntity<List<ResultDTO>> entity = new ResponseEntity<List<ResultDTO>>(resultList, HttpStatus.OK);
		return entity;
	}
	
	
	//2. 기준 정보 관리 - 재료 관리
	@GetMapping("/store/item")
	public String itemList(HttpServletRequest request, Model model) {
		System.out.println("itemList");
	
		List<ItemDTO> itemList = storeService.getitemList();
	
		model.addAttribute("itemList",itemList);
	
		return "store/item";
	}//itemList



	//3. 물류 관리
	//3-1. 재고 관리
	@GetMapping("/store/stock")
	public String stockList(HttpServletRequest request, Model model) {
		System.out.println("stock");
		
			List<StockDTO> stockList = storeService.getStockList();
		
			model.addAttribute("stockList",stockList);
		
			return "store/stock";
	}//stockList
	

	//3-2. 발주 관리
	@GetMapping("/store/order")
	public String orderList(HttpServletRequest request, Model model) {
		System.out.println("order");
		
			List<OrderDTO> orderList = storeService.getOrderList();
		
			model.addAttribute("orderList",orderList);
		
			return "store/order";
	}//orderList


	//3-3. 입고 관리
	@GetMapping("/store/receive")
	public String receiveList(HttpServletRequest request, Model model) {
		System.out.println("receive");
		
			List<ReceiveDTO> receiveList = storeService.getReceiveList();
		
			model.addAttribute("receiveList",receiveList);
		
			return "store/receive";
	}//receiveList



	//4. 영업 관리 - 실적 관리
	@GetMapping("/store/result")
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

