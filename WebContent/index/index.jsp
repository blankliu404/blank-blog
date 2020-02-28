<%@ page language="java" import="method.Time,method.ClassificationMethod" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--
	@author 刘飞 陈新
	@createTime 2019-07-09 15:12
-->
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>空白博客-首页</title>
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
   	
    <!--网站内容 起-->
    <div class="container-fluid w-75 h-100">
        <!--内容左半部分 起-->
        <div class="container w-75 float-left mb-3">
            <div class="text-center">
                <h5 class="card-shadow bg-info card-title text-white mt-3 pt-2 pb-2 w-25" style="margin: 0 auto;border-radius: 2rem"><strong>Blogs</strong>&ensp;<span class="badge badge-pill badge-success">${total}</span></h5>
            </div>
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
            <!-- 页数大于一才有分页 -->
           	<c:if test="${pageCount>1 }">         	
               	<div class="pagination mt-2 pb-3 float-right" style="margin-top: 2rem;">
               		<li class="page-item <c:if test="${page <= 1}">disabled</c:if>"><a class="page-link" href="/blog/index/index?page=1">首页</a></li>
               		<li class="page-item <c:if test="${page <= 1}">disabled</c:if>"><a class="page-link" href="/blog/index/index?page=${page-1<1?1:page-1}">上一页</a></li>
               		<li class="page-item active"><span  class="page-link">${page}</span></li>        
               		<li class="page-item <c:if test="${page >= pageCount}">disabled</c:if>"><a class="page-link" href="/blog/index/index?page=${page+1>pageCount?pageCount:page+1}">下一页</a></li>
               		<li class="page-item <c:if test="${page >= pageCount}">disabled</c:if>"><a class="page-link" href="/blog/index/index?page=${pageCount}">尾页</a></li>
               	</div>
           	</c:if>
        </div>
        <!--内容左半部分 止-->
        <!--内容右半部分 起-->
        <div class="container w-25 float-right">
            <!--分类 起-->
            <div class="card card-shadow mt-3">
                <div class="card-body">
                    <h5 class="card-title float-left"><i class="fa fa-tasks fa-fw" aria-hidden="true"></i>分类</h5>
                    <h5 class="card-title float-right" onclick="location.href='/blog/index/classification'" style="cursor: pointer;"><i class="fa fa-chevron-circle-right" aria-hidden="true"></i></h5>
                    <br>
                    <hr class="bg-success">
                    <c:forEach items="${classAndCountList }" var="cacl">
	                    <h6 onclick="location.href='/blog/index/classification?cid=${cacl.cid}'" class="card-title float-left" style="cursor: pointer;">${ClassificationMethod.cidTocname(cacl.cid) }</h6>
	                    <h6 onclick="location.href='/blog/index/classification?cid=${cacl.cid}'" class="card-title float-right" style="cursor: pointer;"><span class="badge badge-pill badge-primary">${cacl.cnameCount}</span></h6>
	                    <br>
	                    <hr class="bg-success">
                 	</c:forEach>
                </div>
            </div>
            <!--分类 止-->
            <!--关键词 起-->
            <div class="card card-shadow mt-3">
                <div class="card-body">
                    <h5 class="card-title float-left"><i class="fa fa-key fa-fw" aria-hidden="true"></i>关键词</h5>
                    <h5 class="card-title float-right" onclick="location.href='/blog/index/popular'" style="cursor: pointer;"><i class="fa fa-chevron-circle-right" aria-hidden="true"></i></h5>
                    <br>
                    <hr class="bg-success">
                    <c:forEach items="${keywordAndCountList}" var="kcl">
                    	<%  
                    		int random = (int)((Math.random())*8);//产生一个随机数 0-7 整数
                    		request.setAttribute("random", random);
                    	%>		
	                    <c:choose>
	                    	<c:when test="${random eq 0}">
	                    		<a href="/blog/index/popular?keyword=${kcl.keyword}" class="badge badge-info">${kcl.keyword}&ensp;<span class="badge badge-pill badge-warning">${kcl.keywordCount}</span></a>
	                    	</c:when>
	                    	<c:when test="${random eq 1}">
	                    		<a href="/blog/index/popular?keyword=${kcl.keyword}" class="badge badge-secondary">${kcl.keyword}&ensp;<span class="badge badge-pill badge-success">${kcl.keywordCount}</span></a>
	                    	</c:when>
	                    	<c:when test="${random eq 2}">
	                    		<a href="/blog/index/popular?keyword=${kcl.keyword}" class="badge badge-dark">${kcl.keyword}&ensp;<span class="badge badge-pill badge-info">${kcl.keywordCount}</span></a>
	                    	</c:when>
	                    	<c:when test="${random eq 3}">
	                    		<a href="/blog/index/popular?keyword=${kcl.keyword}" class="badge badge-danger">${kcl.keyword}&ensp;<span class="badge badge-pill badge-dark">${kcl.keywordCount}</span></a>
	                    	</c:when>
	                    	<c:when test="${random eq 4}">
	                    		<a href="/blog/index/popular?keyword=${kcl.keyword}" class="badge badge-pill badge-dark">${kcl.keyword}&ensp;<span class="badge badge-primary">${kcl.keywordCount}</span></a>
	                    	</c:when>
	                    	<c:when test="${random eq 5}">
	                    		<a href="/blog/index/popular?keyword=${kcl.keyword}" class="badge badge-secondary">${kcl.keyword}&ensp;<span class="badge badge-pill badge-primary">${kcl.keywordCount}</span></a>
	                    	</c:when>
	                    	<c:when test="${random eq 6}">
	                    		<a href="/blog/index/popular?keyword=${kcl.keyword}" class="badge badge-success">${kcl.keyword}&ensp;<span class="badge badge-pill badge-info">${kcl.keywordCount}</span></a>
	                    	</c:when>
	                    	<c:otherwise>
	                    		<a href="/blog/index/popular?keyword=${kcl.keyword}" class="badge badge-warning">${kcl.keyword}&ensp;<span class="badge badge-pill badge-primary">${kcl.keywordCount}</span></a>
	                    	</c:otherwise> 
	                    </c:choose>
                    </c:forEach>
                </div>
            </div>
            <!--关键词 止-->
            <!--阅读排行榜 起-->
            <div class="card card-shadow mt-3">
                <div class="card-body">
                    <h5 class="card-title float-left"><i class="fa fa-sort-amount-desc fa-fw" aria-hidden="true"></i>阅读排行榜</h5>
                    <br>
                    <hr class="bg-success">
                    <c:forEach items="${articleClickList}" var="acl" varStatus="a">
                    <h6 onclick="location.href='/blog/index/show?aid=${acl.aid}'" class="card-title text-danger" style="cursor:pointer;">${a.count}、&nbsp;${acl.title}</h6>
                    <hr class="bg-success">
                    </c:forEach>
                    
                </div>
            </div>
            <!--阅读排行榜 止-->
            <!--友情链接 起-->
            <div class="card card-shadow mt-3">
                <div class="card-body">
                    <h5 class="card-title float-left"><i class="fa fa-link fa-fw" aria-hidden="true"></i>友情链接</h5>
                    <br>
                    <hr class="bg-success">
                    <c:forEach items="${linkList }" var="ll">
                    <a href="${ll.link}" target="_blank">${ll.lname}</a>
                    <br>
                    <hr class="bg-success">
                    </c:forEach>
                </div>
            </div>
            <!--友情链接 止-->
        </div>
        <!--内容右半部分 止-->
    </div>
    <!--网站内容 止-->
    
	<jsp:include page="public/footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="./static/index/js/main.js"></script>
</html>