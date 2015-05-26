/**
 * 添加属性和SKU时候的输入框控件，包含输入框，修改，移除，添加等操作
 */

(function($) {
	var defaultSetting = {
		category: "mainProperty", //标示所构建的输入框控件类型，mainProperty为一级属性控件，viceProperty为二级属性控件，
		//skuProperty为sku属性控件，skuValue为sku属性值控件
		status: "mod", //确认此输入框的状态，mod代表“显示修改”，add代表“添加”，del代表“已删除”
		inputBoxValue: "", //inputbox输入框中的内容
		inputBoxDes: "", //分类描述
		picBoxValue: "", //图片输入框中的内容
		propertyId: "" //当前属性Id
	};

	var createMainProperty = function(setting) {
		var $inputBox, $opButton, $reButton, $disButton, $group, $a;
		$reButton = $("<button>").attr("class", "btn btn-primary btn-sm").attr("type", "button").html("移除");
		$disButton = $("<button>").attr("class", "btn btn-primary btn-sm").html("显示二级属性");
		//加入bootstrap  tooltip插件
		//			$inputBox = $("<input>").val(setting.inputBoxValue).css("width", "100px").attr("data-toggle", "tooltip").attr("title","this is ");
		$a = $("<a>").attr("data-toggle", "tooltip").attr("title", setting.inputBoxDes).html(setting.inputBoxValue).attr("href", "#").attr("class", "btn btn-link");

		$opButton = $("<button>").attr("class", "btn btn-primary btn-sm");
		$group = $("<div>").append($a).append("\n").append($opButton).append("\n").append($reButton).append("\n").append($disButton).css("padding", "10px");
		$opButton.html("修改");

		//if(setting.status=="mod") {
		//				$opButton.html("修改");
		//				$inputBox.attr("disabled", "disabled");
		//			} else if(setting.status=="add") {
		//				$opButton.html("确认");
		//				$inputBox.removeAttr("disabled");
		//			}
		$opButton.click(function() {
			$("#propertyName").val($a.html());
			console.log($a);

			$("#propertyDes").val();
			$("#propertyModal h4.modal-title")[0].innerHTML = "修改主属性";
			$("#propertyModal button.commit")[0].innerHTML = "修改";
			$("#propertyModal").modal('show');
			$("#propertyModal button.commit")[0].onclick = function() {
				//todo 进行ajax调用，修改库表中的值


				//		alert($("#propertyName").val().trim());
				//		$inputBox.val($("#propertyName").val().trim());
				$a.html($("#propertyName").val().trim());
			};
		});
		$reButton.click(function() {
			//删除操作
			if (confirm("确定要删除" + $inputBox.val())) {
				//todo 从库中删除(置状态)

				$reButton.attr("disabled", "disabled");
				$inputBox.attr("disabled", "disabled");
				//		$inputBox.attr("class", "delete");
				$opButton.attr("disabled", "disabled");
			}
		});

		$disButton.click(function() {
			//显示二级属性列表(传递主属性id？或者传递主属性名称？)
			//根据主属性ID或者名称查表获得二级属性列表
			var mainPropertyId;
			$("#right-plane ul.list").empty();
			for (var i = 0; i < 5; i++) {
				var setting = {
					inputBoxValue: i,
					status: "mod"
				};

				$("#add-viceProperty").show();
				$("#right-plane div.mainProperty label").html($a.html());
				var $group = createViceProperty(setting);
				$("#right-plane ul.list").append($group);

			}

		});

		$("#add-property").show();
		$("#add-viceProperty").hide();

		return $group;
	};


	var createViceProperty = function(setting) {

		var $inputBox, $opButton, $reButton, $group, $a;

		$reButton = $("<button>").attr("class", "btn btn-primary btn-sm").html("移除");
		$inputBox = $("<input>").val(setting.inputBoxValue).attr("disabled", "disabled").css("width", "100px");
		$opButton = $("<button>").attr("class", "btn btn-primary btn-sm").html("修改");
		$group = $("<div>").append($inputBox).append("\n").append($opButton).append("\n").append($reButton).css("padding", "10px");

		$opButton.click(function() {
			$("#propertyName").val($inputBox.val());
			$("#propertyDes").val("");
			$("#propertyModal h4.modal-title")[0].innerHTML = "修改二级属性";
			$("#propertyModal button.commit")[0].innerHTML = "修改";
			$("#propertyModal").modal('show');
			$("#propertyModal button.commit")[0].onclick = function() {
				//todo 进行ajax调用，修改库表中的值
				alert($("#propertyName").val().trim());
				$inputBox.val($("#propertyName").val().trim());
			};
		});

		$reButton.click(function() {
			//删除操作
			if (confirm("确定要删除" + $inputBox.val())) {
				//todo 从库中删除(置状态)

				$reButton.attr("disabled", "disabled");
				$inputBox.attr("disabled", "disabled");
				$inputBox.attr("class", "delete");
				//	$disButton.attr("disabled", "disabled");
				$opButton.attr("disabled", "disabled");
			}
		});
		return $group;
	};

	var createSkuProperty = function(setting) {
		var $inputBox, $opButton, $reButton, $disButton, $group, $a;
		$reButton = $("<button>").attr("class", "btn btn-primary btn-sm").html("移除");
		$disButton = $("<button>").attr("class", "btn btn-primary btn-sm").html("显示SKU属性值");
		//		$inputBox = $("<input>").val(setting.inputBoxValue).css("width", "100px");
		$inputBox = $("<input>").val(setting.inputBoxValue).attr("id", setting.propertyId).attr("readonly", "readonly").css("width", "150px").addClass("form-control col-lg-6");
		$a = $("<a>").attr("data-toggle", "tooltip").attr("title", setting.inputBoxDes).html(setting.inputBoxValue).attr("href", "#").attr("class", "btn btn-link");
		$opButton = $("<button>").attr("class", "btn btn-primary btn-sm");
		$group = $("<div>").append($inputBox).append("\n").append($opButton).append("\n").append($disButton).css("padding", "10px");

		$opButton.html("修改");

		$opButton.click(function() {
			//				$("#propertyName").val($a.html());
			//				$("#propertyDes").val(setting.inputBoxDes);
			$("#choosePic").hide();
			$("#maintainName").val();
			$("#frontName").val($inputBox.val());
			$("#nameDes").val();
			$("#propertyModal h4.modal-title")[0].innerHTML = "修改SKU属性";
			$("#propertyModal button.commit")[0].innerHTML = "修改";
			$("#changeMessage").parent().show();
			$("#propertyModal").modal('show');

			$.ajax({
				url: basePath + "skuManage/skuAttr/" + $inputBox.attr("id") + ".html?" + new Date().getTime(),
				dataType: "json",
				async: false,
				type: "get",
				data: {
					//						skuAttrId: $inputBox.attr("id")
				},
				success: function(data) {
					$("#frontName").val(data.frontName);
					$("#nameDes").val(data.descInfo);
					$("#maintainName").val(data.storeName);
					var $stateRadio = $("input[name='state']"),
						$queryRadio = $("input[name='isQuery']"),
						$compsiteRadio = $("input[name='isCompsite']"),
						$requiredRadio = $("input[name='isRequired']");
					for (var i = 0; i < $stateRadio.length; i++) {
						if ($stateRadio.eq(i).val() == data.state) {
							$stateRadio.eq(i).iCheck('check');
						}
					}
					for (var i = 0; i < $queryRadio.length; i++) {
						if ($queryRadio.eq(i).val() == data.isQuery) {
							$queryRadio.eq(i).iCheck('check');
						}
					}

					for (var i = 0; i < $compsiteRadio.length; i++) {
						if ($compsiteRadio.eq(i).val() == data.isCompsite) {
							$compsiteRadio.eq(i).iCheck('check');
						}
					}
					for (var i = 0; i < $requiredRadio.length; i++) {
						if ($requiredRadio.eq(i).val() == data.isRequired) {
							$requiredRadio.eq(i).iCheck('check');
						}
					}
				},
				error: function(data) {
					alert("出错了！");
				}
			});


			$("#propertyModal button.commit")[0].onclick = function() {
				if ($("#addSkuForm").valid()) {
					$.ajax({
						url: basePath + "skuManage/updateSkuAttr.html?" + new Date().getTime(),
						dataType: "json",
						async: false,
						type: "post",
						data: $("#addSkuForm").serialize(),
						success: function(data) {
							if (data.result == "true") {
								//若状态为启用状态
								if (setting.status == "enable") {
									$group.removeClass("delete");
								}
								$("#propertyModal").modal('hide');
							}
						},
						error: function(data) {
							alert("出错了！");
						}
					});
				}

			};

			$("#enable").on("ifChecked", function(event) {
				setting.status = "enable";
			});

			$("#disable").on("ifChecked", function(event) {
				setting.status = "disable";
			});

		});

		$disButton.click(function() {
			//显示二级属性列表(传递主属性id？或者传递主属性名称？)
			//根据主属性ID或者名称查表获得二级属性列表
			var mainPropertyId, $group, skuAttrId = $inputBox.attr("id");
			$("#right-plane ul.list").empty();
			$("#add-skuValue").show();
			$("#searchSkuValue").show();
			$("#right-plane input.searchInput").show();
			$("#choosePic").show();
			$("#right-plane div.mainProperty").show();
			$("#right-plane div.mainProperty label").html($inputBox.val());
			$("#right-plane div.mainProperty label").attr("skuAttrId", skuAttrId);

			//展示sku属性值列表
			$.ajax({
				url: basePath + "skuManage/skuOption/" + skuAttrId + ".html?" + new Date().getTime(),
				dataType: "json",
				type: "get",
				async: false,
				data: {

				},
				success: function(data) {
					console.log(data);
					$.each(data, function(i, item) {
						var setting = {
							inputBoxValue: item.value,
							propertyId: item.skuOptionId
						};
						if (item.state == "sku_attr_enable") {
							setting.status = "enable";
						} else {
							setting.status = "disable";
						}
						$group = createSkuValue(setting);
						$("#right-plane ul.list").append($group);

					});

				},
				error: function(data) {
					alert("出错了！");
				}
			});

		});

		if (setting.status == "disable") {
			$inputBox.parent().addClass("delete");
		}

		$("#add-sku").show();
		$("#searchSku").show();
		$("#add-skuValue").hide();

		$("#middle-plane input.searchInput").show();

		return $group;
	};
	var createSkuValue = function(setting) {
		var $inputBox, $opButton, $reButton, $group, $a, $img, $imgDiv;

		$reButton = $("<button>").attr("class", "btn btn-primary btn-sm").html("移除");
		$inputBox = $("<input>").val(setting.inputBoxValue).attr("id", setting.propertyId).attr("readonly", "readonly").css("width", "200px").addClass("form-control col-lg-6");
		$opButton = $("<button>").attr("class", "btn btn-primary btn-sm").html("修改");
		$img = $("<img>").attr("src", setting.imgPath).css("width", "45px").css("height", "45px");
		//			$imgDiv = $("<div>").css("width", "100px").css("height", "100px").css("float", "left").append($img);
		$group = $("<div>").append($img).append("\n").append($inputBox).append("\n").append($opButton).append("\n").css("padding", "10px");

		$opButton.click(function() {
			$("#propertyName").val($inputBox.val());
			$("#propertyDes").val("");
			$("#propertyModal h4.modal-title")[0].innerHTML = "修改SKU属性值";
			$("#propertyModal button.commit")[0].innerHTML = "修改";
			$("#propertyModal").modal('show');
			$("#changeMessage").parent().show();

			$("#enable").on("ifChecked", function(event) {
				setting.status = "enable";
			});

			$("#disable").on("ifChecked", function(event) {
				setting.status = "disable";
			});
			//todo  sku属性值的修改

			$.ajax({
				url: basePath + "skuManage/skuOption/" + $inputBox.attr("id") + ".html?" + new Date().getTime(),
				dataType: "json",
				async: false,
				type: "get",
				data: {},
				success: function(data) {
					$("#value").val(data.value);
					$("#addSkuValueForm div input[name='descInfo']").val(data.descInfo);

					var $stateRadio = $("#addSkuValueForm div input[name='state']"),
						$typeInfoRadio = $("#addSkuValueForm div input[name='typeInfo']");
					for (var i = 0; i < $stateRadio.length; i++) {
						if ($stateRadio.eq(i).val() == data.state) {
							$stateRadio.eq(i).iCheck('check');
						}
					}
					for (var i = 0; i < $typeInfoRadio.length; i++) {
						if ($typeInfoRadio.eq(i).val() == data.typeInfo) {
							$typeInfoRadio.eq(i).iCheck('check');
						}
					}
				},
				error: function(data) {
					alert("出错了！");
				}
			});

			$("#propertyModal button.commit")[0].onclick = function() {
				//todo 进行ajax调用，修改库表中的值
				if ($("#addSkuValueForm").valid()) {
					$.ajax({
						url: basePath + "skuManage/updateSkuOption.html?" + new Date().getTime(),
						dataType: "json",
						async: false,
						type: "post",
						data: $("#addSkuValueForm").serialize(),
						success: function(data) {
							if (data.result == "true") {
								//若状态为启用状态
								if (setting.status == "enable") {
									$group.removeClass("delete");
								}
								$("#propertyValueModal").modal('hide');
							}
						},
						error: function(data) {
							alert("出错了！");
						}
					});
				}
			};
		});

		if (setting.status == "disable") {
			$inputBox.parent().addClass("delete");
		}

		return $group;
	};

	window.PropertyGroup = $.fn.PropertyGroup = {

		init: function(setting) {
			var setting = $.extend({}, defaultSetting, setting),
				$group;
			switch (setting.category) {
				case "mainProperty":
					$group = createMainProperty(setting);
					break;
				case "viceProperty":
					$group = createViceProperty(setting);
					break;
				case "skuProperty":
					$group = createSkuProperty(setting);
					break;
				case "skuValue":
					$group = createSkuValue(setting);
					break;
			}

			return $group;
		}

	}
})(jQuery);