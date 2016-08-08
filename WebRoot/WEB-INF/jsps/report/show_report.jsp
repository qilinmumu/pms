<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>CDIOZ Admin</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<!-- Bootstrap Core CSS -->
<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
<!-- Custom CSS -->
<link href="<c:url value='/css/admin.css'/>" rel="stylesheet">
<!-- Fonts -->
<link href="<c:url value='/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css">
<!-- boostrap-table -->
<link href="<c:url value='/css/bootstrap-table.min.css'/>" rel="stylesheet">

</head>

<body>
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html">CDIOZ Admin</a>
		</div>
		
		<ul class="nav navbar-right top-nav">
               <li class="dropdown">
                   <a href="#" class="dropdown-toggle" data-toggle="dropdown"><s:text name="choose"></s:text><b class="caret"></b></a>
                   <ul class="dropdown-menu">
                       <li>
                           <a href="<c:url value='/user/user!toLogin?request_locale=en_US'/>">en_US</a>
                       </li>
                       <li>
                           <a href="<c:url value='/user/user!toLogin?request_locale=zh_CN'/>">zh_CN</a>
                       </li>
                   </ul>
               </li>
           </ul>
           
           <!-- Top Menu -->
           <ul class="nav navbar-right top-nav">
               <li class="dropdown">
                   <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-github-alt"></i> ${user.name} <b class="caret"></b></a>
                   <ul class="dropdown-menu">
                       <li>
                           <a href="#"><i class="fa fa-fw fa-user"></i><s:text name="person"></s:text></a>
                       </li>
                       <li>
                           <a href="<c:url value='/user/user!toLogin'/>"><i class="fa fa-fw fa-power-off"></i><s:text name="exit"></s:text></a>
                       </li>
                   </ul>
               </li>
           </ul>
            
			<!-- Sidebar Menu -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="<c:url value='/report/report!showReport'/>"><i class="fa fa-fw fa-edit"></i><s:text name="report.inputReport"></s:text></a>
                    </li>
                    <li  class="active">
                        <a href="<c:url value='/report/report!loadPersonReport'/>"><i class="fa fa-fw fa-search"></i><s:text name="report.showReport"></s:text></a>
                    </li>              
                    <li>
                        <a href="<c:url value='/mission/mission!showMission'/>"><i class="fa fa-fw fa-file"></i><s:text name="mission.showMission"></s:text></a>
                    </li>
                    <li id="permission">
                        <a href="<c:url value='/mission/mission!inputMission'/>"><i class="fa fa-fw fa-laptop"></i><s:text name="mission.inputMission"></s:text></a>
                    </li>
                    
                </ul>
            </div>

		</nav>

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							CDIOZ <small>Project Management</small>
						</h1>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<i class="fa fa-tag fa-fw"></i> 历史汇报纪录
								</h3>
							</div>
							<div class="panel-body">
								<ul class="nav nav-tabs" role="tablist">
									<li role="presentation" class="active" id="personal">
										<a href="#my-his"aria-controls="my-his" role="tab" data-toggle="tab" id="personalClick">个人历史汇报纪录</a>
									</li>
									<li role="presentation" id="team">
										<a href="#team-his"aria-controls="team-task" role="tab" data-toggle="tab" id="teamClick">团队历史汇报纪录</a>
									</li>
								</ul>

								<div class="tab-content">

									<div role="tabpanel" class="tab-pane active" id="my-his">
										<table class="table table-hover" id="myReport">
											<thead>
												<tr>
													<th data-field="userName">用户</th>
													<th data-field="modifyTime">日期</th>
													<th data-field="task">今日完成计划</th>
													<th data-field="question">今日遇到困难</th>
													<th data-field="nextPlan">明日计划</th>
													<th data-field="remark">备注</th>
												</tr>
											</thead>
											<tbody>
												
											</tbody>
										</table>
									</div>
									<div role="tabpanel" class="tab-pane" id="team-his">
										<table class="table table-hover" id="teamReport">
											<thead>
												<tr>
													<th data-field="userName">用户</th>
													<th data-field="modifyTime">日期</th>
													<th data-field="task">今日完成计划</th>
													<th data-field="question">今日遇到困难</th>
													<th data-field="nextPlan">明日计划</th>
													<th data-field="remark">备注</th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>

									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->
</body>

<!-- jQuery -->
<script src="<c:url value='/js/jquery.js'/>"></script>
<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/js/bootstrap-table.min.js'/>"></script>
<script src="<c:url value='/js/bootstrap-table-zh-CN.js'/>"></script>
<script src="<c:url value='/js/layer.js'/>"></script>

<script type="text/javascript">
	function initMyReport() {
		//初始化表格,动态从服务器加载数据
        $("#myReport").bootstrapTable({
            method: "get",
            url: "<c:url value='/report/report!ajaxLoadPersonReport'/>",
            striped: true,
            pagination: true,
            pageSize: 5,
            pageNumber:1,
            pageList: [5, 10, 15, 20],
            search: true,
            showColumns: true,
            showRefresh: true,
            showToggle: true,
            sidePagination: "server", //表示服务端请求
            //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
            //设置为limit可以获取limit, offset, search, sort, order
            queryParamsType : "undefined", 
            queryParams: function queryParams(params) { 
              var param = {  
                  pageNumber : params.pageNumber,  
                  pageSize : params.pageSize,
              };  
              return param;                 
            },
            onLoadSuccess: function(data){
              layer.msg("加载成功");
            },
            onLoadError: function(){
              layer.msg("加载数据失败", {time : 1500, icon : 2});
            }
        });
	}

	function initTeamReport() {
		//初始化表格,动态从服务器加载数据
        $("#teamReport").bootstrapTable({
            method: "get",
            url: "<c:url value='/report/report!ajaxLoadTeamReport'/>",
            striped: true,
            pagination: true,
            pageSize: 5,
            pageNumber:1,
            pageList: [5, 10, 15, 20],
            search: true,
            showColumns: true,
            showRefresh: true,
            showToggle: true,
            sidePagination: "server", //表示服务端请求
            //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
            //设置为limit可以获取limit, offset, search, sort, order
            queryParamsType : "undefined", 
            queryParams: function queryParams(params) { 
              var param = {  
                  pageNumber : params.pageNumber,  
                  pageSize : params.pageSize,
              };  
              return param;                 
            },
            onLoadSuccess: function(data){
              layer.msg("加载成功");
            },
            onLoadError: function(){
              layer.msg("加载数据失败", {time : 1500, icon : 2});
            }
        });
	}

	$(document).ready(function() {
		var permission = "${user.permission}";
		if (permission != "1") {
			$("#permission").hide();
		}	
		initMyReport();

		$("#personalClick").bind("click", initMyReport);
		$("#teamClick").bind("click", initTeamReport);
	});
</script>

</html>
