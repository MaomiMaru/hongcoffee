package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.EmployeeDAO;
import com.itwillbs.domain.EmployeeDTO;
import com.itwillbs.domain.ItemDTO;
import com.itwillbs.domain.OrderDTO;
import com.itwillbs.domain.ReceiveDTO;
import com.itwillbs.domain.StoreDTO;


@Service
public class EmployeeService {
	
	@Inject
	private EmployeeDAO employeeDAO;

	//사원번호, 비밀번호 확인
	public EmployeeDTO userCheck(EmployeeDTO employeeDTO) {
		System.out.println("EMployeeService userCheck()");
		return employeeDAO.userCheck(employeeDTO);
	}
	
	//지점 출력
	public List<StoreDTO> getStoreList(){
		System.out.println("EmployeeService getStoreList()");
		
		return employeeDAO.getStoreList();
	}//getJijumList
	
	//지점 필터링 출력
	public List<StoreDTO> searchStoreList(StoreDTO storeDTO) {
		System.out.println("EmployeeService searchStoreList()");
		
		return employeeDAO.searchStoreList(storeDTO);
	}//searchStoreList
	
	//재료 출력
	public List<ItemDTO> getItemList(){
		System.out.println("EmployeeService getItemList()");
		
		return employeeDAO.getItemList();
	}//getItemList
	
	//재료 필터링 출력
	public List<ItemDTO> searchItemList(ItemDTO itemDTO) {
		System.out.println("EmployeeService searchItemList()");
		
		return employeeDAO.searchItemList(itemDTO);
	}//searchItemList
	
	//수주 출력
	public List<OrderDTO> getOrderList(){
		System.out.println("EmployeeService getOrderList()");
		
		return employeeDAO.getOrderList();
	}//getSujuList
	
	//수주 필터링 출력
	public List<OrderDTO> searchOrderList(OrderDTO orderDTO) {
		System.out.println("EmployeeService searchOrderList()");
		
		return employeeDAO.searchOrderList(orderDTO);
	}//searchOrderList
	
	//출하 출력
	public List<ReceiveDTO> getShipmentList(){
		System.out.println("EmployeeService getChulList()");
		
		return employeeDAO.getShipmentList();
	}//getChulhaList
	
	//출하 필터링 출력
	public List<ReceiveDTO> searchShipmentList(ReceiveDTO receiveDTO) {
		System.out.println("EmployeeService searchShipmentList()");
		
		return employeeDAO.searchShipmentList(receiveDTO);
	}//searchShipmentList
	
	//사원 출력
	public List<EmployeeDTO> getEmpList(){
		System.out.println("EmployeeService getEmpList()");
		
		return employeeDAO.getEmpList();
	}//getSawonList

	//사원 필터링 출력
	public List<EmployeeDTO> searchEmpList(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeService searchEmpList()");
		
		return employeeDAO.searchEmpList(employeeDTO);
	}//searchEmpList

}
