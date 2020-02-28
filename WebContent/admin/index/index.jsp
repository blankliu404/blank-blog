<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--
	@author 刘飞 陈新
	@createTime 2019-07-09 16:10
-->
<!DOCTYPE html>
<html><head>
	    <meta charset="utf-8">
    <title>空白博客后台</title>

    <meta name="description" content="Dashboard">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!--Basic Styles-->
    <link href="/blog/admin/static/style/bootstrap.css" rel="stylesheet">
    <link href="/blog/admin/static/style/font-awesome.css" rel="stylesheet">
    <link href="/blog/admin/static/style/weather-icons.css" rel="stylesheet">

    <!--Beyond styles-->
    <link id="beyond-link" href="/blog/admin/static/style/beyond.css" rel="stylesheet" type="text/css">
    <link href="/blog/admin/static/style/demo.css" rel="stylesheet">
    <link href="/blog/admin/static/style/typicons.css" rel="stylesheet">
    <link href="/blog/admin/static/style/animate.css" rel="stylesheet">
    
    <!--网站图标 起-->
    <link rel="shortcut icon" href="./favicon.ico" />
    <link rel="bookmark" href="./favicon.ico" />
    <!--网站图标 止-->
</head>
<body>
	<jsp:include page="public/top.jsp"></jsp:include>
	
	<div class="main-container container-fluid">
		<div class="page-container">
			<!-- Page Sidebar -->
          <jsp:include page="public/left.jsp"></jsp:include>
            <!-- /Page Sidebar -->
            <!-- Page Content -->
            <div class="page-content">
                <!-- Page Breadcrumb -->
                <div class="page-breadcrumbs">
                    <ul class="breadcrumb">
                       	<li class="active">控制面板</li>
                    </ul>
                </div>
                <!-- /Page Breadcrumb -->
                     
					<div class="jumbotron">
					  <h1>空白博客提示</h1>
					  <p>啊哈！又有新收获！写篇博客纪念一下吧！</p>
					  <p><a class="btn btn-primary btn-lg" href="/blog/admin/index/article/add" role="button">现在就去！</a></p>
					</div>
                </div>
                <!-- /Page Body -->
            </div>
            <!-- /Page Content -->
		</div>	
	</div>

	    <!--Basic Scripts-->
    <script src="/blog/admin/static/style/jquery_002.js"></script>
    <script src="/blog/admin/static/style/bootstrap.js"></script>
    <script src="/blog/admin/static/style/jquery.js"></script>
    <!--Beyond Scripts-->
    <script src="/blog/admin/static/style/beyond.js"></script>
    


</body></html>