package com.allanshoulders.vsoutjection.sample.dao;

import java.util.List;

public interface ContactsDao {

	public abstract List<User> getAllUsers ();
	public abstract List<User> getUserContactsById (Long id);
	public abstract List<User> getUserContactsByTwitterName (String twitterName);
	public abstract List<User> getUserContactsByEmail (String email);
	
	public abstract User getUserById (Long id);
	public abstract User getUserByTwitterName (String twitterName);
	public abstract User getUserByEmail (String email);
	
}
