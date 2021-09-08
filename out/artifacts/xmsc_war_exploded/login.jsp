<%--
  Created by IntelliJ IDEA.
  User: 87909
  Date: 2021/1/15
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <style type="text/css">
        #table1 {
            width: 100%;
            height: 700px;
        }
        #container{
            width: 300px;
            background-color: white;
            padding: 25px 15px;
            border-radius: 5px;
            margin-left: 750px;
        }
        #div1{
            color: darkgray;
            font-size: 25px;
            font-family: 华文细黑;
            padding-bottom: 5px;
            margin-bottom: 20px;
            border-bottom: 5px rgb(242 98 18)solid;
        }
    </style>
</head>

<body>
<table id="table1" cellspacing="0">
    <tr height="100px">
        <td></td>
        <td><img src="img/xiaomilogo.png" width="150px" /></td>
        <td></td>
    </tr>
    <tr height="500px">
        <td background="img/login_bg2.png"></td>
        <td width="1240px" background="img/login_bg.png">
            <div>
                <div id="container">
                    <div id="div1">
                        <label>管理员登陆</label>
                        <label style="color: red;font-size: 13px;">${errorMsg}</label>
                    </div>
                    <form action="LoginServlet" method="post" onsubmit="return checkInformation()">
                        <!--管理员账号输入框-->
                        <div class="form-group">
                            <label>账号</label>
                            <input type="text" name="managerAccount" id="account" class="form-control" placeholder="请输入账号">
                        </div>

                        <!--管理员密码输入框-->
                        <div class="form-group">
                            <label>密码</label>
                            <input type="password" name="managerPassword" id="pwd" class="form-control" placeholder="请输入密码">
                        </div>

                        <!--记住密码复选框-->
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> 记住密码
                            </label>
                        </div>

                        <!--登录按钮-->
                        <button type="submit" class="btn btn-warning" style="width: 100%;">登录</button>
                    </form>
                </div>
            </div>
        </td>
        <td background="img/login_bg2.png"></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
    </tr>
</table>

<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
    function checkInformation() {
        var usr = document.getElementById("account").value;
        if(usr == ""){
            alert("请输入登录账号！");
            return false;
        }else if(usr.length<4||usr.length>20){
            alert("账号长度必须为4-20个字符！");
            return false;
        }

        var pwd = document.getElementById("pwd").value;
        if(pwd == ""){
            alert("请输入登录密码！");
            return false;
        }else if(pwd.length>16){
            alert("密码长度必须在16字符以内！");
            return false;
        }
    }
</script>

</body>

</html>
<!--219 231 243-->
<!--/*height: 936px;width: 1920px; 104 208 624*/-->