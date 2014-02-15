package com.allanshoulders.vsoutjection.sample.actions;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
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
public class ContactsStruts2JQueryAction extends ActionSupport {
	
	@Autowired
	private ContactsDao contactsDao;
	
	@VSOutject(newInstance=true)
	private User user;
	
	@VSOutject(newInstance=true, onAction="contacts-json")
	private JsonTable<User> contactsJsonTable;

	
	@Action("contacts")
	public String getContacts() throws Exception {
		
		if (!StringUtils.isEmpty(user.getTwitterName())) {
			BeanUtils.copyProperties(this.user, 
					contactsDao.getUserByTwitterName(user.getTwitterName()));
		} else if (!StringUtils.isEmpty(user.getEmail())) {
			BeanUtils.copyProperties(this.user, 
					contactsDao.getUserByEmail(user.getEmail()));
		}
		
		return SUCCESS;
	}
	
	
	@Action(value="contacts-json", results={@Result(type="json")})
	public String getContactsAsJSON() throws Exception {
		
		if (!StringUtils.isEmpty(user.getTwitterName())) {
			contactsJsonTable.setGridModel(
					contactsDao
						.getUserContactsByTwitterName(user.getTwitterName()));
		} else if (!StringUtils.isEmpty(user.getEmail())) {
			contactsJsonTable.setGridModel(
					contactsDao.getUserContactsByEmail(user.getEmail()));
		}
		
		return SUCCESS;
	}
	
}
