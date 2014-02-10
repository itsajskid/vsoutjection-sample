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
		List<User> users = ((ContactsDao)ctx.getBean("contactsDao"))
				.getAllUsers();
		
		for (User user : users) {
			System.out.println(user);
		}
	}
}
