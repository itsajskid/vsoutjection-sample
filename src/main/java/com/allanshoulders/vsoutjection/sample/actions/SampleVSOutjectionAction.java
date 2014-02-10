package com.allanshoulders.vsoutjection.sample.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.allanshoulders.vsoutjection.annotations.VSOutject;
import com.allanshoulders.vsoutjection.sample.dao.ContactsDao;
import com.allanshoulders.vsoutjection.sample.dao.User;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/basic")
@SuppressWarnings("serial")
public class SampleVSOutjectionAction extends ActionSupport {
	
	@Autowired
	private ContactsDao contactsDao;
	
	@Action("modeldrivenstyle")
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	@VSOutject
	public List<User> getModel() {
		return contactsDao.getAllUsers();
	}
	
}
