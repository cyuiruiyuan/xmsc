<%--
  Created by IntelliJ IDEA.
  User: 87909
  Date: 2021/1/15
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>小米商城后台管理系统</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <style type="text/css">
        iframe{
            width: 1680px;
            height: 776px;
            padding: 20px;
        }
    </style>
</head>

<body class="layui-layout-body">
<%--<%--%>
<%--    if(session.getAttribute("manager") == null){--%>
<%--        //如果session中没有manager则判定为管理员未登录，跳转至login.jsp--%>
<%--        request.setAttribute("errorMsg","请先登录！");--%>
<%--        request.getRequestDispatcher("login.jsp").forward(request,response);--%>
<%--    }--%>
<%--%>--%>
<div class="layui-layout layui-layout-admin">

    <div class="layui-header">


        <div class="layui-logo">小米商城后台管理系统</div>
        <!--顶部导航栏-->

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="${sessionScope.manager.managerImg}" class="layui-nav-img">${sessionScope.manager.managerName}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退出</a></li>
        </ul>
    </div>
    <!--左侧导航栏-->
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">类别管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="type_add.jsp" target="mainFrame">添加类别</a></dd>
                        <dd><a href="TypeListServlet" target="mainFrame">类别列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">商品管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="GoodsListTypeServlet" target="mainFrame">发布商品</a></dd>
                        <dd><a href="GoodsListServlet?pageNum=1" target="mainFrame">商品列表</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body" style="padding: 15px 15px 0px 15px;">
        <iframe name="mainFrame" width="100%" height="100%" frameborder="0"></iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © 软工1803龚添-小米商城后台管理系统
    </div>

</div>
<script src="layui/layui.all.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>