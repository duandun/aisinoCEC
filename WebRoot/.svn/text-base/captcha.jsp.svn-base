<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="zh-CN">
  <head>
    <title>My JSP 'captcha.jsp' starting page</title>
	<%@include file="/WEB-INF/views/public/import.jsp"%>
  </head>
  
  <body>
    <img id="verificationCodeImg" name="verificationCodeImg" src="util/captcha" title="点击刷新" alt="验证码">
    <script type="text/javascript">
  		$("#verificationCodeImg").click(function() {
			$("#verificationCodeImg").attr("src", "util/captcha?timestamp=" + new Date().getTime());
		});
  	</script>
  </body>
</html>
