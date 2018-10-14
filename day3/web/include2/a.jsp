<%--
  Created by IntelliJ IDEA.
  User: XYJ
  Date: 2018/10/6
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>AAA  page</h2>
<%
    String str = "abcde";
%>
<%--在a，jsp 中包含b。jsp--%>
<%--<jsp:include page="b.jsp"></jsp:include>--%>

<jsp:forward page="/include/b.jsp">
    
    <jsp:param name="username" value="ac"></jsp:param>
</jsp:forward>


<%--<%--%>
    <%--request.getRequestDispatcher("/include/b.jsp").forward(request,response);--%>

<%--%>--%>
</body>
</html>
