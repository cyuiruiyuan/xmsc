<%--
  Created by IntelliJ IDEA.
  User: 87909
  Date: 2021/1/15
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>


</head>
<body>
<div>类别管理/ 类别列表</div>
<table class="table  table-hover" style="margin-top: 15px;">
    <tr>
        <th width="20%">类别编号</th>
        <th width="20%">类别名称</th>
        <th width="40%">类别描述</th>
        <th width="20%">操作</th>
    </tr>
    <c:forEach items="${typesList}" var="t">
    <tr>
        <td>${t.typeID}</td>
        <td>${t.typeName}</td>
        <td>${t.typeDesc}</td>
        <td>
            <a href="TypeDeleteServlet?tid=${t.typeID}" class="btn btn-danger btn-xs"
            onclick="javascript:return confirm('您确定要删除${t.typeName}吗？')">
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
            </a>
            <a href="TypeQueryServlet?tid=${t.typeID}" class="btn btn-primary btn-xs">
                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
            </a>
        </td>
    </tr>
    </c:forEach>
</table>

<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
</body>
</html>
