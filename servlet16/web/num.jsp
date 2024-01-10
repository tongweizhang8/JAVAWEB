<%--
  Created by IntelliJ IDEA.
  User: ztw
  Date: 12/24/2023
  Time: 4:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>计算和</title>
</head>
<body>
<%
    int num = 0;
    for (int i = 0; i < 100; i++) {
        num += num + i;
    }
    out.print(num);
%>
</body>
</html>
