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

			public List<ItemDTO> getitemList(){
				System.out.println("StoreService getitemList()");
				
				return storeDAO.getitemList();
			}//getitemList
	

	
	//재고 출력
	public List<StockDTO> getStockList(){
		System.out.println("StoreService getStockList()");
		
		return storeDAO.getStockList();
	}//getStockList
	
	
	
	//발주 출력
	public List<OrderDTO> getOrderList(){
		System.out.println("StoreService getOrderList()");
		
		return storeDAO.getOrderList();
	}//getOrderList
	

	
	//입고 출력
	public List<ReceiveDTO> getReceiveList(){
		System.out.println("StoreService getReceiveList()");
		
		return storeDAO.getReceiveList();
	}//getReceiveList
	
	
	
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





}
