package com.allanshoulders.vsoutjection.sample.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.allanshoulders.vsoutjection.sample.enums.UsersColumns;

public class UserRowMapper implements ParameterizedRowMapper<User> {

	@Override
	public User mapRow(ResultSet resultSet, int row) throws SQLException {
		User user = new User();
		
		user.setFirstName(resultSet.getString(UsersColumns.FIRST_NAME.toString()));
		user.setLastName(resultSet.getString(UsersColumns.LAST_NAME.toString()));
		user.setMiddleName(resultSet.getString(UsersColumns.MIDDLE_NAME.toString()));
		user.setId(resultSet.getInt(UsersColumns.ID.toString()));
		user.setCity(resultSet.getString(UsersColumns.CITY.toString()));
		user.setState(resultSet.getString(UsersColumns.STATE.toString()));
		user.setTwitterName(resultSet.getString(UsersColumns.TWITTER_NAME.toString()));
		user.setCountry(resultSet.getString(UsersColumns.COUNTRY.toString()));
		user.setEmail(resultSet.getString(UsersColumns.EMAIL.toString()));
		
		return user;
	}

}
