<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="">

    <title>取消关注</title>


    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/signin.css" rel="stylesheet">

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
            <a class="" href="<s:url action='index'/>"><img src="../images/logo.png"/></a>
        </div>
        <div class="navbar-right">
            <ul class="nav navbar-nav">
                <li><a data-toggle="modal" data-target="" >登出</a></li>
            </ul>
        </div>
    </div>
</div>

<div class="container middle">

    <s:form action="deletefollow" class="form-signin">
        <h2 class="form-signin-heading">搜索并取消关注</h2>

        <label for="inputname" class="sr-only">name</label>
        
        <s:textfield name="username" id="inputname" class="form-control" placeholder="请输入用户名" /><s:property value="message"/>
        <s:submit value="取消关注"  class="btn btn-lg btn-primary btn-block"/>
        <sec:csrfInput />
    </s:form>
    <s:property value="followname"/>
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
