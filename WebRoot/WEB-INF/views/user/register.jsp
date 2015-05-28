<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
<head>

	<title>企业注册</title>
	<%@include file="/WEB-INF/views/public/import.jsp"%>
	<script type="text/javascript" src="<%=path %>js/bootstrap/plugin/bootpag/js/jquery.bootpag.min.js"></script>
	<link type="text/css" rel="stylesheet" href="<%=path %>
	js/jquery/validation/css/validate.css">
	<script type="text/javascript" src="<%=path %>js/jquery/validation/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=path %>js/jquery/validation/additional-methods.js"></script>
	<script type="text/javascript" src="<%=path %>js/jquery/validation/jquery.validate.unobtrusive.js"></script>
	<script type="text/javascript" src="<%=path %>js/jquery/validation/localization/messages_zh.js"></script>

</head>

<body>
	<div class="content" style="top:20%;left:40%;position:absolute;">
		<form:form id="registerForm" action="" method="post" style="width:300px;">

			<div class="control-group">
				<label for="userName" class="control-label">用户名</label>
				<div class="controls">
					<input type="text"  class="form-control" tabindex="1" name="userName" id="userName" 
						 			data-val-required="请填写用户名。" data-val-regex-pattern="(?!^\d[A-Za-z0-9]*$)^[A-Za-z0-9_-]{6,25}$" data-val-regex="用户名只允许字母、数字、下划线、横线组成，首位只能为字母，且至少需要 6 个字符，小于25个字符。" data-val="true"
						 			data-val-remote="该用户已注册。" data-val-remote-additionalfields="*.userName" data-val-remote-url="<%=path %>
					user/userNameCheck.html">
					<span class="help-block">
						<span data-valmsg-replace="true" data-valmsg-for="userName" class="field-validation-valid"></span>
					</span>
				</div>

			</div>

			<div class="control-group">
				<label class="control-label" >企业名称</label>
				<br/>
				<input name="enterpriseName" data-val-length-max="64" data-val-length="企业名称小于64位字符" id="enterpriseName" class="form-control" type="text" data-val="true" data-val-required="请填写企业名。"
		  			data-val-remote-additionalfields="*.enterpriseName" data-val-remote="该企业已注册。" data-val-remote-url="<%=path %>user/enterpriseNameCheck.html" data-val-remote-type="post"></input>
			<span class="help-block">
				<span data-valmsg-replace="true" data-valmsg-for="enterpriseName" class="field-validation-valid"></span>
			</span>
		</div>
		<div class="control-group">
			<label for="userEmail" class="control-label">电子邮箱</label>
			<div class="controls">
				<input type="text" class="form-control" tabindex="4" name="userEmail" id="userEmail" placeholder="123@example.com"
				           			data-val-required="请填写电子邮箱。" data-val-email="请输入正确邮箱。" data-val="true"
				           			data-val-remote="该邮箱已注册。" data-val-remote-additionalfields="*.userEmail" data-val-remote-url="<%=path %>
				user/userEmailCheck.html" >
				<span class="help-block">
					<span data-valmsg-replace="true" data-valmsg-for="userEmail" class="field-validation-valid"></span>
				</span>
			</div>

		</div>
		<div class="control-group">
			<label class="control-label">密码</label>
			<div class="controls">
				<input type="password" class="form-control" tabindex="2" name="userPasswd" id="userPasswd" data-val-required="请填写密码。" data-val-length-min="6" data-val-length-max="32" data-val-length="登录密码必须由6-32位字符组成。" data-val="true" autocomplete="off">
				<span class="help-block">
					<span data-valmsg-replace="true" data-valmsg-for="userPasswd" class="field-validation-valid"></span>
				</span>
			</div>

		</div>
		<div class="control-group">
			<label class="control-label">重复密码</label>
			<div class="controls">
				<input type="password" class="form-control" tabindex="3" name="userRePasswd" id="userRePasswd" data-val-required="请填写重复密码。" data-val-equalto-other="*.userPasswd" data-val-equalto="两次输入的密码不一致。"  data-val-length-min="6" data-val-length-max="32" data-val-length="登录密码必须由6-32位字符组成。" data-val="true" autocomplete="off">
				<span class="help-block">
					<span data-valmsg-replace="true" data-valmsg-for="userRePasswd" class="field-validation-valid"></span>
				</span>
			</div>

		</div>
		<div class="control-group verification">
			<label class="control-label">验证码</label>
			<div class="controls">
				<input type="text" class="form-control verifycode" value="" style="ime-mode:disabled;" name="captchaCode" id="captchaCode" 
									data-val-required="验证码不可为空。" data-val-length-max="4" data-val-length="必须为4位" data-val="true" tabindex="5"
									data-val-remote="验证码错误" data-val-remote-additionalfields="*.captchaCode" data-val-remote-url="<%=path %>
				user/captchaCheck.html"  >
				<span class="help-block">
					<span data-valmsg-replace="true" data-valmsg-for="captchaCode" class="field-validation-valid"></span>
				</span>
				<img id="verificationCodeImg" name="verificationCodeImg" src="<%=path %>util/captcha" title="点击刷新" alt="验证码"></div>

		</div>
		<div class="form-group form-info" style="margin-left:20px;">
			<div class="checkbox checkagreement">
				<input id="agreement" name="agreement" type="checkbox" value="" checked="checked" />
				<label class="control-label">同意</label>
				<button class="btn btn-primary btn-agreement" data-toggle="modal" data-target="#myModal" type="button">注册协议</button>
				<!-- Modal -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog" style="width:900px">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel" style="font-size:28px">服务协议</h4>
							</div>
							<div class="modal-body">
								<div class="container-fluid">

									<!--Start: Tab-content -->
									<div class="tab-content security-content" style="height:400px">

										<div class="tab-pane fade active in">
											<p>免责声明免责声明免责声明免责声明</p>
											<p>免责声明免责声明</p>
										</div>

									</div>
									<!--End: Tab-content -->
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary" data-dismiss="modal">确认</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->
			</div>
		</div>
		<div>
			<button type="button" class="btn btn-default" onclick="register.quickRegister();">注册</button>
		</div>
	</form:form>
</div>
<script type="text/javascript" src="<%=path %>js/views/user/register.js"></script>
</body>
</html>