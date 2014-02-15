<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title><s:text name="vsoutjection.title.contacts.struts2jquery"/></title>
<script type="text/javascript" src="<s:url value="/javascript/jquerylinkfunctions.js"/>"></script>
<sj:head jqueryui="true"/>
</head>
<body>
<h1>All User's of the System</h1>
<s:url var="url" action="allusers-json"/>
<s:include value="jquerytable.jsp"/>

</body>
</html>