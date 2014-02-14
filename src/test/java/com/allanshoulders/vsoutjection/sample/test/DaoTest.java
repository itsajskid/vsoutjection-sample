package com.allanshoulders.vsoutjection.sample.test;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.allanshoulders.vsoutjection.sample.dao.ContactsDao;
import com.allanshoulders.vsoutjection.sample.dao.JdbcContactsDao;
import com.allanshoulders.vsoutjection.sample.dao.User;

public class DaoTest {

	ApplicationContext ctx =  new ClassPathXmlApplicationContext("spring.xml");
	
	
	@Test
	public void jdbcContactsDaoTest() {
		JdbcContactsDao dao = (JdbcContactsDao)ctx.getBean("contactsDao");
		TestCase.assertNotNull(dao);
		TestCase.assertNotNull(dao.getDataSource());
	}
	
	
	@Test
	public void getAllUsersTest() {
		printUsers("getAllUsersTest",
				ctx.getBean(ContactsDao.class)
					.getAllUsers());
	}
	
	
	@Test
	public void getAllContactsByUserIdTest() {
		printUsers("getAllContactsByUserIdTest",
				ctx.getBean(ContactsDao.class)
					.getUserContactsById(9L));
	}
	
	
	
	@Test
	public void getUserContactsByTwitterNameTest() {
		printUsers("getUserContactsByTwitterNameTest",
				ctx.getBean(ContactsDao.class)
					.getUserContactsByTwitterName("@lexluthor"));
	}
	
	
	@Test
	public void getUserContactsByEmailTest() {
		printUsers("getUserContactsByEmailTest",
				ctx.getBean(ContactsDao.class)
					.getUserContactsByEmail("loki@villains.com"));
	}
	
	
	@Test
	public void getUserByIdTest() {
		printUsers("getUserByIdTest", 
				ctx.getBean(ContactsDao.class)
					.getUserById(3L));
	}	
	
	@Test
	public void getUserByTwitterNameTest() {
		printUsers("getUserByTwitterNameTest", 
				ctx.getBean(ContactsDao.class)
					.getUserByTwitterName("@catwoman"));
	}
	
	
	@Test
	public void getUserByEmailTest() {
		printUsers("getUserByEmailTest",
				ctx.getBean(ContactsDao.class)
					.getUserByEmail("twoface@villains.com"));
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
