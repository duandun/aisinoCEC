<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="zh-CN">
  <head>
    <title>企业认证状态</title>
	<%@include file="/WEB-INF/views/public/import.jsp"%>
	<script type="text/javascript" src="<%=path %>js/views/authentication/etrAuthentication.js"></script>
	
	<link type="text/css" rel="stylesheet" href="<%=path %>js/jquery/validation/css/validate.css">
	<script type="text/javascript" src="<%=path %>js/jquery/validation/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=path %>js/jquery/validation/additional-methods.js"></script>
	<script type="text/javascript" src="<%=path %>js/jquery/validation/jquery.validate.unobtrusive.js"></script>
	<script type="text/javascript" src="<%=path %>js/jquery/validation/localization/messages_zh.js"></script>
  </head>
  
  <body>
  
  	<form:form id="etrAuthStatusForm">
	  	企业认证状态：
	  	<c:if test="${status == null}">
	  		未认证<button id="notApplyButton" type="button" class="btn btn-primary btn-lg btn-block" onclick="etrAuth.etrAuthentication();">认证申请</button>
	  	</c:if>
	  	
	  	<c:if test="${status == waitPass}">
	  		审核中<button id="waitPassButton" type="button" class="btn btn-primary btn-lg btn-block" onclick="etrAuth.etrAuthentication();">认证申请</button>
	  	</c:if>
	  	
	  	<c:if test="${status == passed}">
	  		认证通过<button id="passedButton" type="button" class="btn btn-primary btn-lg btn-block" onclick="etrAuth.etrAuthentication();">认证申请</button>
	  	</c:if>
	  	
	  	<c:if test="${status == notPass}">
	  		认证未通过<button id="notPassButton" type="button" class="btn btn-primary btn-lg btn-block" onclick="etrAuth.etrAuthentication();">认证申请</button>
	  	</c:if>
	  	<input type="hidden" value="${enterpriseName}" id="enterpriseName" name="enterpriseName"/>
	  	<input type="hidden" value="${enterpriseId}" id="enterpriseId" name="enterpriseId"/>
	  	<input type="hidden" value="${authenticationId}" id="authenticationId" name="authenticationId"/>
  	</form:form>
  </body>
</html>
