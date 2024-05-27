<%--
  Created by IntelliJ IDEA.
  User: GuoJeongeun
  Date: 2024/5/26
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>修改信息</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-2.2.4.min.js"
                integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container" style="width: 400px;">
            <h3 style="text-align: center;">修改用户信息</h3>

            <form action="${pageContext.request.contextPath}/updateUserServlet" method="post">
                <input type="hidden" name="id" value="${user.id}">

                <div class="form-group">
                    <label for="name">姓名：</label>
                    <input type="text" class="form-control" id="name" name="name" value="${user.name}"
                           readonly="readonly" placeholder="请输入姓名"/>
                </div>

                <div class="form-group">
                    <label>性别：</label>
                    <c:if test="${user.gender=='男'}">
                        <input type="radio" name="gender" value="男" checked/>男
                        <input type="radio" name="gender" value="女"/>女

                    </c:if>
                    <c:if test="${user.gender=='女'}">
                        <input type="radio" name="gender" value="男"/>男
                        <input type="radio" name="gender" value="女" checked/>女
                    </c:if>
                </div>

                <div class="form-group">
                    <label for="age">年龄：</label>
                    <input type="text" class="form-control" id="age" value="${user.age}" name="age"
                           placeholder="请输入年龄"/>
                </div>

                <div class="form-group">
                    <%--@declare id="address"--%><label for="address">籍贯：</label>
                    <select name="address" class="form-control">
                        <c:set var="provinces"
                               value="${['北京', '天津', '上海', '重庆', '河北', '山西', '辽宁', '吉林', '黑龙江', '江苏', '浙江', '安徽', '福建', '江西', '山东', '河南', '湖北', '湖南', '广东', '广西', '海南', '四川', '贵州', '云南', '陕西', '甘肃', '青海', '台湾', '内蒙古', '广西', '西藏', '宁夏', '新疆', '香港', '澳门', '台湾']}"/>
                        <c:forEach var="province" items="${provinces}">
                            <option value="${province}"
                                    <c:if test="${user.address==province}">selected</c:if> >
                                    ${province}
                            </option>
                        </c:forEach>
                    </select>

                </div>

                <div class="form-group">
                    <%--@declare id="qq"--%><label for="qq">QQ：</label>
                    <input type="text" class="form-control" name="qq" value="${user.qq}" placeholder="请输入QQ号码"/>
                </div>

                <div class="form-group">
                    <%--@declare id="email"--%><label for="email">Email：</label>
                    <input type="text" class="form-control" value="${user.email}" name="email"
                           placeholder="请输入邮箱地址"/>
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
