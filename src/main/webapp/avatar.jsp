<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>File Upload</title>
</head>
<body>
	<img src="<s:property value='destUri'/>" />
	<form action="avatar" method="post" enctype="multipart/form-data">
		<label for="myFile">Upload your avatar</label>
		<input type="file" name="myFile" />
		<input type="hidden" name="${_csrf.parameterName}"
                value="${_csrf.token}" />
		<input type="submit" value="submit"/>
	</form>
	<s:property value="myFileFileName"/>
</body>
</html>