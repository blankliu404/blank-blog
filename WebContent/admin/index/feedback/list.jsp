<%@ page language="java" import="method.Time" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--
	@author 刘飞 陈新
	@createTime 2019-07-10 12:03
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
    	    <!--Basic Scripts-->
    <script src="/blog/admin/static/style/jquery_002.js"></script>
    <script src="/blog/admin/static/style/bootstrap.js"></script>
    <script src="/blog/admin/static/style/jquery.js"></script>
    <!--Beyond Scripts-->
    <script src="/blog/admin/static/style/beyond.js"></script>
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
                                        <li class="active">反馈管理</li>
                                        </ul>
                </div>
                <!-- /Page Breadcrumb -->

                <!-- Page Body -->
                <div class="page-body">
                    
<div class="row">
    <div class="col-lg-12 col-sm-12 col-xs-12">
        <div class="widget">
            <div class="widget-body">
                <div class="flip-scroll">
                    <form action="" method="post">
                        <table class="table table-bordered table-hover">
                            <thead class="">
                                <tr>
                                    <th class="text-center" width="10%">ID</th>
                                    <th class="text-center">反馈名称</th>
                                    <th class="text-center" width="10%">反馈时间</th>
                                    <th class="text-center" width="10%">反馈内容</th>
                                    <th class="text-center" width="10%">采纳情况</th>
                                    <th class="text-center" width="10%">采纳时间</th>
                                    <th class="text-center" width="20%">操作</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach items="${feedbackList }" var="fl">
                                    <tr>
                                        <td align="center" style="vertical-align: middle;">${fl.fid }</td>
                                        <td align="center" style="vertical-align: middle;">${fl.ftitle}</td>
                                        <td align="center" style="vertical-align: middle;">${Time.timeShift(fl.ftime)}</td>
                                        <td align="center" style="vertical-align: middle;"><a href="javascript:void(0);" class="btn btn-blue shiny" 
                                        onclick="$('#feedbackModalLabel').html('${fl.ftitle}');
                                        	$('#feedbackModalBody').html('${fl.fcontent}');
                                    	$('#feedbackModal').modal();">点击查看</a></td>
                                       
	                                    <c:choose>   
	                                        <c:when test="${fl.fsolve eq false }">
		                                        <td align="center" style="vertical-align: middle;">待采纳</td>
		                                        <td align="center" style="vertical-align: middle;">待采纳</td>
	                						</c:when> 
	                						<c:otherwise>
	                							<td align="center" style="vertical-align: middle;">已采纳</td>
		                                        <td align="center" style="vertical-align: middle;">${Time.timeShift(fl.fsolve_time)}</td>
	                						</c:otherwise> 
	                					</c:choose>                       
                                        <td align="center" style="vertical-align: middle;">
                                        	<c:if test="${fl.fsolve eq false }">
	                                            <a href="/blog/admin/index/feedback/edit?fid=${fl.fid }" class="btn btn-primary btn-sm shiny">
	                                                <i class="fa fa-edit"></i> 去处理
	                                            </a>
                                            </c:if>
                                            <a href="#" onClick="warning('确实要删除 ${fl.fcontent } 吗', '/blog/admin/index/feedback/delete?fid=${fl.fid }')" class="btn btn-danger btn-sm shiny">
                                                <i class="fa fa-trash-o"></i> 删除
                                            </a>
                                        </td>
                                    </tr>
								</c:forEach>
                            </tbody>
                        </table>
                       
                    </form>
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

    


</body></html>