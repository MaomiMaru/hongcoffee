package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.ItemDTO;
import com.itwillbs.domain.OrderDTO;
import com.itwillbs.domain.ReceiveDTO;
import com.itwillbs.domain.ResultDTO;
import com.itwillbs.domain.StockDTO;
import com.itwillbs.domain.StoreDTO;

@Repository
public class StoreDAO {

	//마이바티스 객체생성 주입
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mappers.StoreMapper";

	//재료 목록
	public List<ItemDTO> getItemList() {
		System.out.println("StoreDAO getItemList()");
		
		return sqlSession.selectList(namespace + ".getItemList");
	}//getItemList
	
	//재료 필터링 목록
	public List<ItemDTO> searchItemList(ItemDTO itemDTO) {
		System.out.println("StoreDAO searchItemList()");
			
		return sqlSession.selectList(namespace + ".searchItemList", itemDTO);
	}//searchItemList



	//재고 목록
	public List<StockDTO> getStockList() {
		System.out.println("StoreDAO getStockList()");
		
		return sqlSession.selectList(namespace + ".getStockList");
	}//getStockList

	//재고 필터링 목록
	public List<StockDTO> searchStockList(StockDTO stockDTO) {
		System.out.println("StoreDAO searchStockList()");
		
		return sqlSession.selectList(namespace + ".searchStockList", stockDTO);
	}//searchStockList

	//발주 목록
	public List<OrderDTO> getOrderList() {
		System.out.println("StoreDAO getOrderList()");
		
		return sqlSession.selectList(namespace + ".getOrderList");
	}//getOrderList

	//발주 필터링 목록
	public List<OrderDTO> searchOrderList(OrderDTO orderDTO) {
		System.out.println("StoreDAO searchOrderList()");
		
		return sqlSession.selectList(namespace + ".searchOrderList", orderDTO);
	}//searchOrderList
	
	//입고 목록
	public List<ReceiveDTO> getReceiveList() {
		System.out.println("StoreDAO getReceiveList()");
		
		return sqlSession.selectList(namespace + ".getReceiveList");
	}//getReceiveList
	

	//소모 목록
	public List<ResultDTO> getSomoList() {
		System.out.println("StoreDAO getSomoList()");
		
		return sqlSession.selectList(namespace + ".getSomoList");
	}//getSomoList
	

	
	//판매 목록
		public List<ResultDTO> getPanmeList() {
			System.out.println("StoreDAO getPanmeList()");
			
			return sqlSession.selectList(namespace + ".getPanmeList");
		}//getPanmeList

	//입고 필터링 목록
	public List<ReceiveDTO> searchReceiveList(ReceiveDTO receiveDTO) {
		System.out.println("StoreDAO searchReceiveList()");
		
		return sqlSession.selectList(namespace + ".searchReceiveList", receiveDTO);
	}//searchReceiveList


	//실적 목록
	public List<ResultDTO> getResultList() {
		System.out.println("StoreDAO getResultList()");
		
		return sqlSession.selectList(namespace + ".getResultList");
	}//getResultList

	public StoreDTO userCheck(StoreDTO storeDTO) {
		System.out.println("StoreDAO userCheck()");
		return sqlSession.selectOne(namespace+".userCheck", storeDTO);
	}


	
	//실적 필터링 목록
	public List<ResultDTO> searchResultList(ResultDTO resultDTO) {
		System.out.println("StoreDAO searchResultList()");
			
		return sqlSession.selectList(namespace + ".searchResultList", resultDTO);
	}//searchResultList

}
