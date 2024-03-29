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
public class EmployeeDAO {

	//마이바티스 객체생성 주입
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mappers.EmpMapper";
	
	//지점 목록
	public List<StoreDTO> getStoreList() {
		System.out.println("EmployeesDAO getStoreList()");
		
		return sqlSession.selectList(namespace + ".getStoreList");
	}//getJijumList()
	
	//지점 필터링 목록
	public List<StoreDTO> searchStoreList(StoreDTO storeDTO) {
		System.out.println("EmployeesDAO searchStoreList()");
		
		return sqlSession.selectList(namespace + ".searchStoreList", storeDTO);
	}//searchStoreList()
	
	//재료 목록
	public List<ItemDTO> getItemList() {
		System.out.println("EmployeesDAO getItemList()");
		
		return sqlSession.selectList(namespace + ".getItemList");
	}//getItemList()
	
	//재료 필터링 목록
	public List<ItemDTO> searchItemList(ItemDTO itemDTO) {
		System.out.println("EmployeesDAO searchItemList()");
		
		return sqlSession.selectList(namespace + ".searchItemList", itemDTO);
	}//searchItemList()
	
	//수주 목록
	public List<OrderDTO> getOrderList() {
		System.out.println("EmployeesDAO getOrderList()");
		
		return sqlSession.selectList(namespace + ".getOrderList");
	}//getSujuList()
	
	//수주 필터링 목록
	public List<OrderDTO> searchOrderList(OrderDTO orderDTO) {
		System.out.println("EmployeesDAO searchOrderList()");
		
		return sqlSession.selectList(namespace + ".searchOrderList", orderDTO);
	}//searchOrderList()
	
	//출하 목록
	public List<ReceiveDTO> getShipmentList() {
		System.out.println("EmployeesDAO getShipmentList()");
		
		return sqlSession.selectList(namespace + ".getShipmentList");
	}//getChulhaList()
	
	//출하 필터링 목록
	public List<ReceiveDTO> searchShipmentList(ReceiveDTO receiveDTO) {
		System.out.println("EmployeesDAO searchShipmentList()");
		
		return sqlSession.selectList(namespace + ".searchShipmentList", receiveDTO);
	}//searchShipmentList()
		
	//사원 목록
	public List<EmployeeDTO> getEmpList() {
		System.out.println("EmployeesDAO getEmpList()");
		
		return sqlSession.selectList(namespace + ".getEmpList");
	}//getSawonList()

	//사원 필터링 목록
	public List<EmployeeDTO> searchEmpList(EmployeeDTO employeeDTO) {
		System.out.println("EmployeesDAO searchEmpList()");
		
		return sqlSession.selectList(namespace + ".searchEmpList", employeeDTO);
	}//searchEmpList
	
	//로그인
	public EmployeeDTO userCheck(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeDAO userCheck()");
		return sqlSession.selectOne(namespace + ".userCheck", employeeDTO);
	}

}
