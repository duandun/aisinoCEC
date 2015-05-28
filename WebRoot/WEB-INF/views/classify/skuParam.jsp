<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<HTML lang="zh-CN">
<HEAD>
	<TITLE> ZTREE DEMO - drag & drop</TITLE>
	<%@include file="/WEB-INF/views/public/import.jsp"%>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="<%=path %>css/demo.css" type="text/css">
	<link rel="stylesheet" href="<%=path %>css/zTreeStyle/zTreeStyle.css" type="text/css">
	<link type="text/css" rel="stylesheet" href="<%=path %>js/bootstrap/plugin/iCheck/skins/all.css" />
	
	<link type="text/css" rel="stylesheet" href="<%=path %>js/jquery/validation/css/validate.css">
	<script type="text/javascript" src="<%=path %>js/jquery/validation/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=path %>js/jquery/validation/additional-methods.js"></script>
	<script type="text/javascript" src="<%=path %>js/jquery/validation/jquery.validate.unobtrusive.js"></script>
	<script type="text/javascript" src="<%=path %>js/jquery/validation/localization/messages_zh.js"></script>
	
	<script type="text/javascript" src="<%=path%>js/bootstrap/plugin/iCheck/js/icheck.min.js"></script>

	<script type="text/javascript" src="<%=path%>js/ztree/jquery.ztree.core-3.5.js"></script>
	
	<script src="<%=path %>js/util/ajaxfileupload.js"></script>
	
	<script src="<%=path %>js/views/classify/tree.js"></script>
	<script src="<%=path %>js/views/classify/PropertyGroup.js"></script>
	<script src="<%=path %>js/views/classify/skuParam.js"></script>
	<style type="text/css"> 
	/*	.ztree li span.button.add {margin-left:2px; margin-right: -1px; background-position:-144px 0; vertical-align:top; *vertical-align:middle}*/
	</style>

</HEAD>
<BODY>

<div class="container">

	<div class="row" style="background-color: #F5F5F5;margin-top:40px;">

	<script>
		$(document).ready(function(){
			
			classifyTree.category = "skuProperty";
			classifyTree.initTree();

			$("#add-sku").hide();
			$("#add-skuValue").hide();
			$("#searchSku").hide();
			$("#adSearchSku").hide();
			$("#searchSkuValue").hide();
			$("#middle-plane input.searchInput").hide();
			$("#right-plane input.searchInput").hide();
			
			//在分类树上查找节点
			$("#searchBtn").click(function(){
				var ztree = $.fn.zTree.getZTreeObj("treeDemo"), 
					treeNode = ztree.getNodeByParam("name", $("#searchBox").val().trim(),null);
				ztree.selectNode(treeNode,false);
			});

		});
	</script>
	<div class="zTreeDemoBackground col-md-4 column">
		
		<ul>
			<input id="searchBox" />
			<button id="searchBtn" class="btn btn-primary">查询</button>
		</ul>
		<br>
		<ul id="treeDemo" class="ztree"></ul>
	</div>
	<div class="property col-md-4 column" id="middle-plane">
		
		
		<div class="row text-center">
			<div class="control-group">
				<button class="btn btn-primary" id="add-sku">添加SKU属性</button>
			</div>
		</div>
		<br>
		<div class="row text-center">
			<div class="control-group">
				<input type="text" class="searchInput"/>
				<button class="btn btn-primary" id="searchSku">查询</button>
				<button class="btn-link" id="adSearchSku" >高级查询</button>
			</div>
			
		</div>		
		
		<div class="row text-center">
			<ul class="list">
			
			</ul>
		</div>
		

	</div>
	<div class="property-value col-md-4 column" id="right-plane">
		<div class="row mainProperty">
			主属性：<label class="control-label"></label>
		</div>
		<br>
		<div class="row text-center">
			<div class="control-group">
				<button class="btn btn-primary" id="add-skuValue">添加SKU属性值</button>
			</div>
		</div>
		<br>
		<div class="row text-center">
			<div class="control-group">
				<input type="text" class="searchInput"/>
				<button class="btn btn-primary" id="searchSkuValue">查询</button>
			</div>
			
		</div>	
		
		
		<div class="row text-center">
			<ul class="list">
			
			</ul>
		</div>

	</div>
	</div>
</div>

