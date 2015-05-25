<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'enterpriseReview.jsp' starting page</title>
    <%@include file="/WEB-INF/views/public/import.jsp"%>
    		<link rel="stylesheet" type="text/css" href="<%=path %>js/bootstrap/plugin/datetimepicker/css/bootstrap-datetimepicker.min.css" media="screen">
		<script type="text/javascript" src="<%=path %>js/bootstrap/plugin/datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
		<script type="text/javascript" src="<%=path %>js/bootstrap/plugin/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   	
   	<div class="content">
   								<form class="form" role="form" id="queryRegionForm" name="queryRegionForm" action="<c:url value="/"/>appReview/index.html" method="post">
							<dl class="dl-horizontal">
								<dt><label class="control-label">企业名称</label></dt>
								<dd>
									<input type="text" class="form-control" id="enterpriseName" name="enterpriseName" value="" maxlength="32" depend="false"  />
								</dd>
								<dt><label class="control-label">申请日期起</label></dt>
								<dd>
									<ul>
										<li>
											<div id="queryStartDateDiv" class="input-group date form_date col-md-4" data-date-format="yyyy-mm-dd hh:ii:ss">
			<input size="16" type="text" readonly name="applyDateStart" id="queryStartDate"
				class="form-control" value="<fmt:formatDate value='${applicationListModel.applicationDateBegin }' pattern="yyyy-MM-dd hh:ii:ss"/>">
			<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
			<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
		</div>
										
										
										</li>
									</ul>
								</dd>
								<dt id="dateErrorMsg"><label class="control-label"><span style="color: #b94a48;">提示：查询起始时间不能大于截止时间</span></label></dt>
							</dl>
							<dl class="dl-horizontal">
								<dt><label class="control-label">审核状态</label></dt>
								<dd>
									<ul>
										<li>
											<div>
												
											</div>
										</li>
									</ul>
								</dd>
								<dt>
									<label class="control-label">申请日期止</label>
								</dt>
								<dd>
									<ul>
										<li>
											<div id="applicationDateEndDiv" class="input-group date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-format="yyyy-mm-dd">
												<input type="text" class="form-control" id="applicationDateEnd" size="16" name="applicationDateEnd"
													value="<fmt:formatDate value="${applicationListModel.applicationDateEnd }" pattern="yyyy-MM-dd"/>" readonly />
												<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
												<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
											</div>
										</li>
									</ul>
								</dd>
								<dd style="text-align: right;">
									<div>
										<button type="button" class="btn btn-primary btn-form-right" onclick="appList.queryRegion();">查询</button>
									</div>
								</dd>
							</dl>
        					<div style="clear: both;"></div>
							<input type="hidden" id="pageSize" name="pageSize" />
							<input type="hidden" id="goPageNo" name="goPageNo" value="${applicationListModel.goPageNo }" />
						</form>
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
  </body>
</html>
