<%--
  Created by IntelliJ IDEA.
  User: 87909
  Date: 2021/1/15
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <style type="text/css">
        #tipsDiv {
            text-align: center;
            padding-top: 150px;
            width: 400px;
            margin: auto;
        }


        #tipsDiv p {
            padding: 30px 0px;
            border-radius: 5px;
            font-size: 25px;
        }
    </style>
</head>

<body>
    <div>操作提示</div>
    
    <div id="tipsDiv">
        <div >
            <c:if test="${code eq 0}">
            <p class="bg-success ">
                <span class="glyphicon glyphicon-ok-circle" style="color: green;"></span>${msg}
            </p>
            </c:if>
            <c:if test="${code eq 1}">
            <p class="bg-danger ">
                <span class="glyphicon glyphicon-remove-circle" style="color: brown;"></span>${msg}
            </p>
            </c:if>
        </div>
    </div>

<script type="text/javascript " src="js/bootstrap.js "></script>
<script type="text/javascript " src="js/jquery-3.4.1.min.js "></script>
</body>

</html>
