<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.aisino.cec.enterprise.enumpackage.authentication.AuditStatusEnum" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="zh-CN">
  <head>
    <title>企业认证详情</title>
	<%@include file="/WEB-INF/views/public/import.jsp"%>
	<script type="text/javascript" src="<%=path %>js/views/auditInfo/auditDetail.js"></script>
	<link type="text/css" rel="stylesheet" href="<%=path %>js/jquery/validation/css/validate.css">
	<script type="text/javascript" src="<%=path %>js/jquery/validation/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=path %>js/jquery/validation/additional-methods.js"></script>
	<script type="text/javascript" src="<%=path %>js/jquery/validation/jquery.validate.unobtrusive.js"></script>
	<script type="text/javascript" src="<%=path %>js/jquery/validation/localization/messages_zh.js"></script>
	<link type="text/css" rel="stylesheet" href="<%=path %>js/bootstrap/plugin/iCheck/skins/all.css" />
	<script type="text/javascript" src="<%=path%>js/bootstrap/plugin/iCheck/js/icheck.min.js"></script>
  </head>
  
  <body>
  
  	<div id="etrAuthenticationForm">
  		<div id="contactInfo">
	  		<h2>当前认证状态</h2>
	  		<div class="control-group">
				<div class="controls">
			 		<input value="${authenticationBean.statusDesc}" type="text" class="form-control" name="status" id="status" readonly="readonly" />
				</div>		
			</div>
	  	</div>
  		
	  	<div id="contactInfo">
	  		<h2>认证联系人信息</h2>
	  		<div class="control-group">
				<label for="contactName" class="control-label">姓名</label>
				<div class="controls">
			 		<input value="${authenticationBean.contactName}" type="text" class="form-control" name="contactName" id="contactName" readonly="readonly" />
				</div>		
			</div>
		  	
		  	<div class="control-group">
		  		<label class="control-label" >手机</label>
		  		<br/>
		  		<input value="${authenticationBean.contactPhone}" name="contactPhone" id="contactPhone" class="form-control" type="text" readonly="readonly"></input>
		  	</div>
		  	<div class="control-group">
			    <label for="contactEmail" class="control-label">电子邮箱</label>
		        <div class="controls">
			       <input value="${authenticationBean.contactEmail}" type="text" class="form-control" name="contactEmail" id="contactEmail" readonly="readonly" />
			    </div>
			</div>
	  		
	  	</div>
	  	
	  	<div id="enterpriseBaseInfo">
	  		<h2>认证企业基本信息</h2>
	  		<div class="control-group">
				<label for="enterpriseName" class="control-label">企业名称</label>
				<div class="controls">
			 		<input type="text" class="form-control" name="enterpriseName" id="enterpriseName" readonly="readonly" value="${authenticationBean.enterpriseName}" />
				</div>		
			</div>
		  	
		  	<div class="control-group">
		  		<label for="legalPersonName" class="control-label">法人姓名</label>
				<div class="controls">
			 		<input value="${authenticationBean.legalPersonName}" type="text" class="form-control" name="legalPersonName" id="legalPersonName" readonly="readonly" />
				</div>		  		
		  	</div>
		  	<div class="control-group">
			    <label for="legalPersonIdNum" class="control-label">法人身份证号</label>
		        <div class="controls">
			       <input value="${authenticationBean.legalPersonIdNum}" type="text" class="form-control" name="legalPersonIdNum" id="legalPersonIdNum" readonly="readonly" />
			    </div>
			</div>
	  		<div class="control-group">
			    <label for="registeredNum" class="control-label">工商注册号</label>
		        <div class="controls">
			       <input value="${authenticationBean.registeredNum}" type="text" class="form-control" name="registeredNum" id="registeredNum" readonly="readonly" />
			    </div>
			</div>
			<div class="control-group">
			    <label for="organizationCode" class="control-label">组织机构代码证号</label>
		        <div class="controls">
			       <input value="${authenticationBean.organizationCode}" type="text" class="form-control" name="organizationCode" id="organizationCode" readonly="readonly" />
			    </div>
			</div>
	  	</div>
	  	
	  	<div id="taxInfo">
	  		<h2>认证企业纳税信息</h2>
	  		<div class="control-group">
			    <label for="taxRegNum" class="control-label">纳税人登记号</label>
		        <div class="controls">
			       <input value="${authenticationBean.taxRegNum}" type="text" class="form-control" name="taxRegNum" id="taxRegNum" readonly="readonly" />
			    </div>
			</div>
			<div class="control-group">
			    <label for="taxpayerIdNum" class="control-label">纳税人识别号</label>
		        <div class="controls">
			       <input value="${authenticationBean.taxpayerIdNum}" type="text" class="form-control" name="taxpayerIdNum" id="taxpayerIdNum" readonly="readonly" />
			    </div>
			</div>
	  	</div>
	  	
	  	<div id="tableDiv">
			<c:if test="${!empty auditInfoList}">
				<h2>历史审核意见</h2>
				<table id="auditInfoTable" border="1" width="800px"> 
					<thead>
						<tr>
							<th style="width: 30px">序号</th>
							<th style="width: 50px">审核人</th>
							<th style="width: 250px">审核时间</th>
							<th style="width: 150px">审核状态</th>
							<th style="width: 200px">审核意见</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${auditInfoList}" var="auditInfo" varStatus="status">
							<tr>
								<td>${status.count }</td>
								<td>${auditInfo.auditorName }</td>
								<td><fmt:formatDate value="${auditInfo.auditTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td>${auditInfo.auditStatusDesc }</td>
								<td><textarea style="width: 500px" rows="3" cols="20" readonly="readonly">${auditInfo.auditOpinion }</textarea></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
  	</div>
  	
  	<c:if test="${authenticationBean.status == watiPass}">
  		<form:form id="auditInfoForm">
	  		<div>
				<div class="label-inner"><span class="font-bold">审核:</span></div>
				<div class="label-inner">
					<input id="auditStatusPassed" name="auditStatus" type="radio" value="<%=AuditStatusEnum.PASSED.getKey() %>" checked="checked" />
					<span><%=AuditStatusEnum.PASSED.getValue() %></span>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input id="auditStatusNotPassed" name="auditStatus" type="radio" value="<%=AuditStatusEnum.NOTPASS.getKey() %>" />
					<span><%=AuditStatusEnum.NOTPASS.getValue() %></span>
				</div>
				<div class="label-inner float-left"></div>
			</div>
	  		<div class="control-group">
	         	<label for="auditOpinion" class="control-label">审核意见:</label>
	         	<div class="controls">
	           		<textarea style="width: 500px" rows="5" cols="40" id="auditOpinion" name="auditOpinion" placeholder="请输入审核意见" 
	           			data-val="true" data-val-required="审核意见不能为空" data-val-length-max="256" data-val-length="审核意见小于256个字符" ></textarea>
	          	</div>
	          	<span class="help-block"><span data-valmsg-replace="true" data-valmsg-for="auditOpinion"></span></span>
	      	</div>
	  		<input id="authenticationId" name="authenticationId" value="${authenticationBean.authenticationId}" type="hidden"/>
	  	</form:form>
	  	<button id="saveAuditInfoButton" type="button" class="btn btn-primary " onclick="auditDetail.saveAuditInfo();">确认</button>
  	</c:if>
  	<button id="goBackButton" type="button" class="btn btn-primary " onclick="auditDetail.goBack();">返回</button>
  </body>
</html>
