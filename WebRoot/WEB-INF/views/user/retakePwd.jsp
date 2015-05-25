<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="zh-CN">
  <head>
    <title>重置密码</title>
	<%@include file="/WEB-INF/views/public/import.jsp"%>
	<script type="text/javascript" src="<%=path %>js/views/user/findPassword.js"></script>
	
	<link type="text/css" rel="stylesheet" href="<%=path %>js/jquery/validation/css/validate.css">
	<script type="text/javascript" src="<%=path %>js/jquery/validation/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=path %>js/jquery/validation/additional-methods.js"></script>
	<script type="text/javascript" src="<%=path %>js/jquery/validation/jquery.validate.unobtrusive.js"></script>
	<script type="text/javascript" src="<%=path %>js/jquery/validation/localization/messages_zh.js"></script>
  </head>
  
  <body>
  	<form:form id="resetPwdForm" method="post">
		<div class="list-group col-md-4">
			<div class="input-group">
	            <label class="control-label">密码</label>
	            <div class="controls">
	                <input type="password" name="password" id="password" data-val-required="请填写密码。" data-val-length-min="6" data-val-length-max="32" data-val-length="登录密码必须由6-32位字符组成。" data-val="true" autocomplete="off">
	            </div>
	            <span class="help-block"><span data-valmsg-replace="true" data-valmsg-for="password" class="field-validation-valid"></span></span>
	      	</div>
			<div class="input-group">
	            <label class="control-label">重复密码</label>
	            <div class="controls">
	                <input type="password" name="repassword" id="repassword" data-val-required="请填写重复密码。" data-val-equalto-other="*.password" data-val-equalto="两次输入的密码不一致。"  data-val-length-min="6" data-val-length-max="32" data-val-length="登录密码必须由6-32位字符组成。" data-val="true" autocomplete="off">
	            </div>
	            <span class="help-block"><span data-valmsg-replace="true" data-valmsg-for="repassword" class="field-validation-valid"></span></span>
	      	</div>
		</div>
		
		<input id="userId" name="userId" value="${userId}" type="hidden"/>
		<button id="retakePwd" type="button" class="btn btn-primary btn-lg btn-block" onclick="findPwd.resetPwd();">重置密码</button>
	</form:form>
  </body>
</html>
