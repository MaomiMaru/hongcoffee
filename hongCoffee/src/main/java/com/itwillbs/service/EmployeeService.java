package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.EmployeeDAO;
import com.itwillbs.domain.EmployeeDTO;
import com.itwillbs.domain.ItemDTO;
import com.itwillbs.domain.OrderDTO;
import com.itwillbs.domain.ShipmentDTO;
import com.itwillbs.domain.StoreDTO;


@Service
public class EmployeeService {
	
	@Inject
	private EmployeeDAO employeeDAO;

	//사원번호, 비밀번호 확인
	public EmployeeDTO userCheck(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeService userCheck()");
		return employeeDAO.userCheck(employeeDTO);
	}
	
	
	//지점 출력
	public List<StoreDTO> getStoreList(){
		System.out.println("EmployeeService getStoreList()");
		
		return employeeDAO.getStoreList();
	}//getJijumList
	
	//재료 출력

	public List<ItemDTO> getitemList(){
		System.out.println("EmployeeService getitemList()");

		
		return employeeDAO.getitemList();
	}//getitemList

	
	
	//수주 출력
	public List<OrderDTO> getOrderList(){
		System.out.println("EmployeeService getOrderList()");
		
		return employeeDAO.getOrderList();
	}//getSujuList
	
	
	
	//출하 출력
	public List<ShipmentDTO> getShipmentList(){
		System.out.println("EmployeeService getChulList()");
		
		return employeeDAO.getShipmentList();
	}//getChulhaList
	

	
	//사원 출력
	public List<EmployeeDTO> getEmpList(){
		System.out.println("EmployeeService getEmpList()");
		
		return employeeDAO.getEmpList();
	}//getSawonList

	//지점 추가
	public void storeInsert(StoreDTO storeDTO) {
		System.out.println("EmployeeService storeInsert()");
		employeeDAO.storeInsert(storeDTO);
	}

	//지점 수정
	public void storeUpdate(StoreDTO storeDTO) {
		System.out.println("EmployeeService storeUpdate()");
		employeeDAO.storeUpdate(storeDTO);
	}

	//사원 추가
	public void employeeInsert(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeService employeeInsert()");
		employeeDAO.employeeInsert(employeeDTO);
	}

	//사원 수정(관리자)
	public void employeeUpdate1(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeService employeeUpdate_admin()");
		employeeDAO.employeeUpdate1(employeeDTO);
	}

	//사원 수정(사원)
	public void employeeUpdate(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeService employeeUpdate()");
		employeeDAO.employeeUpdate(employeeDTO);
		
	}

	//수주 수정
	public void orderUpdate(OrderDTO orderDTO) {
		System.out.println("EmployeeService orderInsert()");
		employeeDAO.orderUpdate(orderDTO);
	}


	public StoreDTO getStore(int num) {
		System.out.println("EmployeeService getStore");
		return employeeDAO.getStore(num);
	}





}
