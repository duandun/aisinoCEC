<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'registerSuccess.jsp' starting page</title>
    <%@include file="/WEB-INF/views/public/import.jsp"%>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
   
  <body>
     <div class="content" style="top:20%;left:40%;position:absolute;">
	    	<div class="container">
	    		<div class="userwall register-login-unit">
	    		<span>注册成功，激活邮件已发送到</span><a href="#" class="f-blue">${email}</a>，<span>请去邮箱激活！</span>
	    			<br/>
	    			<br/>
	    			<a id="targetEmail" class="btn btn-primary">点击登陆指定邮箱</a>
	    			<a  onclick="register.sendMailAgain('${email}');" href="javascript:void(0);" >重发激活邮件</a>
	    		</div>
	    	</div>
	    </div>
	   
	    <script>
	   		 var hash={
					    'qq.com': 'http://mail.qq.com',
					    'gmail.com': 'http://mail.google.com',
					    'sina.com': 'http://mail.sina.com.cn',
					    '163.com': 'http://mail.163.com',
					    '126.com': 'http://mail.126.com',
					    'yeah.net': 'http://www.yeah.net/',
					    'sohu.com': 'http://mail.sohu.com/',
					    'tom.com': 'http://mail.tom.com/',
					    'sogou.com': 'http://mail.sogou.com/',
					    '139.com': 'http://mail.10086.cn/',
					    'hotmail.com': 'http://www.hotmail.com',
					    'live.com': 'http://login.live.com/',
					    'live.cn': 'http://login.live.cn/',
					    'live.com.cn': 'http://login.live.com.cn',
					    '189.com': 'http://webmail16.189.cn/webmail/',
					    'yahoo.com.cn': 'http://mail.cn.yahoo.com/',
					    'yahoo.cn': 'http://mail.cn.yahoo.com/',
					    'eyou.com': 'http://www.eyou.com/',
					    '21cn.com': 'http://mail.21cn.com/',
					    '188.com': 'http://www.188.com/',
					    'foxmail.coom': 'http://www.foxmail.com'
					};
				
	    	jQuery(document).ready(function($) {
	    		var email = "${email}";		
				var url = email.split('@')[1];
				$("#targetEmail").attr("href",hash[url]);
	    	});	
	    </script>
	    <script type="text/javascript" src="<%=path %>js/views/user/register.js"></script>
  </body>
</html>
