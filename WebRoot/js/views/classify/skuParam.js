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
					url: basePath + "skuManage/insertSkuAttr.html?" + new Date().getTime(),
					dataType: "json",
					async: false,
					data: $("#addSkuForm").serialize(),
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
		$("#propertyModal h4.modal-title")[0].innerHTML = "添加SKU属性值";
		$("#propertyModal button.commit")[0].innerHTML = "添加";
		$("#frontName").val("");
		$("#nameDes").val("");
		$("#propertyModal").modal('show');
		$("#choosePic").show();
		$("#changeMessage").parent().hide();

		$("#propertyModal button.commit")[0].onclick = function() {
			if($("#addSkuForm").valid()) {
				var setting = {
				category: "skuValue",
				status: "disable",
				inputBoxValue: $("#frontName").val().trim(),
				inputBoxDes: $("#nameDes").val().trim()
			};
			
				$("#enable").on("ifChecked",function(event){
					setting.status = "enable";
				});
			
				$("#disable").on("ifChecked", function(event){
					setting.status = "disable";
				});

				var $group = PropertyGroup.init(setting);
				$("#right-plane ul.list").append($group);
				$("#propertyModal").modal('hide');
			}
			
		};
	});

});