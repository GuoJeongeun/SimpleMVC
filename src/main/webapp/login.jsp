<%--
  Created by IntelliJ IDEA.
  User: GuoJeongeun
  Date: 2024/5/24
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>登录</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-2.2.4.min.js"
                integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
        <script>
            function refreshCode() {
                var vcode = document.getElementById("vcode");
                vcode.src = "${pageContext.request.contextPath}/checkCodeServlet?time=" + new Date().getTime();
            }
        </script>
    </head>
    <body>
        <div class="container" style="width: 400px;">
            <h3 style="text-align: center;">登录</h3>
            <form action="${pageContext.request.contextPath}/loginServlet" method="post">
                <div class="form-group">
                    <label for="user">用户名：</label>
                    <input type="text" name="username" class="form-control" id="user" placeholder="请输入用户名"/>
                </div>

                <div class="form-group">
                    <label for="password">密码：</label>
                    <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
                </div>

                <div class="form-inline">
                    <label for="vcode">验证码：</label> <input type="text" name="verifycode" class="form-control"
                                                              id="verifycode" placeholder="请输入验证码"
                                                              style="width: 120px;"/>
                    <a href="javascript:refreshCode()">
                        <img src="${pageContext.request.contextPath}/checkCodeServlet" title="点击刷新" id="vcode"/>
                    </a>
                </div>
                <hr/>
                <div class="form-group" style="text-align: center;">
                    <input class="btn btn btn-primary" type="submit" value="登录">
                </div>
            </form>
        </div>
    </body>
</html>
