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

<span style="color: red; ">${message }</span>
<br><br>

<form action="hello.jsp" method="post">

    username: <input type="text" name="username" value="${param.username }"/>
    password: <input type="password" name="password"/>

    <input type="submit" value="Submit"/>

</form>

</body>
</html>
