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
<form action="<%=request.getContextPath()%>/reader?m=query" method="post">
    姓名 : <input type="text" name="mohu_name" value="${mohu_name}" id="mohu_name"/>
    爱好 : <input type="radio" name="mohu_hobby" value="出师表" class="mohu_hobby" ${mohu_hobby=='出师表'?'checked':''}>出师表
    <input type="radio" name="mohu_hobby" value="七步诗" class="mohu_七步诗" ${mohu_hobby=='七步诗'?'checked':''}>七步诗
    <input type="submit" value="查询"/>
</form>
<table>
    <tr>
        <td>
            <input type="checkbox" id="ck">

        </td>
        <td>编号</td>
        <td>姓名</td>
        <td>爱好</td>
        <td>年龄</td>
        <td>所选课程</td>
        <td>
            <input type="button" value="添加" id="insert"/>

        </td>
    </tr>
    <c:forEach items="${list}" var="s">
        <tr>
            <td>
                <input type="checkbox" class="cks" value="${s.id}">
            </td>
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
