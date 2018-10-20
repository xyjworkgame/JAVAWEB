<%@ page import="java.time.temporal.ChronoUnit" %>
<%@ page import="com.javaweb.el.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sun.org.apache.regexp.internal.RE" %>
<%@ page import="com.javaweb.el.Customer1" %><%--
  Created by IntelliJ IDEA.
  User: xyjwork
  Date: 2018/10/20
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //模拟 Servlet 中的操作.
    List<Customer1> customers = new ArrayList<Customer1>();
    customers.add(new Customer1(1, "AA", 12));
    customers.add(new Customer1(2, "BB", 13));
    customers.add(new Customer1(3, "CC", 14));
    customers.add(new Customer1(4, "DD", 15));
    customers.add(new Customer1(5, "EE", 16));

    request.setAttribute("customers", customers);
%>

<jsp:forward page="testtag.jsp"></jsp:forward>
</body>
</html>
