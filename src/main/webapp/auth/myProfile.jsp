<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<s:property value="user.getAvatar()"/>
<s:property value="user.getUsername()"/>
<s:property value="user.getNickname()"/>
<s:property value="user.getGender()"/>
<s:property value="weiboAmount"/>
<p><a href="<s:url action='follow'/>">My Follow</a></p>
</body>
</html>