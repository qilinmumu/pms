<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	
	<!-- Bootstrap Core CSS -->
    <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value='/css/admin.css'/>" rel="stylesheet">

    <!-- Fonts -->
    <link href="<c:url value='/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css"> 
  </head>
  
  <body>
    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
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
           
            <!-- Top Menu Items -->
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
           
          <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
          <div class="collapse navbar-collapse navbar-ex1-collapse">
               <ul class="nav navbar-nav side-nav">
                   <li>
                       <a href="<c:url value='/report/report!showReport'/>"><i class="fa fa-fw fa-edit"></i><s:text name="report.inputReport"></s:text></a>
                   </li>
                   <li>
                       <a href="<c:url value='/report/report!loadPersonReport'/>"><i class="fa fa-fw fa-search"></i><s:text name="report.showReport"></s:text></a>
                   </li>              
                   <li class="active">
                       <a href="<c:url value='/mission/mission!showMission'/>"><i class="fa fa-fw fa-file"></i><s:text name="mission.showMission"></s:text></a>
                   </li>
                   <li id="permission">
                       <a href="<c:url value='/mission/mission!inputMission'/>"><i class="fa fa-fw fa-laptop"></i><s:text name="mission.inputMission"></s:text></a>
                   </li>
                   
               </ul>
           </div>
           <!-- /.navbar-collapse -->
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
                
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-file fa-fw"></i> 查看任务布置</h3>
                            </div>
                            <div class="panel-body">
                                    <ul class="nav nav-tabs" role="tablist">
	                                    <li role="presentation" class="active" id="personal">
	                                   		<a href="#my-task" aria-controls="my-task" role="tab" data-toggle="tab" id="personalClick">个人任务列表</a>
	                                    </li>
	                                    <li role="presentation" id="team">
	                                    	<a href="#team-task" aria-controls="team-task" role="tab" data-toggle="tab" id="teamClick">团队任务列表</a>
	                                    </li>
                                    </ul>

                                    <!-- Tab panes -->
                                    <div class="tab-content">
                                        <div role="tabpanel" class="tab-pane active" id="my-task">
                                            <table class="table table-hover" id="myMission">
                                                <thead>
                                                      <tr>
                                                         <th data-field="missionId" data-visible="false">任务id</th>
                                                         <th data-field="userName">用户</th>
                                                         <th data-field="task">任务内容</th>
                                                         <th data-field="progress">进度(%)</th>
                                                         <th data-field="create">创建时间</th>
                                                         <th data-field="start">开始时间</th>
                                                         <th data-field="end">结束时间</th>
                                                         <th data-field="modify">修改时间</th>
                                                         <th data-field="remark">备注</th>
                                                         <th data-field="status">状态</th>
                                                         <th class="col-xs-2" data-field="action" data-formatter="actionFormatter" data-events="actionEvents">操作</th>  
                                                      </tr>
                                                   </thead>
                                                   <tbody>
                                                      
                                                   </tbody>
                                            </table>

                                        </div>
                                        <div role="tabpanel" class="tab-pane" id="team-task">
                                            <table class="table table-hover" id="teamMission">
                                                <thead>
                                                      <tr>
                                                      	 <th data-field="missionId" data-visible="false">任务id</th>
                                                         <th data-field="userName">用户</th>
                                                         <th data-field="task">任务内容</th>
                                                         <th data-field="progress">进度(%)</th>
                                                         <th data-field="create">创建时间</th>
                                                         <th data-field="start">开始时间</th>
                                                         <th data-field="end">结束时间</th>
                                                         <th data-field="modify">修改时间</th>
                                                         <th data-field="remark">备注</th>
                                                         <th data-field="status">状态</th> 
                                                      </tr>
                                                   </thead>
                                                   <tbody>
                                                    
                                                   </tbody>
                                            </table>
                                        </div>
                                        
                                    </div>

                                    <!-- modal -->
                                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                      <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                          <div class="modal-header">
                                               <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                               </button>
                                               <h4 class="modal-title" id="myModalLabel">个人任务操作修改</h4>
                                          </div>
                                          <form action="<c:url value='/mission/mission!updateMisstion'/>" id="my-content" method="post">
                                              <div class="modal-body">
                                                 <input type="hidden" name="updateMissionDTO.missionId" id="missionId">
                                                 <div class="form-group">
                                                   <label for="task-content" class="control-label">任务内容:</label>
                                                   <input type="text" class="form-control" id="task-content" readonly>
                                                 </div>
                                                 <div class="form-group">
                                                   <label for="task－start" class="control-label">开始时间:</label>
                                                   <input class="form-control" id="task-start" readonly></input>
                                                 </div>
                                                 <div class="form-group">
                                                   <label for="task－end" class="control-label">结束时间:</label>
                                                   <input class="form-control" id="text-end" readonly></input>
                                                 </div>
                                                 <div class="form-group">
                                                   <label for="task－alter" class="control-label">修改时间:</label>
                                                   <input class="form-control" id="task-alter" readonly></input>
                                                 </div>
                                                 <div class="form-group">
                                                   <label for="task－note" class="control-label">备注:</label>
                                                   <input class="form-control" id="task-note" name="updateMissionDTO.remark"></input>
                                                 </div>
                                                 <div class="form-group">
                                                   <label for="task-rate" class="control-label">进度(%):</label>
                                                   <input type="text" class="form-control" id="task-rate" name="updateMissionDTO.progress">
                                                 </div>
                                                 <div class="form-group">
                                                     <label for="task-status" class="control-label">状态:</label>
                                                     <select class="form-control" id="task-status" name="updateMissionDTO.status">
                                                       	<option value="-1">请选择任务状态</option>
                                                		<option value="未完成">未完成</option>
                                                		<option value="已完成">已完成</option>
                                                		<option value="放弃">放弃</option>
                                                     </select>
                                                 </div>
                                              </div>
                                              <div class="modal-footer">
                                                  <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                  <button type="submit" class="btn btn-primary" id="my-submit">确定</button>
                                              </div>
                                            </form>
                                        </div>
                                      </div>
                                    </div>
                                    
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
  </body>
