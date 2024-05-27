<%--
  Created by IntelliJ IDEA.
  User: GuoJeongeun
  Date: 2024/5/25
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>信息展示</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-2.2.4.min.js"
                integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
        <style>
            td, th {
                text-align: center;
            }
        </style>
        <script>
            function deleteUser(id) {
                if (confirm("确定删除吗")) {
                    location.href = "${pageContext.request.contextPath}/deleteUserServlet?id=" + id;
                }
            }

            window.onload = function () {
                //给删除选中按钮添加单击事件
                document.getElementById("delSelected").onclick = function () {
                    if (confirm("您确定要删除选中条目吗？")) {
                        var flag = false;
                        //判断是否有选中条目
                        var cbs = document.getElementsByName("uid");
                        for (var i = 0; i < cbs.length; i++) {
                            if (cbs[i].checked) {
                                //有一个条目选中了
                                flag = true;
                                break;
                            }
                        }

                        if (flag) {//有条目被选中
                            //表单提交
                            document.getElementById("form").submit();
                        }
                    }
                }
                //获取第一个cb
                document.getElementById("firstCb").onclick = function () {
                    //2.获取下边列表中所有的cb
                    var cbs = document.getElementsByName("uid");
                    //3.遍历
                    for (var i = 0; i < cbs.length; i++) {
                        //4.设置这些cbs[i]的checked状态 = firstCb.checked
                        cbs[i].checked = this.checked;
                    }
                }
            }
        </script>
    </head>
    <body>
        <div class="container">
            <h3 style="text-align: center">用户信息列表</h3>
            <%--            查询--%>
            <div style="float: left;">
                <form class="form-inline" method="post"
                      action="${pageContext.request.contextPath}/findUserByPageServlet">
                    <div class="form-group">
                        <label for="exampleInputName2">姓名</label>
                        <input type="text" class="form-control" id="exampleInputName2" name="name">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputName3">籍贯</label>
                        <input type="text" class="form-control" id="exampleInputName3" name="address">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail2">邮箱</label>
                        <input type="email" class="form-control" id="exampleInputEmail2" name="email">
                    </div>
                    <button type="submit" class="btn btn-default">查询</button>
                </form>
            </div>

            <%--            操作--%>
            <div style="float: right;margin: 5px;">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
                <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>
            </div>

            <%--            数据展示--%>
            <div>
                <form action="${pageContext.request.contextPath}/delSelectedUserServlet" method="post" id="form">
                    <table border="1" class="table table-bordered table-hover">
                        <tr class="success">
                            <th><input type="checkbox" id="firstCb">全选</th>
                            <th>编号</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>年龄</th>
                            <th>籍贯</th>
                            <th>QQ</th>
                            <th>邮箱</th>
                            <th>操作</th>
                        </tr>

                        <%--        EL配合JSTL遍历users对象集合--%>
                        <c:forEach items="${pb.list}" var="user" varStatus="s">
                            <tr>
                                <td><input type="checkbox" name="uid" value="${user.id}"></td>
                                <td>${user.id}</td>
                                <td>${user.name}</td>
                                <td>${user.gender}</td>
                                <td>${user.age}</td>
                                <td>${user.address}</td>
                                <td>${user.qq}</td>
                                <td>${user.email}</td>
                                <td><a class="btn btn-default btn-sm"
                                       href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>
                                    <a
                                            class="btn btn-default btn-sm"
                                            href="javascript:deleteUser(${user.id})">删除</a></td>
                            </tr>
                        </c:forEach>

                    </table>
                </form>
            </div>

            <%--            分页--%>
            <div>
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <c:if test="${pb.currentPage == 1}">
                            <li class="page-item disabled">
                                <a class="page-link" href="#" tabindex="-1" aria-disabled="true">
                                    <span aria-hidden="true">&lt;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${pb.currentPage != 1}">
                            <li class="page-item">
                                <a class="page-link"
                                   href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage - 1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}"
                                   aria-label="Previous">
                                    <span aria-hidden="true">&lt;</span>
                                </a>
                            </li>
                        </c:if>

                        <c:forEach begin="1" end="${pb.totalPage}" var="i">
                            <c:if test="${pb.currentPage == i}">
                                <li class="page-item active">
                                    <a class="page-link" href="#">
                                            ${i} <span class="sr-only">(current)</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${pb.currentPage != i}">
                                <li class="page-item">
                                    <a class="page-link"
                                       href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">
                                            ${i}
                                    </a>
                                </li>
                            </c:if>
                        </c:forEach>
                        <c:if test="${pb.currentPage == pb.totalPage}">
                            <li class="page-item disabled">
                                <a class="page-link" href="#" tabindex="-1" aria-disabled="true">
                                    <span aria-hidden="true">&gt;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${pb.currentPage != pb.totalPage}">
                            <li class="page-item">
                                <a class="page-link"
                                   href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage + 1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}"
                                   aria-label="Next">
                                    <span aria-hidden="true">&gt;</span>
                                </a>
                            </li>
                        </c:if>

                        <span style="font-size: 25px; margin-left: 5px;">共${pb.totalCount}条记录，共${pb.totalPage}页</span>
                    </ul>
                </nav>
            </div>

        </div>
    </body>
</html>
