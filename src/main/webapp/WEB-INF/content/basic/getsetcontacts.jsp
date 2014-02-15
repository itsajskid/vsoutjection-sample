<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title><s:property value="vsoutjection.title.contacts.getset"/></title>
</head>
<body>
<h1><s:property value="twitterName"/>'s profile</h1>
<s:include value="user.jsp"/>
<br/>

<h1><s:property value="twitterName"/>'s contacts</h1>
<s:include value="contacts.jsp"/>

<br/>
<s:a action="modeldrivenstyle">See All Users</s:a>
</body>
</html>