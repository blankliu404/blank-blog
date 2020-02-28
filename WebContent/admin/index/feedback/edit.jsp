<%@ page language="java" import="method.Time" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--
	@author 刘飞 陈新
	@createTime 2019-07-10 19:48
-->
<!DOCTYPE html>
<html><head>
        <meta charset="utf-8">
    <title>空白博客后台-反馈管理</title>

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
                        <a href="/blog/admin/index/feedback/list">反馈管理</a>
                    </li>
                                        <li class="active">编辑反馈</li>
                                        </ul>
                </div>
                <!-- /Page Breadcrumb -->

                <!-- Page Body -->
                <div class="page-body">
                    
<div class="row">
    <div class="col-lg-12 col-sm-12 col-xs-12">
        <div class="widget">
            <div class="widget-header bordered-bottom bordered-blue">
                <span class="widget-caption">编辑反馈</span>
            </div>
            <div class="widget-body">
                <div id="horizontal-form">
                  	 <form class="form-horizontal" role="form" action="/blog/admin/index/feedback/edit?fid=${feedback.fid }" method="post">
                        <div class="form-group">
                            <label for="title" class="col-sm-2 control-label no-padding-right">反馈名称</label>
                            <div class="col-sm-6">
                                <input class="form-control" value="${feedback.ftitle }" disabled="disabled" name="title"  required="required" type="text">
                            </div>
                            <p class="help-block col-sm-4 red">* 必填</p>
                        </div>
                        <div class="form-group">
                            <label for="ftime" class="col-sm-2 control-label no-padding-right">反馈时间</label>
                            <div class="col-sm-6">
                                <input class="form-control" value="${Time.timeShift(feedback.ftime) }" disabled="disabled" name="ftime"  required="required" type="text">
                            </div>
                            <p class="help-block col-sm-4 red">* 必填</p>
                        </div>   
                        <div class="form-group">
                            <label for="" class="col-sm-2 control-label no-padding-right">反馈内容</label>
                            <div class="col-sm-6">
                               <a href="javascript:void(0);" class="btn btn-blue shiny"
                                onclick="$('#feedbackModalLabel').html('${feedback.ftitle}');
                                        	$('#feedbackModalBody').html('${feedback.fcontent}');
                                    	$('#feedbackModal').modal();">点击查看</a>
                            </div>
                            <p class="help-block col-sm-4 red">* 必填</p>
                        </div>                      
                        <div class="form-group">
                            <label for="fsolve" class="col-sm-2 control-label no-padding-right">是否采纳此反馈</label>
                            <div class="col-xs-4">
                                <label>
                                    <input required="required" class="checkbox-slider colored-blue" type="checkbox" name="fsolve">
                                    <span class="text"></span>
                                </label>
                            </div>
                            <p class="help-block col-sm-4 red">* 必填</p>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">保存修改</button>
                            </div>
                        </div>
                    </form>
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

    <!--LArge Modal Templates-->
    <div id="feedbackModal" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="feedbackModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="feedbackModalLabel">Large modal</h4>
                </div>
                <div id="feedbackModalBody" class="modal-body">
                    ...
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div>
    <!--End Large Modal Templates-->

        <!--Basic Scripts-->
    <script src="/blog/admin/static/style/jquery_002.js"></script>
    <script src="/blog/admin/static/style/bootstrap.js"></script>
    <script src="/blog/admin/static/style/jquery.js"></script>
    <!--Beyond Scripts-->
    <script src="/blog/admin/static/style/beyond.js"></script>

</body></html>