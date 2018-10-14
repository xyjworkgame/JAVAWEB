<%--
  Created by IntelliJ IDEA.
  User: XYJ
  Date: 2018/10/6
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h5>BBBB PAGE</h5>

<%
    //1.请求转发的代码
    //request.getRequestDispatcher("/c.jsp").forward(request,response);

    //2.请求的重定向
    response.sendRedirect("c.jsp");
%>
</body>
</html>
