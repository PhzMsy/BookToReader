<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/9
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
    <script>
        $(function (){
            $("#insert").click(function (){
                location = "reader/insert.jsp";
            });

            $(".update").click(function (){
                location = "reader/update.jsp?id="+$(this).next().val();
            });

            $(".delete").click(function (){
                let id = $(this).prev().val();
                $.ajax({
                    url:"reader?m=delete",
                    data:{id:id},
                    dataType:"json",
                    success:function (obj){
                        if(obj){
                            location.reload();
                        }
                    }
                });
            });
        });
    </script>
</head>
<body>
<table>
    <tr>
        <td></td>
        <td>编号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>所选课程</td>
        <td>
            <input type="button" value="添加" id="insert"/>
        </td>
    </tr>
    <c:forEach items="${list}" var="s">
        <tr>
            <td></td>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.hobby}</td>
            <td>${s.age}</td>
            <td>
                <c:forEach items="${s.bkRrList}" var="sc">
                    ${sc.book.name}
                </c:forEach>
            </td>
            <td>
                <input type="button" value="修改" class="update">
                <input type="hidden" value="${s.id}">
                <input type="button" value="删除" class="delete">
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
