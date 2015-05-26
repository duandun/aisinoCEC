/**
 * 添加属性和SKU时候的输入框控件，包含输入框，修改，移除，添加等操作
 */

(function($){
	
	
})(jQuery);

$(document).ready(function(){
	//添加SKU属性
	$("#add-sku").click(function() {
		$("#propertyModal h4.modal-title")[0].innerHTML = "添加SKU属性";
		$("#propertyModal button.commit")[0].innerHTML = "添加";
		$("#frontName").val("");
		$("#nameDes").val("");
		$("#changeMessage").parent().hide();
		$("#propertyModal").modal('show');

		var zTree = $.fn.zTree.getZTreeObj(classifyTree.treeId);
		//当前被选中的树节点集合
		var nodes = zTree.getSelectedNodes();
		//当前被选中的树节点
		var node = nodes[0];
		
		$("#addSkuForm input[name='categoryId']").val(node.categoryId);
		
		$("#propertyModal button.commit")[0].onclick = function() {
			
			if($("#addSkuForm").valid()) {
				var setting = {
						category: "skuProperty",
						status: "disable",
						inputBoxValue: $("#frontName").val().trim(),
						inputBoxDes: $("#nameDes").val().trim()
				};

				$.ajax({
					type:"post",
					url: basePath + "skuManage/insertSkuAttr/"+node.categoryId+".html?" + new Date().getTime(),
					dataType: "json",
					async: false,
					data:  $("#addSkuForm").serialize(),
					success: function(data) {
						if(data.result=="true") {
							$("#enable").on("ifChecked",function(event){
								setting.status = "enable";
							});
							
							$("#disable").on("ifChecked", function(event){
								setting.status = "disable";
							});
							setting.propertyId = data.skuAttrId;
							var $group = PropertyGroup.init(setting);
							$("#middle-plane ul.list").append($group);
						
							$("#propertyModal").modal('hide');
						} else {
							alert("出错了!");
						}
					},
					error: function(data) {
						console.log(data);
						alert("ajax出错了!");
					}
				});
				
				
			}
			
		};
	});
	
	

	//添加SKU属性值
	$("#add-skuValue").click(function() {
		
		$("#propertyValueModal h4.modal-title")[0].innerHTML = "添加SKU属性值";
		$("#propertyValueModal button.commit")[0].innerHTML = "添加";
		$("#value").val("");
		$("#addSkuValueForm div input[name='descInfo']").val("");
		$("#propertyValueModal").modal('show');
		$("#choosePic").show();
		$("#addSkuValueForm div input[name='modifyInfo']").parent().hide();
		var skuAttrId = $("#right-plane div.mainProperty label").attr("skuAttrId");
		$("#addSkuValueForm input[name='skuAttrId']").val(skuAttrId);
		
		$("#propertyValueModal button.commit")[0].onclick = function() {
			if($("#addSkuValueForm").valid()) {
				var setting = {
						category: "skuValue",
						status: "disable",
						inputBoxValue: $("#value").val().trim(),
						inputBoxDes: $("#addSkuValueForm div input[name='descInfo']").val().trim()
				};
			
				$("#enable").on("ifChecked",function(event){
					setting.status = "enable";
				});
			
				$("#disable").on("ifChecked", function(event){
					setting.status = "disable";
				});
				
				$.ajax({
					url: basePath + "skuManage/insertSkuOption/" +skuAttrId+".html?" + new Date().getTime(),
					dataType: "json",
					type: "post",
					async: false,
					data: $("#addSkuValueForm").serialize(),
					success: function(data) {
						if(data.result=="true") {
							$("#enable").on("ifChecked",function(event){
								setting.status = "enable";
							});
							
							$("#disable").on("ifChecked", function(event){
								setting.status = "disable";
							});
							setting.propertyId = data.skuOptionId;
							var $group = PropertyGroup.init(setting);
							$("#right-plane ul.list").append($group);
						
							$("#propertyModal").modal('hide');
						} else {
							alert("出错了!");
						}
					},
					error: function(data) {
						alert("ajax出错了！");
					}
				});
			}
			
		};
	});

});