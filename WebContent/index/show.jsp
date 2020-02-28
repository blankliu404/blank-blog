<%@ page language="java" import="method.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--
	@author 刘飞 陈新
	@createTime 2019-07-11 12:36
-->
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>空白博客-文章详情页</title>
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
   	<!--面包屑导航 起-->

	<nav aria-label="breadcrumb">
	  	<ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="javascript:self.location=document.referrer;">上一页</a></li>
		    <li class="breadcrumb-item active" aria-current="page">${ClassificationMethod.cidTocname(article.cid)}</li>
	  	</ol>
	</nav>
	<!--面包屑导航 止-->
    <!--网站内容 起-->
    <div class="container-fluid w-75 h-100 mt-3">
    	<!--文章内容部分 起-->
		<div class="container w-75 float-left pt-3">
			<div class="rounded card-shadow article_bg p-3">
				<h2 class="card-title float-left"><strong>${article.title}</strong></h2>&emsp;
				<c:choose>
					<c:when test="${article.origin eq true }">
					<span class="badge badge-pill badge-success">原创</span>
					</c:when>
					<c:otherwise>
					<span class="badge badge-pill badge-white">转载</span>
					</c:otherwise>
				</c:choose>
				<br><hr class="bg-white">
	            <h6 class="card-subtitle mb-2">
	                <i class="fa fa-calendar fa-fw" aria-hidden="true"></i>${Time.timeShift(article.createTime)}&ensp;
	                <i class="fa fa-eye fa-fw" aria-hidden="true"></i>${article.click}
	            </h6>
	            <hr class="bg-white">
	            <div class="card-body">${article.content}</div>
            </div>
    		<!-- 评论区 -->
            <div id="review-area" class="card bg-white card-shadow mt-3 mb-2">
    			<h5 class="card-title p-3 mb-0">评论</h5>
    			<hr class="bg-success">
    			<c:choose>
    				<c:when test="${reviewList.size() eq 0}">
    					<div class="alert alert-waring" >暂无评论&emsp;<a name="review" href="#rcontent">评论一个</a></div>
    				</c:when>
    				<c:otherwise>
	    				<c:forEach items="${reviewList}" var="rl">
	    					<c:if test="${rl.torid eq 0 }">
				    			<!-- 评论模板 -->
				    			<div class="card-body">
				    				<c:choose>
				    					<c:when test="${rl.rsex eq '男'}">
					    					<img height="50px" src="./static/index/image/man.jpg" alt="man.jpg" class="float-left mr-3">
					    				</c:when>
					    				<c:otherwise>
					    				<img height="50px" src="./static/index/image/woman.jpg" alt="man.jpg" class="float-left mr-3">
				    					</c:otherwise>
				    				</c:choose>
				    				<div class="pl-5">
										<h6><strong>${rl.rname}</strong><small>&emsp;${Time.timeShift(rl.rtime)}</small></h6>
										<div class="card-text">
											${rl.rcontent}&emsp;<a name="reply" href="#rcontent" data-rid="${rl.rid}" data-rname="${rl.rname}">回复</a>
										</div>
										<% pageContext.setAttribute("request", request);%>
										
										${ReviewMethod.setLowListReview(request,rl.rid)}
										<c:if test="${lowReviewList.size()>0}">
										<div class="card bg-light mt-3">
											<c:forEach items="${lowReviewList}" var="lrl">
												<!-- 评论模板 -->
												<div class="card-body">
								    				<c:choose>
								    					<c:when test="${lrl.rsex eq '男'}">
									    					<img height="50px" src="./static/index/image/man.jpg" alt="man.jpg" class="float-left mr-3">
									    				</c:when>
									    				<c:otherwise>
									    					<img height="50px" src="./static/index/image/woman.jpg" alt="man.jpg" class="float-left mr-3">
								    					</c:otherwise>
								    				</c:choose>
								    				<div class="pl-5">
														<h6><strong>${lrl.rname}&emsp;@${lrl.torname}</strong><small>&emsp;${Time.timeShift(lrl.rtime)}</small></h6>
														<div class="card-text">
															${lrl.rcontent}&emsp;<a name="reply" href="#rcontent" data-rid="${rl.rid}" data-rname="${lrl.rname}">回复</a>
														</div>
													</div>
												</div>	
											</c:forEach>
										</div>
										</c:if>
									</div>
									
				    			</div>
				    			<hr class="bg-success">	   
				    		</c:if> 			
		    			</c:forEach>
		    		</c:otherwise>
	    		</c:choose>
    		</div>
    		<!-- 评论框 -->
    		<div id="review-card" class="card bg-white card-shadow mb-5">
    			<textarea id="rcontent" class="form-control" placeholder="请输入评论内容" name="rcontent" style="resize: none;"></textarea>
    			<div class="row" >
    				<input type="text" name="rname" class="form-control col-3 ml-3 mt-1" placeholder="请输入昵称">
    				<input type="text" name="remail" class="form-control col-3 ml-1 mt-1" placeholder="请输入邮箱">
    				<input type="text" name="rsex" class="form-control col-2 ml-1 mt-1" placeholder="请输入性别">
    				<button id="review" class="btn btn-success ml-2 w-25 mt-1">评论</button>
    			</div>
    			
    		</div>
    		<!-- 评论框 -->
    		<!-- 评论区 -->     
		</div>
		<!--文章内容部分 止-->
		<div class="container w-25 float-left">
		
			<!--相关推荐 起-->
	            <div class="card card-shadow mt-3">
	                <div class="card-body">
	                    <h5 class="card-title float-left"><i class="fa fa-bar-chart fa-fw" aria-hidden="true"></i>相关推荐</h5>
	                    <br>
	                    <hr class="bg-success">
	                    <c:choose>
	                    	<c:when test="${recommendedList.size()<=1}">
		                    	<h6 class="card-title text-danger" style="cursor:pointer;">暂无推荐</h6>
			                    <hr class="bg-success">
	                    	</c:when>
	                    	<c:otherwise>
			                    <c:forEach items="${recommendedList}" var="rl">
				                    <c:if test="${rl.aid != aid}">
					                    <h6 onclick="location.href='/blog/index/show?aid=${rl.aid}'" class="card-title text-danger" style="cursor:pointer;">${rl.title}</h6>
					                    <hr class="bg-success">
				            		</c:if>
			               		</c:forEach>
		               		</c:otherwise>
	                    </c:choose>
	                </div>
	            </div>
	            <!--相关推荐 止-->
		</div>
    </div>
    <!--网站内容 止-->
    
    
	<jsp:include page="public/footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="./static/index/js/main.js"></script>
