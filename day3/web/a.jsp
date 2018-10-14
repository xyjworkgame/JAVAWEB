<%--
  Created by IntelliJ IDEA.
  User: XYJ
  Date: 2018/10/6
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" errorPage="/error.jsp" %>
<%--<%@page contentType="application/msword;charset=UTF-8" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="hello.jsp" method="post">

        username :
        <input type="text" name="username"></input>
        <input type="submit" value="submit"/>
    </form>
</body>
</html>
