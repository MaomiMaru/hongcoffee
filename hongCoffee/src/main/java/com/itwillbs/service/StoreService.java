package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.StoreDAO;
import com.itwillbs.domain.ItemDTO;
import com.itwillbs.domain.OrderDTO;
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
	public List<StockDTO> getStockList(){
		System.out.println("StoreService getStockList()");
		
		return storeDAO.getStockList();
	}//getStockList
	
	//재고 필터링 출력
	public List<StockDTO> searchStockList(StockDTO stockDTO) {
		System.out.println("StoreService searchStockList(()");
					
		return storeDAO.searchStockList(stockDTO);
	}//searchStockList
	
	//발주 출력
	public List<OrderDTO> getOrderList(){
		System.out.println("StoreService getOrderList()");
		
		return storeDAO.getOrderList();
	}//getOrderList
	

	//발주 필터링 출력
	public List<OrderDTO> searchOrderList(OrderDTO orderDTO) {
		System.out.println("StoreService searchOrderList()");
		
		return storeDAO.searchOrderList(orderDTO);
	}//searchOrderList

	
	//입고 출력
	public List<ReceiveDTO> getReceiveList(){
		System.out.println("StoreService getReceiveList()");
		
		return storeDAO.getReceiveList();
	}//getReceiveList
	
	
	//입고 필터링 출력
	public List<ReceiveDTO> searchReceiveList(ReceiveDTO receiveDTO) {
		System.out.println("StoreService searchReceiveList()");
			
		return storeDAO.searchReceiveList(receiveDTO);
	}//searchReceiveList
	
	
	//소모 출력
	public List<ResultDTO> getSomoList(){
		System.out.println("StoreService getSomoList()");
		
		return storeDAO.getSomoList();
	}//getSomoList

	//판매 출력
	public List<ResultDTO> getPanmeList(){
		System.out.println("StoreService getPanmeList()");
		
		return storeDAO.getPanmeList();
	}//getPanmeList

	
	//실적 출력
	public List<ResultDTO> getResultList(){
		System.out.println("StoreService getEmpList()");
		
		return storeDAO.getResultList();
	}//getResultList


	
	//로그인
	public StoreDTO userCheck(StoreDTO storeDTO) {
		System.out.println("StoreService userCheck()");
		return storeDAO.userCheck(storeDTO);
	}





	
	//실적 필터링 출력
	public List<ResultDTO> searchResultList(ResultDTO resultDTO) {
		System.out.println("StoreService searchResultList()");
			
		return storeDAO.searchResultList(resultDTO);
	}//searchResultList


}
