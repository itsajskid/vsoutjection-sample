package com.allanshoulders.vsoutjection.sample.actions;

import java.util.ArrayList;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.allanshoulders.vsoutjection.annotations.VSOutject;
import com.allanshoulders.vsoutjection.sample.dao.ContactsDao;
import com.allanshoulders.vsoutjection.sample.dao.User;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/basic")
@SuppressWarnings("serial")
public class GetterSetterStyleVSOutjectionAction extends ActionSupport {

	private User user;
	private ArrayList<User> contacts;
	
	@Autowired
	private ContactsDao contactsDao;

	@VSOutject(newInstance=true)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@VSOutject(newInstance=true)
	public ArrayList<User> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<User> contacts) {
		this.contacts = contacts;
	}

	@Action("getsetcontacts")
	@Override
	public String execute() throws Exception {
		User user = contactsDao.getUserByTwitterName(this.user.getTwitterName());
		BeanUtils.copyProperties(this.user, user);
		contacts.addAll(contactsDao.getUserContactsById(user.getId()));		
		return SUCCESS;
	}
}
