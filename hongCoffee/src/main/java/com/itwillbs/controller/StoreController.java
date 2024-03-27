package com.itwillbs.controller;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

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
import com.itwillbs.service.StoreService;

@Controller
//@RequestMapping("/store/*")
public class StoreController {
	
@Inject
private StoreService storeService;


//로그인
@GetMapping("/store/main")
public String main() {
	System.out.println();
	return "store/main";
	}

	
//재료 목록
@GetMapping("/store/item")
public String itemList(HttpServletRequest request, Model model) {
	System.out.println("itemList");
	
	List<ItemDTO> itemList = storeService.getItemList();
	
	model.addAttribute("itemList",itemList);
	
	return "store/item";
	}//itemList


//재료 필터링 목록
@PostMapping("/store/itemSearch")
public String itemSearchList(HttpServletRequest request, Model model) {
	System.out.println("itemSearch");
	
	ItemDTO itemDTO = new ItemDTO();
	
	String item_sType = request.getParameter("item_type");
	int item_type = 100;
	
	String item_sPrice = request.getParameter("item_price");
	int item_price = 0;
	
	try {
		if (item_sType != null || item_sType != "") {
			item_type = Integer.parseInt(item_sType);
		}
	} catch(NumberFormatException e) {
		e.printStackTrace();
	}
	try {
		if (item_sPrice != null || item_sPrice != "") {
			item_price = Integer.parseInt(item_sPrice);
		}
	} catch(NumberFormatException e) {
		e.printStackTrace();
	}
	
	itemDTO.setItem_type(item_type);
	itemDTO.setItem_price(item_price);
	System.out.println(item_type);
	
	String item_name = request.getParameter("item_name");
	itemDTO.setItem_name(item_name);
	
	List<ItemDTO> itemList;
	
	if(item_type == 100 && item_name == null && item_price == 0) {
		itemList = storeService.getItemList();
	}else {
		itemList = storeService.searchItemList(itemDTO);
	}
	
	model.addAttribute("itemList", itemList);
	
	return "store/item";
}//itemSearchList


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


//실적 목록
@GetMapping("/store/result")
public String resultList(HttpServletRequest request, Model model) {
	System.out.println("result");
	
		List<ResultDTO> resultList = storeService.getResultList();
	
		model.addAttribute("resultList",resultList);
	
		return "store/result";
	}//resultList


//실적 필터링
@PostMapping("/store/resultSearch")
public String resultSearchList(HttpServletRequest request, Model model) throws Exception {
	System.out.println("resultSearch");
	
	ResultDTO resultDTO = new ResultDTO();
	
	String rs_date = request.getParameter("rs_date");
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	Date d1 = format.parse(rs_date);
	Timestamp date1 = new Timestamp(d1.getTime());
	resultDTO.setRs_date(date1);
	
	List<ResultDTO> resultList;
	
	if(rs_date != null) {
		resultList = storeService.searchResultList(resultDTO);
	}else {
		resultList = storeService.getResultList();
	}
	
	model.addAttribute("resultList",resultList);
	
	return "store/result";
	}//resultSearchList

}

