package com.manash.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages="com.manash.dao")
public class Persistance_Beans {
	
	/*@Bean("hkDS")
	public DataSource createDS() {
		HikariDataSource hkDS=null;
		//create data source object
		hkDS=new HikariDataSource();
		//set dateSource  properties 
		hkDS.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hkDS.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		hkDS.setUsername("system");
		hkDS.setPassword("manash");
		return hkDS;
	}*/
	/*@Bean("jt")
	public JdbcTemplate createJdbcTemplate() {
		JdbcTemplate jt=null;
		jt=new JdbcTemplate(createDS());
		return jt;
	}*/

}
