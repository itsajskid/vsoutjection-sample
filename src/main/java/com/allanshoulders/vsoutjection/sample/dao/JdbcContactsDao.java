package com.allanshoulders.vsoutjection.sample.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.allanshoulders.vsoutjection.sample.enums.UsersColumns;

public class JdbcContactsDao extends JdbcDaoSupport implements ContactsDao {
	
	@Autowired
	private UserRowMapper userRowMapper;
	
	public JdbcContactsDao(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Override
	public List<User> getAllUsers() {
		return getJdbcTemplate().query("select * from users", userRowMapper);
	}	
	
	@Override
	public List<User> getUserContactsById(Long id) {		
		StringBuilder sql = new StringBuilder("select * from users ")
			.append("left join contacts a on a.user_id = ? ")
			.append("where users.id = a.contact_id");
		
		return getJdbcTemplate().query(sql.toString(),
				userRowMapper, 
				id);
	}

	@Override
	public List<User> getUserContactsByTwitterName(String twitterName) {
		return getUserContactsById(
				getIdBy(UsersColumns.TWITTER_NAME, twitterName));
	}

	@Override
	public List<User> getUserContactsByEmail(String email) {
		return getUserContactsById(
				getIdBy(UsersColumns.EMAIL, email));
	}

	@Override
	public User getUserById(Long id) {
		return this.getUserBy(UsersColumns.ID, id);
	}

	@Override
	public User getUserByTwitterName(String twitterName) {
		return this.getUserBy(UsersColumns.TWITTER_NAME, twitterName);
	}

	@Override
	public User getUserByEmail(String email) {
		return this.getUserBy(UsersColumns.EMAIL, email);
	}
	
	private Long getIdBy(UsersColumns column, Object value) {
		StringBuilder sql = new StringBuilder("select id from users ")
			.append("where ")
			.append(column).append(" = ?");
		
		return getJdbcTemplate().queryForObject(sql.toString(), Long.class, value);
	}
	
	private User getUserBy(UsersColumns column, Object value) {
		StringBuilder sql = new StringBuilder("select * from users ")
			.append("where ")
			.append(column).append(" = ?");
		
		return getJdbcTemplate().queryForObject(sql.toString(), userRowMapper, value);
	}

}
