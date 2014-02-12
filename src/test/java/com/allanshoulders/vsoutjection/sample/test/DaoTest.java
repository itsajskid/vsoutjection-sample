package com.allanshoulders.vsoutjection.sample.test;

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
		printUsers(((ContactsDao)ctx.getBean("contactsDao"))
				.getAllUsers());
	}
	
	
	@Test
	public void getAllContactsByUserIdTest() {
		printUsers(((ContactsDao)ctx.getBean("contactsDao"))
				.getUsersContactsById(9L));
	}
	
	
	private void printUsers(List<User> users) {
		for (User user : users) {
			System.out.println(user);
		}
		
		System.out.println();
	}
}
