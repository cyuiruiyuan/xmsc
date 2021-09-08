<%--
  Created by IntelliJ IDEA.
  User: 87909
  Date: 2021/1/18
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="layui/css/layui.css" />
    <style type="text/css">
        #container{
            width: 600px;
            height: 400px;
            margin: 50px auto;
        }
    </style>
</head>
<body>
<h4>商品管理 / 发布商品</h4>
<div id="container">
    <form class="layui-form" action="GoodsUpdateServlet" method="post" enctype="multipart/form-data" onsubmit="return checkInformation()">


        <div class="layui-form-item">
            <label class="layui-form-label">商品编号</label>
            <div class="layui-input-block">
                <input type="text"  value="${goods.goodsID}"  class="layui-input" disabled="disabled">
                <input type="hidden" name="goodsID" value="${goods.goodsID}" >

            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">商品类别</label>
            <div class="layui-input-block">
                <select name="typeID" >
                    <c:forEach items="${typeList}" var="t">
                        <option value="${t.typeID}">${t.typeName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">商品名称</label>
            <div class="layui-input-block">
                <input type="text" id="goodsName" name="goodsName" value="${goods.goodsName}"  class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">商品图片</label>
            <div class="layui-input-block">
                <input type="file" id="goodsImg" name="goodsImg"> <label style="color: lightgray; font-size: 13px;">请选择商品图片</label>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">商品价格</label>
            <div class="layui-input-block">
                <input type="text" id="goodsPrice" name="goodsPrice" value="${goods.goodsPrice}"  class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">商品数量</label>
            <div class="layui-input-block">
                <input type="number" id="goodsNum" name="goodsNum" value="${goods.goodsNum}"  class="layui-input">
            </div>
        </div>

        <div class="layui-form-item layui-form-text" >
            <label class="layui-form-label">商品描述</label>
            <div class="layui-input-block">
                <textarea name="goodsDesc" id="goodsDesc" class="layui-textarea">${goods.goodsDesc}</textarea>
            </div>
        </div>
        <div class="layui-form-item layui-form-text" >
            <label class="layui-form-label">图文详情</label>
            <div class="layui-input-block">
                <textarea name="goodsDetail" id="goodsDetail" class="layui-textarea">${goods.goodsDetail}</textarea>
            </div>
        </div>

        <div class="layui-form-item" style="margin-top: 20px;">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="layui/layui.all.js" ></script>
<script type="text/javascript">
    function checkInformation() {
        var name = document.getElementById("goodsName").value;
        if(name == ""){
            alert("请输入商品名称！");
            return false;
        }else if(name.length<2||name.length>40){
            alert("商品名称长度必须为2-40个字符！");
            return false;
        }
        var img = document.getElementById("goodsImg").value;
        if(img == ""){
            alert("请上传商品图片！");
            return false;
        }
        var price = document.getElementById("goodsPrice").value;
        if(price == ""){
            alert("请输入商品价格！");
            return false;
        }
        var num = document.getElementById("goodsNum").value;
        if(num == ""){
            alert("请输入商品数量！");
            return false;
        }

        var desc = document.getElementById("goodsDesc").value;
        if(desc.length>400){
            alert("商品描述长度必须在400字符以内！");
            return false;
        }
    }
</script>
</body>
</html>
