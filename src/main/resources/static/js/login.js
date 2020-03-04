function myRefersh() {
	var e = document.getElementById("verifyCode");
	const source = e.src; // 获得原来的 src 中的内容
	//console.log( "source : " + source  ) ;

	var index = source.indexOf("?");  // 从 source 中寻找 ? 第一次出现的位置 (如果不存在则返回 -1 )
	//console.log( "index : " + index  ) ;

	if (index > -1) { // 如果找到了 ?  就进入内部
		var s = source.substring(0, index); // 从 source 中截取 index 之前的内容 ( index 以及 index 之后的内容都被舍弃 )
		//console.log( "s : " + s  ) ;

		var date = new Date(); // 创建一个 Date 对象的 一个 实例
		var time = date.getTime(); // 从 新创建的 Date 对象的实例中获得该时间对应毫秒值
		e.src = s + "?time=" + time; // 将 加了 尾巴 的 地址 重新放入到 src 上

		//console.log( e.src ) ;
	} else {
		var date = new Date();
		e.src = source + "?time=" + date.getTime();
	}
}

function registerViewShow() {//注册界面切换
	window.location.href = "register.html";
}

function login() {
	var userAccount = document.getElementById("userAccount");
	var accountVal = userAccount.value.trim();
	var userpswd = document.getElementById("userpswd");
	var pswdVal = userpswd.value.trim();
	if (accountVal == "" || pswdVal == "") {
		alert("请输入账号或者密码");
		return;
	}
	var qverifyCodeFri = $("#qverifyCode").val();
	var qverifyCode = qverifyCodeFri.trim();
	if (qverifyCode == "") {
		alert("请输入验证码");
		return;
	}
	//    if(accountVal.length<5 || accountVal.length>18){
	//        alert("账号需在5~18位");
	//        return;
	//    }
	//    if (pswdVal.length<6 ||pswdVal.length>10) {
	//        alert("密码需在6~10位");
	//        return;
	//    }
	$.ajax({
		url: "login.ajax",
		type: "POST",
		data: {
			account: accountVal,
			password: pswdVal,
			qverifyCode: qverifyCode
		},
		dataType: "json",
		success: function (response) {
			var isLogin = response.ISLOGIN;
			console.log(isLogin);

			if (isLogin == "SUCCEED") {
				// alert("登录成功");
				console.log("登录成功");
				window.location.href = "mainViewShow.html";
			} else {
				if (isLogin == "INPUTERROR") {
					(new $.zui.ModalTrigger({ custom: '账户密码输出错误' })).show();
				} else if (isLogin == "UNFILLED") {
					(new $.zui.ModalTrigger({ custom: '输出空白' })).show();
				} else if (isLogin == "verifyCodeError") {
					(new $.zui.ModalTrigger({ custom: '验证码错误' })).show();
				} else if (isLogin == "USERSTOP") {
					(new $.zui.ModalTrigger({ custom: '用户被禁用' })).show();
				}
				console.log("怎么回事");
				// $("#userpswd").val("");
				// $("#qverifyCode").val("");
				myRefersh();
			}
		},
		error: function () {
		}
	});

	//TOOD 取值,判断
	//获取表单元素,把form表单进行提交
	// var form=document.getElementById("loginForm");
	// form.submit();//一键提交
	//    window.location.href="mainView.html";
}

function register() {
	var account = $("#inputAccountExample3").val().trim();
	var password = $("#inputPasswordExample3").val().trim();
	if (account == "" || password == "") {
		alert("请输入账号或者密码");
		return;
	}
	$.ajax({
		url: "loginRegisterController",
		type: "POST",
		data: {
			account: account,
			password: password,
		},
		dataType: "text",
		success: function (response) {
			if (response == "succeed") {
				console.log(response);
			} else {
				console.log(response);
			}
		},
		error: function () {
		}
	});
}

function cancelRegister() {
	history.back(-1);
}