package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.EmployeeDTO;
import com.itwillbs.domain.ItemDTO;
import com.itwillbs.domain.OrderDTO;
import com.itwillbs.domain.ReceiveDTO;
import com.itwillbs.domain.StoreDTO;
@Repository
public class EmployeesDAO {

	// 마이바티스 객체생성 주입
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mappers.EmpMapper";
	
	//지점 목록
	public List<StoreDTO> getStoreList() {
		System.out.println("EmployeesDAO getStoreList()");
		
		return sqlSession.selectList(namespace + ".getStoreList");
	}//getJijumList()
	
	//재료 목록
	public List<ItemDTO> getIngredientList() {
		System.out.println("EmployeesDAO getIngredientList()");
		
		return sqlSession.selectList(namespace + ".getIngredientList");
	}//getJeryoList()
	
	//수주 목록
	public List<OrderDTO> getOrderList() {
		System.out.println("EmployeesDAO getOrderList()");
		
		return sqlSession.selectList(namespace + ".getOrderList");
	}//getSujuList()
	
	//출하 목록
		public List<ReceiveDTO> getShipmenthaList() {
			System.out.println("EmployeesDAO getShipmenthaList()");
			
			return sqlSession.selectList(namespace + ".getShipmenthaList");
		}//getChulhaList()
	
		
		//사원 목록
		public List<EmployeeDTO> getEmpList() {
			System.out.println("EmployeesDAO getEmpList()");
			
			return sqlSession.selectList(namespace + ".getEmpList");
		}//getSawonList()
}
