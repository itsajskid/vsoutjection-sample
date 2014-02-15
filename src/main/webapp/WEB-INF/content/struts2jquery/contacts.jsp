<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title><s:property value="vsoutjection.title.contacts.struts2jquery"/></title>
<script type="text/javascript" src="<s:url value="/javascript/jquerylinkfunctions.js"/>"></script>
<sj:head jqueryui="true"/>
</head>
<body>
<h1><s:property value="twitterName"/>'s profile</h1>
<s:include value="../basic/user.jsp"/>
<br/>

<s:url var="url" action="contacts-json">
	<s:param name="twitterName" value="twitterName"/>
	<s:param name="email" value="email"/>
</s:url>
<h1><s:property value="twitterName"/>'s contacts</h1>
<s:include value="jquerytable.jsp"/>

<br/>
<s:a action="allusers">See All Users</s:a>

</body>
</html>