<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>CDIOZ Admin</title>
    
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
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
            
            <!-- 选择语言 -->
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
               
            <!-- Sidebar Menu  -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li class="active">
                        <a href="<c:url value='/report/report!showReport'/>"><i class="fa fa-fw fa-edit"></i><s:text name="report.inputReport"></s:text></a>
                    </li>
                    <li>
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
                <form action="<c:url value='/report/report!addReport'/>" method="post">
                	<input type="hidden" name="reportDTO.reportId" value="<s:property value="report.reportId"/>"/>
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
                                <h3 class="panel-title"><i class="fa fa-check fa-fw"></i><s:text name="report.today"></s:text></h3>
                            </div>
                            <div class="panel-body">
                                <textarea class="form-control" rows="4" id="text-achi" name="reportDTO.task"><s:property value="report.todayTask"/></textarea>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-question fa-fw"></i><s:text name="report.question"></s:text></h3>
                            </div>
                            <div class="panel-body">
                                <textarea class="form-control" rows="4" id="text-ques" name="reportDTO.question"><s:property value="report.todayQuestion"/></textarea>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-github fa-fw"></i><s:text name="report.plan"></s:text></h3>
                            </div>
                            <div class="panel-body">
                                <textarea class="form-control" rows="4" id="text-plan" name="reportDTO.plan"><s:property value="report.plan"/></textarea>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-book fa-fw"></i><s:text name="report.remark"></s:text></h3>
                            </div>
                            <div class="panel-body">
                                <textarea class="form-control" rows="4" id="text-remark" name="reportDTO.remark"><s:property value="report.remark"/></textarea>
                            </div>
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary pull-right" id="edit-submit"><s:text name="submit"></s:text></button>
            </form>
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
  <script src="<c:url value='/js/layer.js'/>"></script>
  <script src="<c:url value='/js/bootstrap-table.min.js'/>"></script>

  <script type="text/javascript">
        function checkReport() {
            var task = $("#text-achi").val();
                var question = $("#text-ques").val();
                var plan = $("#text-plan").val();
                var remark = $("#text-remark").val();
                
                if(task == null || task == ""){
                    layer.msg("请填写今日完成任务");
                    $("#text-achi").focus();
                    return false;
                } else if(task.length > 500){
                    layer.msg("今日完成任务的字数不能超过500字");
                    $("#text-achi").focus();
                    return false;
                }
                
                if(question == null || question == ""){
                    layer.msg("请填写今日遇到问题");
                    $("#text-ques").focus();
                    return false;
                } else if(question.length > 500){
                    layer.msg("今日遇到问题的字数不能超过500字");
                    $("#text-ques").focus();
                    return false;
                }

                if(plan == null || plan == ""){
                    layer.msg("请填写明日计划");
                    $("#text-plan").focus();
                    return false;
                } else if(plan.length >500){
                    layer.msg("明日计划的字数不能超过500字");
                    $("#text-plan").focus();
                    return false;
                }
                
                if(remark != "" && remark.length > 500){
                    layer.msg("备注的字数不能超过500字");
                    $("#text-remark").focus();
                    return false;
                }
        }

        $(document).ready(function(){
            var permission = "${user.permission}";
            if(permission != "1"){
                $("#permission").hide();
            }
            
            $("#edit-submit").bind("click", checkReport);
            
            var tip = "<s:property value='[1].tip'/>";
            if(tip != "") {
            	layer.msg(tip);
            }
        });
    </script>
</html>
