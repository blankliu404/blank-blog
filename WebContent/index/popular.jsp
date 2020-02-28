<%@ page language="java" import="method.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--
    @author 刘飞 陈新
    @createTime 2019-07-09 15:15
-->
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>空白博客-热门</title>
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
        <!--内容部分 起-->
    <div class="container w-75 mb-3">
        <!--所有热门 起-->
        <div class="card card-shadow mt-3">
            <div class="card-body">
                <h5 class="card-title float-left">热门</h5>
                <p class="text-dark float-right">共<font class="text-danger">${keywordAndCountList.size()}</font>个</p>
                <br>
                <hr class="text-info">
                <c:forEach items="${keywordAndCountList}" var="kacl">
                	<c:choose>
                		<c:when test="${kacl.keyword eq keyword }">
		                <!--热门模块 起-->
		                <div style="cursor: pointer;" onclick="location.href='/blog/index/popular?keyword=${kacl.keyword}'" class="card card-shadow mt-3 pl-2 pr-2 text-center border-success float-left mr-2">
		                    <div class="card-body">
		                        <h6 class="card-title mb-0 float-left mr-2">${kacl.keyword}</h6>
		                        <span class="badge badge-pill badge-success">${kacl.keywordCount}</span>
		                    </div>
		                </div>
		                <!--热门模块 止-->
		                </c:when>
		                <c:otherwise>
		                <!--热门模块 起-->
		                <div style="cursor: pointer;" onclick="location.href='/blog/index/popular?keyword=${kacl.keyword}'" class="card card-shadow mt-3 pl-2 pr-2 text-center border-info float-left mr-2">
		                    <div class="card-body">
		                        <h6 class="card-title mb-0 float-left mr-2">${kacl.keyword}</h6>
		                        <span class="badge badge-pill badge-info">${kacl.keywordCount}</span>
		                    </div>
		                </div>
		                <!--热门模块 止-->
		                </c:otherwise>
	                </c:choose>
                </c:forEach>
            </div>
        </div>
        <!--所有热门 止-->
        <c:forEach items="${articleList }" var="al" varStatus="status">
            	<c:choose>
            		<c:when test="${status.count%2!=0}">
		            <!--文章展示模板 起-->
		            <div class="card card-shadow mt-3 bg-secondary">
		                <div class="card-body text-white">
		                    <h5 class="card-title">${al.title }</h5>
		                    <hr class="bg-white">
		                    <h6 class="card-subtitle mb-2">
		                        <i class="fa fa-calendar fa-fw" aria-hidden="true"></i>${Time.timeShift(al.createTime) }&ensp;
		                        <i class="fa fa-eye fa-fw" aria-hidden="true"></i>${al.click }
		                    </h6>
		                    <hr class="bg-white">
		                    <p class="card-text">${al.breviary }</p>
		                    <button onclick="location.href='/blog/index/show?aid=${al.aid}'" type="button" class="btn btn-outline-light float-right">
		                        去看看&ensp;<i class="fa fa-hand-o-right" aria-hidden="true"></i>
		                    </button>
		                </div>
		            </div>
		            <!--文章展示模板 止-->
		       		</c:when>
		       		<c:otherwise>
		            <!--文章展示模板 起-->
		            <div class="card card-shadow mt-3">
		                <div class="card-body">
		                    <h5 class="card-title">${al.title }</h5>
		                    <hr class="bg-success">
		                    <h6 class="card-subtitle mb-2 text-muted">
		                        <i class="fa fa-calendar fa-fw" aria-hidden="true"></i>${Time.timeShift(al.createTime) }&ensp;
		                        <i class="fa fa-eye fa-fw" aria-hidden="true"></i>${al.click }
		                    </h6>
		                    <hr class="bg-success">
		                    <p class="card-text">${al.breviary }</p>
		                    <button onclick="location.href='/blog/index/show?aid=${al.aid}'" type="button" class="btn btn-outline-primary float-right">
		                        去看看&ensp;<i class="fa fa-hand-o-right" aria-hidden="true"></i>
		                    </button>
		                </div>
		            </div>
		            <!--文章展示模板 止-->
		            </c:otherwise>
		        </c:choose>
		    </c:forEach>
            
           	<c:if test="${pageCount<=1}"><div class="pb-3"></div></c:if><!-- 调整格式 -->
           	<!-- 页数大于一才有分页 -->
           	<c:if test="${pageCount>1 }">         	
               	<div class="pagination mt-2 pb-5 float-right" style="margin-top: 2rem;">
               		<li class="page-item <c:if test="${page <= 1}">disabled</c:if>"><a class="page-link" href="/blog/index/popular?page=1&&keyword=${keyword}">首页</a></li>
               		<li class="page-item <c:if test="${page <= 1}">disabled</c:if>"><a class="page-link" href="/blog/index/popular?page=${page-1<1?1:page-1}&&keyword=${keyword}">上一页</a></li>
               		<li class="page-item active"><span  class="page-link">${page}</span></li>        
               		<li class="page-item <c:if test="${page >= pageCount}">disabled</c:if>"><a class="page-link" href="/blog/index/popular?page=${page+1>pageCount?pageCount:page+1}&&keyword=${keyword}">下一页</a></li>
               		<li class="page-item <c:if test="${page >= pageCount}">disabled</c:if>"><a class="page-link" href="/blog/index/popular?page=${pageCount}&&keyword=${keyword}">尾页</a></li>
               	</div>
           	</c:if>
    </div>
    <!--内容部分 止-->
    
	<jsp:include page="public/footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="./static/index/js/main.js"></script>
</html>