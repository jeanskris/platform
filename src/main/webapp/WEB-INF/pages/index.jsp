<%--
  Created by IntelliJ IDEA.
  User: ZJDX
  Date: 2016/6/20
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>云控制台</title>


    <link rel="stylesheet" href="assets/css/reset.css">

    <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

    <link rel="stylesheet" href="assets/css/styleLogin.css">


</head>
<body>
<!-- Mixins-->
<!-- Pen Title-->
<div class="pen-title">
    <h1>信息轨云平台控制台</h1>
</div>

<div class="container">
    <div class="card"></div>
    <div class="card">
        <h1 class="title">登录</h1>
        <form  action="loginDeveloper" method="POST" onsubmit="checkForm()">
            <div class="input-container">
                <input type="text" name="phonenum" id="phoneLogin" required="required">
                <label for="phoneLogin">Phone Number</label>
                <div class="bar"></div>
            </div>
            <div class="input-container">
                <input type="password" autocomplete="off" name="password"id="passwordLogin" required="required"
                       onfocus="passwordFocus()"
                       onblur="passwordBlur()">
                <label for="passwordLogin">Password</label>
                <div class="bar"></div>
            </div>
            <div class="button-container">
                <button type="submit" ><span>登录</span></button>
            </div>
            <div class="footer"><a href="#">忘记密码?</a></div>
        </form>
    </div>
    <div class="card alt">
        <div class="toggle"></div>
        <h1 class="title">注册
            <div class="close"></div>
        </h1>
        <form>
            <div class="input-container">
                <input type="text" id="phone" required="required"
                       onfocus="phoneFocus()"
                       onblur="phoneBlur()">
                <label for="phone">Phone Number</label>
                <div class="bar"></div>
                <div style="color:white" id="phoneId"></div>
            </div>
            <div class="input-container">
                <input type="password" id="password" required="required">
                <label for="password">Password</label>
                <div class="bar"></div>
                <div style="color:white" id="passwordId"></div>
            </div>
            <div class="input-container">
                <input type="password" id="repass" required="required"
                       onblur="repassBlur()">
                <label for="repass">Repeat Password</label>
                <div class="bar"></div>
                <div style="color:white" id="repassId"></div>
            </div>
            <div class="button-container">
                <button onclick="register()"><span>提交</span></button>
            </div>
        </form>
    </div>
</div>

<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="assets/md5.js"></script>
<script src="assets/index.js"></script>
<script type="text/javascript" src="assets/jhere-custom.js"></script>
<script type="text/javascript" src="assets/bootstrap.js"></script>
<script type="text/javascript" src="assets/load.js"></script>
</body>
</html>

