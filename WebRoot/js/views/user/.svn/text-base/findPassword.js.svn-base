(function($) {
	window.findPwd = $.fn.findPwd = {
		
		/**
		 * 重新生成验证码
		 */
		refreshCaptcha : function() {
			$("#verificationCodeImg").attr("src", basePath + "util/captcha?timestamp=" + new Date().getTime());
		},
		/**
		 * 找回密码
		 */
		findPassword : function() {
			if($("#findPwdForm").valid()) {
				$("#findPwdForm").attr("action", basePath + "user/findPassword.html");
				$("#findPwdForm").submit();
				$.jBox.tip("请等待...", 'loading');
			}
		},
		/**
		 * 重发找回密码邮件
		 * 
		 * @param {Object}
		 *            email
		 */
		sendFindPwdMailAgain : function() {
			$.ajax({
				url : basePath + "user/sendFindPwdMailAgain.html?" + new Date().getTime(),
				type : "post",
				dataType : "json",
				data : {
					email : $("#email").val()
				},
				async : false,
				success : function(data) {
					result = data.result;
					if(result === 'false') {
						alert("找回密码邮件发送失败，请点击重发！", "提示信息");
					} else {
						alert("找回密码邮件发送成功！", "提示信息");
					}
				},
				error : function(data) {
					alert("找回密码邮件发送失败，请点击重发！", "提示信息");
				}
			});
		},
		
		/**
		 * 重置密码
		 */
		resetPwd : function() {
			if($("#resetPwdForm").valid()) {
				$("findPwdButton").attr("disabled","true");
				$("#resetPwdForm").attr("action", basePath + "user/resetPwd.html");
				$("#resetPwdForm").submit();
			}
		}
	};
})(jQuery);
