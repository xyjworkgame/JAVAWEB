<%--
  Created by IntelliJ IDEA.
  User: XYJ
  Date: 2018/10/6
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>attr 1</h2>
    <%
        pageContext.setAttribute("pageContextAttr","pageContextValue");
        request.setAttribute("requestAttr","requestContextValue");
        session.setAttribute("sessionAttr","sessionContextValue");
        application.setAttribute("applicationAttr","applicationContextValue");

    %>
    <br><br>
    pageContextAttr : <%= pageContext.getAttribute("pageContextAttr")%>
    <br><br>
    requestAttr : <%= request.getAttribute("requestAttr")%>
    <br><br>
    sessionAttr : <%= session.getAttribute("sessionAttr")%>
    <br><br>
    application : <%= application.getAttribute("applicationAttr")%>
    <br><br>
<a href="attr_2.jsp"> to attr.jsp</a>

    <br><br>
<a href="testAttr">to attr Servlet</a>


<%
    request.getRequestDispatcher("/attr_2.jsp").forward(request,response);
%>
</body>
</html>
