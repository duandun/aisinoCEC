(function($) {
	window.etrAuth = $.fn.etrAuth = {
		/**
		 * 发起认证申请或者是编辑认证信息或者是查看认证信息
		 */
		etrAuthentication : function() {
			if($("#etrAuthStatusForm").valid()) {
				$("#etrAuthStatusForm").attr("action", basePath + "authentication/toEtrAuthenticationPage.html");
				$("#etrAuthStatusForm").submit();
			}
		},
		
		applyAuth : function() {
			if($("#etrAuthenticationForm").valid()) {
				$("applyButton").attr("disabled","true");
				$("#etrAuthenticationForm").attr("action", basePath + "authentication/applying.html");
				$("#etrAuthenticationForm").submit();
			}
		},
		goBack : function() {
			history.back(-1);
		}
	};
})(jQuery);
