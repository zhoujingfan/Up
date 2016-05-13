<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="description" content="">
<meta name="author" content="">
<title>Signin Template for Bootstrap</title>
</head>
<body>
	<div>
		<s:form action="register">
			<h2>Please sign up</h2>
			<s:textfield name="username" placeholder="Username"/>
			<s:password name="password" placeholder="Password"/>
			<s:password name="confirmPassword" placeholder="Confirm Password"/>
			<s:textfield name="nickname" placeholder="Nickname"/>
			<s:textfield type="email" name="email" placeholder="Email"/>
			<s:textfield name="phone" placeholder="Phone"/>
			<s:textfield name="signature" placeholder="Signature"/>
			<s:textfield name="address" placeholder="Address"/>
			<s:radio name="gender" list="genderList" label="Gender"/>
			<s:submit value="Sign Up"/>
			<sec:csrfInput />
		</s:form>
	</div>
</body>
</html>