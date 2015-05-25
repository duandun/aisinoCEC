<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
    String path = request.getContextPath() + "/";
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%-- bootstrapCss --%>
<link type="text/css" rel="stylesheet" href="<%=path %>js/bootstrap/main/css/bootstrap.min.css">
<%--
	<link type="text/css" rel="stylesheet" href="<%=path %>js/bootstrap/main/css/font-awesome.min.css">
--%>
<%-- 引入jquery --%>
<script type="text/javascript" src="<%=path %>js/jquery/1.11.2/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="<%=path %>js/jquery/placeholder/jquery.placeholder.min.js"></script>
<%-- 引入bootstrap及其插件 --%>
<script type="text/javascript" src="<%=path %>js/bootstrap/main/js/bootstrap.min.js"></script>
<!--[if lt IE 9]>
<script type="text/javascript" src="<%=path %>js/bootstrap/main/js/css3-mediaqueries.js"></script>
<script type="text/javascript" src="<%=path %>js/bootstrap/main/js/html5shiv.min.js"></script>
<script type="text/javascript" src="<%=path %>js/bootstrap/main/js/respond.min.js"></script>
<![endif]-->
<script type="text/javascript">
	var path="<%=path %>";
	var basePath="<%=basePath %>";
    $(function () {
        $('input, textarea').placeholder();
    });
</script>
<%-- 引入js校验插件 --%>
<%--
	<link type="text/css" rel="stylesheet" href="<%=path %>js/jquery/validation/css/validate.css">
	<script type="text/javascript" src="<%=path %>js/jquery/validation/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=path %>js/jquery/validation/additional-methods.js"></script>
	<script type="text/javascript" src="<%=path %>js/jquery/validation/jquery.validate.unobtrusive.js"></script>
	<script type="text/javascript" src="<%=path %>js/jquery/validation/localization/messages_zh.js"></script>
--%>
<%-- 引入分页插件 --%>
<%--
	<script type="text/javascript" src="<%=path %>js/bootstrap/plugin/bootpag/js/jquery.bootpag.min.js"></script>
--%>
<%-- 引入icheck插件(示例：如需要请拷贝到所需页面) --%>
<%--
	<link type="text/css" rel="stylesheet" href="<%=path %>js/bootstrap/plugin/iCheck/skins/all.css" />
	<script type="text/javascript" src="<%=path%>js/bootstrap/plugin/iCheck/js/icheck.min.js"></script>
--%>
<%-- 引入日历插件(示例：如需要请拷贝到所需页面) --%>
<%-- 
	<link rel="stylesheet" type="text/css" href="<%=path %>js/bootstrap/plugin/datetimepicker/css/bootstrap-datetimepicker.min.css" media="screen">
	<script type="text/javascript" src="<%=path %>js/bootstrap/plugin/datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="<%=path %>js/bootstrap/plugin/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
--%>