<!--
	作者：duandun2012@163.com
	时间：2015-05-14
	描述：添加/修改SKU属性模态框
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
      	<form:form id="addSkuForm" action="" method="post">
      	<input type="hidden" value="222" name="categoryId"/>
      	<input type="hidden" value="" name="skuAttrId">
      	<div class="control-group">
      		 <label for="storeName" class="control-label" >维护名称：</label>
      		 <input type="text" name="storeName" id="maintainName" data-val-required="请填写名称" data-val-regex-pattern="(?!^\d[A-Za-z0-9]*$)^[A-Za-z0-9_-]{1,25}$" data-val-regex="用户名只允许字母、数字、下划线、横线组成，首位只能为字母，小于25个字符。" 
      		 data-val="true" class="form-control" data-val-remote="该维护名称已存在。" data-val-remote-additionalfields="*.storeName,*.categoryId,*.skuAttrId" data-val-remote-url="<%=path %>skuManage/storeNameCheck.html"/>
      		<span class="help-block">
      			<span data-valmsg-replace="true" data-valmsg-for="storeName" class="field-validation-valid">
			</span></span>
      	</div>
      	<br>
      	<div class="control-group">
      		<label for="frontName" class="control-label">前端名称：</label>
      		<input type="text" name="frontName" id="frontName"  data-val-length-max="64" data-val-length="前端名称小于64位字符" data-val-required="请填写名称" data-val="true" class="form-control" 
      		data-val="true" data-val-remote="该前端名称已存在" data-val-remote-additionalfields="*.frontName,*.categoryId,*.skuAttrId" data-val-remote-url="<%=path %>skuManage/frontNameCheck.html" data-val-remote-type="post"/>
      		<span class="help-block">
      			<span data-valmsg-replace="true" data-valmsg-for="frontName" class="field-validation-valid">
			</span></span>
      	</div>
        <br>
        <div class="control-group picture"><!--
     	图片：<input type="file"  name="selectBtn" value="选择图片" id="choosePic"/>
     	--></div>
      	<br>
      	<div class="col-md-6 control-group">
      		 启用：<input type="radio" name="state" id="enable" value="sku_attr_enable">
			<label for="enable">启用</label>

			<input type="radio" name="state" checked id="disable" value="sku_attr_disable">
			<label for="disable">不启用</label>
		
		</div>
		
		<div class="col-md-6 control-group">
      		 查询属性：<input type="radio" name="isQuery" id="isQueryProperty" value="sku_true">
			<label for="isQueryProperty">是</label>

			<input type="radio" name="isQuery" checked id="notQueryProperty" value="sku_false">
			<label for="notQueryProperty">否</label>
		</div>
		<br>
		<br>
		<div class="col-md-6 control-group">
      		组合属性：<input type="radio" name="isCompsite" id="isGroupProperty" value="sku_true">
			<label for="isGroupProperty">是</label>

			<input type="radio" name="isCompsite" checked id="notGroupProperty" value="sku_false">
			<label for="notGroupProperty">否</label>
		</div>
		
		
		<div class="col-md-6 control-group">
      		必选项：<input type="radio" name="isRequired" id="isRequiredProperty" value="sku_true">
			<label for="isRequiredProperty">是</label>

			<input type="radio" name="isRequired" checked id="notRequiredProperty" value="sku_false">
			<label for="notRequiredProperty">否</label>
		</div>
		<br>
		<br>
		<!--<div class="control-group">
			类型：<input type="radio" name="cstate" id="multiSelect">
			<label for="multiSelect">多选</label>

			<input type="radio" name="cstate" checked id="singleSelect">
			<label for="singleSelect">单选</label>
		</div>
		<br>
		-->
		
		<div class="control-group">
			 <label for="descInfo" class="control-label">描述：</label>
			 <input type="text" name="descInfo" id="nameDes" class="form-control"/>
        	
		</div>
		<br>
		<div class="control-group">
			<label for="modifyInfo" class="control-label">修改信息：</label>
			<input type="text" name="modifyInfo" id="changeMessage"  class="form-control"/>
		</div>
		
      </form:form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary commit">修改</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<!--
	作者：duandun2012@163.com
	时间：2015-05-26
	描述：添加/修改SKU属性值模态框
