<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
    <title>CDIOZ Admin</title>
    
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	
	<!-- Bootstrap Core CSS -->
    <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="<c:url value='/css/admin.css'/>" rel="stylesheet">
    <!-- Fonts -->
    <link href="<c:url value='/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css">

  </head> 
  <body>
    <div id="content-wrapper">
		<div id="logo">
			<h1>
	        	<small>Project Management</small>
	        </h1>
	    </div>
	    <div id="loginbox">
    	    <form action="<c:url value='/user/user!checkLogin'/>" method="post" id="loginform" class="form-vertical">
    	        <div class="form-group" id="login-user">
				    <div class="input-group">
			        	<div class="input-group-addon"><i class="fa fa-fw fa-user"></i></div>
			        	<input type="text" class="form-control"  placeholder='<s:text name="login.username"></s:text>' name="account" id="account">
				    </div>
		        	<s:property value="fieldErrors.accountError[0]"/>
				</div>
						  
    	        <div class="form-group" id="login-psw">
				    <div class="input-group">
			        	<div class="input-group-addon"><i class="fa fa-fw fa-lock"></i></div>
			        	<input type="password" class="form-control"  placeholder='<s:text name="login.password"></s:text>' name="password" id="password">
				    </div>
		        	<s:property value="fieldErrors.passwordError[0]"/>
				</div>
                <div class="form-group">
                	<input type="checkbox" id="remember" >
                	<label ><s:text name="login.remember"></s:text></label>
                </div>
    	        <div class="form-actions">
    	        	<span  class="pull-right btn-submit">
    	        	    <button type="submit" action="index.html" class="btn btn-primary form－login" id="submit"><s:text name="login.login"></s:text></button>
    	        	</span>
    	        </div>
    	    </form>
	    </div>
	</div>
  </body>
  <script src="<c:url value='/js/jquery.js'/>"></script>
  <script src="<c:url value='/js/bootstrap.min.js'/>"></script>
  <script src="<c:url value='/js/layer.js'/>"></script>
  <script src="<c:url value='/js/base64.min.js'/>"></script>
  <s:if test="exception != null">
		<script type="text/javascript">
			var error = '<s:property value="exception.getMessage()"/>';
			//如果error不为空，说明有错误，则显示错误提示
			layer.msg(error, {e : 2000, icon : 2});
			localStorage.removeItem("pms.account");
            localStorage.removeItem("pms.password");
            localStorage.removeItem("pms.remember");
		</script>
	</s:if>
  
  <!-- javascrip -->
  <script type="text/javascript">
  	function rmb() {
  		var uaccount = $("#account").val();
		var upassword = $("#password").val();
		//表单验证
		if(uaccount == null || uaccount == ""){
			layer.msg("请输入账号", {e : 1500, icon : 2});
			$("#account").focus();
			return false;
		}
		if(upassword == null || upassword == ""){
			layer.msg("请输入密码", {e : 1500, icon : 2});
			$("#password").focus();
			return false;
		}
		
		var flag = $("#remember").prop('checked');
        if (flag == true) { //如果勾选，则将账号，密码加密后保存到localStorage中
            var encodeAcc = Base64.encode(uaccount);
            var encodePsw = Base64.encode(upassword);
            localStorage.setItem("pms.account", encodeAcc);
            localStorage.setItem("pms.password", encodePsw);
            localStorage.setItem("pms.remember", "true");
        } else {    //如果未勾选，则将localStorage中保存的数据删除
            localStorage.removeItem("pms.account");
            localStorage.removeItem("pms.password");
            localStorage.removeItem("pms.remember");
        }
  	}
  
    //判断localStorage中是否有保存信息，如果有则解密显示到输入框
    function checkRemember() {
        var flag = localStorage.getItem("pms.remember");
        if (flag == "true") {
            var account = localStorage.getItem("pms.account");
            var password = localStorage.getItem("pms.password");
            $("#account").val(Base64.decode(account));
            $("#password").val(Base64.decode(password));
            $("#remember").attr("checked", flag);
        }
    }
  
	$(document).ready(function(){
		checkRemember();
		$("#submit").bind("click", rmb);
	});
  </script>
</html>
