package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.StoreDAO;
import com.itwillbs.domain.ItemDTO;


@Service
public class StoreService {
	
	@Inject
	private StoreDAO storeDAO;

	//재료 출력
		public List<ItemDTO> getIngredientList(){
			System.out.println("StoreService getIngredientList()");
			
			return storeDAO.getIngredientList();
		}//getJeryoList
}
