<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="">

    <title>首页</title>


    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/signin.css" rel="stylesheet">

    <link href="../css/style.css" rel="stylesheet">
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="../js/html5shiv.min.js"></script>
    <script src="../js/respond.min.js"></script>
    <![endif]-->
</head>

<body onload="indexonload()">
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
                <li><a data-toggle="modal" data-target="" ><form action="logout" method="post">
                    <sec:csrfInput/>
                    <input type="submit" value="登出"/>
                </form></a></li>
            </ul>
        </div>
    </div>
</div>

<div class="container">

    <div class="row mainbody">

        <div class="col-lg-3 sidebar-offcanvas" id="sidebar">
            <div class="row" style="text-align: center">
                <a><img class="img-thumbnail img-thumbnail" src="../images/cjj.jpg"
                        alt="Generic placeholder image" width="150" height="150"></a>
                <h3><a><s:property value="username"/></a></h3>
                <a href="<s:url action='follow'/>" class="col-lg-4"><div><p>关注<br><s:property value="follownums"/></p></div></a>
                <a href="<s:url action='follow'/>" class="col-lg-4"><div><p>粉丝<br><s:property value="myfansnums"/></p></div></a>
                <a href="" class="col-lg-4"><div><p>微博<br>9999</p></div></a>

            </div>

            <div class="list-group">
                <a href="#" class="list-group-item active">UP热点</a>
                <a href="#" class="list-group-item">软院男足建院15年来首夺校长杯冠军</a>
                <a href="#" class="list-group-item">5号线北延至贝加尔湖聘请cjj总工程师</a>
                <a href="#" class="list-group-item">zjf接连一月炉石神抽</a>
                <a href="#" class="list-group-item">cx重出江湖誓做米其林中国第一人</a>
                <a href="#" class="list-group-item">北邮试点改革化学竞赛特长生可转专业zw称赶上了好时代</a>
                <a href="#" class="list-group-item">春天到了高冷男神zjj走出宿舍找到了女盆友</a>
                <a href="#" class="list-group-item">土豪hxy掷重金改建宏福操场以便停降私人飞机</a>
                <a href="#" class="list-group-item">sy老师课题组取得重大科研成果空降北邮最年轻教授</a>
                <a href="#" class="list-group-item">北邮软院教学改革新增软件的安装与卸载工程专业</a>
                <a href="#" class="list-group-item">UP日前完成对新浪微博的并购，因每日转账限额尾款将在三天内打至新浪支付宝账户</a>
            </div>
        </div><!--/.sidebar-offcanvas-->

        <div class="col-lg-7">
            <div class="up">
                <div>
                    <h3>欢迎陈家家家家家家家家家俊来给大家讲两句</h3>
                        <input id="textarea" style="width: 100%"/>
                        <div class="row">
                            <input class="col-lg-10" type="file" name="pic" accept="image/*">
                            <button class="col-lg-2" id="subbmit"  onclick="sub()">发布</button>
                        </div>
                </div>
            </div>

            <div class="up">                        <!--全套微博是这个-->
                <div class="row">
                    <div class="col-lg-2">
                        <a href=""><img class="img-thumbnail" src="../images/cjj.jpg" alt="Generic placeholder image" width="100" height="100"></a>
                    </div>
                    <div class="col-lg-10 row">
                        <div class="up_userid">
                            <a>陈家家家家家家家家家俊</a>
                        </div>
                        <div class="col-lg-1 up_time">
                            <a>20:61</a>
                        </div>
                        <div class="col-lg-11 up_source">
                            <p>来自 <a> 牛逼的不要不要的 vibe shot2</a></p>
                        </div>
                        <div class="clearfix"></div>
                        <div class="up_body">
                            <p>Bootstrap 利用 Autoprefixer 自动为 某些 CSS 属性添加针对特定厂商的前缀。如果你是从 Less/Sass 源码编译
                                Bootstrap的，并且没有使用Bootstrap 自带的 Gruntfile 文件，那你就必须将 Autoprefixer
                                集成到你的编译工具和编译过程中。如果你使用的是我们预先编译好的 Bootstrap文件或者使用的是我们提供的 Gruntfile
                                文件，那就无需操心了，我们已经将这些工作替你搞定了。</p>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div>

                </div>
                <div class="row">
                    <button type="button" class="btn btn-default btn-sm col-lg-3">收藏</button>
                    <button type="button" class="btn btn-default btn-sm col-lg-3">转发</button>
                    <button type="button" class="btn btn-default btn-sm col-lg-3" onclick="">评论</button>
                    <button type="button" class="btn btn-default btn-sm col-lg-3" data-bind='click: agreeClick, visible: agree'>点赞<span data-bind='text: numberOfClicks'>&nbsp;</span></button>
                    <button type="button" class="btn btn-default btn-sm col-lg-3" data-bind='click: disagreeClick, visible: disagree'>已赞<span data-bind='text: numberOfClicks'>&nbsp;</span></button>
                    <div class="clearfix"></div>
                </div>

                <div id="review" class="row reviews">
                    <div id="my_img" class="col-lg-2 reviews_img">
                        <a href=""><img id="my_image" src="../images/zjf.jpg" class="img-rounded" width="30px" height="30px"></a>
                    </div>
                    <div id="reviews" class="col-lg-10">
                        <form id="say_sth" class="row reviews_form">
                            <input id="a_review" class="col-lg-10" type="text">
                            <button id="submit_review" class="col-lg-2 btn btn-default btn-sm" type="submit">评论</button>
                            <!--<div class="clearfix"></div>-->
                        </form>

                        <hr/>

                        <div id="reviewsagain" class="row">
                            <div id="review_img" class="col-lg-1">
                                <a href=""><img id="review_image" src="../images/zjf.jpg" width="30px" height="30px" class="img-rounded"></a>
                            </div>
                            <div id="" class="col-lg-11">
                                <p><a>周竞帆帆帆帆帆帆帆帆</a>： 你说得对</p>
                                <div>
                                    <div class="reviews_time">
                                        <p>20:61</p>
                                    </div>
                                    <div class="row reviews_buttons">
                                        <button class="col-lg-6 btn btn-default btn-xs">回复</button>
                                        <button class="col-lg-6 btn btn-default btn-xs"><span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span></button>
                                    </div>
                                </div>
                            </div>
                        </div><!--这是全套评论-->

                        <hr/>

                        <div class="row">
                            <div class="col-lg-1">
                                <a href=""><img src="../cjj.jpg" width="30px" height="30px" class="img-rounded"></a>
                            </div>
                            <div class="col-lg-11">
                                <p><a>陈家家家家家家家家家俊</a>： 嗯啊</p>
                                <div>
                                    <div class="reviews_time">
                                        <p>20:61</p>
                                    </div>
                                    <div class="row reviews_buttons">
                                        <button class="col-lg-6 btn btn-default btn-xs">回复</button>
                                        <button class="col-lg-6 btn btn-default btn-xs"><span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span></button>
                                    </div>
                                </div>
                            </div>
                        </div><!--这是全套评论-->

                        <!--<div class="clearfix"></div>-->
                    </div>

                </div>
            </div>

        </div>

        <div class="col-lg-2">
            <div class="list-group">
                <a href="#" class="list-group-item">首页</a>
                <a href="<s:url action='myProfile'/>" class="list-group-item">我的信息</a>
                <a href="#" class="list-group-item">赞</a>
            </div>
            <div class="list-group">
                <a href="#" class="list-group-item">特别关注</a>
                <a href="#" class="list-group-item">同学</a>
                <a href="#" class="list-group-item">同事</a>
                <a href="#" class="list-group-item">家人</a>
                <a href="#" class="list-group-item">女神</a>
            </div>
        </div>

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

<script src="../js/knockout-3.4.0.js" type="text/javascript"></script>
<script src="../js/knockout-3.4.0.debug.js" type="text/javascript"></script>

<script src="../js/indexonload.js"></script>

</body>
<script>
function sub(){
    $alert("发布成功");
    var formdata = {content:$("input#textarea").val(),_csrf:$("[name='_csrf']").attr("value")};
    $.ajax({
        url: "/weibo/publish.action",
        data: {content:$("input#textarea").val(),_csrf:$("[name='_csrf']").attr("value")},
        method: "POST",
        success: function( result ) {
            alert("发布成功");
        }
    });
};
</script>
</html>
