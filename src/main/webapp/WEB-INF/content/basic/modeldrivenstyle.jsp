<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Sample Action</title>
</head>
<body>
<h1>All Users in the System</h1>

<table border="0" cellpadding="5" cellspacing="0">
	<thead>
		<tr>
			<th>First Name</th>
			<th>Middle Name</th>
			<th>Last Name</th>
			<th>Twitter</th>
			<th>City</th>
			<th>State</th>
			<th>Country</th>
			<th>Email</th>
		</tr>
	</thead>
	
<s:iterator value="model" status="iterStatus">
	<tr>
		<td><s:property value="firstName"/></td>
		<td><s:property value="middleName"/></td>
		<td><s:property value="lastName"/></td>
		<td><s:a action="getsetcontacts"><s:property value="twitterName"/></s:a></td>
		<td><s:property value="city"/></td>
		<td><s:property value="state"/></td>
		<td><s:property value="country"/></td>
		<td><s:a action="fieldlevelcontacts"><s:property value="email"/></s:a></td>
	</tr>
</s:iterator>

<tfoot>
<tr><td>Number of total contacts: <s:property value="model.size()"/></td></tr>
</tfoot>

</table>

</body>
</html>