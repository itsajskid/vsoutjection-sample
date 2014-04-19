package com.allanshoulders.vsoutjection.sample.test;

import org.apache.struts2.StrutsSpringTestCase;

public class Struts2JqueryTest extends StrutsSpringTestCase {

	@Override
	protected String[] getContextLocations() {
		return new String[]{"classpath*:test-spring.xml"};
	}
	
	public void testJsonTable() throws Exception {
		System.out.println(executeAction("/struts2jquery/allusers-json.action"));
	}
}
