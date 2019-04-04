package com.manash.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manash.service.BankService;

public class DistrubatedTransactionTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/manash/cfgs/applicationContext.xml");
		//get proxy class object
		proxy=ctx.getBean("bankService",BankService.class);
		System.out.println("Transfer Money???"+proxy.transferMoney(1001, 1003, 1000));
		//close ioc container
		((AbstractApplicationContext) ctx).close();
	}
}
