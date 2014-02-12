package com.allanshoulders.vsoutjection.sample.dao;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DaoConfiguration {

	@Bean
	@Scope("singleton")
	public DataSource dataSource () {
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		dataSource.setUrl("jdbc:hsqldb:res:com/allanshoulders/vsoutjection/sample/database/Contacts");
		dataSource.setUsername("SA");
		dataSource.setPassword("");
		dataSource.setInitialSize(5);
		dataSource.setMaxActive(10);
		
		return dataSource;
		
	}
	
	@Autowired
	@Bean
	@Scope("singleton")
	public ContactsDao contactsDao (DataSource dataSource) {
		return new JdbcContactsDao(dataSource);
	}
	
	@Bean
	@Scope("singleton")
	public UserRowMapper userRowMapper() {
		return new UserRowMapper();
	}
}
