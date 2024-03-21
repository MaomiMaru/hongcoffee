package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.EmployeesDAO;
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
	
}
