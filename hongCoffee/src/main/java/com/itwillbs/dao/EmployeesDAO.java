package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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
	
}
