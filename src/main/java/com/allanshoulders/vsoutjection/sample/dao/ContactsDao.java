package com.allanshoulders.vsoutjection.sample.dao;

import java.util.List;

public interface ContactsDao {

	public abstract List<User> getAllUsers ();
	public abstract List<User> getUsersContactsById(Long id);
}
