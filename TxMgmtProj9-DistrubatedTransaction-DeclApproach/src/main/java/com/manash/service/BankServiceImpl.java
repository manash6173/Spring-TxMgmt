package com.manash.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.manash.dao.MysqlDepositeDAO;
import com.manash.dao.OracleWithdrawDAO;

public class BankServiceImpl implements BankService {
	
	private OracleWithdrawDAO oradao;
	private MysqlDepositeDAO mysqldao;
	
	public BankServiceImpl(OracleWithdrawDAO oradao, MysqlDepositeDAO mysqldao) {
		this.oradao = oradao;
		this.mysqldao = mysqldao;
	}
	@Override
	public boolean withdrawMoney(int accno, int amount) {
		//use oradao
		int count=oradao.withdrawMoney(accno, amount);
		if(count==0)
			return false;
		return true;
	}
	@Override
	public boolean depositeMoney(int accno, int amount) {
		//use mysqldao
		int count=mysqldao.depositeMoney(accno, amount);
		if(count==0)
			return false;
		return true;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean transferMoney(int srcAccno, int destAccno, int amount) {
		
		boolean oraflag=withdrawMoney(srcAccno, amount);
		boolean mysqlflag=depositeMoney(destAccno, amount);
		
		if(oraflag==true && mysqlflag==true)
			return true;
		else
			throw new RuntimeException("Invalid account number");
	}
}
