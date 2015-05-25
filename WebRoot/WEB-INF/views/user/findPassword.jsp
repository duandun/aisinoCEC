<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="zh-CN">
  <head>
    <title>找回密码</title>
	<%@include file="/WEB-INF/views/public/import.jsp"%>
	<script type="text/javascript" src="<%=path %>js/views/user/findPassword.js"></script>
	
	<link type="text/css" rel="stylesheet" href="<%=path %>js/jquery/validation/css/validate.css">
	<script type="text/javascript" src="<%=path %>js/jquery/validation/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=path %>js/jquery/validation/additional-methods.js"></script>
	<script type="text/javascript" src="<%=path %>js/jquery/validation/jquery.validate.unobtrusive.js"></script>
	<script type="text/javascript" src="<%=path %>js/jquery/validation/localization/messages_zh.js"></script>
  </head>
  
  <body>
  	<form:form id="findPwdForm" method="post">
	  	<div class="list-group col-md-4">
			<div>
          		<label for="emailOrUserName">用户名/邮箱</label>
          		<div>
	           		<input type="text" name="emailOrUserName" id="emailOrUserName" placeholder="请输入登录用户名或者邮箱" 
	           			data-val-required="必须输入用户名或者邮箱" data-val="true"
	           			data-val-remote="没有该用户" data-val-remote-additionalfields="*.emailOrUserName" data-val-remote-url="<%=path %>user/checkEmailOrUserNameIsExists.html" >
	          	</div>
	          	<span class="help-block"><span data-valmsg-replace="true" data-valmsg-for="emailOrUserName"></span></span>
	      	</div>
			<div>
				<label>验证码</label>
				<div>
					<input type="text" value="" style="ime-mode:disabled;" name="captchaCode" id="captchaCode" 
						data-val-required="验证码不可为空。" data-val-length-max="4" data-val-length="必须为4位" data-val="true" tabindex="5"
						data-val-remote="验证码错误" data-val-remote-additionalfields="*.captchaCode" data-val-remote-url="<%=path %>user/captchaCheck.html"  >
					<img id="verificationCodeImg" onclick="findPwd.refreshCaptcha();" name="verificationCodeImg" src="<%=path %>util/captcha" title="点击刷新" alt="验证码">
				</div>
				<span class="help-block"><span data-valmsg-replace="true" data-valmsg-for="captchaCode"></span></span>
		  	</div>
		</div>
		<button id="findPwdButton" type="button" class="btn btn-primary btn-lg btn-block" onclick="findPwd.findPassword();">找回密码</button>
	</form:form>
  </body>
</html>
