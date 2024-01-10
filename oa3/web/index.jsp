    <%@page contentType="text/html;charset=UTF-8"%>
<!--访问jsp的时候不生成session对象-->
<%@page session="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>欢迎使用OA系统</title>
</head>
<body>
<%--前端超链接发送请求的时候，请求路径以“/”开始，并且要带着项目名--%>
<%--以下这样写代码，oa项目名写死了，这种设计不好--%>
<%--<a href=“/oa/list.jsp">查看部门列表</a>--%>
<%--<a href="<%=request.getContextPath()%>/list.jsp">查看部门列表</a>--%>
<%--调用哪个对象的方法，可以动态获取一个应用的根路径--%>
<%--<%=request.getContextPath()%>--%>
<h1>用户登陆</h1>
<hr>
<%--前端页面发送请求的时候，请求路径以“/”开始，并且要带着项目名--%>
<form action="${pageContext.request.contextPath}/user/login" method="">
    username: <input type="text" name="username"><br>
    password: <input type="password" name="password"><br>
    <input type="checkbox" name="rememberMe" value="1">十天内免登录<br>
    <input type="submit" value="登陆">
</form>
</body>
</html>