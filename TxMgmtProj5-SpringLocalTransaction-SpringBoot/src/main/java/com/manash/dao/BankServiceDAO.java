package com.manash.dao;

public interface BankServiceDAO {
	public int withdraw(int accnt,float amount);
	public int deposite(int accnt,float amount);
}
