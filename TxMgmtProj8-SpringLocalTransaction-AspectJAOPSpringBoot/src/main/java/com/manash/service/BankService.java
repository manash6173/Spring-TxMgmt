package com.manash.service;

public interface BankService {
	public boolean withdrawAmount(int accno,float amount) ;
	public boolean depositeAmount(int accno,float amount) ;
	public boolean transferAmount(int accnofrom,int accnoto,float amount)throws IllegalAccessException ;

}
