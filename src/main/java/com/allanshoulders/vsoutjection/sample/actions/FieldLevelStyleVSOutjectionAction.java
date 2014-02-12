package com.allanshoulders.vsoutjection.sample.actions;

import org.apache.struts2.convention.annotation.Action;

import com.allanshoulders.vsoutjection.annotations.VSOutject;
import com.allanshoulders.vsoutjection.sample.dao.User;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class FieldLevelStyleVSOutjectionAction extends ActionSupport {

	@VSOutject(newInstance=true)
	private User user;
	
	@Action("fieldlevelcontacts")
	@Override
	public String execute() throws Exception {
		return super.execute();
	}
}
