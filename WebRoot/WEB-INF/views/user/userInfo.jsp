<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.aisino.cec.user.enumpackage.UserGenderEnum" %>
<%@ page import="com.aisino.cec.enterprise.enumpackage.IndustryEnum" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%
    String userName = request.getRemoteUser();
%>
<html lang="zh-CN">
  <head>
    <title>完善用户企业信息</title>
	<%@include file="/WEB-INF/views/public/import.jsp"%>
	<script type="text/javascript">
		var male = '<%=UserGenderEnum.MALE.getValue() %>';
		//var userName = '<%=userName %>';
		//测试
		var url = document.location.search;
		var valArray = url.split('=');
		var userName = valArray[1];
		
	</script>
	<script type="text/javascript" src="<%=path %>js/views/user/jquery.cxselect.js"></script>
	<script type="text/javascript" src="<%=path %>js/views/user/userInfo.js"></script>
	<link type="text/css" rel="stylesheet" href="<%=path %>js/jquery/validation/css/validate.css">
	<script type="text/javascript" src="<%=path %>js/jquery/validation/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=path %>js/jquery/validation/additional-methods.js"></script>
	<script type="text/javascript" src="<%=path %>js/jquery/validation/jquery.validate.unobtrusive.js"></script>
	<script type="text/javascript" src="<%=path %>js/jquery/validation/localization/messages_zh.js"></script>
	<link type="text/css" rel="stylesheet" href="<%=path %>js/bootstrap/plugin/iCheck/skins/all.css" />
	<script type="text/javascript" src="<%=path%>js/bootstrap/plugin/iCheck/js/icheck.min.js"></script>
  </head>
  
  <body>
  	<form:form id="userInfoForm" method="post">
	  	<div class="list-group col-md-4">
			<div>
          		<label for="userRealName">姓名:</label>
          		<div>
	           		<input type="text" name="userRealName" id="userRealName" placeholder="请输入真实姓名" 
	           			data-val-required="请输入姓名" data-val="true" data-val-regex-pattern="^([\u4E00-\u9FA5]{1,10}(\·[\u4E00-\u9FA5]{1,10})*)$" 
	           			data-val-regex="姓名只能是汉字或·组成" data-val-length-max="30" data-val-length="姓名长度不超过30个汉字" />
	          	</div>
	          	<span class="help-block"><span data-valmsg-replace="true" data-valmsg-for="userRealName"></span></span>
	      	</div>
	      	<div>
				<div class="label-inner"><span class="font-bold">性别:</span></div>
				<div class="label-inner">
					<input id="userGenderMale" name="userGender" type="radio" value="<%=UserGenderEnum.MALE.getValue() %>" checked="checked" />
					<span><%=UserGenderEnum.MALE.getKey() %></span>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input id="userGenderFemale" name="userGender" type="radio" value="<%=UserGenderEnum.FEMALE.getValue() %>" />
					<span><%=UserGenderEnum.FEMALE.getKey() %></span>
				</div>
			</div>
	      	<div>
          		<label for="userPhone">手机:</label>
	          	<div>
	           		<input type="text" name="userPhone" id="userPhone" placeholder="请输入手机号码" 
	           			data-val="true" data-val-phoneCN="手机号码格式不正确" />
	          	</div>
	          	<span class="help-block"><span data-valmsg-replace="true" data-valmsg-for="userPhone"></span></span>
	      	</div>
	      	<div>
          		<label for="enterpriseName">企业名称:</label>
          		<div>
	           		<input type="text" name="enterpriseName" id="enterpriseName" placeholder="请输入企业名称" 
	           			data-val-required="必须输入企业名称" data-val="true" data-val-length-max="64" data-val-length="企业名称小于64个字符" />
	          	</div>
	          	<span class="help-block"><span data-valmsg-replace="true" data-valmsg-for="enterpriseName"></span></span>
	      	</div>
	      	<div>
          		<label for="userPosition">您的职位:</label>
          		<div>
	           		<input type="text" name="userPosition" id="userPosition" placeholder="请输入职位" 
	           			 data-val-length-max="32" data-val-length="职位小于32个字符" />
	          	</div>
	          	<span class="help-block"><span data-valmsg-replace="true" data-valmsg-for="userPosition"></span></span>
	      	</div>
	      	<div>
          		<div class="label-inner"><span class="font-bold">主营行业:</span></div>
				<div>
					<select id="mainIndustry" name="mainIndustry" >
						<option value="">请选择</option>
						<option value="<%=IndustryEnum.INTERNET.getValue() %>"><%=IndustryEnum.INTERNET.getKey() %></option>
						<option value="<%=IndustryEnum.MANUFACTURE.getValue() %>"><%=IndustryEnum.MANUFACTURE.getKey() %></option>
						<option value="<%=IndustryEnum.FOOD.getValue() %>"><%=IndustryEnum.FOOD.getKey() %></option>
					</select>
				</div>
	      	</div>
	      	<div>
          		<label for="mainProduct">主营产品:</label>
          		<div>
	           		<textarea rows="5" cols="40" id="mainProduct" name="mainProduct" placeholder="请输入主营产品" 
	           			data-val="true" data-val-length-max="256" data-val-length="主营产品描述小于256个字符" ></textarea>
	          	</div>
	          	<span class="help-block"><span data-valmsg-replace="true" data-valmsg-for="mainProduct"></span></span>
	      	</div>
	      	<div>
          		<div class="label-inner"><span class="font-bold">联系方式:</span></div>
				<div id="element_id">
					<select class="province" name="province"></select> 
				    <select class="city" name="city"></select>
					<select class="district" name="district"></select>
				</div>
				<div>
	           		<input type="text" name="street" id="street" placeholder="街道 门牌号 大厦名称 房间号码" 
	           			data-val="true" data-val-length-max="128" data-val-length="地址小于128个字符" />
	          	</div>
	          	<span class="help-block"><span data-valmsg-replace="true" data-valmsg-for="street"></span></span>
	      	</div>
	      	<input type="hidden" id="userId" name="userId" />
		</div>
		<button id="userInfoButton" type="button" class="btn btn-primary btn-lg btn-block" onclick="userInfo.saveUserInfo();">确认提交</button>
	</form:form>
  </body>
</html>
