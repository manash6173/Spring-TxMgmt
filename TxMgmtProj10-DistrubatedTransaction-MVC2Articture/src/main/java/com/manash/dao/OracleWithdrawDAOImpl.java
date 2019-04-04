package com.manash.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class OracleWithdrawDAOImpl implements OracleWithdrawDAO {
	
	private static final String ORACLE_WITHDRAW_QUERY="UPDATE BANKACCOUNT SET BALANCE=BALANCE-? WHERE ACCNO=?";
	
	private JdbcTemplate template;

	public OracleWithdrawDAOImpl(JdbcTemplate template) {
			this.template = template;
	}



	@Override
	public int withdrawMoney(int accno, int amount) {
		int count=0;
		//use template object
		count=template.update(ORACLE_WITHDRAW_QUERY, amount,accno);
		return count;
	}
}
