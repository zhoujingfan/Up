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
	<form action="avatar" method="post" enctype="multipart/form-data">
		<label for="myFile">Upload your avatar</label>
		<input type="file" name="myFile" />
		<input type="hidden" name="${_csrf.parameterName}"
                value="${_csrf.token}" />
		<input type="submit" value="submit"/>
	</form>
</body>
</html>