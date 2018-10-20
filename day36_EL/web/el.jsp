<%@ page import="com.javaweb.el.Customer" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: xyjwork
  Date: 2018/10/19
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="el.jsp" method="post">

    username: <input type="text" name="username"
                     value="<%= request.getParameter("username") == null ? "" : request.getParameter("username")%>"/>

    <!--
        EL 表达式的有点: 简洁!
    -->
    username: <input type="text" name="username"
                     value="${param.username }"/>
    <input type="submit" value="Submit"/>

</form>

username: <%= request.getParameter("username") %>

<br><br>

<jsp:useBean id="customer" class="com.javaweb.el.Customer" scope="session"></jsp:useBean>
<jsp:setProperty property="age" value="12" name="customer"/>

age:
<%
    Customer customer2 = (Customer)session.getAttribute("customer");
    out.print(customer2.getAge());
%>
<br>
age: <jsp:getProperty property="age" name="customer"/>

<br>
<br>

<%
    application.setAttribute("time", new Date());
%>

<a href="el2.jsp?score=89&name=A&name=B&name=C">To El2 Page</a>

</body>
</html>
