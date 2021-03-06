<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>文档管理系统</title>

    <link href="../3rd/zui/css/zui.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/mainView.css">
    <script type="text/javascript">
        function menuJump(url){
            var showframe=document.getElementById("showView");
            showframe.src=url;
        }
    </script>
</head>

<body>
    <div class="main">
        <div class="top">
            <!-- 头部 -->
            <ul class="nav nav-tabs topTitle">
                <!-- 导航栏 -->
                <li class="active"><a href="#">主站</a></li>
                <li><a href="#">任务<span class="label label-badge label-success">4</span></a></li>
                <li>
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">更多 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">任务</a></li>
                        <li><a href="#">bug</a></li>
                        <li><a href="#">需求</a></li>
                        <li><a href="#">用例</a></li>
                    </ul>
                </li>
                <li class="face">
                    <img src="../img/akari.jpg" style="width: 30px;">
                </li>
                <li><a href="#">动态<span class="label label-badge label-success">4</span></a></li>
                <li><a href="#">个人信息</a></li>
                <li>
                    <a href="">历史记录</a>
                </li>
            </ul>
            <!-- 搜索栏 -->
            <div class="input-group search">
                <div class="input-control search-box search-box-circle has-icon-left has-icon-right search-example"
                    id="searchboxExample">
                    <input id="inputSearchExample3" type="search" class="form-control search-input" placeholder="搜索">
                    <label for="inputSearchExample3" class="input-control-icon-left search-icon"><i
                            class="icon icon-search"></i></label>
                </div>
                <span class="input-group-btn">
                    <button class="btn btn-primary" type="button">搜索</button>
                </span>
            </div>
        </div>
        <!-- 下部 -->
        <div class="centerCenter">
            <div class="left1">
                <!-- 下左部 -->
                <nav class="menu" data-ride="menu" style="width: 200px;margin: auto;">
                <!-- 树形菜单 -->
                <ul id="treeMenu" class="tree tree-menu" style="border: 1px solid #8c4bf5;" data-ride="tree">
                    <c:forEach var="menu" items="${requestScope.adminMenu}">
                        <c:if test="${menu.fid==0 }">
                            <li >
                                <a href="#"><i class="icon icon-user"></i>${menu.name}</a>
                                <ul>
                                    <c:forEach var="sonMenu" items="${requestScope.adminMenu }">
                                        <c:if test="${sonMenu.fid==menu.id }">
                                            <li><a href="#" onclick="menuJump('${sonMenu.url}')">${sonMenu.name}</a></li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </li>
                        </c:if>
                    </c:forEach>
                </ul>
                </nav>
            </div>
            <div id="centerView" >
                <iframe id="showView" src="" frameborder="0" width="100%" height="99%"></iframe>
            </div>

            <div style="border-left: 1px solid #000000;">
                <!-- 轮播图片 -->
                <div id="myNiceCarousel" class="carousel slide phone" data-ride="carousel">
                    <!-- 圆点指示器 -->
                    <ol class="carousel-indicators">
                        <li data-target="#myNiceCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#myNiceCarousel" data-slide-to="1"></li>
                        <li data-target="#myNiceCarousel" data-slide-to="2"></li>
                    </ol>

                    <!-- 轮播项目 -->
                    <div class="carousel-inner">
                        <div class="item active">
                            <img alt="First slide" style="height:150px" src="../img/wsj.jpg">
                            <div class="carousel-caption">
                                <!-- <h3>我是第一张幻灯片</h3>
                                <p>:)</p> -->
                            </div>
                        </div>
                        <div class="item">
                            <img alt="Second slide" style="height:150px" src="../img/lh.jpg">
                            <div class="carousel-caption">
                                <!-- <h3>我是第二张幻灯片</h3>
                                <p>0.0</p> -->
                            </div>
                        </div>
                        <div class="item">
                            <img alt="Third slide" style="height:150px" src="../img/true.jpg">
                            <div class="carousel-caption">
                                <!-- <h3>我是第三张幻灯片</h3>
                                <p>最后一张咯~</p> -->
                            </div>
                        </div>
                    </div>

                    <!-- 项目切换按钮 -->
                    <a class="left carousel-control" href="#myNiceCarousel" data-slide="prev">
                        <span class="icon icon-chevron-left"></span>
                    </a>
                    <a class="right carousel-control" href="#myNiceCarousel" data-slide="next">
                        <span class="icon icon-chevron-right"></span>
                    </a>
                </div>
            </div>
        </div>

    </div>
</body>
<script src="../3rd/jquery.js"></script>
<script src="../js/zui.min.js"></script>

</html>