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

    <title>我的关注</title>


    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/signin.css" rel="stylesheet">

    <link href="../css/style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

<body>
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

<div class="container row middle">
    <div class="col-lg-1"></div>
    <s:form action="addfollow" class="form-signin col-lg-4">
    <p>一时找不到想取消关注谁？<a href="<s:url action='cancelfollow'/>">搜索并取消关注</a></p>
        <h2 class="form-signin-heading">我的关注</h2>

        <label for="inputEmail" class="sr-only">Email address</label>
        <s:textfield name="username" id="inputEmail" class="form-control" placeholder="想关注谁嘞" /><s:property value="message"/>

        <s:submit value="点击添加关注" class="btn btn-lg btn-primary btn-block" />
        <sec:csrfInput />

        
    </s:form>
    <div class="col-lg-7 row">
        <h3 class="col-lg-2 follow">关注数</h3>
        <h3 class="col-lg-4 follow"><s:property value="follownums"/></h3>
        <h3 class="col-lg-2 follow">粉丝数</h3>
        <h3 class="col-lg-4 follow"><s:property value="myfansnums"/></h3>
        <div class="clearfix"></div>
        <!--<s:property value="followname"/>-->
        <h3 class="col-lg-12 followed">已关注</h3>
        <div class="clearfix"></div>
        <!--<div class="col-lg-2"></div>-->
        <!--<div class="col-lg-2"><h4 class="followed">杨杰慧</h4></div>-->
        <!--<div class="col-lg-6"><a class="btn btn-primary">取消关注</a></div>-->
        <s:iterator value="follownames" id='allnames'>
            <p><s:property value='allnames'/></p><button >取消关注</button><br/>
        </s:iterator>
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
