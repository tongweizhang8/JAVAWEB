<%--
  Created by IntelliJ IDEA.
  User: ztw
  Date: 12/24/2023
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>随机数</title>
</head>
<body>
<%
    double num = Math.random();
    out.print(num);
    if (num > 0.5){
%>
<P>num小于0.5</P>
<%
    }
    else{
%>
<P>num大于0.5</P>
<%
    }
%>
</body>
</html>
