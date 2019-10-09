package com.detu.service;

import java.sql.SQLException;
import java.util.List;

import com.detu.dao.SearchProductDao;

public class SearchProductService {

	public List<Object> findProductByWord(String word) throws SQLException {
		SearchProductDao dao = new SearchProductDao();
		List<Object> list = dao.findProductByWord(word);
		
		return list;
	}

}
