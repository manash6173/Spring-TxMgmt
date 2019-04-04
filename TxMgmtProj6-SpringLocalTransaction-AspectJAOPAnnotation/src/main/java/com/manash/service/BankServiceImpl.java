package com.manash.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.manash.dao.BankServiceDAO;
import com.manash.service.BankService;

@Service(value="bankService")
public class BankServiceImpl implements BankService {
	
	@Autowired
	private BankServiceDAO dao;
	
	private boolean withdrawflag=false;
	private boolean depositeflag=false;
	
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
	
	  @Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="IllegalAccessException")
	 @Override
	public boolean transferAmount(int accnofrom,int accnoto, float amount) throws IllegalAccessException{
		 /*try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 */
		 boolean withdraw=withdrawAmount(accnofrom, amount);
		boolean deposite=depositeAmount(accnoto, amount);
		if(withdraw==true && deposite==true)
			return true;
		else {
			throw new IllegalAccessException("Invalid account number");
		}
	}

}
