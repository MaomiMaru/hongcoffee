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
	private EmployeeDAO employeesDAO;

	//지점 출력
	public List<StoreDTO> getStoreList(){
		System.out.println("EmployeesService getStoreList()");
		
		return employeesDAO.getStoreList();
	}//getJijumList
	
	//재료 출력
	public List<ItemDTO> getIngredientList(){
		System.out.println("EmployeesService getIngredientList()");
		
		return employeesDAO.getIngredientList();
	}//getJeryoList
	
	
	//수주 출력
	public List<OrderDTO> getOrderList(){
		System.out.println("EmployeesService getOrderList()");
		
		return employeesDAO.getOrderList();
	}//getSujuList
	
	
	
	//출하 출력
	public List<ReceiveDTO> getShipmenthaList(){
		System.out.println("EmployeesService getChulhaList()");
		
		return employeesDAO.getShipmenthaList();
	}//getChulhaList
	

	
	//사원 출력
	public List<EmployeeDTO> getEmpList(){
		System.out.println("EmployeesService getEmpList()");
		
		return employeesDAO.getEmpList();
	}//getSawonList
}
