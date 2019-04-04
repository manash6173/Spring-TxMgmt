package com.manash.service;

import org.springframework.aop.target.ThreadLocalTargetSource;

import com.manash.dao.BankServiceDAO;
import com.manash.service.BankService;

public class BankServiceImpl implements BankService {
	private BankServiceDAO dao;
	private boolean withdrawflag=false;
	private boolean depositeflag=false;
	private boolean transferflag=false;
  
	public BankServiceImpl(BankServiceDAO dao) {
		this.dao = dao;
	}
	@Override
	public boolean withdrawAmount(int accno, float amount) {
		int result=0;
		//use dao
		result=dao.withdraw(accno, amount);
		if(result!=0)
			withdrawflag=true;
		return withdrawflag;
	}

	@Override
	public boolean depositeAmount(int accno, float amount){
		int result=0;
		//use dao
		result=dao.deposite(accno, amount);
		if(result!=0)
			depositeflag=true;
		return depositeflag;
	}
	
	 @Override
	public boolean transferAmount(int accnofrom,int accnoto, float amount) throws IllegalAccessException{
		 try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 
		 boolean withdraw=withdrawAmount(accnofrom, amount);
		boolean deposite=depositeAmount(accnoto, amount);
		if(withdraw==true && deposite==true)
			return true;
		else {
			throw new IllegalAccessException("Invalid account number");
		}
	}

}
