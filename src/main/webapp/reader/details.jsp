<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/13
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
    <script>
        $(function (){
            $.ajax({
                url:"../reader",
                data:{m:"queryCourseForAjax"},
                dataType:"json",
                success:function (resp){
                    console.log(resp)
                    for(let course of resp){
                        $("#cla").append("<input type='checkbox' name='cids' class='cids' value="+course.id+">"+course.name);
                    }
                }
            });
            const id = ${param.id}
                $.ajax({
                url:"../reader?m=queryById&id="+id,
                dataType:"json",
                success:function (resp){
                    $("#id").val(resp.id);
                    $("#name").val(resp.name);
                    $("#age").val(resp.age);
                    $(".hobby[value="+resp.hobby+"]").prop("checked",true);
                    $("#country").val(resp.country.country);

                    let bk = resp.bkRrList;
                    for(let bks of bk){
                        $(".cids[value="+bks.book.id+"]").prop("checked",true);
                    }
                }
            });


            $.ajax({
                url:"../reader",
                data:{m:"queryForCountry",id:id},
                dataType:"json",
                success:function (resp){
                    $("#country").val(resp);
                }
            });
        });
    </script>
</head>
<body>
<form>
    <table>
        <tr>
            <td>姓名</td>
            <td>
                <input type="text" name="name" id="name">
            </td>
        </tr>
        <tr>
            <td>爱好</td>
            <td>
                <input type="radio" name="hobby" class="hobby" value="七进七出">七进七出
                <input type="radio" name="hobby" class="hobby" value="守街亭">守街亭
                <input type="radio" name="hobby" class="hobby" value="出师表">出师表
                <input type="radio" name="hobby" class="hobby" value="缝草鞋">缝草鞋
                <input type="radio" name="hobby" class="hobby" value="七步诗">七步诗
                <input type="radio" name="hobby" class="hobby" value="打黄盖">打黄盖
                <input type="radio" name="hobby" class="hobby" value="据守">据守
            </td>
        </tr>
        <tr>
            <td>年龄</td>
            <td>
                <input type="text" name="age" id="age">
            </td>
        </tr>
        <tr>
            <td>书籍</td>
            <td id="cla">
            </td>
        </tr>
        <tr>
            <td>国家</td>
            <td>
                <input type="text" name="country" id="country">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="button" value="返回主页面" id="btn"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
