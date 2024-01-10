<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--毙掉session对象，写上这个，内置对象就不能用了--%>
<%--<%@ page session="false"%>--%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>部门列表界面</title>
    <%--设置整个网页的基础路径是：http://localhost:8080/oa/--%>
    <base href="http://localhost:8080/oa/">
</head>
<body>
<%--显示一个登陆界面--%>
<h3>欢迎${username}</h3>
<a href="/user/exit">退出系统</a>
<script type="text/javascript">
    function del(deptno){
        //弹出确认框，点击确定，返回true，点击取消，返回false
        var ok = alert("执行删除操作");
        if(ok){
            //发送请求进行删操作
            //在js代码中如何发送请求给服务器？
            //alert("正在删除数据，请稍后")
            //document.location.href = "delete.html";
            //document.location  = "delete.html";
            //window.location = "delete.html";
            //window.location.href = "delete.html";
            /*注意html的base标签科能对JS代码不起作用，所以js代码前最好加上/oa*/
            document.location.href = "/oa/dept/delete?deptno=" + deptno;
        }
    }
</script>
    <h1>部门列表</h1>
    <hr>
    <table border="1px" align="center" width="50%">
        <tr>
            <th>序号</th>
            <th>部门编号</th>
            <th>部门名称</th>
            <th>操作</th>
        </tr>
        <!--以上是固定的-->

        <c:forEach items="deptList" varStatus="deptStatus" var="dept">
            <tr>
                <th>${deptStatus.count}</th>
                <th>${dept.deptno}</th>
                <th>${dept.dname}</th>
                <td>
                    <!--href后面设置为javascript：void(0)表示任然保留住超链接的样子-->
                    <!--点击此超链接后，不进行页面的跳转-->
                    <!--只是希望用户点击此超链接后的时候执行一段js代码，不进行页面的跳转-->
                    <a href="javascript:void(0)" onclick="del(${dept.deptno})">删除</a>
                    <a href="${pageContext.request.contextPath}/WEB-INF/detail.jspd/detail.jsp?f=m&dno=${dept.deptno}">修改</a>
                    <a href="${pageContext.request.contextPath}/WEB-INF/detail.jspd/detail.jsp?f=d&dno=${dept.deptno}">详情</a>
                </td>
            </tr>
        </c:forEach>


        <!--以下是固定的-->
    </table>
    <hr>
    <a href="/WEB-INF/add.jsp">新增部门</a>
</body>
</html>