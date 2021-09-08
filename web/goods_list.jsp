<%--
  Created by IntelliJ IDEA.
  User: 87909
  Date: 2021/1/16
  Time: 4:55
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
<div>商品管理/ 商品列表</div>
<div style="margin-top: 25px">
    商品类别：
    <c:forEach items="${typeList}" var="t">
        <c:choose>
            <c:when test="${t.typeID eq typeID}">
                <a href="GoodsListByTypeServlet?tid=${t.typeID}&pageNum=1"
                   class="btn btn-primary btn-xs">${t.typeName}</a>
            </c:when>
            <c:otherwise>
                <a href="GoodsListByTypeServlet?tid=${t.typeID}&pageNum=1"
                   class="btn btn-default btn-xs">${t.typeName}</a>
            </c:otherwise>
        </c:choose>

    </c:forEach>
</div>
<table class="table  table-hover table-bordered" style="margin-top: 15px;">
    <tr>
        <th width="10%">商品编号</th>
        <th width="25%">商品名称</th>
        <th width="16%">商品图片</th>
        <th width="12%">商品价格</th>
        <th width="12%">商品数量</th>
        <th width="25%">操作</th>

    </tr>
    <c:forEach items="${goodsList}" var="goods">
    <tr>
        <td>${goods.goodsID}</td>
        <td>${goods.goodsName}</td>
        <td><img src="${goods.goodsImg}" height="30px" /></td>
        <td>${goods.goodsPrice}</td>
        <td>${goods.goodsNum}</td>
        <td>
            <a href="GoodsDeleteServlet?goodsID=${goods.goodsID}" class="btn btn-danger btn-xs"
               onclick="javascript:return confirm('您确定要删除${goods.goodsName}吗？')">
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
            </a>
            <a href="GoodsQueryServlet?goodsID=${goods.goodsID}" class="btn btn-primary btn-xs">
                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
            </a>
            <a href="" class="btn btn-success btn-xs">
                <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>详情
            </a>
        </td>
    </tr>
    </c:forEach>
    <tr>
        <td colspan="6" style="text-align: center;">
            <c:if test="${pageNum eq 1}">
                <a class="btn btn-xs">首页</a>
            </c:if>
            <c:if test="${pageNum gt 1}">
                <a class="btn btn-xs" href="${url}?pageNum=1&tid=${typeID}">首页</a>
            </c:if>
            <c:if test="${pageNum eq 1}">
                <a class="btn btn-xs">上一页</a>
            </c:if>
            <c:if test="${pageNum gt 1}">
                <a class="btn btn-xs" href="${url}?pageNum=${pageNum-1}&tid=${typeID}">上一页</a>
            </c:if>
            当前第 ${pageNum} 页/共 ${pageCount} 页
            <c:if test="${pageNum lt pageCount}">
                <a class="btn btn-xs"  href="${url}?pageNum=${pageNum+1}&tid=${typeID}">下一页</a>
            </c:if>
            <c:if test="${pageNum eq pageCount}">
                <a class="btn btn-xs">下一页</a>
            </c:if>
            <c:if test="${pageNum lt pageCount}">
                <a class="btn btn-xs"  href="${url}?pageNum=${pageCount}&tid=${typeID}">尾页</a>
            </c:if>
            <c:if test="${pageNum eq pageCount}">
                <a class="btn btn-xs">尾页</a>
            </c:if>

        </td>
    </tr>
</table>

<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
</body>
</html>

