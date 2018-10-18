<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: xyjwork
  Date: 2018/10/18
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String tokenVlaue = new Date().getTime() + "";
    session.setAttribute("token",tokenVlaue);
%>
    <form action="/tokenServlet" method="post">
        <input type="hidden" value="<%= tokenVlaue%>" name="token"/>


            name <input type="text" name="name" />

        <input type="submit" value="Submit"/>

    </form>
</body>
</html>
