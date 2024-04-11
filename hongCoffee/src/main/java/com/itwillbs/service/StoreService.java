package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.StoreDAO;
import com.itwillbs.domain.ItemDTO;
import com.itwillbs.domain.OrderDTO;
import com.itwillbs.domain.ProductDTO;
import com.itwillbs.domain.ReceiveDTO;
import com.itwillbs.domain.ResultDTO;
import com.itwillbs.domain.StockDTO;
import com.itwillbs.domain.StoreDTO;


@Service
public class StoreService {
	
	@Inject
	private StoreDAO storeDAO;
	
	//재료 출력
	public List<ItemDTO> getItemList(){
		System.out.println("StoreService getItemList()");

		return storeDAO.getItemList();
	}//getItemList


	//재료 필터링 출력
	public List<ItemDTO> searchItemList(ItemDTO itemDTO) {
		System.out.println("StoreService searchItemList()");
				
		return storeDAO.searchItemList(itemDTO);
	}//searchItemList	

	
	//재고 출력
	public List<StockDTO> getStockList(int num){
		System.out.println("StoreService getStockList()");
		
		return storeDAO.getStockList(num);
	}//getStockList
	
	
	//재고 필터링 출력
	public List<StockDTO> searchStockList(StockDTO stockDTO) {
		System.out.println("StoreService searchStockList(()");
					
		return storeDAO.searchStockList(stockDTO);
	}//searchStockList
	
	
	//발주 출력
	public List<OrderDTO> getOrderList(int num){
		System.out.println("StoreService getOrderList()");
		
		return storeDAO.getOrderList(num);
	}//getOrderList
	

	//발주 필터링 출력
	public List<OrderDTO> searchOrderList(OrderDTO orderDTO) {
		System.out.println("StoreService searchOrderList()");
		
		return storeDAO.searchOrderList(orderDTO);
	}//searchOrderList

	
	//입고 출력
	public List<ReceiveDTO> getReceiveList(int num){
		System.out.println("StoreService getReceiveList()");
		
		return storeDAO.getReceiveList(num);
	}//getReceiveList
	
	
	//입고 필터링 출력
	public List<ReceiveDTO> searchReceiveList(ReceiveDTO receiveDTO) {
		System.out.println("StoreService searchReceiveList()");
			
		return storeDAO.searchReceiveList(receiveDTO);
	}//searchReceiveList
	
	
	//소모 출력
	public List<ResultDTO> getConsumeList(int num){
		System.out.println("StoreService getConsumeList()");
		
		return storeDAO.getConsumeList(num);
	}//getSomoList

	
	//소모 필터링 출력
	public List<ResultDTO> searchConsumeList(ResultDTO resultDTO) {
		System.out.println("StoreService searchConsumeList()");
		
		return storeDAO.searchConsumeList(resultDTO);
	}//searchSomoList
	
	
	//판매 출력
	public List<ResultDTO> getSellList(int num){
		System.out.println("StoreService getSellList()");
		
		return storeDAO.getSellList(num);
	}//getPanmeList

	
	//판매 필터링 출력
	public List<ResultDTO> searchSellList(ResultDTO resultDTO) {
		System.out.println("StoreService searchSellList()");
		
		return storeDAO.searchSellList(resultDTO);
	}//searchPanmeList
	
	
	//실적 출력
	public List<ResultDTO> getResultList(int num){
		System.out.println("StoreService getEmpList()");
		
		return storeDAO.getResultList(num);
	}//getResultList

	
	//실적 필터링 출력
	public List<ResultDTO> searchResultList(ResultDTO resultDTO) {
		System.out.println("StoreService searchResultList()");
			
		return storeDAO.searchResultList(resultDTO);
	}//searchResultList

	
	//로그인
	public StoreDTO userCheck(StoreDTO storeDTO) {
		System.out.println("StoreService userCheck()");
		return storeDAO.userCheck(storeDTO);
	}



	public void stockInsert(StockDTO stockDTO) {
		System.out.println("StoreService stockInsert()");
		storeDAO.stockInsert(stockDTO);
	}

	public StockDTO getStock(int num) {
		System.out.println("StoreService getStock()");
		return storeDAO.getStock(num);
	}



	public int getItemNum(String item_name) {
		System.out.println("StoreService getItemNum()");
		return storeDAO.getItemNum(item_name);
	}



	public OrderDTO getOrder(int od_num) {
		System.out.println("StoreService getOrder()");
		return storeDAO.getOrder(od_num);
	}


	public void receiveInsert(ReceiveDTO receiveDTO) {
		System.out.println("StoreService receiveInsert()");
		storeDAO.receiveInsert(receiveDTO);
	}

	public void orderInsert(OrderDTO orderDTO) {
		System.out.println("StoreService orderInsert()");
		storeDAO.orderInsert(orderDTO);
	}

	public void orderUpdate(OrderDTO orderDTO) {
		System.out.println("StoreService orderUpdate()");
		storeDAO.orderUpdate(orderDTO);
	}

	public void receiveUpdate(ReceiveDTO receiveDTO) {
		System.out.println("StoreService receiveUpdate()");
		storeDAO.receiveUpdate(receiveDTO);
	}



	public ReceiveDTO getReceive(int od_num) {
		System.out.println("StoreService getReceive()");
		return storeDAO.getReceive(od_num);
	}
	
	public ItemDTO getItem(int item_num) {
		System.out.println("StoreService getItem()");
		return storeDAO.getItem(item_num);
	}
	
	//==그래프
	
	//재고 그래프
		public List<StockDTO> getStock6(int num) {
			System.out.println("StoreService getStock6()");
			return storeDAO.getStock6(num);
		}



		public List<ResultDTO> getResultMain(int num) {
			System.out.println("StoreService getResultMain()");
			return storeDAO.getResultMain(num);
		}



	public void consumeInsert(ResultDTO resultDTO) {
		System.out.println("StoreService consumeInsert()");
		storeDAO.consumeInsert(resultDTO);
	}


	public int getStockNum(StockDTO stockDTO) {
		System.out.println("StoreService getStockNum()");
		return storeDAO.getStockNum(stockDTO);
	}


	public Object getConsume(int rs_num) {
		System.out.println("StoreService getConsume");
		return storeDAO.getConsume(rs_num);
	}


	public void consumeUpdate(ResultDTO resultDTO) {
		System.out.println("StoreService consumeUpdate()");
		storeDAO.consumUpdate(resultDTO);
	}


	public void sellInsert(ResultDTO resultDTO) {
		System.out.println("StoreService sellInsert()");
		storeDAO.sellInsert(resultDTO);
	}


	public void stockUpdate(StockDTO stockDTO) {
		System.out.println("StoreService stockUpdate()");
		storeDAO.stockUpdate(stockDTO);
	}


	public ResultDTO getSales(int rs_num) {
		System.out.println("StoreService getSales()");
		return storeDAO.getSales(rs_num);
	}


	public void salesUpdate(ResultDTO resultDTO) {
		System.out.println("StoreService salesUpdate()");
		storeDAO.salesUpdate(resultDTO);
	}


	public void orderDelete(int od_num) {
		System.out.println("StoreService orderDelete()");
		storeDAO.orderDelete(od_num);
	}

	public void autoPay() {
		System.out.println("StoreService autoPay()");
		Timestamp now = new Timestamp(System.currentTimeMillis());
		System.out.println(now);
		storeDAO.autoPay(now);
	}


	public ResultDTO getSell(int rs_num) {
		System.out.println("StoreService getSell()");
		return storeDAO.getSell(rs_num);
	}






}
