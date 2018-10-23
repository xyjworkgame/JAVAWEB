<%--
  Created by IntelliJ IDEA.
  User: xyjwork
  Date: 2018/10/23
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <font color="red">${message}</font>
    <form action="hello.jsp" method="post">
        useranme: <input type="text" name="username"/>
        password: <input type="password" name="password"/>

        <input type="submit" name="Submit">

    </form>
</body>
</html>
