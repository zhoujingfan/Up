<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="">

    <title>我的信息</title>


    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <link href="../css/style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="mainbody">
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="" href="#"><img src="../images/logo.png"/> </a>
        </div>
        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="">
            </div>
            <button type="submit" class="btn btn-default">搜索</button>
        </form>
        <div class="navbar-right">
            <ul class="nav navbar-nav">
                <li><a data-toggle="modal" data-target="" >登出</a></li>
            </ul>
        </div>
    </div>
</div>

<div class="container row middle">
    <div class="col-lg-3"></div>
    <div class="col-lg-9">
        <h1 style="font-family: 微软雅黑">我的信息</h1>
    </div>
    <div class="col-lg-4">


    </div>

    <div class="col-lg-2" style="text-align: right">
        <h2 style="font-family: 微软雅黑">用户名</h2>
        <h2 style="font-family: 微软雅黑">昵称</h2>
        <h2 style="font-family: 微软雅黑">性别</h2>
        <h2 style="font-family: 微软雅黑">总微博数</h2>

    </div>
    <div class="col-lg-4">

        <!--<s:property value="user.getAvatar()"/>-->

        <h2 style="font-family: 微软雅黑"><s:property value="user.getUsername()"/></h2>
        <h2 style="font-family: 微软雅黑"><s:property value="user.getNickname()"/></h2>
        <h2 style="font-family: 微软雅黑"><s:property value="user.getGender()"/></h2>
        <h2 style="font-family: 微软雅黑"><s:property value="weiboAmount"/></h2>
        <h2 style="font-family: 微软雅黑"><a href="<s:url action='follow'/>">我的关注</a></p>

    </div>
</div>

<div class="container btt" id="btt">
    <p class="pull-right"><a href="#" style="font-size: 30px"><span class="glyphicon glyphicon-chevron-up" aria-hidden="true"></span></a></p>
</div>

<div class="footer">
    <div class="container">
        <p class="footer-class">Copyright &copy; 2016.UP All rights reserved.</p>
    </div>
</div>

<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>