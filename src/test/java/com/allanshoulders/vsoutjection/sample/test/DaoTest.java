package com.allanshoulders.vsoutjection.sample.test;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.allanshoulders.vsoutjection.sample.dao.ContactsDao;
import com.allanshoulders.vsoutjection.sample.dao.JdbcContactsDao;
import com.allanshoulders.vsoutjection.sample.dao.User;

@ContextConfiguration("classpath:test-spring.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DaoTest {
	
	@Autowired
	private JdbcContactsDao dao;
	
	@Autowired
	private ContactsDao contactsDao;
	
	@Test
	public void jdbcContactsDaoTest() {
		TestCase.assertNotNull(dao);
		TestCase.assertNotNull(dao.getDataSource());
	}
	
	
	@Test
	public void getAllUsersTest() {
		printUsers("getAllUsersTest", contactsDao.getAllUsers());
	}
	
	
	@Test
	public void getAllContactsByUserIdTest() {
		printUsers("getAllContactsByUserIdTest",
				contactsDao.getUserContactsById(9L));
	}

	
	@Test
	public void getUserContactsByTwitterNameTest() {
		printUsers("getUserContactsByTwitterNameTest",
				contactsDao.getUserContactsByTwitterName("@lexluthor"));
	}
	
	
	@Test
	public void getUserContactsByEmailTest() {
		printUsers("getUserContactsByEmailTest",
				contactsDao.getUserContactsByEmail("loki@villains.com"));
	}
	
	
	@Test
	public void getUserByIdTest() {
		printUsers("getUserByIdTest", contactsDao.getUserById(3L));
	}	
	
	
	@Test
	public void getUserByTwitterNameTest() {
		printUsers("getUserByTwitterNameTest", 
				contactsDao.getUserByTwitterName("@catwoman"));
	}
	
	
	@Test
	public void getUserByEmailTest() {
		printUsers("getUserByEmailTest", 
				contactsDao.getUserByEmail("twoface@villains.com"));
	}
	
	
	private void printUsers (String testMethodName, User ... users) {
		printUsers(testMethodName, Arrays.asList(users));
	}
	
	
	private void printUsers (String testMethodName, List<User> users) {
		System.out.println(testMethodName);
		
		for (User user : users) {
			System.out.println(user);
		}
		
		System.out.println();
	}
}
