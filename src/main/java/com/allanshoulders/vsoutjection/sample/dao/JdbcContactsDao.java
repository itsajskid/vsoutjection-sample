package com.allanshoulders.vsoutjection.sample.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@Override
	public List<User> getUsersContactsById(Long id) {
		StringBuilder sb = new StringBuilder("select * from users, ")
				.append("(select * from contacts where contacts.user_id = :id) a ")
				.append("where users.id = a.contact_id");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		
		return getJdbcTemplate().query(sb.toString(),
				userRowMapper, 
				id);
	}

}
