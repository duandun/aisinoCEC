<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="zh-CN">
  <head>
    <title>找回密码</title>
	<%@include file="/WEB-INF/views/public/import.jsp"%>
	<script type="text/javascript" src="<%=path %>js/views/user/findPassword.js"></script>
  </head>
  
  <body>
  	 找回密码邮件发送成功，请去邮箱点击链接进行重置密码操作。<br />
  	 若没有收到邮件，请点击<a onclick="findPwd.sendFindPwdMailAgain();">重新发送</a>
  	<input id="email" name="email" type="hidden" value="${email}"/>
  </body>
</html>
