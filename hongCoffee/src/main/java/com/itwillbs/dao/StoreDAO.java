package com.itwillbs.dao;



import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.ItemDTO;


@Repository
public class StoreDAO {

	// 마이바티스 객체생성 주입
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mappers.StoreMapper";
	
	
	//재료 목록
		public List<ItemDTO> getIngredientList() {
			System.out.println("StoreDAO getIngredientList()");
			
			return sqlSession.selectList(namespace + ".getIngredientList");
		}//getJeryoList()
}
