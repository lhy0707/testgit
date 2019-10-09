package com.detu.service;

import java.sql.SQLException;

import com.detu.dao.TransferDao;
import com.detu.util.MyDataSourceUtils;

public class TransferService {

	public boolean transfer(String out, String in, double money) {
		
		TransferDao dao = new TransferDao();
		boolean isTransferSuccess = true;
		try {
			MyDataSourceUtils.startTransaction();
			dao.out(out,money);
			int i = 1/0;
			dao.in(in,money);
			
		} catch (Exception e) {
			isTransferSuccess = false;
			try {
				MyDataSourceUtils.rollback();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			
		}finally {
			try {
				MyDataSourceUtils.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return isTransferSuccess;
		
		
	}

}
