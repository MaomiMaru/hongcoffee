package com.itwillbs.controller;


import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.domain.ItemDTO;
import com.itwillbs.service.StoreService;

@Controller
@RequestMapping("/store/*")
public class StoreController {
	
@Inject
private StoreService storeService;


//로그인
@GetMapping("main")
public String main() {
	System.out.println();
	return "store/main";
}

	
//재료 목록
@GetMapping("/store/ingredient")
public String jeryoList(HttpServletRequest request, Model model) {
	System.out.println("ingredient");
	
		List<ItemDTO> ingredientList = storeService.getIngredientList();
	
		model.addAttribute("ingredientList",ingredientList);
	
		return "store/ingredient";
	}//jijumList


//재고 목록
@GetMapping("stock")
public String stock() {
	System.out.println("stock");
	
		return "store/stock";
	}//stock
	

//발주 목록
@GetMapping("order")
public String order() {
	System.out.println("order");
	
		return "store/order";
	}//order


//입고 목록
@GetMapping("receive")
public String receive() {
	System.out.println("receive");
	
		return "store/receive";
	}//receive



//실적
@GetMapping("result")
public String result() {
	System.out.println("result");
	
		return "store/result";
	}//result

}

