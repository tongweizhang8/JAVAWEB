  <%--
  Created by IntelliJ IDEA.
  User: ztw
  Date: 12/28/2023
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <base href="${pageContext.request.contextPath}://${pageContext.request.serverName}:${pageContext.request.contextPath}${pageContext.request.contextPath}/">
  <title>银行账户转账</title>
</head>
<body>
<form action="transfer" method="post">
  转出账户：<input type="text" name="formAction"><br>
  转入账户：<input type="text" name="toAction"><br>
  转账金额：<input type="text" name="money"><br>
  <input type="submit" value="转账">
</form>
</body>
</html>
