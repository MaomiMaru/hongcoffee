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
	public List<StoreDTO> getJijumList() {
		System.out.println("EmployeesDAO getJijumList()");
		
		return sqlSession.selectList(namespace + ".getJijumList");
	}//getJijumList()
	
	//재료 목록
	public List<ItemDTO> getJeryoList() {
		System.out.println("EmployeesDAO getJeryoList()");
		
		return sqlSession.selectList(namespace + ".getJeryoList");
	}//getJeryoList()
	
	//수주 목록
	public List<OrderDTO> getSujuList() {
		System.out.println("EmployeesDAO getSujuList()");
		
		return sqlSession.selectList(namespace + ".getSujuList");
	}//getSujuList()
	
	//출하 목록
		public List<ReceiveDTO> getChulhaList() {
			System.out.println("EmployeesDAO getChulhaList()");
			
			return sqlSession.selectList(namespace + ".getChulhaList");
		}//getChulhaList()
	
		
		//사원 목록
		public List<EmployeeDTO> getSawonList() {
			System.out.println("EmployeesDAO getSawonList()");
			
			return sqlSession.selectList(namespace + ".getSawonList");
		}//getSawonList()
}
