package com.manash.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class MysqlDepositeDAOImpl implements MysqlDepositeDAO {
	
	private static final String MYSQL_DEPOSITE_QUERY="UPDATE BANKACCOUNT SET BALANCE=BALANCE+? WHERE ACCNO=?";
	
	private JdbcTemplate template;

	
	public MysqlDepositeDAOImpl(JdbcTemplate template) {
		this.template = template;
	}


	@Override
	public int depositeMoney(int accno, int amount) {
		int count=0;
		//use template object
		count=template.update(MYSQL_DEPOSITE_QUERY, amount,accno);
		return count;
	}
}
