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
public class FieldLevelStyleVSOutjectionAction extends ActionSupport {

	@Autowired
	private ContactsDao contactsDao;
	
	@VSOutject (newInstance=true)
	private User user;
	
	@VSOutject (newInstance=true)
	private ArrayList<User> contacts;
	
	@Action("fieldlevelcontacts")
	@Override
	public String execute() throws Exception {
		User user = contactsDao.getUserByEmail(this.user.getEmail());
		BeanUtils.copyProperties(this.user, user);
		contacts.addAll(contactsDao.getUserContactsById(user.getId()));
		return SUCCESS;
	}
}
