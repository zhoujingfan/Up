<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>File Upload</title>
</head>
<body>
	<img src="<s:property value='destUri'/>" />
	<s:form action="avatar" method="POST" enctype="multipart/form-data">
		<s:file name="upload" label="Upload your avatar" />
		<s:submit value="submit"/>
		<s:hidden name="%{#attr._csrf.parameterName}"
			value="%{#attr._csrf.token}" />
	</s:form>
	<s:property value="destUri" />
	<s:property value="upload" />
</body>
</html>