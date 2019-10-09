package com.detu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.detu.util.DataSourceUtils;

public class SearchProductDao {

	public List<Object> findProductByWord(String word) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pname like ? limit 0,8";
		List<Object> query = runner.query(sql, new ColumnListHandler("pname"),"%"+word+"%");
		return query;
	}

}
