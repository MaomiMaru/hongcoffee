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

	@GetMapping("/store/main")
	public String main() {
		System.out.println();
		return "store/main";
	}

	
//재료 목록
@GetMapping("/store/item")
public String itemList(HttpServletRequest request, Model model) {
	System.out.println("ingredient");
	
		List<ItemDTO> itemList = storeService.getItemList();
	
		model.addAttribute("itemList",itemList);
	
		return "store/item";
	}//jeryoList


//재고 목록
@GetMapping("/store/stock")
public String stockList(HttpServletRequest request, Model model) {
	System.out.println("stock");
	
		List<StockDTO> stockList = storeService.getStockList();
	
		model.addAttribute("stockList",stockList);
	
		return "store/stock";
	}//stockList
	

//발주 목록
@GetMapping("/store/order")
public String orderList(HttpServletRequest request, Model model) {
	System.out.println("order");
	
		List<OrderDTO> orderList = storeService.getOrderList();
	
		model.addAttribute("orderList",orderList);
	
		return "store/order";
	}//orderList


//입고 목록
@GetMapping("/store/receive")
public String receiveList(HttpServletRequest request, Model model) {
	System.out.println("receive");
	
		List<ReceiveDTO> receiveList = storeService.getReceiveList();
	
		model.addAttribute("receiveList",receiveList);
	
		return "store/receive";
	}//receiveList



//실적
@GetMapping("/store/result")
public String resultList(HttpServletRequest request, Model model) {
	System.out.println("result");
	
		List<ResultDTO> resultList = storeService.getResultList();
	
		model.addAttribute("resultList",resultList);
	
		return "store/result";
	}//resultList
}

