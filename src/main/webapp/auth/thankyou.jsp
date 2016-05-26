<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="">

    <title>UP！！！Shakalaka~~~</title>


    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/register.css" rel="stylesheet">

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
    </div>
</div>

<div class="container middle">
    <s:form action="avatar" method="POST" enctype="multipart/form-data" class="form-register">
        <div class="row">
            <h2 class="form-register-heading">你好，<s:property value="username" />！</h2>
            <h3 class="form-register-heading">欢迎加入UP</h3>

            <div class="progress">
                <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 33%;">

                </div>
                <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 33%;">
                    选择头像
                </div>
                <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 34%;">

                </div>
            </div>

            <div style="text-align: center">
                <p>请自行将图片裁剪为分辨率</br>不小于200*200的正方形</p>
                <div class="fileinput fileinput-new row" data-provides="fileinput" style="text-align: center">
                    <div class="col-lg-7">
                        <div class="fileinput-preview thumbnail" data-trigger="fileinput" style="width: 150px; height: 150px;"></div>
                    </div>
                    <div class="col-lg-5">
                        <div class="fileinput-preview thumbnail" data-trigger="fileinput" style="width: 80px; height: 80px;"></div>
                    </div>
                    <div class="clearfix"></div>
                    <div>
                        <span class="btn btn-default btn-file"><span class="fileinput-new">选择图片</span><span class="fileinput-exists">更换图片</span><s:file name="upload" label="Upload your avatar" /></span>
                        <a href="#" class="btn btn-default fileinput-exists" data-dismiss="fileinput">移除图片</a>
                    </div>
                </div>
            </div>

            <s:submit class="btn btn-lg btn-primary btn-block" value="上传图片"/>
            <s:hidden name="%{#attr._csrf.parameterName}" value="%{#attr._csrf.token}" />

        </div>

        <div class="fileinput fileinput-new" data-provides="fileinput">


        </div>

    </s:form>
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

<script src="../js/jasny-bootstrap.min.js"></script>
<script src="../js/docs.min.js"></script>

<script src="../js/holder.min.js"></script>

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
