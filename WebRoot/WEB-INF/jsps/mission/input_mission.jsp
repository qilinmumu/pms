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
	
	<!-- Bootstrap Core CSS -->
    <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/css/bootstrap-datetimepicker.min.css'/>">
    <!-- Custom CSS -->
    <link href="<c:url value='/css/admin.css'/>" rel="stylesheet">

    <!-- Fonts -->
    <link href="<c:url value='/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css">
	
	<!-- jQuery -->
    <script src="<c:url value='/js/jquery.js'/>"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value='/js/bootstrap.min.js'/>"></script>
    <script src="<c:url value='/js/bootstrap-datetimepicker.min.js'/>"></script>
    <script src="<c:url value='/js/bootstrap-datetimepicker.zh-CN.js'/>"></script>
    <script src="<c:url value='/js/layer.js'/>"></script>
    
    <script type="text/javascript">
	    $(document).ready(function(){
	    	var permission = "${user.permission}";
			if(permission != "1"){
				$("#permission").hide();
			}
			
			$("#head-start,#head-alter,#head-end").datetimepicker({
	            format: 'yyyy-mm-dd',  
	            language: 'zh-CN',
	            minView: "month",
	            autoclose:true,
	        });
			
			var tip = "<s:property value='[1].tip'/>";
			if(tip != "") {
				layer.msg(tip);
			}
			
	    });
    </script>
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
                 <li>
                     <a href="<c:url value='/mission/mission!showMission'/>"><i class="fa fa-fw fa-file"></i><s:text name="mission.showMission"></s:text></a>
                 </li>
                 <li class="active" id="permission">
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
                                <h3 class="panel-title"><i class="glyphicon glyphicon-hand-right"></i> 组长任务布置</h3>
                            </div>
                            <div class="panel-body">
                                <form action="<c:url value='/mission/mission!addMission'/>" method="post">
                                    <div class="row">
                                        <div class="col-md-2"></div>
                                            <div class="col-md-8">
                                                <div class="form-group">
	                                                <label class="control-label">成员:</label>
	                                                <select class="form-control" name="addMissionDTO.userId" id="worker">
	                                                	<option value="-1">请选择成员</option>
	                                                	<s:iterator value="userList" var="w">
	                                                		<option value="<s:property value='#w.userId'/>"><s:property value="#w.name"/></option>
	                                                	</s:iterator>
	                                                </select>
                                                </div>
                                                <div class="form-group">
                                                  <label for="task-content" class="control-label">任务内容:</label>
                                                  <input type="text" class="form-control" id="head-content" name="addMissionDTO.task">
                                                  
                                                </div>
                                                
                                                <div class="form-group">
                                                            <label for="head-start">开始时间:</label>
                                                            <div class='input-group date' >
                                                                <input type='text' class="form-control" id="head-start" name="addMissionDTO.start"/>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                                                                </span>
                                                            </div>
                                                      </div>

                                                <div class="form-group">
                                                            <label for="head-end">结束时间:</label>
                                                            <div class='input-group date' >
                                                                <input type='text' class="form-control" id="head-end" name="addMissionDTO.end"/>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                                                                </span>
                                                            </div>
                                                </div>
                                                <div class="form-group">
                                                  <label for="task－note" class="control-label">备注:</label>
                                                  <input class="form-control" id="head－note" name="addMissionDTO.remark"></input>
                                                </div>
                                                <button type="submit" class="btn btn-primary pull-right" id="head-submit">确定</button>
                                            </div>
                                        <div class="col-md-2"></div>
                                    </div>
                                </form>
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
</html>
