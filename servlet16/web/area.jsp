<%--
  Created by IntelliJ IDEA.
  User: ztw
  Date: 12/24/2023
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>计算⚪面积</title>
</head>
<body>
<%!
    double PI = Math.PI;
    double r = 50;
    double getArea(double a){
        return PI * a * a;
    }
%>
<p>area<%=getArea(r)%></p>  
</body>
</html>
