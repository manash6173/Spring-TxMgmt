package com.manash.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class BankServiceDAOImpl implements BankServiceDAO {
	private static final String WITHDRAW_QUERY="UPDATE BANKACCOUNT SET BALANCE=BALANCE-? WHERE ACCNO=?";
	private static final String DEPOSITE_QUERY="UPDATE BANKACCOUNT SET BALANCE=BALANCE+? WHERE ACCNO=?";
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public int withdraw(int accnt, float amount){
		int result=0;
		result=jt.update(WITHDRAW_QUERY, amount,accnt);
		return result;
	}
	@Override
	public int deposite(int accnt, float amount){
		int result=0;
		result=jt.update(DEPOSITE_QUERY, amount,accnt);
		return result;
	}
}
