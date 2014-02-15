package com.allanshoulders.vsoutjection.sample.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.allanshoulders.vsoutjection.annotations.VSOutject;
import com.allanshoulders.vsoutjection.sample.dao.ContactsDao;
import com.allanshoulders.vsoutjection.sample.dao.JsonTable;
import com.allanshoulders.vsoutjection.sample.dao.User;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/struts2jquery")
@SuppressWarnings("serial")
public class AllUsersStruts2JQueryAction extends ActionSupport {

	@Autowired
	private ContactsDao contactsDao;
	
	@VSOutject(newInstance=true, onAction="allusers-json")
	private JsonTable<User> usersJsonTable;
	
	@Action(value="allusers-json", results={@Result(type="json")})
	public String getAllUsersAsJSON() throws Exception {
		usersJsonTable.setGridModel(contactsDao.getAllUsers());
		return SUCCESS;
	}
	
	@Action("allusers")
	public String getAllUsers() throws Exception {
		return SUCCESS;
	}
	
}
