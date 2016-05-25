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
<script src="http://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
<title>Publish</title>
</head>
<body>
	<s:form action="publish">
		<s:textfield name="content" placeholder="Say something"/>
		<sec:csrfInput />
		<s:submit value="Submit"/>
	</s:form>
	<input type="text" id="2"/>
	<button id="1">submit</button>
</body>
<script>
$(document).ready(function(){
  $("button#1").click(function(){
	  var formdata = {content:$("input#2").val(),_csrf:$("[name='_csrf']").attr("value")};
	  $.ajax({
		  url: "/weibo/publish.action",
		  data: {content:$("input#2").val(),_csrf:$("[name='_csrf']").attr("value")},
		  method: "POST",
		  success: function( result ) {
		    alert("success");
		  }
		});
  });
});
</script>
</html>