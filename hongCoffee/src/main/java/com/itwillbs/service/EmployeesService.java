package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.EmployeesDAO;
import com.itwillbs.domain.EmployeeDTO;
import com.itwillbs.domain.ItemDTO;
import com.itwillbs.domain.OrderDTO;
import com.itwillbs.domain.ReceiveDTO;
import com.itwillbs.domain.StoreDTO;


@Service
public class EmployeesService {
	
	@Inject
	private EmployeesDAO employeesDAO;

	//지점 출력
	public List<StoreDTO> getJijumList(){
		System.out.println("EmployeesService getJijumList()");
		
		return employeesDAO.getJijumList();
	}//getJijumList
	
	//재료 출력
	public List<ItemDTO> getJeryoList(){
		System.out.println("EmployeesService getJeryoList()");
		
		return employeesDAO.getJeryoList();
	}//getJeryoList
	
	
	//수주 출력
	public List<OrderDTO> getSujuList(){
		System.out.println("EmployeesService getSujuList()");
		
		return employeesDAO.getSujuList();
	}//getSujuList
	
	
	
	//출하 출력
	public List<ReceiveDTO> getChulhaList(){
		System.out.println("EmployeesService getChulhaList()");
		
		return employeesDAO.getChulhaList();
	}//getChulhaList
	

	
	//사원 출력
	public List<EmployeeDTO> getSawonList(){
		System.out.println("EmployeesService getSawonList()");
		
		return employeesDAO.getSawonList();
	}//getSawonList
}
