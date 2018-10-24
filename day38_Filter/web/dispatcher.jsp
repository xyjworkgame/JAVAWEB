<%--
  Created by IntelliJ IDEA.
  User: XYJ
  Date: 2018/10/24
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page errorPage="test.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--<jsp:forward page="/test.jsp">To Test page</jsp:forward>--%>
    <%--<jsp:include page="/test.jsp"></jsp:include>--%>

<%
    int i = 10 /0;
%>
</body>
</html>