<!-- jQuery -->
<script src="<c:url value='/js/jquery.js'/>"></script>
<!-- Bootstrap Core JavaScript -->
<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/js/bootstrap-table.min.js'/>"></script>
<script src="<c:url value='/js/bootstrap-table-zh-CN.js'/>"></script>
<script src="<c:url value='/js/layer.js'/>"></script>

<script type="text/javascript">
    function actionFormatter(value, row, index) {         
        return [                 
            '<button class="change btn btn-primary" title="Change" id="change" data-toggle="modal" data-target="#myModal">修改</button>'
        ].join('');
    }

    window.actionEvents = { 
        'click .change': function (e, value, row, index) {
          $("#task-content").val(row.task);
          $("#missionId").val(row.missionId);
          $("#task-start").val(row.start);
          $("#text-end").val(row.end);
          $("#task-alter").val(row.modify);
          $("#task-note").val(row.remark);
          $("#task-rate").val(row.progress);
          var option = $("#task-status").children();
          for(var i = 0; i < option.length; i++) {
            if (option[i].value == row.status) {
              option[i].selected = true;
            }
          }
        }
    };

    function initMyMission() {
        //初始化表格,动态从服务器加载数据
        $("#myMission").bootstrapTable({
            method: "get",
            url: "<c:url value='/mission/mission!ajaxLoadPersonMission'/>",
            striped: true,
            pagination: true,
            pageSize: 5,
            pageNumber:1,
            pageList: [5, 10, 15, 20],
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

    function initTeamMission() {
        //初始化表格,动态从服务器加载数据
        $("#teamMission").bootstrapTable({
            method: "get",
            url: "<c:url value='/mission/mission!ajaxLoadTeamMission'/>",
            striped: true,
            pagination: true,
            pageSize: 5,
            pageNumber:1,
            pageList: [5, 10, 15, 20],
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

    function check() {
        var rate = $("#task-rate").val();
        var status = $("#task-status").val();
        if(rate == null || rate == ""){
            layer("请填写进度");
            $("#task-rate").focus();
            return false;
        }
        if(status == -1){
            layer("请选择任务状态");
            return false;
        }
    }

    $(document).ready(function(){
        var permission = "${user.permission}";
        if(permission != "1"){
            $("#permission").hide();
        }

        $("#my-submit").bind("click", check);
        $("#personalClick").bind("click", initMyMission);
        $("#teamClick").bind("click", initTeamMission);

        initMyMission();
        
    });
    
</script>
</html>
