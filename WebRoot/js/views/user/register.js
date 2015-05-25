/**
 * 
 */

(function($){
	window.register = $.fn.register = {
		/**
		 * 快速注册
		 */
		quickRegister : function() {
			if($("#registerForm").valid()&&$("#agreement").is(':checked')) {
				if(!$("#agreement").is(':checked')) {
					alert("请同意服务协议");
					return;
				}
				$("#registerForm").attr('action', basePath + "user/registUser.html?" + new Date().getTime());
				$("#registerForm").submit();
			}
		},
		/**
		 * 重发激活邮件
		 */
		sendMailAgain : function(email) {
			$.ajax({
				url : basePath + "user/sendEmailAgain.html?" + new Date().getTime(),
				type : "post",
				dataType : "json",
				data : {
					email : email
				},
				async : false,
				success : function(data) {
					alert("激活邮件发送成功！", "提示信息");
				},
				error : function(data) {
					alert("激活邮件发送失败，请点击重发！", "提示信息");
				}
			});
		}
		
	};
})(jQuery);

jQuery(document).ready(function($) {
	$("#verificationCodeImg").click(function() {
		$("#verificationCodeImg").attr("src", basePath + "util/captcha?timestamp=" + new Date().getTime());
	});
});

