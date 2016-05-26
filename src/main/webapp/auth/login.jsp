<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="">

    <title>UPUP~登录</title>


    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/signin.css" rel="stylesheet">

    <link href="../css/jasny-bootstrap.min.css" rel="stylesheet">
    <link href="../css/docs.min.css" rel="stylesheet">

    <link href="../css/style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="../js/html5shiv.min.js"></script>
    <script src="../js/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="" href="#"><img src="../images/logo.png"/> </a>
        </div>
        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">搜索</button>
        </form>
    </div>
</div>

<div class="container middle">
    <c:url value="/auth/login" var="loginUrl" />
    <form action="${loginUrl}" method="post" class="form-signin row">
        <h2 class="form-signin-heading">登录</h2>

        <c:if test="${param.error != null}">
            <p>您的用户名或密码错误</p>
        </c:if>
        <c:if test="${param.logout != null}">
            <p>您已登出</p>
        </c:if>

        <label for="inputname" class="sr-only">用户名</label>
        <input type="text" name="username" id="inputname" class="form-control" placeholder="用户名" required="required" autofocus>

        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="密码" required>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>

        <p>没有账号？<a href="registerInput">立即注册</a></p>
    </form>
</div>

<div class="container btt" id="btt">
    <p class="pull-right"><a href="#" style="font-size: 30px"><span class="glyphicon glyphicon-chevron-up"
                                                                    aria-hidden="true"></span></a></p>
</div>

<div class="footer">
    <div class="container">
        <p class="footer-class">Copyright &copy; 2016.UP All rights reserved.</p>
        <!--<p class="pull-right"><a href="#"><span class="glyphicon glyphicon-chevron-up"
        aria-hidden="true"></span></a></p>-->
    </div>
</div>

<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>

<script src="../js/jasny-bootstrap.min.js"></script>
<script src="../js/docs.min.js"></script>

<script src="../js/holder.min.js"></script>

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>