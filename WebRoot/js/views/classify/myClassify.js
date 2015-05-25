(function($) {
	
	var createPart = function(part) {
		$("#" + part + "-plane ul.list li").click(function() {
			for (var i = 0; i < $("ul.list li").length; i++) {
				$($("#" + part + "-plane ul.list li")[i]).removeClass("active");
			}
			if ($(this).attr("class") === "delete") {
				return;
			}
			$(this).addClass("active");
		});

		$("#add-" + part + "-class").click(function() {
			$("#addClassify").modal("show");
			$("#classifyName").val("");
			$("#addClassify button.commit").click(function() {
				$("<li>").html($("#classifyName").val().trim()).appendTo($("#" + part + "-plane ul.list"));
				myClassify.refresh(part);
				$("#addClassify").modal('hide');
			});
		});

		$("#modify-" + part + "-class").click(function() {
			$("#modifyClassify").modal('show');
			var value = $("#" + part + "-plane ul.list li.active").html().trim();
			$("#modifyClassify input[name='classifyName']").val(value);
			$("#modifyClassify button.commit").click(function() {
				$("#" + part + "-plane ul.list li.active").html($("#modifyClassify input[name='classifyName']").val().trim());

				$("#modifyClassify").modal('hide');
			});
		});

		$("#delete-" + part + "-class").click(function() {
			var $currentItem = $("#" + part + "-plane ul.list li.active");
			if(confirm("确定要删除分类--"+$currentItem.html().trim()+"吗？")) {
				$currentItem.addClass("delete");
			}
		});
	};

	window.myClassify = $.fn.myClassify = {

		init: function(part) {
			switch (part) {
				case "left":
					createPart("left");
					break;
				case "middle":
					createPart("middle");
					break;
				case "right":
					createPart("right");
					break;
			}
		},

		//	刷新三栏，将事件重新绑定
		refresh: function(part) {
			$("#" + part + "-plane ul.list li").click(function() {
				for (var i = 0; i < $("ul.list li").length; i++) {
					$($("#" + part + "-plane ul.list li")[i]).removeClass("active");
				}
				if ($(this).attr("class") === "delete") {
					return;
				}
				$(this).addClass("active");
			});
		}

	};

})(jQuery);

$(document).ready(function() {

	myClassify.init("left");
	myClassify.init("middle");
	myClassify.init("right");

});