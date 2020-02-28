<%@ page language="java" import="method.Time" contentType="text/html; charset=UTF-8"
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
                                        <li class="active">文章管理</li>
                                        </ul>
                </div>
                <!-- /Page Breadcrumb -->

                <!-- Page Body -->
                <div class="page-body">
                    
<button type="button" class="btn btn-sm btn-azure btn-addon" onClick="javascript:window.location.href = '/blog/admin/index/article/add'"> <i class="fa fa-plus"></i> Add
</button>
<div class="row">
    <div class="col-lg-12 col-sm-12 col-xs-12">
        <div class="widget">
            <div class="widget-body">
                <div class="flip-scroll">
                      	<table class="table table-bordered table-hover">
                            <thead class="">
                                <tr>
                                    <th class="text-center" width="10%">ID</th>
                                    <th class="text-center">文章名称</th>
                                    <th class="text-center" width="10%">是否原创</th>
                                    <th class="text-center" width="10%">发布时间</th>
                                    <th class="text-center" width="20%">操作</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach items="${articleList }" var="al">
                                    <tr>
                                        <td align="center" style="vertical-align: middle;">${al.aid}</td>
                                        <td align="center" style="vertical-align: middle;">${al.title}</td>
                                        <td align="center" style="vertical-align: middle;">
                                        <c:choose>
                                        	<c:when test="${al.origin eq false}">否</c:when>
                                        	<c:otherwise>是</c:otherwise>
                                        </c:choose>
                                        </td>
                                        <td align="center" style="vertical-align: middle;">${Time.timeShift(al.createTime)}</td>
                                        <td align="center" style="vertical-align: middle;">
                                            <a href="/blog/admin/index/article/edit?aid=${al.aid}" class="btn btn-primary btn-sm shiny">
                                                <i class="fa fa-edit"></i> 编辑
                                            </a>
                                            <a href="#" onClick="warning('确实要删除${al.title}吗', '/blog/admin/index/article/delete?aid=${al.aid}')" class="btn btn-danger btn-sm shiny">
                                                <i class="fa fa-trash-o"></i> 删除
                                            </a>
                                        </td>
                                    </tr>
								</c:forEach>
                            </tbody>
                        </table>
                        <!-- 页数大于一才有分页 -->
                        <c:if test="${pageCount>1 }">
                        	
	                       	<div class="pagination" style="margin-top: 2rem;">
	                       		<li class="page-item <c:if test="${page <= 1}">disabled</c:if>"><a class="page-link" href="/blog/admin/index/article/list?page=1">首页</a></li>
	                       		<li class="page-item <c:if test="${page <= 1}">disabled</c:if>"><a class="page-link" href="/blog/admin/index/article/list?page=${page-1<1?1:page-1}">上一页</a></li>
	                       		<li class="page-item active"><span  class="page-link">${page}</span></li>        
	                       		<li class="page-item <c:if test="${page >= pageCount}">disabled</c:if>"><a class="page-link" href="/blog/admin/index/article/list?page=${page+1>pageCount?pageCount:page+1}">下一页</a></li>
	                       		<li class="page-item <c:if test="${page >= pageCount}">disabled</c:if>"><a class="page-link" href="/blog/admin/index/article/list?page=${pageCount}">尾页</a></li>
	                       	</div>
	                   </c:if>
                </div>
                <div style="padding-top:10px;">
         
                </div>
                <div>
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
    


</body></html>