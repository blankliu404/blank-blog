<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
    @author 刘飞 陈新
    @createTime 2019-07-09 15:15
-->
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>空白博客-反馈</title>
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
    <div class="alert alert-info text-center">如果您对空白博客有一些建议，那么请填写如下信息反馈给我们，我们或许会采纳您的建议，更好的完善空白博客，谢谢！</div>
    <div class="card float-left" style="width: 10rem;">
        <img class="card-img-top" src="./static/index/image/wechat.jpg" alt="Card image cap">
        <div class="card-body">
            <p class="card-text text-info" style="text-indent: 2em">您也可以通过扫码加微信联系到我们，如果您能给予我们一些支持，那将万分荣幸！</p>
        </div>
    </div>
    <form class="form-group w-75  offset-2" action="/blog/index/feedback" method="post">
    	<div class="text-center">
    		<input style="margin: 0 auto;" class="form-control w-75 mb-2" placeholder="请输入反馈标题" name="ftitle" required="required">
    	</div>
	    <div class="text-center">
	        
	        <textarea placeholder="请输入反馈内容" style="margin: 0 auto;resize: vertical;height: 500px;" class="form-control w-75 mb-2" name="fcontent" required="required"></textarea>
	    </div>
	    <div class="text-center pb-3">
	    	<input class="btn btn-info mt-2 w-25" type="reset" value="重置"> <input class="btn btn-info mt-2 w-25" type="submit" value="提交">
	    </div>
    </form>
    <!--内容部分 止-->
 	<jsp:include page="public/footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="./static/index/js/main.js"></script>
<!-- 配置文件 -->
<script type="text/javascript" src="/blog/utf8-jsp/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="/blog/utf8-jsp/ueditor.all.js"></script>
<!-- 实例化编辑器 -->
<script type="text/javascript">
    var ue = UE.getEditor('container',{
        initialFrameHeight:400
    });
</script>
</html>