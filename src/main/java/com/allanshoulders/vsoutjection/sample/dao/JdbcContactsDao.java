package com.allanshoulders.vsoutjection.sample.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class JdbcContactsDao extends SimpleJdbcDaoSupport implements ContactsDao {
	
	@Autowired
	private UserRowMapper userRowMapper;
	
	public JdbcContactsDao(JdbcTemplate jdbcTemplate) {
		this.setJdbcTemplate(jdbcTemplate);
	}
	
	public JdbcContactsDao(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Override
	public List<User> getAllUsers() {
		return getJdbcTemplate().query("select * from users", userRowMapper);
	}

}
