<%--
  Created by IntelliJ IDEA.
  User: 87909
  Date: 2021/1/15
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css" />
    <style type="text/css">
        #container{
            width: 600px;
            height: 400px;
            margin: 80px auto;
        }
    </style>
</head>

<body>
<h4>类别管理/ 添加类别</h4>

<div id="container">
    <form class="layui-form" action="TypeAddServlet" method="post" onsubmit="return checkInformation()">
        <div class="layui-form-item" >
            <label class="layui-form-label">类别名称</label>
            <div class="layui-input-block">
                <input type="text" name="typeName" id="typeName" placeholder="请输入类别名称" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item layui-form-text" style="margin-top: 50px;">
            <label class="layui-form-label">类别描述</label>
            <div class="layui-input-block">
                <textarea name="typeDesc" id="typeDesc" placeholder="请输入类别描述" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item" style="margin-top: 50px;">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>

</div>
<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
    function checkInformation() {
        var name = document.getElementById("typeName").value;
        if(name == ""){
            alert("请输入类别名称！");
            return false;
        }else if(name.length<2||name.length>12){
            alert("类别名称长度必须为2-12个字符！");
            return false;
        }

        var desc = document.getElementById("typeDesc").value;
        if(desc.length>40){
            alert("类别描述长度必须在40字符以内！");
            return false;
        }
    }
</script>
</body>

</html>