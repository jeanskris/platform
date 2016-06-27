<%--
  Created by IntelliJ IDEA.
  User: ZJDX
  Date: 2016/6/20
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Access-Control-Allow-Origin" content="*" />

<!-- MAIN EFFECT -->
<script type="text/javascript" src="assets/jquery.js"></script>
<script type="text/javascript" src="assets/jhere-custom.js"></script>
<script type="text/javascript" src="assets/bootstrap.js"></script>
<script type="text/javascript" src="assets/load.js"></script>
<!--self-defined-->
<script type="text/javascript" src="assets/index.js"></script>
</head>

<body >
<button id="carCloud" onclick="carCloud()">车端云</button>
<button id="environment" >环境云</button>
<button id="user">用户云</button>
<button id="application" onclick="application()">应用云</button>

<p id="commandTime" >0 </p>
<p id="result" ></p>

</body>
</html>