-->
<div class="modal" id="propertyValueModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        	<span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">修改主属性</h4>
      </div>
      <div class="modal-body">
      	<form:form id="addSkuValueForm" action="" method="post">
      	<input type="hidden" value="222" name="skuAttrId"/>
      	<input type="hidden" value="" name="skuOptionId" />
      	<div class="control-group">
      		<label for="value" class="control-label">可选项值：</label>
      		<input type="text" name="value" id="value"  data-val-length-max="64" data-val-length="可选项值小于64位字符" data-val-required="请填写名称"  data-val="true" class="form-control" 
      		data-val="true" data-val-remote="可选项值已存在" data-val-remote-additionalfields="*.value,*.skuAttrId,*.skuOptionId" data-val-remote-url="<%=path %>skuManage/valueCheck.html" data-val-remote-type="post"/>
      		<span class="help-block">
      			<span data-valmsg-replace="true" data-valmsg-for="value" class="field-validation-valid">
			</span></span>
      	</div>
        <br>
        <div class="control-group picture">
     	可选图片：<input type="button"  name="imageId" value="选择图片" id="choosePic"/>   	
     	</div>
     	<br>
     	<div id="displayImg">
     		<img alt="图片1" src="<%=path %>images/11.png" title="图片" id="imgPreview" style="width:50px;height:50px;"/>
     		<button type="button" class="btn btn-default">删除</button>
     	</div>
      	<br>
      
      	<br>
      	<div class="col-md-6 control-group">
      		 启用：<input type="radio" name="state"  value="sku_option_enable">
			<label >启用</label>

			<input type="radio" name="state" checked value="sku_option_disable">
			<label>不启用</label>
		
		</div>
		
		<div class="control-group">
			类型：<input type="radio" name="typeInfo" id="multiSelect">
			<label for="multiSelect">多选</label>

			<input type="radio" name="typeInfo" checked id="singleSelect">
			<label for="singleSelect">单选</label>
		</div>
		<br>
		
		<div class="control-group">
			 <label for="descInfo" class="control-label">描述：</label>
			 <input type="text" name="descInfo" class="form-control"/>
        	
		</div>
		<br>
		<div class="control-group">
			<label for="modifyInfo" class="control-label">修改信息：</label>
			<input type="text" name="modifyInfo"  class="form-control"/>
		</div>
		
      </form:form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary commit">修改</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<!-- 图片上传 -->
<form:form id="picUploadForm" method="post" action="" style="display:none;">
      	<div class="control-group  picPanel">
      		<div class="panel panel-primary">
				
				 <div class="panel-body">
				    <div class="imageSelect">
      		<input type="file" id="uploadImg" name="uploadImg" value="图片"/>
      		<br>
      		<label class="control-label">存储名称：</label>
      		<input type="text" name="storeName" data-val-regex-pattern="(?!^\d[A-Za-z0-9]*$)^[A-Za-z0-9_-]{1,25}$" data-val-regex="用户名只允许字母、数字、下划线、横线组成，首位只能为字母，小于25个字符。"
      		 data-val-required="请填写名称" data-val="true" class="form-control" 
      		 data-val="true" data-val-remote="可选项值已存在" data-val-remote-additionalfields="*.storeName" data-val-remote-url="<%=path %>skuManage/valueCheck.html" data-val-remote-type="post"/>
      		<span class="help-block">
      			<span data-valmsg-replace="true" data-valmsg-for="storeName" class="field-validation-valid">
			</span></span>
      		
      		<label class="control-label">图片名称：</label>
      		<input type="text" name="frontName"   data-val-length-max="64" data-val-length="可选项值小于64位字符" data-val-required="请填写名称" data-val="true" class="form-control" 
      		data-val="true" data-val-remote="可选项值已存在" data-val-remote-additionalfields="*.frontName" data-val-remote-url="<%=path %>skuManage/valueCheck.html" data-val-remote-type="post"/>
      		<span class="help-block">
      			<span data-valmsg-replace="true" data-valmsg-for="frontName" class="field-validation-valid">
			</span></span>
			
			<label for="descInfo" class="control-label">描述：</label>
			 <input type="text" name="descInfo" class="form-control"/>
			 <br>
			 <button type="button" class="btn btn-default" onclick="return skuParam.uploadImage();">上传</button>
			 </div>	
				  </div>
			</div>
      	</div>
</form:form>

<script>
				$(document).ready(function(){
				  $('input').iCheck({
				    checkboxClass: 'icheckbox_square-red',
				    radioClass: 'iradio_square-blue',
				    increaseArea: '20%'
				  });
				});
</script>
</BODY>

</HTML>
