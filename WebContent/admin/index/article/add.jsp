<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--
	@author 刘飞 陈新
	@createTime 2019-07-10 11:20
-->
<!DOCTYPE html>
<html><head>
	    <meta charset="utf-8">
    <title>空白博客后台-文章管理</title>

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
    <link rel="shortcut icon" href="../favicon.ico" />
    <link rel="bookmark" href="../favicon.ico" />
    <!--网站图标 止-->
</head>
<body>
	<!-- 头部 -->
	<jsp:include page="../public/top.jsp"></jsp:include>
	<!-- /头部 -->
	
	<div class="main-container container-fluid">
		<div class="page-container">
			<!-- Page Sidebar -->
            <jsp:include page="../public/left.jsp"></jsp:include>
            <!-- /Page Sidebar -->
            <!-- Page Content -->
            <div class="page-content">
                <!-- Page Breadcrumb -->
                <div class="page-breadcrumbs">
                    <ul class="breadcrumb">
                                        <li>
                        <a href="/blog/admin/index">系统</a>
                    </li>
                                        <li>
                        <a href="/blog/admin/index/article/list">文章管理</a>
                    </li>
                                        <li class="active">添加文章</li>
                                        </ul>
                </div>
                <!-- /Page Breadcrumb -->

                <!-- Page Body -->
                <div class="page-body">
                    
<div class="row">
    <div class="col-lg-12 col-sm-12 col-xs-12">
        <div class="widget">
            <div class="widget-header bordered-bottom bordered-blue">
                <span class="widget-caption">新增文章</span>
            </div>
            <div class="widget-body">
                <div id="horizontal-form">
                    <form class="form-horizontal" role="form" action="/blog/admin/index/article/add" method="post">
                        <div class="form-group">
                            <label for="title" class="col-sm-2 control-label no-padding-right">文章标题</label>
                            <div class="col-sm-6">
                                <input class="form-control"  placeholder="请输入文章标题" name="title"  required="required" type="text">
                            </div>
                            <p class="help-block col-sm-4 red">* 必填</p>
                        </div>
                        <div class="form-group">
                            <label for="keyword" class="col-sm-2 control-label no-padding-right">关键词</label>
                            <div class="col-sm-6">
                                <input class="form-control"  placeholder="请填入关键词" name="keyword" type="text" required="required">
                            </div>
                            <p class="help-block col-sm-4 red">* 必填</p>
                        </div>

                        <div class="form-group">
                            <label for="breviary" class="col-sm-2 control-label no-padding-right">摘要</label>
                            <div class="col-sm-6">
                                <textarea name="breviary" class="form-control" required="required" style="resize: none"></textarea>
                            </div>
                            <p class="help-block col-sm-4 red">* 必填</p>
                        </div>
                        <div class="form-group">
                            <label for="origin" class="col-sm-2 control-label no-padding-right">是否原创</label>
                            <div class="col-xs-4">
                                <label>
                                    <input class="checkbox-slider colored-blue" type="checkbox" name="origin">
                                    <span class="text"></span>
                                </label>
                            </div>
                            <p class="help-block col-sm-4 red">* 必填</p>
                        </div>

                        <div class="form-group">
                            <label for="classification" class="col-sm-2 control-label no-padding-right">所属分类</label>
                            <div class="col-sm-6">
                                <select name="classification" required="required"> 
                                    <c:forEach items="${classificationList}" var="cl">
                                    <option value="${cl.cid }">${cl.cname }</option>
  									</c:forEach>
                                </select>
                            </div>
                            <p class="help-block col-sm-4 red">* 必填</p>
                        </div>
                        <div class="form-group">
                            <label for="content"  class="col-sm-2 control-label no-padding-right">内容</label>
                            <div class="col-sm-6">
                                <textarea id="container" name="content" required="required"></textarea>
                            </div>
                            <p class="help-block col-sm-4 red">* 必填</p>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">发布文章</button>
                            </div>
                        </div>
                </div>
            </div>
        </div>
    </div>
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

	<!-- 配置文件 -->
    <script type="text/javascript" src="/blog/utf8-jsp/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="/blog/utf8-jsp/ueditor.all.js"></script>
    <!-- 实例化编辑器 -->
    <script type="text/javascript">
        var ue = UE.getEditor('container',{
            initialFrameHeight:500
        });
    </script>
</body></html>