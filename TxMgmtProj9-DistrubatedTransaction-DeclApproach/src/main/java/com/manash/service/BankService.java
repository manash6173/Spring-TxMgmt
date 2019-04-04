package com.manash.service;

public interface BankService {
	public boolean withdrawMoney(int accno,int amount);
	public boolean depositeMoney(int accno,int amount);
	public boolean transferMoney(int srcAccno,int destAccno,int amount);

}
