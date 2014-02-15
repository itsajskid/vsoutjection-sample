/**
 * Boilerplate yes, but good enough for our example code.
 */

var baseUrl = "/vsoutjection-sample/struts2jquery/contacts.action?";

function userContactsByTwitterLink(cellvalue, options, rowObject) {
	var action = baseUrl + "&twitterName=" + cellvalue;
	var atag = "<a href='" + action +"'>" + cellvalue + "</a>";
	return atag;
}

function userContactsByEmailLink(cellvalue, options, rowObject) {
	var action = baseUrl + "&email=" + cellvalue;
	var atag = "<a href='" + action +"'>" + cellvalue + "</a>";
	return atag;
}