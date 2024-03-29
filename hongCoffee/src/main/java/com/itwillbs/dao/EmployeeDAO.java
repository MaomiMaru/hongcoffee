package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.EmployeeDTO;
import com.itwillbs.domain.ItemDTO;
import com.itwillbs.domain.OrderDTO;
import com.itwillbs.domain.ReceiveDTO;
import com.itwillbs.domain.ShipmentDTO;
import com.itwillbs.domain.StoreDTO;
@Repository
public class EmployeeDAO {

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
	public List<ItemDTO> getItemList() {
		System.out.println("EmployeesDAO getItemList()");
		
		return sqlSession.selectList(namespace + ".getItemList");
	}//getJeryoList()
	
	//수주 목록
	public List<OrderDTO> getOrderList() {
		System.out.println("EmployeesDAO getOrderList()");
		
		return sqlSession.selectList(namespace + ".getOrderList");
	}//getSujuList()
	
	//출하 목록
	public List<ReceiveDTO> getShipmentList() {
		System.out.println("EmployeesDAO getShipmentList()");
		
		return sqlSession.selectList(namespace + ".getShipmentList");
	}//getChulhaList()
	
		
	//사원 목록
	public List<EmployeeDTO> getEmpList() {
		System.out.println("EmployeesDAO getEmpList()");
		
		return sqlSession.selectList(namespace + ".getEmpList");
	}//getSawonList()

	//로그인
	public EmployeeDTO userCheck(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeDAO userCheck()");
		return sqlSession.selectOne(namespace + ".userCheck", employeeDTO);
	}

	public void storeInsert(StoreDTO storeDTO) {
		System.out.println("EmployeeDAO storeInsert()");
		sqlSession.insert(namespace+".storeInsert", storeDTO);
		
	}

	public void storeUpdate(StoreDTO storeDTO) {
		System.out.println("EmployeeDAO storeUpdate()");
		sqlSession.update(namespace+".storeUpdate", storeDTO);
	}

	public void employeeInsert(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeDAO employeeInsert()");
		sqlSession.insert(namespace+".employeeInsert", employeeDTO);
	}

	public void employeeUpdate1(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeDAO employeeUpdate_admin()");
		sqlSession.update(namespace+".employeeUpdate1", employeeDTO);
	}

	public void employeeUpdate(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeDAO employeeUpdate()");
		sqlSession.update(namespace+".employeeUpdate", employeeDTO);
		
	}

	public void orderUpdate(OrderDTO orderDTO) {
		System.out.println("EmployeeDAO orderUpdate()");
		sqlSession.update(namespace+".orderUpdate", orderDTO);
	}

	public StoreDTO getStore(int num) {
		System.out.println("EmployeeDAO getStore()");
		return sqlSession.selectOne(namespace+".getStore", num);
	}

	public void itemInsert(ItemDTO itemDTO) {
		System.out.println("EmployeeDAO itemInsert()");
		sqlSession.insert(namespace+".itemInsert", itemDTO);
	}

	public ItemDTO getItem(int item_num) {
		System.out.println("EmployeeDAO getItem()");
		return sqlSession.selectOne(namespace+".getItem", item_num);
	}

	public void itemUpdate(ItemDTO itemDTO) {
		System.out.println("EmployeeDAO itemUpdate()");
		sqlSession.update(namespace+".itemUpdate", itemDTO);
	}

	public OrderDTO getOrder(int od_num) {
		System.out.println("EmployeeDAO getOrder()");
		return sqlSession.selectOne(namespace+".getOrder", od_num);
	}

	public void shipmentInsert(ShipmentDTO shipmentDTO) {
		System.out.println("EmployeeDAO shipmentInsert()");
		sqlSession.insert(namespace+".shipmentInsert", shipmentDTO);
	}

	public void shipmentUpdate(ShipmentDTO shipmentDTO) {
		System.out.println("EmployeeDAO shipmentUpdate()");
		sqlSession.update(namespace+".shipmentUpdate", shipmentDTO);
	}

	public ShipmentDTO getShipment(int od_num) {
		System.out.println("EmployeeDAO getShipment()");
		return sqlSession.selectOne(namespace+".getShipment", od_num);
	}

//	public EmployeeDTO getEmployeeA(int emp_num) {
//		System.out.println("EmployeeDAO getEmployeeA()");
//		return sqlSession.selectOne(namespace+".getEmployeeA",emp_num);
//	}



	
	
	
	
	
	
	
	
}
