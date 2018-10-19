<%@ page import="com.javaweb.el.Customer" %><%--
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

    username: <input type="text" name="username"
                     value="${param.username}"/>
    <input type="submit" value="Submit"/>

</form>

username: <%= request.getParameter("username")%>
<br>
<br>
<jsp:useBean id="customer" class="com.javaweb.el.Customer" scope="session"/>
<jsp:setProperty name="customer" property="age" value="12"/>

age:
<%
    Customer customer1 = (Customer) session.getAttribute("Customer");
    out.print(customer1.getAge());
%>
<br>
age:<jsp:getProperty name="customer" property="age"/>

<a href="el2.jsp">to el.jsp</a>
</body>
</html>
