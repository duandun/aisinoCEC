/**
 * 添加属性和SKU时候的输入框控件，包含输入框，修改，移除，添加等操作
 */

(function($) {


})(jQuery);

$(document).ready(function() {

	//初始化上传图片窗口
	$("#picUploadForm").appendTo('body');
	$("#picUploadForm").hide();

	$("#choosePic").click(function() {

		$("#picUploadForm").show();
		$("#choosePic").parent().after($("#picUploadForm"));
		$("#picUploadForm div input[name='frontName']").val("");
		$("#picUploadForm div input[name='descInfo']").val("");

		$("#picUploadForm div.picPanel button").click(function() {
			$("#picUploadForm").appendTo('body');
			$("#picUploadForm").hide();
		});
	});

	window.skuParam = $.fn.skuParam = {
			
		resetDialog: function() {
			$.ajax({
				url: basePath+"skuManage/clearImg.html?"+new Date().getTime(),
				dataType: "json",
				type: "get",
				data:{},
				async: false,
				success: function(data) {
					var result = data.result;
					if(result=="success") {
						$("#value").val("");
						$("#addSkuValueForm div input[name='descInfo']").val("");
						$("#addSkuValueForm div input[name='modifyInfo']").val("");
						$("#picUploadForm div input[name='frontName']").val("");
						$("#picUploadForm div input[name='descInfo']").val("");
						$("#displayImg").html("");
					}
				},
				error: function(data) {
					alert("出错了！");
				}
			});
		},
		
		uploadImage: function() {
			$("#uploadImg").ajaxStart(function() {
				//	$.jBox.tip("正在上传...", 'loading');
				console.log("正在上传。。。。");
			}).ajaxComplete(function() {
				//	$.jBox.closeTip();
			});
			var file = $("#uploadImg").val();
			if (file == "") {
				//	$.jBox.info('请选择上传的图片!', '提示');
				return false;
			} else {
				// 判断上传的文件的格式是否正确
				var fileType = file.substring(file.lastIndexOf(".") + 1)
					.toLowerCase();
				if (fileType != "jpg" && fileType != "png" && fileType != "gif" && fileType != "bmp" && fileType != "jpeg") {
					//	$.jBox.info('上传图片格式错误', '提示');
					alert("上传图片格式错误");
					return false;
				} else {
					$.ajaxFileUpload({
						//	url : basePath + "loan/uploadContractPictures.html",
						//填写上传图片url
						url: basePath + "skuManage/uploadImage.html?" + new Date().getTime(),
						secureuri: false,
						fileElementId: 'uploadImg',
						dataType: 'JSON',
						data: {
							frontName: $("#picUploadForm div input[name='frontName']").val(),
							descInfo: $("#picUploadForm div input[name='descInfo']").val()
						},
						type: "post",
						success: function(data) {
							//console.log($("#picUploadForm").serialize());
							console.log(data);
						//	console.log(data.uploadResultCode);
							var json = eval("(" + data + ")");
						//	console.log(json);
							if ("NONE" == json.uploadResultCode) {
								//	$.jBox.info("图片没有上传成功!", "提示");
							} else if ("NOTALLOW" == json.uploadResultCode) {
								//	$.jBox.info("上传图片格式错误,要求为jpg、gif、png、jpeg或bmp!", "提示");
							} else if ("toBig" == json.uploadResultCode) {
								//	$.jBox.info("上传的文件最大为5MB!", "提示");
							} else if ("SUCCESS" == json.uploadResultCode) {
								
								
								var $img = $("<img>").attr("src", json.imageData).css("width", "50px").css("height", "50px").appendTo($("#displayImg"));
								$("<button>").addClass("btn btn-default").html("删除").appendTo($("#displayImg")).click(function() {
									var that = this;
									var result = skuParam.removeImg(json.imageId, function(data) {									
										if(data.result == "success") {
											$img.remove();
											
											$(that).remove();
										}
									});
									
								});
								
								$("#imgPreview").attr("src", json.imageData);
								$("#uploadImg").val("");
							} else {
								if ("failure" == json.uploadResultCode) {
									//		$.jBox.error("上传失败！请重试", "提示信息");
									alert("上传失败");
									return false;
								}
							}
						},
						error: function(data, status, e) {
							//	$.jBox.error("与服务器通信失败！请稍后重试", "提示信息");
							console.log(data);
							alert("出错了！");
							return false;
						}
					});
				}
			}
		},
		
		removeImg: function(imageId, callback) {
			var result;
			$.ajax({
				url: basePath + "skuManage/removeImg.html?" + new Date().getTime(),
				dataType: "json",
				type: "post",
				async: false,
				data: {
					imageId: imageId
				},
				success: function(data) {
					callback&&callback(data);
				},
				error: function(data)  {
					alert("删除出错了！");
					result = data.result;
				}
			});
			
		}
		
	};

	//添加SKU属性
	$("#add-sku").click(function() {
		$("#propertyModal h4.modal-title")[0].innerHTML = "添加SKU属性";
		$("#propertyModal button.commit")[0].innerHTML = "添加";
		$("#frontName").val("");
		$("#nameDes").val("");
		$("#maintainName").val("");
		$("#changeMessage").parent().hide();
		$("#propertyModal").modal('show');

		var zTree = $.fn.zTree.getZTreeObj(classifyTree.treeId);
		//当前被选中的树节点集合
		var nodes = zTree.getSelectedNodes();
		//当前被选中的树节点
		var node = nodes[0];

		$("#addSkuForm input[name='categoryId']").val(node.categoryId);
		$("#addSkuForm input[name='skuAttrId']").val("");

		//清除之前的错误信息
		$("#addSkuForm").validate().resetForm();
		$("#addSkuForm div span span").html("");
		$("#propertyModal button.commit")[0].onclick = function() {

			if ($("#addSkuForm").valid()) {
				var setting = {
					category: "skuProperty",
					status: "disable",
					inputBoxValue: $("#frontName").val().trim(),
					inputBoxDes: $("#nameDes").val().trim()
				};

				$.ajax({
					type: "post",
					url: basePath + "skuManage/insertSkuAttr/" + node.categoryId + ".html?" + new Date().getTime(),
					dataType: "json",
					async: false,
					data: $("#addSkuForm").serialize(),
					success: function(data) {
						if (data.result == "true") {
							$("#enable").on("ifChecked", function(event) {
								setting.status = "enable";
							});

							$("#disable").on("ifChecked", function(event) {
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

		//清除之前的错误信息
		$("#addSkuValueForm").validate().resetForm();
		$("#addSkuValueForm div span span").html("");
		$("#addSkuValueForm div input[name='modifyInfo']").parent().hide();
		var skuAttrId = $("#right-plane div.mainProperty label").attr("skuAttrId");
		$("#addSkuValueForm input[name='skuAttrId']").val(skuAttrId);
		$("#addSkuValueForm input[name='skuOptionId']").val("");

		$("#propertyValueModal button.commit")[0].onclick = function() {
			if ($("#addSkuValueForm").valid()) {
				var setting = {
					category: "skuValue",
					status: "disable",
					inputBoxValue: $("#value").val().trim(),
					inputBoxDes: $("#addSkuValueForm div input[name='descInfo']").val().trim()
				};

				$("#enable").on("ifChecked", function(event) {
					setting.status = "enable";
				});

				$("#disable").on("ifChecked", function(event) {
					setting.status = "disable";
				});

				$.ajax({
					url: basePath + "skuManage/insertSkuOption/" + skuAttrId + ".html?" + new Date().getTime(),
					dataType: "json",
					type: "post",
					async: false,
					data: $("#addSkuValueForm").serialize(),
					success: function(data) {
						if (data.result == "true") {
							$("#enable").on("ifChecked", function(event) {
								setting.status = "enable";
							});

							$("#disable").on("ifChecked", function(event) {
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