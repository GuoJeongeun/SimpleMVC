<%--
  Created by IntelliJ IDEA.
  User: GuoJeongeun
  Date: 2024/5/26
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>添加用户</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-2.2.4.min.js"
                integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>

    </head>
    <body>
        <div class="container">
            <h3 style="text-align: center">添加用户</h3>
            <form action="${pageContext.request.contextPath}/addUserServlet" method="post">
                <div class="form-group">
                    <label for="name">姓名：</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
                </div>

                <div class="form-group">
                    <label>性别：</label>
                    <input type="radio" name="gender" value="男" checked="checked"/>男
                    <input type="radio" name="gender" value="女"/>女
                </div>

                <div class="form-group">
                    <label for="age">年龄：</label>
                    <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
                </div>

                <div class="form-group">
                    <%--@declare id="address"--%><label for="address">籍贯：</label>
                    <select name="address" class="form-control" id="jiguan">
                        <option value="北京">北京</option>
                        <option value="天津">天津</option>
                        <option value="河北">河北</option>
                        <option value="山西">山西</option>
                        <option value="内蒙古">内蒙古</option>
                        <option value="辽宁">辽宁</option>
                        <option value="吉林">吉林</option>
                        <option value="黑龙江">黑龙江</option>
                        <option value="上海">上海</option>
                        <option value="江苏">江苏</option>
                        <option value="浙江">浙江</option>
                        <option value="安徽">安徽</option>
                        <option value="福建">福建</option>
                        <option value="江西">江西</option>
                        <option value="山东">山东</option>
                        <option value="河南">河南</option>
                        <option value="湖北">湖北</option>
                        <option value="湖南">湖南</option>
                        <option value="广东">广东</option>
                        <option value="广西">广西</option>
                        <option value="海南">海南</option>
                        <option value="重庆">重庆</option>
                        <option value="四川">四川</option>
                        <option value="贵州">贵州</option>
                        <option value="云南">云南</option>
                        <option value="西藏">西藏</option>
                        <option value="陕西">陕西</option>
                        <option value="甘肃">甘肃</option>
                        <option value="青海">青海</option>
                        <option value="宁夏">宁夏</option>
                        <option value="新疆">新疆</option>
                        <option value="香港">香港</option>
                        <option value="澳门">澳门</option>
                        <option value="台湾">台湾</option>
                    </select>
                </div>

                <div class="form-group">
                    <%--@declare id="qq"--%><label for="qq">QQ：</label>
                    <input type="text" class="form-control" name="qq" placeholder="请输入QQ"/>
                </div>

                <div class="form-group">
                    <%--@declare id="email"--%><label for="email">Email：</label>
                    <input type="text" class="form-control" name="email" placeholder="请输入邮箱"/>
                </div>

                <div class="form-group" style="text-align: center">
                    <input class="btn btn-primary" type="submit" value="提交"/>
                    <input class="btn btn-default" type="reset" value="重置"/>
                    <input class="btn btn-default" type="button" value="返回" onclick="history.back()"/>
                </div>
            </form>
        </div>
    </body>
</html>
