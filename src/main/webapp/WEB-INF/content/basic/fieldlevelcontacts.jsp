<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title><s:text name="vsoutjection.title"/>Contacts (Field Level)</title>
</head>
<body>
<h1><s:property value="twitterName"/>'s contacts</h1>

<table cellspacing="0" cellpadding="5" border="0">
	<tr>
		<td>Name:</td>
		<td>
			<s:property value="firstName"/>&nbsp;
			<s:if test="middleName.length > 0">
				<s:property value="middleName"/>
			</s:if>
			<s:property value="lastName"/>
		</td>
	</tr>
	<tr>
		<td>Twitter:</td>
		<td><s:property value="twitterName"/></td>
	</tr>
	<tr>
		<td>Email:</td>
		<td><s:property value="email"/>
	</tr>
	<tr>
		<td>Location:</td>
		<td>
			<s:if test="city != 'Unknown'">
				<s:property value="city"/>,
			</s:if>
			<s:if test="state != 'NA'">
				<s:property value="state"/>
			</s:if>
			<s:property value="country"/>
		</td>
	</tr>
</table>

<br/>

<s:include value="contacts.jsp"/>

</body>
</html>