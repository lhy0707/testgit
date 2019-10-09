package com.detu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.detu.service.TransferService;

public class TransferServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String out = request.getParameter("out");
		String in = request.getParameter("in");
		double money = Double.parseDouble(request.getParameter("money"));
		TransferService transfer = new TransferService();
		boolean isTransferSuccess = transfer.transfer(out,in,money);
		response.setContentType("text/html;charset=utf-8");
		if(isTransferSuccess) {
			response.getWriter().write("转账成功");
		}else {
			response.getWriter().write("转账失败");
		}
		
		
	}
}
