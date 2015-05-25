(function($){

	var defaultSetting = {
		view: {
			fontCss: getFont,
			removeHoverDom: removeHoverDom,
			selectedMulti: false,
			addHoverDom: null
		},
		edit: {
			enable: false,
			showRemoveBtn: setRemoveBtn,
			showRenameBtn: setRenameBtn
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		async: {  //异步加载数据
			enable: true,
			autoParam: ["id"],
			contentType: "application/x-www-form-urlencoded",
			dataType: "text",
			otherParam: [],
			type: "post",
			url:getUrl,
			dataFilter: dataFilter
		},
		callback: {
//			beforeDrag: beforeDrag,
//			beforeDrop: beforeDrop,
			beforeEditName: beforeEditName,
			beforeRemove: beforeRemove,
			onClick: onClick,
			beforeClick: beforeClick,
			beforeExpand: beforeExpand,
			onAsyncSuccess: onAsyncSuccess,
			onAsyncError: onAsyncError
		}
	};

	var zNodes =[
	          {name:"500个节点", id:"1", count:500, times:1, isParent:true},
	          {name:"1000个节点", id:"2", count:1000, times:1, isParent:true},
	          {name:"2000个节点", id:"3", count:2000, times:1, isParent:true}
	];
	
	function dataFilter(treeId, parentNode, responseData) {
//		console.log(responseData);
		return responseData;
	}

	function onClick(event, treeId, treeNode) {
		//	alert(treeNode.name);
			//从服务器端获取规格参数或sku属性并显示
		//	$.ajax();
			if(treeNode.del) {
				return false;
			}
			
			$("#middle-plane ul.list").empty();
			$("#right-plane ul.list").empty();
			$("#add-property").hide();
			$("#add-viceProperty").hide();
			$("#add-sku").hide();
			$("#add-skuValue").hide();
			$("#choosePic").hide();
						
			if(treeNode.isParent) {
				return false;
			}
			
			var $group;
			for(var i = 0;i<20;i++) {
				var setting = {
						inputBoxValue: i,
						category: classifyTree.category
				};
				$group = PropertyGroup.init(setting);
				$("#middle-plane ul.list").append($group);
			}
			
			//查询sku属性
			$("#middle-plane input.searchInput").val("");
			$("#searchSku").click(function(){
				var $a = $("#middle-plane ul.list a"), value = $("#middle-plane input.searchInput").val().toLowerCase();
				for(var i = 0;i<$a.length;i++) {
					if($a.eq(i).html().toLowerCase() == value) {
					//	$a.eq(i).parent().css("background-color", "yellow");						
						$("#middle-plane").animate({scrollTop:$a.eq(i).offset().top-60},1000);
					
						
					}
				}
			});
			
			$("#searchSkuValue").click(function(){
				var $input = $("#right-plane ul.list input"), value = $("#right-plane input.searchInput").val().toLowerCase();
				for(var i = 0;i<$input.length;i++) {
					if($input.eq(i).val().toLowerCase() == value) {
						$("#right-plane").animate({scrollTop:$input.eq(i).offset().top-60},1000);
					}
				}
			});
			
			$("[data-toggle='tooltip']").tooltip();
	}

	function beforeClick(treeId, treeNode, clickFlag) {
		if(treeNode.drop) {
			return false;
		}
		else {
			return true;
		}
	}

	function beforeDrag(treeId, treeNodes) {
		for (var i=0,l=treeNodes.length; i<l; i++) {
			if (treeNodes[i].drag === false) {
				return false;
			}
		}
		return true;
	}
	function beforeDrop(treeId, treeNodes, targetNode, moveType) {

		return targetNode ? targetNode.drop !== false : true;
	}

	function getFont(treeId, treeNode) {
		if(treeNode.del) {
			return {color:"grey"};
		}
		else {
			return {};
		}
	}

	function setRemoveBtn(treeId, treeNode) {
		if(treeNode.del) {
			return false;
		}
		else {
			return true;
		}
	}

	function setRenameBtn(treeId, treeNode) {
		if(treeNode.del) {
			return false;
		}
		else {
			return true;
		}
	}

	function beforeRemove(treeId, treeNode) {
		if(confirm("确定删除分类---"+treeNode.name+"吗?")) {
			iter(treeNode);
		}
		return false;
	}

	function iter(item) {
		if(item.isParent) {
			item.del = true;
			var zTree = $.fn.zTree.getZTreeObj(classifyTree.treeId);
			zTree.updateNode(item, true);
			var children = item.children;
			$.each(children, function(i,kk){
				iter(kk);
			});
		} else {
			item.del = true;
			var zTree = $.fn.zTree.getZTreeObj(classifyTree.treeId);
			zTree.updateNode(item, true);
			return;
		}
	}

	var newCount = 1;
	function addHoverDom(treeId, treeNode) {
		if(treeNode.del) {
			return null;
		}
		var sObj = $("#" + treeNode.tId + "_span");
		if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
		var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
			+ "' title='add node' onfocus='this.blur();'></span>";
		sObj.after(addStr);
		var btn = $("#addBtn_"+treeNode.tId);
		if (btn) btn.bind("click", function(){
			var zTree = $.fn.zTree.getZTreeObj(classifyTree.treeId);

			$("#addClassify").modal('show');

			return false;
		});

	};

	function beforeEditName(treeId, treeNode) {
		$("#modifyClassify").modal('show');
		$("input[name='classifyName']")[1].value = treeNode.name;
		return false;
	}

	function removeHoverDom(treeId, treeNode) {
		$("#addBtn_"+treeNode.tId).unbind().remove();
	}
	
	var perCount = 100;
	function getUrl(treeId, treeNode) {
		//根据父节点加载其子节点
//		var curCount = (treeNode.children) ? treeNode.children.length:0;
//		var getCount = (curCount + perCount) > treeNode.count ? (treeNode.count - curCount) : perCount;
//		var param = "id="+treeNode.id+"_"+(treeNode.times++) +"&count="+getCount;
//		console.log(param);
		return basePath + "classify/getChildNodes.html";
	}

	function beforeExpand(treeId, treeNode) {
		if(!treeNode.isAjaxing) {
			ajaxGetNodes(treeNode, "refresh");
			return true;
		} else {
			alert("zTree正在下载数据中，请稍后展开");
			return false;
		}
	}
	
	function ajaxGetNodes(treeNode, reloadType) {
		var zTree = $.fn.zTree.getZTreeObj(classifyTree.treeId);
		if (reloadType == "refresh") {
			treeNode.icon = basePath + "css/zTreeStyle/img/loading.gif";
			zTree.updateNode(treeNode);
		}
		zTree.reAsyncChildNodes(treeNode, reloadType, true);
	}
	
	function onAsyncSuccess(event, treeId, treeNode, msg) {
		if (!msg || msg.length == 0) {
			return;
		}
		var zTree = $.fn.zTree.getZTreeObj(classifyTree.treeId),
		totalCount = treeNode.count;
//		if (treeNode.children.length < totalCount) {
//			setTimeout(function() {ajaxGetNodes(treeNode);}, perTime);
//		} else {
//			treeNode.icon = "";
//			zTree.updateNode(treeNode);
//			zTree.selectNode(treeNode.children[0]);
//			endTime = new Date();
//			var usedTime = (endTime.getTime() - startTime.getTime())/1000;
//			className = (className === "dark" ? "":"dark");
//			showLog("[ "+getTime()+" ]&nbsp;&nbsp;treeNode:" + treeNode.name );
//			showLog("加载完毕，共进行 "+ (treeNode.times-1) +" 次异步加载, 耗时："+ usedTime + " 秒");
//		}
		
		treeNode.icon = "";
		zTree.updateNode(treeNode);
		zTree.selectNode(treeNode.children[0]);
	}
	
	function onAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
		var zTree = $.fn.zTree.getZTreeObj(classifyTree.treeId);
		alert("异步获取数据出现异常。");
		treeNode.icon = "";
		zTree.updateNode(treeNode);
	}
	
	window.classifyTree = $.fn.classifyTree = {
		treeId: "treeDemo",
		customSetting: defaultSetting,
		category: "mainProperty",
		
		initTree: function() {
			var setting = $.extend({},defaultSetting, classifyTree.customSetting);
			$.fn.zTree.init($("#"+classifyTree.treeId), setting, zNodes);

		}

	};

})(jQuery);

$(document).ready(function(){

});
