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
  
  	<form:form id="etrAuthenticationForm">
	  	<div id="contactInfo">
	  		<h2>认证联系人信息</h2>
	  		<div class="control-group">
				<label for="contactName" class="control-label">姓名</label>
				<div class="controls">
			 		<input value="${authenticationBean.contactName}" type="text" maxlength="30" class="form-control" tabindex="1" name="contactName" id="contactName" 
			 			data-val-required="请填姓名。" data-val-regex-pattern="^([\u4E00-\u9FA5]{1,10}(\·[\u4E00-\u9FA5]{1,10})*)$" 
	           			data-val-regex="姓名只能是汉字或·组成" data-val-length-max="30" data-val-length="姓名长度不超过30个汉字" data-val="true">
					<span class="help-block">
						<span data-valmsg-replace="true" data-valmsg-for="contactName" class="field-validation-valid">
						</span>
					</span>
				</div>		
			</div>
		  	
		  	<div class="control-group">
		  		<label class="control-label" >手机</label>
		  		<br/>
		  		<input value="${authenticationBean.contactPhone}" name="contactPhone" maxlength="11" data-val-phoneCN="手机号码格式不正确" id="contactPhone" class="form-control" type="text" data-val="true" data-val-required="请填写手机号。"
		  			></input>
				<span class="help-block">
				<span data-valmsg-replace="true" data-valmsg-for="contactPhone" class="field-validation-valid">
				</span>
				</span>		  		
		  	</div>
		  	<div class="control-group">
			    <label for="contactEmail" class="control-label">电子邮箱</label>
		        <div class="controls">
			       <input value="${authenticationBean.contactEmail}" type="text" class="form-control" tabindex="4" name="contactEmail" id="contactEmail" placeholder="123@example.com"
			           maxlength="50" data-val-length-max="50" data-val-length="邮箱长度不超过50位"  data-val-required="请填写电子邮箱。" data-val-email="请输入正确邮箱。" data-val="true">
			       <span class="help-block"><span data-valmsg-replace="true" data-valmsg-for="contactEmail" class="field-validation-valid"></span></span>
			    </div>
			</div>
	  		
	  	</div>
	  	
	  	<div id="enterpriseBaseInfo">
	  		<h2>认证企业基本信息</h2>
	  		<div class="control-group">
				<label for="enterpriseName" class="control-label">企业名称</label>
				<div class="controls">
			 		<input  type="text"   class="form-control" tabindex="1" name="enterpriseName" id="enterpriseName" readonly="readonly" value="${authenticationBean.enterpriseName}"
			 			maxlength="120" data-val-length-max="120" data-val-length="企业名称长度不超过120位"  data-val-required="请填写企业名称" data-val="true" />
			 		<span class="help-block">
						<span data-valmsg-replace="true" data-valmsg-for="enterpriseName" class="field-validation-valid">
						</span>
					</span>
				</div>		
			</div>
		  	
		  	<div class="control-group">
		  		<label for="legalPersonName" class="control-label">法人姓名</label>
				<div class="controls">
			 		<input value="${authenticationBean.legalPersonName}" type="text" maxlength="30" class="form-control" tabindex="1" name="legalPersonName" id="legalPersonName" 
			 			data-val-required="请填法人姓名。" data-val-regex-pattern="^[\u4e00-\u9fa5]{1,15}$|^[a-zA-Z]{1,30}$" data-val-regex="法人姓名只能是汉字或者英文字母组成，汉字不超过15个，英文字母不超过30个" data-val="true">
					<span class="help-block">
						<span data-valmsg-replace="true" data-valmsg-for="legalPersonName" class="field-validation-valid">
						</span>
					</span>
				</div>		  		
		  	</div>
		  	<div class="control-group">
			    <label for="legalPersonIdNum" class="control-label">法人身份证号</label>
		        <div class="controls">
			       <input value="${authenticationBean.legalPersonIdNum}" type="text" maxlength="18"  class="form-control" tabindex="1" name="legalPersonIdNum" id="legalPersonIdNum" 
			 			data-val-required="请填写法人身份证号。" data-val-regex-pattern="^\d{15}$|^\d{18}$|^\d{17}[x,X]$" data-val-regex="身份证号为15或者18位数字，或者17位数字最后一位位x或者X" data-val="true">
			       <span class="help-block"><span data-valmsg-replace="true" data-valmsg-for="legalPersonIdNum" class="field-validation-valid"></span></span>
			    </div>
			</div>
	  		<div class="control-group">
			    <label for="registeredNum" class="control-label">工商注册号</label>
		        <div class="controls">
			       <input value="${authenticationBean.registeredNum}" type="text" maxlength="15"  class="form-control" tabindex="1" name="registeredNum" id="registeredNum" 
			 			data-val-required="请填写工商注册号。" data-val-regex-pattern="^\d{13}$|^\d{15}$" data-val-regex="工商注册号为13或者15位数字" data-val="true">
			       <span class="help-block"><span data-valmsg-replace="true" data-valmsg-for="registeredNum" class="field-validation-valid"></span></span>
			    </div>
			</div>
			<div class="control-group">
			    <label for="organizationCode" class="control-label">组织机构代码证号</label>
		        <div class="controls">
			       <input value="${authenticationBean.organizationCode}" type="text" maxlength="10" class="form-control" tabindex="1" name="organizationCode" id="organizationCode" placeholder="88888888-8"
			 			data-val-required="请填写组织机构代码证号。" data-val-regex-pattern="^\d{8}-\d$" data-val-regex="组织机构代码证号形式应为88888888-8" data-val="true">
			       <span class="help-block"><span data-valmsg-replace="true" data-valmsg-for="organizationCode" class="field-validation-valid"></span></span>
			    </div>
			</div>
	  	</div>
	  	
	  	<div id="taxInfo">
	  		<h2>认证企业纳税信息</h2>
	  		<div class="control-group">
			    <label for="taxRegNum" class="control-label">纳税人登记号</label>
		        <div class="controls">
			       <input value="${authenticationBean.taxRegNum}" type="text" maxlength="18" class="form-control" tabindex="1" name="taxRegNum" id="taxRegNum"
			 			data-val-required="请填写纳税登记号。" data-val-regex-pattern="^\d{15}$|^\d{18}$" data-val-regex="纳税人登记号为15位或者18位" data-val="true">
			       <span class="help-block"><span data-valmsg-replace="true" data-valmsg-for="taxRegNum" class="field-validation-valid"></span></span>
			    </div>
			</div>
			<div class="control-group">
			    <label for="taxpayerIdNum" class="control-label">纳税人识别号</label>
		        <div class="controls">
			       <input value="${authenticationBean.taxpayerIdNum}" type="text" maxlength="20" class="form-control" tabindex="1" name="taxpayerIdNum" id="taxpayerIdNum"
			 			data-val-required="请填写纳税人识别号。" data-val-regex-pattern="^\d{15}$|^\d{17}$|^\d{18}$|^\d{20}$" data-val-regex="纳税人识别号为15,17,18或者20位数字" data-val="true">
			       <span class="help-block"><span data-valmsg-replace="true" data-valmsg-for="taxpayerIdNum" class="field-validation-valid"></span></span>
			    </div>
			</div>
	  	</div>
	  	
	  	<input id="authenticationId" name="authenticationId" value="${authenticationBean.authenticationId}" type="hidden"/>
	  	<input id="enterpriseId" name="enterpriseId" value="${authenticationBean.enterpriseId}" type="hidden"/>
	  	<input id=status name="status" value="${authenticationBean.status}" type="hidden"/>
	  	<c:if test="${authenticationBean.status != passed}">
	  		<button id="applyButton" type="button" class="btn btn-primary btn-lg btn-block" onclick="etrAuth.applyAuth();">申请认证</button>
	  	</c:if>
	  	
	  	<button id="goBackButton" type="button" class="btn btn-primary btn-lg btn-block" onclick="etrAuth.goBack();">返回</button>
  	</form:form>
  </body>
</html>
