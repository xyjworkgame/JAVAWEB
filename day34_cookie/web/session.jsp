<%--
  Created by IntelliJ IDEA.
  User: xyjwork
  Date: 2018/10/16
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        out.print(session.getId());

        Cookie cookie = new Cookie("session",session.getId());
        cookie.setMaxAge(20);
        response.addCookie(cookie);

    %>
</body>
</html>
