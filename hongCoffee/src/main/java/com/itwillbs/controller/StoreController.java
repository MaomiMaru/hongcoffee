package com.itwillbs.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.itwillbs.domain.ProductDTO;
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

	// 로그인 주소매핑
	@GetMapping("/login")
	public String login() {
		System.out.println("StoreController login()");

		return "store/login";
	}

	// 로그인 버튼을 눌렀을 때 처리 과정
	@PostMapping("/loginPro")
	public String loginPro(StoreDTO storeDTO, HttpSession session) {
		System.out.println("StoreController loginPro()");

		StoreDTO storeDTO1 = storeService.userCheck(storeDTO);
		if (storeDTO1 != null) {
			session.setAttribute("num", storeDTO1.getNum());
			session.setAttribute("sname", storeDTO1.getName());
			session.setAttribute("boss", storeDTO1.getBoss());
			session.setAttribute("state", storeDTO1.getState());
			return "redirect:/store/main";
		} else {
			return "/store/msg";
		}
	}

	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("StoreController logout()");
		session.invalidate();
		return "redirect:/store/login";
	}

	// 1. 대시 보드
	@GetMapping("/main")
	public String main() {
		System.out.println("StoreController main()");

		return "store/main";

	}

	// 2. 기준 정보 관리 - 재료 관리
	@GetMapping("/store/item")
	public String item(HttpServletRequest request, Model model) {
		System.out.println("StoreController item()");

		List<ItemDTO> itemList = storeService.getItemList();

		model.addAttribute("itemList", itemList);

		return "store/item";
	}// itemList

	// 2-1. 재료 필터링
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
			itemList = storeService.getItemList();
		} else {
			itemList = storeService.searchItemList(itemDTO);
		}

		model.addAttribute("itemList", itemList);

		return "/store/item";
	}// itemSearchList

	// 3. 물류 관리
	// 3-1. 재고 관리
	@GetMapping("/stock")

	public String stock(HttpServletRequest request, Model model) {

		System.out.println("StoreController stock()");

		List<StockDTO> stockList = storeService.getStockList();

		model.addAttribute("stockList", stockList);

		return "store/stock";
	}// stockList

	// 3-1-1. 재고 관리 필터링
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

		String item_sminPrice = request.getParameter("item_minPrice");

		String item_smaxPrice = request.getParameter("item_maxPrice");

		try {
			stockDTO.setItem_minPrice(item_sminPrice != null ? Integer.parseInt(item_sminPrice) : 0);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		try {
			stockDTO.setItem_maxPrice(item_smaxPrice != null ? Integer.parseInt(item_smaxPrice) : 0);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		String item_name = request.getParameter("item_name");
		stockDTO.setItem_name(item_name);

		List<StockDTO> stockList;

		if (item_sType == null && item_name == "" && item_sminPrice == null && item_smaxPrice == null) {
			stockList = storeService.getStockList();
		} else {
			stockList = storeService.searchStockList(stockDTO);
		}

		model.addAttribute("stockList", stockList);

		return "/store/stock";
	}// stockSearchList

	// 3-1-2 재고 관리 - 추가
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

	// 3-1-2 재고 관리 - 수정
	@GetMapping("/popup/stock_update")
	public String stock_update(HttpServletRequest request, Model model) {
		System.out.println("StoreController stock_update()");

		int stock_num = Integer.parseInt(request.getParameter("stock_num"));
		StockDTO stockDTO = new StockDTO();
		stockDTO = storeService.getStock(stock_num);
		model.addAttribute("stockDTO", stockDTO);

		return "/store/popup/stock_update";
	}
	
	@PostMapping("/popup/stock_updatePro")
	public String stock_updatePro(StockDTO stockDTO){
		System.out.println("StoreController stock_updatePro");
		
		storeService.stockUpdate(stockDTO);
		
		return "/store/popup/close";
	}

	// 3-2. 발주 관리
	@GetMapping("/order")
	public String order(HttpServletRequest request, Model model) {
		System.out.println("StoreController order()");

		List<OrderDTO> orderList = storeService.getOrderList();

		model.addAttribute("orderList", orderList);

		return "store/order";

	}// orderList

	// 3-2-1. 발주 필터링
	@PostMapping("/orderSearch")
	public String orderSearch(HttpServletRequest request, Model model) throws Exception {
		System.out.println("StoreController orderSearch()");

		OrderDTO orderDTO = new OrderDTO();

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

		if (item_name == "" && item_sminPrice == null && item_smaxPrice == null && od_time == ""
				&& received_sNot == null) {
			orderList = storeService.getOrderList();
		} else {
			orderList = storeService.searchOrderList(orderDTO);
		}

		model.addAttribute("orderList", orderList);

		return "/store/order";
	}// orderSearchList

	// 3-3. 입고 관리
	@GetMapping("/receive")
	public String receive(HttpServletRequest request, Model model) {
		System.out.println("StoreController receive()");

		List<ReceiveDTO> receiveList = storeService.getReceiveList();

		model.addAttribute("receiveList", receiveList);

		return "store/receive";

	}// receiveList

	// 3-3-1. 입고 필터링
	@PostMapping("/receiveSearch")
	public String receiveSearch(HttpServletRequest request, Model model) throws Exception {
		System.out.println("StoreController receiveSearch()");

		ReceiveDTO receiveDTO = new ReceiveDTO();

		String item_name = request.getParameter("item_name");
		receiveDTO.setItem_name(item_name);

		String item_sminPrice = request.getParameter("item_minPrice");

		String item_smaxPrice = request.getParameter("item_maxPrice");

		try {
			receiveDTO.setItem_minPrice(item_sminPrice != null ? Integer.parseInt(item_sminPrice) : 0);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		try {
			receiveDTO.setItem_maxPrice(item_smaxPrice != null ? Integer.parseInt(item_smaxPrice) : 0);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		String rc_time = request.getParameter("rc_time");

		if (rc_time != "") {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date d1 = format.parse(rc_time);
			Timestamp date1 = new Timestamp(d1.getTime());
			receiveDTO.setRc_time(date1);
		}

		List<ReceiveDTO> receiveList;

		if (item_name == "" && item_sminPrice == null && item_smaxPrice == null && rc_time == "") {
			receiveList = storeService.getReceiveList();
		} else {
			receiveList = storeService.searchReceiveList(receiveDTO);
		}

		model.addAttribute("receiveList", receiveList);

		return "/store/receive";
	}// receiveSearchList

	// 3-3-1. 물류 관리 - 입고 추가
	@GetMapping("/popup/receive_insert")
	public String receive_insert(HttpServletRequest request, Model model) {
		System.out.println("StoreController  receive_insert");

		int od_num = Integer.parseInt(request.getParameter("od_num"));
		model.addAttribute("orderDTO", storeService.getOrder(od_num));

		return "store/popup/receive_insert";
	}// receive_insert

	@PostMapping("/popup/receive_insertPro")
	public String receive_insertPro(ReceiveDTO receiveDTO) {
		System.out.println("StoreController receive_insertPro");

		receiveDTO.setItem_num(storeService.getItemNum(receiveDTO.getItem_name()));
		storeService.receiveInsert(receiveDTO);

		return "store/popup/close";
	}// receive_insertPro

	// 3-3-1. 물류 관리 - 발주 추가
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

	// 3-3-2. 물류 관리 - 발주 수정
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

	// 3-3-1 입고 관리 - 수정
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

	// 4. 영업 관리
	// 4-1. 실적 관리
	@GetMapping("/result")
	public String result(HttpServletRequest request, Model model) {
		System.out.println("StoreController result()");

		List<ResultDTO> resultList = storeService.getResultList();

		model.addAttribute("resultList", resultList);

		return "store/result";
	}// resultList

	// 4-1-1. 실적 관리 - 실적 추가
	@GetMapping("/popup/result_insert")
	public String result_insert() {
		System.out.println("StoreController result_insert()");

		return "/store/popup/result_insert";
	}

	// 4-1-1. 실적 필터링
	@PostMapping("/resultSearch")
	public String resultSearch(HttpServletRequest request, Model model) throws Exception {
		System.out.println("StoreController resultSearch()");

		ResultDTO resultDTO = new ResultDTO();

		String rs_date = request.getParameter("rs_date");

		if (rs_date != "") {
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//			Date d1 = format.parse(rs_date);
//			Timestamp date1 = new Timestamp(d1.getTime());
			resultDTO.setRs_date(rs_date);
		}
		List<ResultDTO> resultList;

		if (rs_date == "") {
			resultList = storeService.getResultList();
		} else {
			resultList = storeService.searchResultList(resultDTO);
		}

		model.addAttribute("resultList", resultList);

		return "/store/result";
	}// resultSearch

	// 4-2. 소모 관리
	@GetMapping("/store/consume")
	public String consume(HttpServletRequest request, Model model) {
		System.out.println("StoreController consume()");

		List<ResultDTO> consumeList = storeService.getConsumeList();

		model.addAttribute("consumeList", consumeList);

		return "store/consume";
	}// somoList

	@GetMapping("/popup/consume_insert")
	public String consume_insert() {
		System.out.println("StoreController consume_insert()");
		return "/store/popup/consume_insert";
	}

	@PostMapping("/popup/consume_insertPro")
	public String consume_insertPro(HttpServletRequest request) {
		System.out.println("StoreController consume_insertPro()");
		ResultDTO resultDTO = new ResultDTO(); 
		int stock_num = storeService.getStockNum(request.getParameter("item_name")); 
		
		String rs_date = request.getParameter("rs_date");
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		Date d1;
//		try {
//			d1 = format.parse(rs_date);
//		} catch (ParseException e) {
//			d1 = new Date();
//		}
//		Timestamp rdate = new Timestamp(d1.getTime());
		
		
		resultDTO.setRs_date(rs_date);
		resultDTO.setNum(Integer.parseInt(request.getParameter("num")));
		resultDTO.setConsume(Integer.parseInt(request.getParameter("consume")));
		resultDTO.setStock_num(stock_num);
		storeService.consumeInsert(resultDTO);
		
		return "store/popup/close";
	}

	@GetMapping("/popup/consume_update")
	public String consume_update(HttpServletRequest request, Model model) {
		System.out.println("StoreController consume_update()");
		
		int rs_num = Integer.parseInt(request.getParameter("rs_num"));
		model.addAttribute("resultDTO", storeService.getConsume(rs_num));
		
		
		return "/store/popup/consume_update";
	}

	@PostMapping("/popup/consume_updatePro")
	public String consume_updatePro(ResultDTO resultDTO) {
		System.out.println("StoreController consume_updatePro()");
		
		storeService.consumeUpdate(resultDTO);
		
		return "store/popup/close";
	}

	// 4-2-1. 소모 필터링
	@PostMapping("/consumeSearch")
	public String consumeSearch(HttpServletRequest request, Model model) throws Exception {
		System.out.println("StoreController consumeSearch()");

		ResultDTO resultDTO = new ResultDTO();

		String rs_date = request.getParameter("rs_date");

		if (rs_date != "") {
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//			Date d2 = format.parse(rs_date);
//			Timestamp date2 = new Timestamp(d2.getTime());
			resultDTO.setRs_date(rs_date);
		}

		List<ResultDTO> consumeList;

		if (rs_date == "") {
			consumeList = storeService.getConsumeList();
		} else {
			consumeList = storeService.searchConsumeList(resultDTO);
		}

		model.addAttribute("consumeList", consumeList);

		return "/store/consume";
	}// somoSearch

	// 4-3. 판매 관리
	@GetMapping("/sell")
	public String sell(HttpServletRequest request, Model model) {
		System.out.println("StoreController sell()");

		List<ResultDTO> sellList = storeService.getSellList();

		model.addAttribute("sellList", sellList);

		return "store/sell";
	}// panmeList

	// 4-3-.1 판매 필터링
	@PostMapping("/sellSearch")
	public String sellSearch(HttpServletRequest request, Model model) throws Exception {
		System.out.println("StoreController sellSearch()");

		ResultDTO resultDTO = new ResultDTO();

		String rs_date = request.getParameter("rs_date");

		if (rs_date != "") {
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//			Date d3 = format.parse(rs_date);
//			Timestamp date3 = new Timestamp(d3.getTime());
			resultDTO.setRs_date(rs_date);
		}
		List<ResultDTO> sellList;

		if (rs_date == "") {
			sellList = storeService.getSellList();
		} else {
			sellList = storeService.searchSellList(resultDTO);
		}

		model.addAttribute("sellList", sellList);

		return "/store/sell";
	}// panmeSearch
	
	@GetMapping("popup/sell_insert")
	public String sell_insert() {
		System.out.println("StoreController sell_insert()");
		
		return "/store/popup/sell_insert";
	}
	
	@PostMapping("popup/sell_insertPro")
	public String sell_insertPro(HttpServletRequest request, ResultDTO resultDTO) {
		System.out.println("StoreController sell_insertPro()");
		
		resultDTO.setRs_date(request.getParameter("rs_date"));
		resultDTO.setProd_name(request.getParameter("prod_name"));
		resultDTO.setSales(Integer.parseInt(request.getParameter("sales")));
//		resultDTO.setProd_price(Integer.parseInt(request.getParameter("prod_price")));
		
		storeService.sellInsert(resultDTO);
		
		return "/store/popup/close";
	}
	
	@GetMapping("/popup/sell_update")
	public String sell_update(HttpServletRequest request, Model model) {
		System.out.println("StoreController sell_update()");
		
		int rs_num = Integer.parseInt(request.getParameter("rs_num"));
		model.addAttribute("resultDTO", storeService.getSales(rs_num));
		
		
		return "/store/popup/sell_update";
	}
	
	@PostMapping("/popup/sell_updatePro")
	public String sell_updatePro(ResultDTO resultDTO) {
		System.out.println("StoreController sell_updatePro()");
		
		storeService.salesUpdate(resultDTO);
		
		return "store/popup/close";
	}
	

	// 창 닫기
	@GetMapping("popup/close")
	public String close() {
		System.out.println("close()");
		return "/emp/popup/close";
	}

}
