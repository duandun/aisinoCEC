(function($) {
	window.userInfo = $.fn.userInfo = {
		/**
		 * 保存用户企业信息
		 * @return {TypeName} 
		 */
		saveUserInfo : function() {
			if($("#userInfoForm").valid()){
				$.ajax( {
					url : basePath + "user/saveUserInfo.html?" + new Date().getTime(),
					type : "post",
					dataType : "json",
					data : $("#userInfoForm").serialize(),
					async : true,
					success : function(data) {
						var result = data.result;
						if (result) {
							alert("完善信息成功!");
							userInfo.findUserInfoVo();
						} else {
							alert("完善信息失败!");
							return false;
						}
					},
					error : function(data) {
						alert("完善信息失败!");
						return false;
					}
				});
			}
		},

		findUserInfoVo : function() {
			$.ajax({
				url : basePath + "user/findUserInfoVo.html?" + new Date().getTime(),
				type : "post",
				dataType : "json",
				data : {
					userName : userName
				},
				async : false,
				success : function(data) {
					userInfoVo = data.userInfoVo;
					$("#userRealName")[0].value = userInfoVo.userRealName;
					if (male == userInfoVo.userGender || null == userInfoVo.userGender) {
						$("#userGenderMale").iCheck("check");
						$("#userGenderFemale").iCheck("uncheck");
					} else {
						$("#userGenderMale").iCheck("uncheck");
						$("#userGenderFemale").iCheck("check");
					}
					$("#userPhone")[0].value = userInfoVo.userPhone;
					$("#enterpriseName")[0].value = userInfoVo.enterpriseName;
					$("#userPosition")[0].value = userInfoVo.userPosition;
					if(userInfoVo.mainIndustry == null){
						$("#mainIndustry")[0].value = "";
					} else {
						$("#mainIndustry")[0].value = userInfoVo.mainIndustry;
					}
					$("#mainProduct")[0].value = userInfoVo.mainProduct;
					$(".province").attr("data-value",userInfoVo.province);
					$(".city").attr("data-value",userInfoVo.city);
					$(".district").attr("data-value",userInfoVo.district);
					$("#street")[0].value = userInfoVo.street;
					$("#userId")[0].value = userInfoVo.userId;
				},
				error : function(data) {
					alert("与服务器通信失败！请稍后重试");
				}
			});
		}
	};
})(jQuery);

jQuery(document).ready(function($) {
	$(document).ready(function(){
	  $('input').iCheck({
	    checkboxClass: 'icheckbox_square-red',
	    radioClass: 'iradio_square-blue',
	    increaseArea: '20%'
	  });
	});
	userInfo.findUserInfoVo();
	$('#element_id').cxSelect( {
		url : path + 'js/views/user/cityData.min.json', // 提示：如果服务器不支持 .json 类型文件，请将文件改为 .js 文件
		selects : [ 'province', 'city', 'district' ]
	});
});
