package com.manash.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class TxMgmt_Beans {
	@Autowired
	private DataSource ds;
	
	@Bean(name="txMgmr")
	public DataSourceTransactionManager createTxMgmr() {
		DataSourceTransactionManager txMgmr=null;
		txMgmr=new DataSourceTransactionManager(ds);
		return txMgmr;
	}

}
