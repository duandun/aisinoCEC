(function($) {
	window.auditDetail = $.fn.auditDetail = {
		saveAuditInfo : function() {
			if ($("#auditInfoForm").valid()) {
				$.ajax( {
					url : basePath + "auditInfo/saveAuditInfo.html?" + new Date().getTime(),
					type : "post",
					dataType : "json",
					data : $("#auditInfoForm").serialize(),
					async : true,
					success : function(data) {
						var result = data.result;
						if (result) {
							alert("审核成功!");
							window.location.href= basePath + "authentication/show/" + $("#authenticationId").val() + ".html";
						} else {
							alert("审核失败!");
							return false;
						}
					},
					error : function(data) {
						alert("审核失败!");
						return false;
					}
				});
			}
		},
		goBack : function() {
			window.location.href = basePath + "authentication/findAuthenticationInfoList.html?" + new Date().getTime();
		}
	};
})(jQuery);
jQuery(document).ready(function($) {
	$('input').iCheck( {
		checkboxClass : 'icheckbox_square-red',
		radioClass : 'iradio_square-blue',
		increaseArea : '20%'
	});
});