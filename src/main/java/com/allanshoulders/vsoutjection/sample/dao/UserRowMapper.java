package com.allanshoulders.vsoutjection.sample.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.allanshoulders.vsoutjection.sample.enums.Database;

public class UserRowMapper implements ParameterizedRowMapper<User> {

	@Override
	public User mapRow(ResultSet resultSet, int row) throws SQLException {
		User user = new User();
		
		user.setFirstName(resultSet.getString(Database.FIRST_NAME.toString()));
		user.setLastName(resultSet.getString(Database.LAST_NAME.toString()));
		user.setMiddleName(resultSet.getString(Database.MIDDLE_NAME.toString()));
		user.setId(resultSet.getInt(Database.ID.toString()));
		user.setCity(resultSet.getString(Database.CITY.toString()));
		user.setState(resultSet.getString(Database.STATE.toString()));
		user.setTwitterName(resultSet.getString(Database.TWITTER_NAME.toString()));
		user.setCountry(resultSet.getString(Database.COUNTRY.toString()));
		user.setEmail(resultSet.getString(Database.EMAIL.toString()));
		
		return user;
	}

}
