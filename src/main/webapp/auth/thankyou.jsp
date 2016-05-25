<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Thank you for your register.</h1>
	<p class="lead">
		Here is your personal information.<br>Username:
		<s:property value="username" />
	</p>
	<s:form action="avatar" method="POST" enctype="multipart/form-data">
		<s:file name="upload" label="Upload your avatar" />
		<s:submit value="submit"/>
		<s:hidden name="%{#attr._csrf.parameterName}"
			value="%{#attr._csrf.token}" />
	</s:form>
</body>
</html>