<%--
  Created by IntelliJ IDEA.
  User: xyjwork
  Date: 2018/10/16
  Time: 17:39
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
<br><br>

Bye: <%= session.getAttribute("username")%>
<br><br>

<a href="login.jsp">重新登录</a>
<%
    session.invalidate();
%>
</body>
</html>
