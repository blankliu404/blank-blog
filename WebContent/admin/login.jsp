<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!--
	@author 刘飞 陈新
	@createTime 2019-07-09 16:01 
-->
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<!--Head--><head>
    <meta charset="utf-8">
    <title>空白博客后台登录</title>
    <meta name="description" content="login page">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!--Basic Styles-->
    <link href="./static/style/bootstrap.css" rel="stylesheet">
    <link href="./static/style/font-awesome.css" rel="stylesheet">
    <!--Beyond styles-->
    <link id="beyond-link" href="./static/style/beyond.css" rel="stylesheet">
    <link href="./static/style/demo.css" rel="stylesheet">
    <link href="./static/style/animate.css" rel="stylesheet">
    <!--网站图标 起-->
    <link rel="shortcut icon" href="./favicon.ico" />
    <link rel="bookmark" href="./favicon.ico" />
    <!--网站图标 止-->
</head>
<!--Head Ends-->
<!--Body-->

<body>
    <div class="login-container animated fadeInDown" style="margin-top: 10rem;">
    	<div style="text-align: center;">
    		<img src="/blog/index/static/index/image/logo.png" style="margin: 0 auto;">
    	</div>
        <form action="/blog/admin/login" method="post">
            <div class="loginbox bg-white">
                <div class="loginbox-title" style="color:#00A8FF">LOG IN</div>
                <div class="loginbox-textbox">
                    <input value="admin" class="form-control" placeholder="username" name="admin" type="text">
                </div>
                <div class="loginbox-textbox">
                    <input class="form-control" placeholder="password" name="password" type="password">
                </div>
                <div class="loginbox-submit">
                    <input class="btn btn-primary btn-block" value="Login" type="submit">
                </div>
            </div>
        </form>
    </div>
    <!--Basic Scripts-->
    <script src="./static/style/jquery.js"></script>
    <script src="./static/style/bootstrap.js"></script>
    <script src="./static/style/jquery_002.js"></script>
    <!--Beyond Scripts-->
    <script src="./static/style/beyond.js"></script>




</body><!--Body Ends--></html>