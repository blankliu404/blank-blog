<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
    @author 刘飞 陈新
    @createTime 2019-07-09 15:26
-->
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>空白博客-关于我</title>
    <!--自定义静态资源 起-->
    <link rel="stylesheet" type="text/css" href="./static/index/css/main.css">
    <!--自定义静态资源 止-->
    <!--bootstrap4 cdn资源 起-->
    <!-- 新 Bootstrap4 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <!--bootstrap4 cdn资源 止-->
    <!--网站图标 起-->
    <link rel="shortcut icon" href="./favicon.ico" />
    <link rel="bookmark" href="./favicon.ico" />
    <!--网站图标 止-->
    <!--font-awesome-4.7.0-->
    <link rel="stylesheet" type="text/css" href="./static/font-awesome-4.7.0/css/font-awesome.min.css">
</head>

<body>
	<jsp:include page="public/nav.jsp"></jsp:include>
	<div class="container-fluid w-75 mt-3">
        <!--内容部分 起-->
		<div id="authors" class="carousel slide w-50 float-left" data-ride="carousel">
			  <ol class="carousel-indicators">
			    <li data-target="#authors" data-slide-to="0" class="active"></li>
			    <li data-target="#authors" data-slide-to="1"></li>
			    <li data-target="#authors" data-slide-to="2"></li>
			    <li data-target="#authors" data-slide-to="3"></li>
			  </ol>
			  <div class="carousel-inner">
			    <div class="carousel-item active">
			      	<img class="d-block w-100" height="550" src="./static/index/image/author1.jpg" alt="First slide">
			    	<div class="carousel-caption d-none d-md-block">
        				<h4>刘飞</h4>
        				<p>码农一号</p>
      				</div>
			    </div>
			    <div class="carousel-item">
			      	<img class="d-block w-100" height="550" src="./static/index/image/author2.png" alt="Second slide">
			    	<div class="carousel-caption d-none d-md-block">
        				<h4>陈新</h4>
        				<p>码农二号</p>
      				</div>
			    </div>
			    <div class="carousel-item">
			      	<img class="d-block w-100" height="550" src="./static/index/image/author3.png" alt="Third slide">
			    	<div class="carousel-caption d-none d-md-block">
        				<h4>宁昭义</h4>
        				<p>PS大神一号</p>
      				</div>
			    </div>
			    <div class="carousel-item">
			      	<img class="d-block w-100" height="550" src="./static/index/image/author4.png" alt="Fourth slide">
			    	<div class="carousel-caption d-none d-md-block">
        				<h4>田兴宇</h4>
        				<p>PS大神二号</p>
      				</div>
			    </div>
			  </div>
			  <a class="carousel-control-prev" href="#authors" role="button" data-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="sr-only">上一个</span>
			  </a>
			  <a class="carousel-control-next" href="#authors" role="button" data-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="sr-only">下一个</span>
			  </a>
		</div>
		<img class="w-50 float-left" height="550" src="./static/index/image/introduction.png"/>
        <!--内容部分 止-->
    </div>
    
	<jsp:include page="public/footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="./static/index/js/main.js"></script>

</html>