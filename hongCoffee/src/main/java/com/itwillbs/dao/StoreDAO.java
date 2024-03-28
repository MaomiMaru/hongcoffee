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

	// 마이바티스 객체생성 주입
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mappers.StoreMapper";

	//재료 목록
	public List<ItemDTO> getitemList() {
		System.out.println("StoreDAO getitemList()");

		return sqlSession.selectList(namespace + ".getitemList");
	}//getitemList()


	//재고 목록
	public List<StockDTO> getStockList() {
		System.out.println("StoreDAO getStockList()");
		
		return sqlSession.selectList(namespace + ".getStockList");
	}//getStockList

	//발주 목록
	public List<OrderDTO> getOrderList() {
		System.out.println("StoreDAO getOrderList()");
		
		return sqlSession.selectList(namespace + ".getOrderList");
	}//getOrderList

	//입고 목록
	public List<ReceiveDTO> getReceiveList() {
		System.out.println("StoreDAO getReceiveList()");
		
		return sqlSession.selectList(namespace + ".getReceiveList");
	}//getReceiveList

	//실적 목록
	public List<ResultDTO> getResultList() {
		System.out.println("StoreDAO getResultList()");
		
		return sqlSession.selectList(namespace + ".getResultList");
	}//getResultList

	public StoreDTO userCheck(StoreDTO storeDTO) {
		System.out.println("StoreDAO userCheck()");
		return sqlSession.selectOne(namespace+".userCheck", storeDTO);
	}


	
}
