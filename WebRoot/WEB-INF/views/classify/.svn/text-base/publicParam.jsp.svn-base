<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML lang="zh-CN">
<HEAD>
	<TITLE> ZTREE DEMO - drag & drop</TITLE>
	<%@include file="/WEB-INF/views/public/import.jsp"%>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="<%=path %>css/demo.css" type="text/css">
	<link rel="stylesheet" href="<%=path %>css/zTreeStyle/zTreeStyle.css" type="text/css">
	<link type="text/css" rel="stylesheet" href="<%=path %>js/bootstrap/plugin/iCheck/skins/all.css" />
	<script type="text/javascript" src="<%=path%>js/bootstrap/plugin/iCheck/js/icheck.min.js"></script>

	<script type="text/javascript" src="<%=path%>js/ztree/jquery.ztree.core-3.5.js"></script>

	<script src="<%=path %>js/views/classify/tree.js"></script>
	<script src="<%=path %>js/views/classify/PropertyGroup.js"></script>
	<style type="text/css">
	/*	.ztree li span.button.add {margin-left:2px; margin-right: -1px; background-position:-144px 0; vertical-align:top; *vertical-align:middle}*/
	</style>

</HEAD>
<BODY>

<div class="container">

	<div class="row" style="background-color: #F5F5F5;margin-top:40px;">

	<script>
		$(document).ready(function(){
			
			//设置显示  规格参数管理/sku属性管理
			classifyTree.category = "mainProperty";
			classifyTree.initTree();

			$("#add-property").hide();
			$("#add-viceProperty").hide();
			
			
			
			/*$("#add-sku").hide();
			$("#add-property").hide();
			$("#add-viceProperty").hide();
			$("#add-skuValue").hide();*/


			$("#searchBtn").click(function(){
				var ztree = $.fn.zTree.getZTreeObj("treeDemo");
				console.log($("#searchBox").val().trim());
				var treeNode = ztree.getNodeByParam("name", $("#searchBox").val().trim(),null);
			//	var treeNodeArr = ztree.getNodesByParamFuzzy("name", $("#searchBox").val().trim(),null);
//				for(var i = 0;i<treeNodeArr.length;i++) {
//					ztree.selectNode(treeNodeArr[i], true);
//				}
				//var treeNode = ztree.getNodeByParam("name")
				console.log(treeNode);
				ztree.selectNode(treeNode,false);
			});

			//添加一级属性
			$("#add-property").click(function(){

				$("#propertyModal h4.modal-title")[0].innerHTML = "添加主属性";
				$("#propertyModal button.commit")[0].innerHTML = "添加";
				$("#propertyName").val("");
				$("#propertyDes").val("");
				$("#propertyModal").modal('show');


//				var setting = {
//					category: "mainProperty",
//					status: "add"
//				};
//				PropertyGroup.init(setting);

				$("#propertyModal button.commit")[0].onclick = function() {
					var setting = {
						category: "mainProperty",
						status: "mod",
						inputBoxValue: $("#propertyName").val().trim(),
						inputBoxDes: $("#propertyDes").val().trim()
					};

					var $group = PropertyGroup.init(setting);
					$("#middle-plane ul.list").append($group);
					$("[data-toggle='tooltip']").tooltip();
				};
			});

			//添加二级属性
			$("#add-viceProperty").click(function(){
				$("#propertyModal h4.modal-title")[0].innerHTML = "添加二级属性";
				$("#propertyModal button.commit")[0].innerHTML = "添加";
				$("#propertyName").val("");
				$("#propertyDes").val("");
				$("#propertyModal").modal('show');

				$("#propertyModal button.commit")[0].onclick = function() {
					var setting = {
						category: "viceProperty",
						status: "mod",
						inputBoxValue: $("#propertyName").val().trim()
					};

					var $group = PropertyGroup.init(setting);
					$("#right-plane ul.list").append($group);
				};
			});

		});
	</script>
	<div class="zTreeDemoBackground col-md-4 column">
		<ul>
			
		</ul>
		<ul>
			<input id="searchBox" />
			<button id="searchBtn" class="btn btn-primary">查询</button>
		</ul>

		<ul id="treeDemo" class="ztree"></ul>
	</div>
	<div class="property col-md-4 column" id="middle-plane">
		<ul>
			<button for="tt" class="btn btn-primary" id="add-property">添加一级属性</button>
		</ul>

		<ul class="list">
			
		</ul>

	</div>
	<div class="property-value col-md-4 column" id="right-plane">
		<div class="mainProperty">
			主属性：<label class="control-label"></label>
		</div>
		<ul>
			<button for="ee" class="btn btn-primary" id="add-viceProperty">添加二级属性</button>
		</ul>
		<ul class="list">

		</ul>

	</div>
	</div>
</div>

<!--
	作者：duandun2012@163.com
	时间：2015-05-14
	描述：添加/修改主属性模态框
-->
<div class="modal" id="propertyModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        	<span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">修改主属性</h4>
      </div>
      <div class="modal-body">
        <p>主属性名称：<input type="text" name="propertyName" id="propertyName" value="aasdf" class="form-control"/></p>
        <p>主属性描述：<input type="text" name="propertyDes" id="propertyDes" value="aasdf" class="form-control" /></p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary commit">修改</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</BODY>

</HTML>
