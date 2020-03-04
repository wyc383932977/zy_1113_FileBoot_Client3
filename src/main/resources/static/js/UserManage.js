function queryList() {
	var form = document.getElementById("queryList");
	form.submit();
}

function changeState(userId) {
	$.ajax({
		type: "POST",
		url: "userStateChange.ajax",
		data: {
			id: userId
		},
		dataType: "json",
		success: function (response) {
			if (response.msg == "succ") {
				var t = new $.zui.ModalTrigger({ custom: '修改成功', title: '状态修改', icon: 'heart' });
				t.show({hidden: function() {//绑定监听，同时显示
					console.log("ccc");
					queryList();
				}});
			} else {
				(new $.zui.ModalTrigger({ custom: '修改失败' })).show();
			}
		}
	});
}

function first() {
	$('#myPager').on('onPageChange', function (e, state, oldState) {
		if (state.page !== oldState.page) {
			if (state.page !== oldState.page) {
				$("#newCurrPage").val(state.page);
				queryList();
			}
		}
	});
}
