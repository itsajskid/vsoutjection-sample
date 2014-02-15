<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<sjg:grid 
	id="gridtable"
	gridModel="gridModel"
	dataType="json"
	rownumbers="true"
	href="%{url}"
	loadonce="true"
	sortable="true">
	
	<sjg:gridColumn name="firstName" index="firstName" title="First Name"/>
	<sjg:gridColumn name="lastName" index="lastName" title="Last Name"/>
	<sjg:gridColumn name="twitterName" index="twitterName" title="Twitter Name" 
		formatter="userContactsByTwitterLink"/>
	<sjg:gridColumn name="city" index="city" title="City"/>
	<sjg:gridColumn name="state" index="state" title="State"/>
	<sjg:gridColumn name="country" index="country" title="Country"/>
	<sjg:gridColumn name="email" index="email" title="Email" formatter="userContactsByEmailLink"/>
	
</sjg:grid>