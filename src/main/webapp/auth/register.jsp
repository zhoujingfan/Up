<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

        <title>UP！！！Shakalaka~~~</title>


        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/signin.css" rel="stylesheet">
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
        <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
        <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">搜索</button>
        </form>
        <div class="navbar-right">
        <ul class="nav navbar-nav">
        <li><a data-toggle="modal" data-target="#register" >注册</a></li>
        <li><a data-toggle="modal" data-target="#signin" >登录</a></li>
        </ul>
        </div>
        </div>
        </div>

        <div class="container middle">
        <form class="form-register"  action="register">

        <script type="text/javascript">
        function showRegistera()
        {
        $("#registera").show();
        $("#registerb").hide();
        }
        function showRegisterb()
        {
        $("#registerb").show();
        $("#registera").hide();
        }
        </script>

        <h2 class="form-register-heading">注册</h2>

        <div id="registera" class="row" >
        <div class="progress">
        <div class="progress-bar " role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
        style="width: 50%;">
        验证邮箱
        </div>
        </div>

        <label for="inputEmail" class="sr-only">邮箱</label>
        <s:textfield type="email" id="inputEmail" name="email" class="form-control form-control-first"
                     placeholder="邮箱"/>

        <label for="inputPassword" class="sr-only">密码</label>
        <s:password name="password" id="inputPassword" class="form-control form-control-middle" placeholder="密码"/>
        
        <label for="inputConfirmPassword" class="sr-only">再次输入密码</label>
        <s:password name="confirmPassword" id="inputConfirmPassword" class="form-control form-control-middle"
                    placeholder="再次输入密码"/>
        
        <label for="inputname" class="sr-only">用户名</label>
        <s:textfield name="username" id="inputname" class="form-control form-control-middle" placeholder="用户名"/>
        
        <label for="inputPhonenumber" class="sr-only">手机</label>
        <s:textfield name="phone" id="inputPhonenumber" class="form-control form-control-last" placeholder="手机"/>
        
        <a class="btn btn-lg btn-primary btn-block" onclick="showRegisterb()">下一步</a>
        </div>

        <div id="registerb" class="row" style="display: none;">
        <div class="progress">
        <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
        style="width: 50%;">

        </div>
        <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
        style="width: 50%;">
        完善资料
        </div>
        </div>
        <label for="inputnickname" class="sr-only">昵称</label>
        <s:textfield name="nickname" id="inputnickname" class="form-control form-control-single" placeholder="昵称"/>
     
        <s:radio name="gender" list="genderList" label=""/>
        <sec:csrfInput/>

        <label for="inputsignature" class="sr-only">个性签名</label>
        <s:textfield name="signature" id="inputsignature" class="form-control form-control-first" placeholder="个性签名"/>
        
        <label for="inputaddress" class="sr-only">地址</label>
        <s:textfield name="address" id="inputaddress" class="form-control form-control-last" placeholder="地址"/>
        
        <div class="col-lg-6">
        <a class="col-lg-6 btn btn-lg btn-primary btn-block" onclick="showRegistera()">上一步</a>
        </div>
        <div class="col-lg-6">
        <s:submit value="注册" class="btn btn-lg btn-primary btn-block"/>
        </div>
        </div>
        </form>
        </div>

        <div class="container btt" id="btt">
        <p class="pull-right"><a href="#" style="font-size: 30px"><span class="glyphicon glyphicon-chevron-up"
        aria-hidden="true"></span></a></p>
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