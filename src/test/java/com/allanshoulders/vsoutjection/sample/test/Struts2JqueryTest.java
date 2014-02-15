package com.allanshoulders.vsoutjection.sample.test;

import org.apache.struts2.StrutsSpringTestCase;

public class Struts2JqueryTest extends StrutsSpringTestCase {

	@Override
	protected String[] getContextLocations() {
		return new String[]{"/WEB-INF/spring*.xml"};
	}
	
	public void testJsonTable() throws Exception {
		System.out.println(executeAction("/struts2jquery/allusers.action"));
	}
}
