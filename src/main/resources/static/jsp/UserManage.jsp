<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh_cn">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link href="../3rd/zui/css/zui.min.css" rel="stylesheet">
	<link rel="stylesheet" href="../css/UserManage.css">
	<script type="text/javascript" src="../js/UserManage.js"></script>

	<title>客户管理</title>
</head>

<body onload="first()">
	<div class="main">
		<form id="queryList" action="userManageController" method="POST">
			<div class="input-control has-label-left" style="width: 150px;margin-left: 200px;
				margin-top: 50px;">
				<input id="inputAccountExample2" type="text" class="form-control" name="account"
					value="${requestScope.account}">
				<label for="inputAccountExample2" class="input-control-label-left">用户名:</label>
			</div>
			<input type="hidden" name="newCurrPage" id="newCurrPage">
		</form>

		<div style="width: 100px;margin-left: 400px;">
			<button class="btn btn-primary" type="button" onclick="queryList();">查询</button>
		</div>
		<!-- 表格 -->
		<div style="margin-top: 60px;margin-left: 100px;">
			<table border="1" class="u10">
				<tr>
					<!-- "th"表示表头 -->
					<th>用户名</th>
					<th>名字</th>
					<th>状态</th>
					<th>积分</th>
					<th>注册时间</th>
					<th>操作</th>
				</tr>
				<c:forEach var="clientUser" items="${list }">
					<!-- 若未指定作用域,则所用作用域都找一遍 -->
					<tr>
						<td>${clientUser.account }</td>
						<td>${clientUser.name }</td>
						<td>${clientUser.stateStr }</td>
						<td>${clientUser.score }</td>
						<td>${clientUser.createTime }</td>
						<td>
							<a href="#" onclick="changeState('${clientUser.id}')">开启/禁用</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<!-- 隐藏按钮 -->
		<input type="hidden" id="currPage" value="${requestScope.pageBean.currPage }">
		<input type="hidden" id="allPage" value="${requestScope.pageBean.allPage }">

		<div style="margin: 0 auto;">
			<ul id="myPager" class="pager" data-ride="pager" data-page="${requestScope.pageBean.currPage}" data-rec-total="${requestScope.pageBean.pageNum}" data-rec-per-page="2" data-max-nav-count="4" data-elements="prev_icon,page_of_total_text,next_icon"></ul>
		</div>
	</div>
</body>

<script src="../3rd/jquery.js"></script>
<script src="../js/zui.min.js"></script>

</html>