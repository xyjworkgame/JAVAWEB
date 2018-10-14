<%--
  Created by IntelliJ IDEA.
  User: XYJ
  Date: 2018/10/6
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>hello</h2>

<%
    request.setCharacterEncoding("UTF-8");
%>
username : <%= request.getParameter("username")%>

<%
    String val =request.getParameter("username");
    String username = new String(val.getBytes("iso-8859-1"),"utf-8")
    out.print(username);
%>
</body>
</html>
