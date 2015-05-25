<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="zh-CN">
	<head>
		<%@include file="/WEB-INF/views/public/import.jsp"%>		
		
		<script type="text/javascript" src="<%=path %>js/bootstrap/plugin/bootpag/js/jquery.bootpag.min.js"></script>
		
		<link type="text/css" rel="stylesheet" href="<%=path %>js/bootstrap/plugin/iCheck/skins/all.css" />
		<script type="text/javascript" src="<%=path%>js/bootstrap/plugin/iCheck/js/icheck.min.js"></script>
		
		<link rel="stylesheet" type="text/css" href="<%=path %>js/bootstrap/plugin/datetimepicker/css/bootstrap-datetimepicker.min.css" media="screen">
		<script type="text/javascript" src="<%=path %>js/bootstrap/plugin/datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
		<script type="text/javascript" src="<%=path %>js/bootstrap/plugin/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
		
		<link type="text/css" rel="stylesheet" href="<%=path %>js/jquery/validation/css/validate.css">
		<script type="text/javascript" src="<%=path %>js/jquery/validation/jquery.validate.min.js"></script>
		<script type="text/javascript" src="<%=path %>js/jquery/validation/additional-methods.js"></script>
		<script type="text/javascript" src="<%=path %>js/jquery/validation/jquery.validate.unobtrusive.js"></script>
		<script type="text/javascript" src="<%=path %>js/jquery/validation/localization/messages_zh.js"></script>
	</head>
	<body>
		<div class="list-group col-md-4">
			<form:form id="validateForm" action="/psat/a.action" method="post">
				<input type="text" class="form-control" name="username" id="username" placeholder="用户名" data-val-integer data-val-required="请填写用户名。" data-val="true" data-val-length-min="6" data-val-length="登录密码必须由6-32位字符组成。">
				<span class="help-block">
					<span data-valmsg-replace="true" data-valmsg-for="username" class="field-validation-valid"></span>
				</span>
				<br />
				<input type="text" class="form-control" name="test" id="test" placeholder="自定义测试" data-val-required="自定义测试。" data-val-equalto="密码和确认密码不匹配。" data-val-equalto-other="username" data-val="true" data-val-email="格式为EMAIL" >
				<span class="help-block">
					<span data-valmsg-replace="true" data-valmsg-for="test" class="field-validation-valid"></span>
				</span>
				<br />
				<button type="button" onclick="checkForm();">测试</button>
			</form:form>
			<script type="text/javascript">
				function checkForm(){
					if($("#validateForm").valid()){
						alert("ss");
					}
				}
			</script>
		</div>
		<div style="clear: both;height: 20px;"></div>
	    <div id="page-selection"></div>
	    <script>
	        $('#page-selection').bootpag({
	            total: 10
	        }).on("page", function(event, pageNum){
	             alert(pageNum);
	        });
	    </script>
	    
	    <div>
		    <input type="checkbox">
			<input type="checkbox" checked>
			<input type="radio" name="iCheck">
			<input type="radio" name="iCheck" checked>
			<script>
				$(document).ready(function(){
				  $('input').iCheck({
				    checkboxClass: 'icheckbox_square-red',
				    radioClass: 'iradio_square-blue',
				    increaseArea: '20%'
				  });
				});
			</script>
		</div>
		
		<div style="clear: both;height: 20px;"></div>
		<div id="queryStartDateDiv" class="input-group date form_date col-md-4" data-date-format="yyyy-mm-dd hh:ii:ss">
			<input size="16" type="text" readonly name="applyDateStart" id="queryStartDate"
				class="form-control" value="<fmt:formatDate value="${applicationQueryDataModel.applyDateStart}" pattern="yyyy-MM-dd hh:ii:ss"/>">
			<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
			<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
		</div>
		<script type="text/javascript">
		    $(".form_date").datetimepicker({
				language : 'zh-CN', // 默认语言
				weekStart : 1, // 一周从哪一天开始。0（星期日）到6（星期六）
				todayBtn : 1, // 日历的最下面是否有"今天"按钮
				autoclose : 1, // 选择完日期之后，是否自动关闭
				todayHighlight : 1, // 今天是否高亮
				startView : 2, // 打开之后的开始视图
				minView : 0, // 日期选择器所能提供的最精确的时间选择视图
				forceParse : 0,
				//showMeridian:true,//显示上下午
				pickerPosition : "bottom-left"
				//pickerPosition : "bottom-right"
			});
		</script>  
		
		<div style="clear: both;height: 20px;"></div>
		<div id="queryStartDateDiv" class="col-md-4">
			<ul class="nav nav-tabs">
			  <li role="presentation" class="active"><a href="#">Home</a></li>
			  <li role="presentation"><a href="#">Profile</a></li>
			  <li role="presentation"><a href="#">Messages</a></li>
			</ul>
		</div>
		
		<div style="clear: both;height: 20px;"></div>
		<div id="queryStartDateDiv" class="col-md-4">
			<ul class="nav nav-pills">
			  <li role="presentation" class="active"><a href="#">Home</a></li>
			  <li role="presentation"><a href="#">Profile</a></li>
			  <li role="presentation"><a href="#">Messages</a></li>
			</ul>
		</div>
		
		<div style="clear: both;height: 20px;"></div>
		<div id="queryStartDateDiv" class="col-md-4">
			<form class="navbar-form navbar-left" role="search">
			  <div class="form-group">
			    <input type="text" class="form-control" placeholder="Search">
			  </div>
			  <button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
		
		<div style="clear: both;height: 20px;"></div>
		<div id="queryStartDateDiv" class="col-md-4">
			<span class="label label-default">Default</span>
			<span class="label label-primary">Primary</span>
			<span class="label label-success">Success</span>
			<span class="label label-info">Info</span>
			<span class="label label-warning">Warning</span>
			<span class="label label-danger">Danger</span>
		</div>
		
		<div style="clear: both;height: 20px;"></div>
		<div id="queryStartDateDiv" class="col-md-4">
			<ul class="nav nav-pills" role="tablist">
			  <li role="presentation" class="active"><a href="#">Home <span class="badge">42</span></a></li>
			  <li role="presentation"><a href="#">Profile</a></li>
			  <li role="presentation"><a href="#">Messages <span class="badge">3</span></a></li>
			</ul>
		</div>
		
		<div style="clear: both;height: 20px;"></div>
		<div class="progress col-md-4">
		  <div class="progress-bar progress-bar-success" style="width: 35%">
		    <span class="sr-only">35% Complete (success)</span>
		  </div>
		  <div class="progress-bar progress-bar-warning progress-bar-striped" style="width: 20%">
		    <span class="sr-only">20% Complete (warning)</span>
		  </div>
		  <div class="progress-bar progress-bar-danger" style="width: 10%">
		    <span class="sr-only">10% Complete (danger)</span>
		  </div>
		</div>
		
		<div style="clear: both;height: 20px;"></div>
		<div class="list-group col-md-4">
		  <a href="#" class="list-group-item active">
		    Cras justo odio
		  </a>
		  <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
		  <a href="#" class="list-group-item">Morbi leo risus</a>
		  <a href="#" class="list-group-item">Porta ac consectetur ac</a>
		  <a href="#" class="list-group-item">Vestibulum at eros</a>
		</div>
		
		<div style="clear: both;height: 20px;"></div>
		<div class="list-group col-md-4">
			<div class="panel panel-primary">
			  <div class="panel-heading">Panel heading without title</div>
			  <div class="panel-body">
			    Panel content
			  </div>
			</div>
		</div>
		
		<div style="clear: both;height: 20px;"></div>
		<div class="list-group col-md-4">
			<div class="panel panel-success">
				<div class="panel-heading">Panel heading without title</div>
				  <div class="panel-body">
				    Panel content
				  </div>
			</div>
		</div>
		
		<div style="clear: both;height: 20px;"></div>
		<div class="list-group col-md-4">
			<div class="dropdown">
			  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
			    Dropdown
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
			    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
			    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
			    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
			  </ul>
			</div>
			<div class="dropup">
			  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-expanded="true">
			    Dropdown
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu2">
			    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
			    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
			    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
			    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
			  </ul>
			</div>
		</div>
		
		
		<div style="clear: both;height: 20px;"></div>
		<div class="list-group col-md-4">
			<div class="btn-group btn-group-justified" role="group" aria-label="...">
			  <div class="btn-group" role="group">
			    <button type="button" class="btn btn-default">Left</button>
			  </div>
			  <div class="btn-group" role="group">
			    <button type="button" class="btn btn-default">Middle</button>
			  </div>
			  <div class="btn-group" role="group">
			    <button type="button" class="btn btn-default">Right</button>
			  </div>
			</div>
		</div>
		
		<div style="clear: both;height: 20px;"></div>
		<div class="list-group col-md-4">
			<div class="input-group">
			  <span class="input-group-addon" id="basic-addon1">@</span>
			  <input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group">
			  <input type="text" class="form-control" placeholder="Recipient's username" aria-describedby="basic-addon2">
			  <span class="input-group-addon" id="basic-addon2">@example.com</span>
			</div>
			
			<div class="input-group">
			  <span class="input-group-addon">$</span>
			  <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
			  <span class="input-group-addon">.00</span>
			</div>
		</div>
		
		<a href="user/toFindPwdPage.html">找回密码</a>
	</body>
</html>
