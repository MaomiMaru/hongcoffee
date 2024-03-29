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



	//1. 대시 보드
	@GetMapping("/main")
	public String main() {
		System.out.println("StoreController main()");

		return "/store/main";
	}


	

//2. 기준 정보 관리 - 재료 관리
@GetMapping("/store/item")
public String itemList(HttpServletRequest request, Model model) {
	System.out.println("itemList");
	
		List<ItemDTO> itemList = storeService.getItemList();
	
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
	

	
	//2-2. 기준 정보 관리 - 재료 필터링 목록
	@PostMapping("/itemSearch")
	public String itemSearch(HttpServletRequest request, Model model) {
		System.out.println("StoreController itemSearch()");

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

		String item_sPrice = request.getParameter("item_price");
		int item_price = 0;

		try {
			if (item_sPrice != null || item_sPrice != "") {
				item_price = Integer.parseInt(item_sPrice);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		itemDTO.setItem_price(item_price);

		String item_name = request.getParameter("item_name");
		itemDTO.setItem_name(item_name);

		List<ItemDTO> itemList;

		if (item_type == 100 && item_name == null && item_price == 0) {
			itemList = storeService.getItemList();
		} else {
			itemList = storeService.searchItemList(itemDTO);
		}

		model.addAttribute("itemList", itemList);

		return "/store/item";
	}//itemSearchList

	

	//3-2. 발주 관리
		@GetMapping("/store/order")
		public String orderList(HttpServletRequest request, Model model) {
			System.out.println("order");
			
				List<OrderDTO> orderList = storeService.getOrderList();
			
				model.addAttribute("orderList",orderList);
			
				return "store/order";
		}//orderList

	
	//3-2. 물류 관리 - 재고 필터링 목록
	@PostMapping("/stockSearch")
	public String stockSearch(HttpServletRequest request, Model model) {
		System.out.println("StoreController stockSearch()");

		StockDTO stockDTO = new StockDTO();

		String item_sType = request.getParameter("item_type");

		try {
			stockDTO.setItem_type(item_sType != null ? Integer.parseInt(item_sType) : 100);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		String item_sPrice = request.getParameter("item_price");
		int item_price = 0;

		try {
			if (item_sPrice != null || item_sPrice != "") {
				item_price = Integer.parseInt(item_sPrice);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		stockDTO.setItem_price(item_price);

		String item_name = request.getParameter("item_name");
		stockDTO.setItem_name(item_name);

		List<StockDTO> stockList;

		if (item_sType == null && item_name == "" && item_price == 0) {
			stockList = storeService.getStockList();
		} else {
			stockList = storeService.searchStockList(stockDTO);
		}

		model.addAttribute("stockList", stockList);

		return "/store/stock";
	}//stockSearchList

	
	

	
	//3-4. 물류 관리 - 발주 필터링 목록
	@PostMapping("/orderSearch")
	public String orderSearch(HttpServletRequest request, Model model) throws Exception {
		System.out.println("StoreController orderSearch()");

		OrderDTO orderDTO = new OrderDTO();

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

		if (item_name == "" && item_price == 0 && od_time == "" && received_sNot == null) {
			orderList = storeService.getOrderList();
		} else {
			orderList = storeService.searchOrderList(orderDTO);
		}

		model.addAttribute("orderList", orderList);

		return "/store/order";
	}//orderSearchList

	
	//3-3. 입고 관리
		@GetMapping("/store/receive")
		public String receiveList(HttpServletRequest request, Model model) {
			System.out.println("receive");
			
				List<ReceiveDTO> receiveList = storeService.getReceiveList();
			
				model.addAttribute("receiveList",receiveList);
			
				return "store/receive";
		}//receiveList



	
	

	//3-6. 물류 관리 - 입고 필터링 목록
	@PostMapping("/receiveSearch")
	public String receiveSearch(HttpServletRequest request, Model model) throws Exception {
		System.out.println("StoreController receiveSearch");

		ReceiveDTO receiveDTO = new ReceiveDTO();

		String item_name = request.getParameter("item_name");
		receiveDTO.setItem_name(item_name);

		String item_sPrice = request.getParameter("item_price");

		int item_price = 0;

		try {
			if (item_sPrice != "") {
				item_price = Integer.parseInt(item_sPrice);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		receiveDTO.setItem_price(item_price);

		String rc_time = request.getParameter("rc_time");

		if (rc_time != "") {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date d1 = format.parse(rc_time);
			Timestamp date1 = new Timestamp(d1.getTime());
			receiveDTO.setRc_time(date1);
		}

		List<ReceiveDTO> receiveList;

		if (item_name == "" && item_price == 0 && rc_time == "") {
			receiveList = storeService.getReceiveList();
		} else {
			receiveList = storeService.searchReceiveList(receiveDTO);
		}

		model.addAttribute("receiveList", receiveList);

		return "/store/receive";
	}//receiveSearchList

	

	
	
	//4-2. 영업 관리 - 실적 필터링 목록
	@PostMapping("resultSearch")
	public String resultSearch(HttpServletRequest request, Model model) throws Exception {
		System.out.println("StoreController resultSearch()");

		ResultDTO resultDTO = new ResultDTO();

		String rs_date = request.getParameter("rs_date");

		if (rs_date != "") {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date d1 = format.parse(rs_date);
			Timestamp date1 = new Timestamp(d1.getTime());
			resultDTO.setRs_date(date1);
		}
		List<ResultDTO> resultList;

		if (rs_date == "") {
			resultList = storeService.getResultList();
		} else {
			resultList = storeService.searchResultList(resultDTO);
		}

		model.addAttribute("resultList", resultList);

		return "/store/result";
	}//resultSearchList
	
	//4. 영업 관리 - 소모 관리
		@GetMapping("/store/somo")
		public String somoList(HttpServletRequest request, Model model) {
				System.out.println("result");
				
				List<ResultDTO> somoList = storeService.getSomoList();
				
				model.addAttribute("somoList",somoList);
				
				return "store/somo";
		}//somoList
		


		

		//4. 영업 관리 - 판매 관리
		@GetMapping("/store/panme")
		public String panmeList(HttpServletRequest request, Model model) {
				System.out.println("result");
				
				List<ResultDTO> panmeList = storeService.getPanmeList();
				
				model.addAttribute("panmeList",panmeList);
				
				return "store/panme";
		}//panmeList
		
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
