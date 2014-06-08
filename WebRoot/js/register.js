jQuery(function($) {
		$("#check_custom_password").blur(function() {
			var pass = $("#custom_password").val();
			var comfirmPass = $("#check_custom_password").val();
			if (pass == comfirmPass) {
				$("#msg1").html("");
			} else {
				$("#msg1").html("<font color='red'>两次密码输入不一致</font>");
			}

		});
		$("#custom_Email").blur(function() {
			var email = $("#custom_Email").val();
			var r_email = /^\w\w+@\w+\.[a-zA-Z]{2,7}$/;
			if (r_email.test(email)) {
				$("#msg2").html("");
			} else {
				$("#msg2").html("<font color='red'>邮箱格式不符</font>");
			}
		});
		$("#custom_Phone").blur(function() {
			var phone = $("#custom_Phone").val();

			var r_phone = /^1[3,4,5,8][0-9]\d{8}$/;
			if (r_phone.test(phone)) {
				$("#msg3").html("");

			} else {
				$("#msg3").html("<font color='red'>手机号码格式不符，应为11位数字</font>");
			}
		});
		$("#custom_QQ").blur(function() {
			var QQ = $("#custom_QQ").val();
			var r_QQ = /^[1-9][0-9]{4,9}$/;//腾讯QQ是从10000开始的，目前只有10位

			if (r_QQ.test(QQ)) {
				$("#msg5").html("");
				$("#submit").removeAttr("disabled");
			} else {
				$("#msg5").html("<font color='red'>QQ号码格式不符，应为6-10位数字</font>");
			}
		});
		$("#custom_ID").blur(function() {
			var ID = $("#custom_ID").val();
			var r_ID = /^(\d{15}|\d{18}|\d{17}[a-zA-Z]{1})$/;
			if (r_ID.test(ID)) {
				$("#msg4").html("");

			} else {
				$("#msg4").html("<font color='red'>身份证输入有误</font>");
			}
		});

		$("#login_name,#custom_Name,#custom_sex,#custom_Address,#check_custom_password,#custom_Email,#custom_Phone,#custom_QQ,#custom_ID")
				.blur(function() {
					var name = $("#login_name").val();
					var realname = $("#custom_Name").val();
					var gender = $("#custom_sex").val();
					var address = $("#custom_Address").val();
					var pass = $("#custom_password").val();
					var comfirmPass = $("#check_custom_password").val();
					var email = $("#custom_Email").val();
					var ID = $("#custom_ID").val();
					var QQ = $("#custom_QQ").val();
					var phone = $("#custom_Phone").val();
					
					var r_email = /^\w\w+@\w+\.[a-zA-Z]{2,7}$/;
					var r_phone = /^1[3,4,5,8][0-9]\d{8}$/;
					var r_QQ = /^[1-9][0-9]{4,9}$/;//腾讯QQ是从10000开始的，目前只有10位
					var r_ID = /^(\d{15}|\d{18}|\d{17}[a-zA-Z]{1})$/;
					
					if(name!=""&&realname!=""&&gender!=""&&address!=""&&
						pass == comfirmPass&&r_email.test(email)&&r_phone.test(phone)&&r_QQ.test(QQ)&&r_ID.test(ID)){
						$("#submit").removeAttr("disabled");
						
						$("#msg6").html("");
						$("#msg7").html("");
						$("#msg8").html("");
						$("#msg9").html("");
						$("#msg10").html("");
						$("#msg11").html("");
					}
					else{
						$("#submit").attr("disabled","disabled");
					}
				});
	});