<%--
  Created by IntelliJ IDEA.
  User: xyjwork
  Date: 2018/10/16
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    SessionID：<%= session.getId()%>
    <br><br>

    IsNew : <%=session.isNew()%>
    <br><br>
    MaxInactiveInterval: <%=session.getMaxInactiveInterval()%>
    <br><br>
    CreateTime : <%= session.getCreationTime()%>

    <br><br>

    LastAccessTime: <%= session.getLastAccessedTime()%>

    <br><br>

    <%
        Object username = session.getAttribute("username");
        if (username ==null){
            username = "";
        }
    %>
    <form action="<%= response.encodeURL("hello.jsp")%>" method="post">
        username: <input type="text" name="username"
                         value="<%=username %>">

        <input type="submit" value="Submit">

    </form>
</body>
</html>
