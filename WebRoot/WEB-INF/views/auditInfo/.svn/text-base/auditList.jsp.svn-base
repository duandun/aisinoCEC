<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.aisino.cec.enterprise.enumpackage.authentication.AuditStatusEnum" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="zh-CN">
	<head>
	    <title>查询企业申请认证信息</title>
		<%@include file="/WEB-INF/views/public/import.jsp"%>
		<script type="text/javascript" src="<%=path %>js/bootstrap/plugin/bootpag/js/jquery.bootpag.min.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=path %>js/bootstrap/plugin/datetimepicker/css/bootstrap-datetimepicker.min.css" media="screen">
		<script type="text/javascript" src="<%=path %>js/bootstrap/plugin/datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
		<script type="text/javascript" src="<%=path %>js/bootstrap/plugin/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
		<script type="text/javascript" src="<%=path %>js/util/util.js"></script>
		<script type="text/javascript" src="<%=path %>js/views/auditInfo/auditList.js"></script>
		<script type="text/javascript">
			var totalPageNo = ${totalPages }+""; 
			var pageNum = ${pageNum }+""; 
		</script>
	</head>
	
	<body>
		<div>
			<form:form id="queryDataForm" name="queryDataForm" method="post">
				<div style="width: 100%;">
					<div class="form-group">
						<div class="float-left">
							<div class="label-inner">
								<span class="font-bold">企业名称</span>
							</div>
							<div class="float-left">
								<input type="text" name="enterpriseName" id="enterpriseName" class="form-control" value="${condition.enterpriseName}" />
							</div>
						</div>
					</div>
					<div class="form-group">
		          		<div class="float-left">
		          			<div class="label-inner">
								<span class="font-bold">申请状态</span>
							</div>
						</div>
						<div class="float-left">
							<select id="status" name="status">
								<option value="" <c:if test="${(condition.waitPass!=condition.status && condition.passed!=condition.status && condition.notPass!=condition.status) || null==condition.status }">selected = "selected"</c:if>>全部</option>
								<option value="<%=AuditStatusEnum.WAITPASS.getKey() %>" <c:if test="${condition.waitPass==condition.status && null!=condition.status}">selected = "selected"</c:if>><%=AuditStatusEnum.WAITPASS.getValue() %></option>
								<option value="<%=AuditStatusEnum.PASSED.getKey() %>" <c:if test="${condition.passed==condition.status && null!=condition.status}">selected = "selected"</c:if>><%=AuditStatusEnum.PASSED.getValue() %></option>
								<option value="<%=AuditStatusEnum.NOTPASS.getKey() %>" <c:if test="${condition.notPass==condition.status && null!=condition.status}">selected = "selected"</c:if>><%=AuditStatusEnum.NOTPASS.getValue() %></option>
							</select>
						</div>
			      	</div>
				</div>
				<div style="width: 100%;">
					<div class="form-group">
						<div class="float-left">
							<div class="label-inner">
								<span class="font-bold">起始日期</span>
							</div>
							<div class="col-xs-2 float-left input-group date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-format="yyyy-mm-dd">
								<input type="text" class="form-control" id="startApplyTime" name="startApplyTime" value="<fmt:formatDate value="${condition.startApplyTime}" type="date" />" readonly />
			                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
								<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="float-left">
							<div class="label-inner">
								<span class="font-bold">终止日期</span>
							</div>
							<div class="col-xs-2 float-left input-group date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-format="yyyy-mm-dd">
								<input type="text" class="form-control" id="endApplyTime" name="endApplyTime" value="<fmt:formatDate value="${condition.endApplyTime}" type="date" />" readonly />
								<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
								<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
							</div>
						</div>
					</div>
					<div class="label-inner"><span id="errorDateValidate" class="bg-danger"></span></div>
			      	<div>
						<button type="button" class="btn btn-primary btn-lg btn-block" onclick="auditList.queryData();">查询</button>
					</div>
				</div>	
				<input type="hidden" id="pageNum" name="pageNum" value="${pageNum }" />
			</form:form>
		</div>
		<div id="tableDiv" align="center">
			<c:if test="${empty list}">
				<strong>没有查询到数据!</strong>
			</c:if>
			<c:if test="${!empty list}">
				<table id="authTable" border="1" width="600px"> 
					<thead>
						<tr>
							<th style="width: 30px">序号</th>
							<th style="width: 100px">企业名称</th>
							<th style="width: 80px">申请时间</th>
							<th style="width: 30px">状态</th>
							<th style="width: 20px">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="auth" varStatus="status">
							<tr>
								<td>${(pageNum-1) * condition.pageSize + status.count }</td>
								<td>${auth.enterpriseName }</td>
								<td><fmt:formatDate value="${auth.applyTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td>${auth.statusDesc }</td>
								<td><a href="<c:url value="/"/>authentication/show/${auth.authenticationId }.html">详情</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
		<div id="paginationContainer" style="text-align: center;">
			<div id="pagination"></div>
		</div>
	</body>
</html>