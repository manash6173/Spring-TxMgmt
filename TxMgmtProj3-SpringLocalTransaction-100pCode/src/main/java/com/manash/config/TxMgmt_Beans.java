package com.manash.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionProxyFactoryBean;

import com.manash.service.BankService;

@Configuration
public class TxMgmt_Beans {
	@Autowired
	private DataSource ds;
	@Autowired
	private BankService bankService;
	
	@Bean(name="txMgmr")
	public DataSourceTransactionManager createTxMgmr() {
		return new DataSourceTransactionManager(ds);
	}
	@Bean(name="tpfb")
	public TransactionProxyFactoryBean createTpfb() {
		TransactionProxyFactoryBean tpfb=null;
		tpfb=new TransactionProxyFactoryBean();
		Properties props=new Properties();
		props.put("transferAmount","PROPAGATION_REQUIRED");
		NameMatchTransactionAttributeSource nmta=null;
		nmta=new NameMatchTransactionAttributeSource();
		nmta.setProperties(props);
		tpfb.setTarget(bankService);
		tpfb.setTransactionAttributeSource(nmta);
		tpfb.setTransactionManager(createTxMgmr());
		
		return tpfb;
	}

}
