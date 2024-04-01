package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.EmployeeDAO;
import com.itwillbs.domain.EmployeeDTO;
import com.itwillbs.domain.ItemDTO;
import com.itwillbs.domain.OrderDTO;
import com.itwillbs.domain.ReceiveDTO;
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
	public List<ItemDTO> getItemList(){
		System.out.println("EmployeeService getItemList()");
		
		return employeeDAO.getItemList();
	}//getJeryoList
	
	
	//수주 출력
	public List<OrderDTO> getOrderList(){
		System.out.println("EmployeeService getOrderList()");
		
		return employeeDAO.getOrderList();
	}//getSujuList
	
	
	
	//출하 출력
	public List<ReceiveDTO> getShipmentList(){
		System.out.println("EmployeeService getShipmentList()");
		
		return employeeDAO.getShipmentList();
	}//getChulhaList
	

	
	//사원 출력
	public List<EmployeeDTO> getEmpList(){
		System.out.println("EmployeeService getEmpList()");
		
		return employeeDAO.getEmpList();
	}//getSawonList

	//팝업=========================================================
	//지점 추가
	public void storeInsert(StoreDTO storeDTO) {
		System.out.println("EmployeeService storeInsert()");
		employeeDAO.storeInsert(storeDTO);
	}

	public StoreDTO getStore(int num) {
		System.out.println("EmployeeService getStore()");
		return employeeDAO.getStore(num);
	}

	//지점 수정
	public void storeUpdate(StoreDTO storeDTO) {
		System.out.println("EmployeeService storeUpdate()");
		employeeDAO.storeUpdate(storeDTO);
	}

	//재료 추가
	public void itemInsert(ItemDTO itemDTO) {
		System.out.println("EmployeeService itemInsert()");
		employeeDAO.itemInsert(itemDTO);
	}

	public ItemDTO getItem(int item_num) {
		System.out.println("EmployeeService getItem()");
		return employeeDAO.getItem(item_num);
	}
	
	//재료 수정
	public void itemUpdate(ItemDTO itemDTO) {
		System.out.println("EmployeeService itemInsertPro()");
		employeeDAO.itemUpdate(itemDTO);
	}

	//수주 수정
	public void orderUpdate(OrderDTO orderDTO) {
		System.out.println("EmployeeService orderInsert()");
		employeeDAO.orderUpdate(orderDTO);
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

	public OrderDTO getOrder(int od_num) {
		System.out.println("EmployeeService getOrder()");
		return employeeDAO.getOrder(od_num);
	}


	public void shipmentInsert(ShipmentDTO shipmentDTO) {
		System.out.println("EmployeeService shipmentInsert()");
		employeeDAO.shipmentInsert(shipmentDTO);
	}

	public ShipmentDTO getShipment(int od_num) {
		System.out.println("EmployeeService getShipment()");
		return employeeDAO.getShipment(od_num);
	}

	public void shipmentUpdate(ShipmentDTO shipmentDTO) {
		System.out.println("EmployeeService shipmentUpdate()");
		employeeDAO.shipmentUpdate(shipmentDTO);
		
	}

	public EmployeeDTO getEmployee(int emp_num) {
		System.out.println("EmployeeDTO getEmployee()");
		return employeeDAO.getEmployee(emp_num);
	}


	public void shipmentDelete(ShipmentDTO shipmentDTO) {
		System.out.println("EmployeeDTO shipmentDelete()");
		employeeDAO.shipmentDelete(shipmentDTO);
	}










}
