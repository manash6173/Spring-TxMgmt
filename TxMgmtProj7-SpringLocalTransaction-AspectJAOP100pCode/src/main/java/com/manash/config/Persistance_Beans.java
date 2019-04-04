package com.manash.config;



import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages="com. manash.dao")
public class Persistance_Beans {
	
	@Bean(name="hkDs")
	public DataSource createDs() {
		HikariDataSource hkcp=null;
		//create dataSource object
		hkcp=new HikariDataSource();
		hkcp.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hkcp.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		hkcp.setUsername("system");
		hkcp.setPassword("manash");
		return (DataSource) hkcp;
	}
	@Bean(name="template")
	public JdbcTemplate createhTemplate() {
		JdbcTemplate jt=null;
		jt=new JdbcTemplate(createDs());
		return jt;
	}
}
