(function($) {
	window.auditList = $.fn.auditList = {
		queryData : function(pageNum) {
			$("#errorDateValidate")[0].innerHTML = "";
			var startApplyTime = $("#startApplyTime").val();
			var endApplyTime = $("#endApplyTime").val();
			if (compareTime(startApplyTime, endApplyTime, true)) {
				if (undefined == pageNum || null == pageNum) {
				pageNum = 1;
				}
				$("#pageNum")[0].value = pageNum;
				$("#queryDataForm").attr("action", basePath + "authentication/findAuthenticationInfoList.html");
				$("#queryDataForm").submit();
			} else {
				$("#errorDateValidate")[0].innerHTML = "起始日期不能大于终止日期！";
			}
		}
	};
})(jQuery);
jQuery(document).ready(function($) {
	/** 日期初始化事件 */
	$(".form_date").datetimepicker({
		language : 'zh-CN', // 默认语言
		weekStart : 1, // 一周从哪一天开始。0（星期日）到6（星期六）
		todayBtn : 1, // 日历的最下面是否有“今天”按钮
		autoclose : 1, // 选择完日期之后，是否自动关闭
		todayHighlight : 1, // 今天是否高亮
		startView : 2, // 打开之后的开始视图
		minView : 2, // 日期选择器所能提供的最精确的时间选择视图
		forceParse : 0,
		pickerPosition : "bottom-left"
	});
	if (0 != totalPageNo) {
		if (parseInt(totalPageNo) > 0) {
			$("#pagination").bootpag( {
				total : parseInt(totalPageNo),
				page : pageNum,
				maxVisible : 5,
				leaps: true
			}).on("page", function(event, goPageNum) {
				auditList.queryData(goPageNum);
			});
		}
	} else {
		if (0 == pageNum) {
			auditList.queryData();
		}
	}
});