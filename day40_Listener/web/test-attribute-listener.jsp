<%--
  Created by IntelliJ IDEA.
  User: xyjwork
  Date: 2018/10/31
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    request.setAttribute("name","ABCD");
    System.out.println("--------------------");

    request.setAttribute("name","DEFG");
    System.out.println("---------------------");

    request.removeAttribute("name");
    System.out.println("---------------------");

%>
</body>
</html>