<script type="text/javascript">
	//rname rcontent rsex remail torid aid torname
	var Review = new Object();

	$("a[name='reply']").click(function(){
		Review.torid = $(this).attr("data-rid");
		Review.torname = $(this).attr("data-rname")

		$("#rcontent").attr("placeholder",'@'+Review.torname)
		$("#rcontent").focus()
	})

	$('#review').click(function(){
		//获取
		Review.aid = ${aid}

		Review.rcontent = $("textarea[name='rcontent']").val()
		Review.rname = $("input[name='rname']").val()
		Review.remail = $("input[name='remail']").val()
		Review.rsex = $("input[name='rsex']").val()
		//验证
		if (Review.rcontent == '') {
			alert('请输入评论内容') 
			return false
		}
		if (Review.rname == '') {
			alert('请输入你的昵称')
			 return false
		}
		if (!/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(Review.remail) ||Review.remail == '') {
			alert('请正确输入邮箱') 
			return false
		}
		if (Review.rsex != '男' && Review.rsex != '女') {
			alert('请正确输入性别') 
			return false
		}

		$.post("/blog/index/show", Review, function(data){
			alert("评论成功！")
			$("textarea[name='rcontent']").val('')
			$("input[name='rname']").val('')
			$("input[name='remail']").val('')
			$("input[name='rsex']").val('')		//全部置空  解决缓存评论滞留问题
			location.reload();
		})

	})
</script>
</html>