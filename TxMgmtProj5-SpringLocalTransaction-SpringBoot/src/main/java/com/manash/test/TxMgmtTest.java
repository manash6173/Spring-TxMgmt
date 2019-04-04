package com.manash.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;

import com.manash.config.AppConfig;
import com.manash.service.BankService;

@SpringBootApplication
@Import(value=AppConfig.class)
public class TxMgmtTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		//create IOC Container
        ctx=SpringApplication.run(TxMgmtTest.class, args);
        //get proxy class object
        proxy=ctx.getBean("tpfb",BankService.class);
        //invoke methods
        try {
        //System.out.println("Deposite Sucessfull::"+proxy.depositeAmount(1001, 1000));
        System.out.println("---------------------");
        //System.out.println("WithDraw Amount::"+proxy.withdrawAmount(1002, 100));
        System.out.println("---------------------");
        System.out.println("Transfer Money::"+proxy.transferAmount(1001, 1003, 1000));
        }
        catch (Exception e) {
			e.printStackTrace();
		}
        //close ioc container
        ((AbstractApplicationContext) ctx).close();
	}
}









