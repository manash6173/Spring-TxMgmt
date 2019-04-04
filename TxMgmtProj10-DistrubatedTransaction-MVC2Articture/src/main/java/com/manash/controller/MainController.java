package com.manash.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manash.service.BankService;


public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ApplicationContext ctx;
    private BankService proxy;
	
	public void init() throws ServletException {
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/manash/cfgs/applicationContext.xml");
	}

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int srcAccno=0,destAccno=0,amt=0;
		boolean status=false;
		RequestDispatcher rd=null;
		//read form data
		srcAccno=Integer.parseInt(req.getParameter("srcAcno"));
		destAccno=Integer.parseInt(req.getParameter("destAcno"));
		amt=Integer.parseInt(req.getParameter("amt"));
		try {
		proxy=ctx.getBean("bankService",BankService.class);
		//call b.method
		status=proxy.transferMoney(srcAccno, destAccno, amt);
		//get requestdispatcher object
		rd=req.getRequestDispatcher("status.jsp");
		req.setAttribute("status",status);
		//forward request to jsp page
		rd.forward(req, res);
		}
		catch(Exception e) {
			e.printStackTrace();
			rd=req.getRequestDispatcher("error.jsp");
			req.setAttribute("status","Failed");
			rd.forward(req,res);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
