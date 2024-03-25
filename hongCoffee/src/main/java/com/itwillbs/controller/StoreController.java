package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.domain.ItemDTO;
import com.itwillbs.service.StoreService;

@Controller

public class StoreController {
	
@Inject
private StoreService storeservice;


@GetMapping("/store/main")
public String main() {
	System.out.println();
	return "store/main";
}

//재료 목록
@GetMapping("/store/ingredient")
public String jeryoList(HttpServletRequest request, Model model) {
	System.out.println("ingredient");
	
		List<ItemDTO> ingredientList = storeservice.getIngredientList();
	
		model.addAttribute("ingredientList",ingredientList);
	
		return "store/ingredient";
	}//jijumList

}

