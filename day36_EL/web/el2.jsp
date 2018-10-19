<%@ page import="com.javaweb.el.Customer" %><%--
  Created by IntelliJ IDEA.
  User: xyjwork
  Date: 2018/10/19
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
age: ${sessionScope.customer.age}
<br>
age: ${sessionScope.customer["age"]}

<%--相当于
<%
    Customer customer1 = (Customer) session.getAttribute("Customer");
    out.print(customer1.getAge());
%>--%>
<%
    Customer customer = new Customer();
    customer.setName("xie");
    session.setAttribute("com.javaweb.el",customer);
%>
<br>
<%--主要用于区别的点的时候。则使用[] 会更加的方便--%>
name:${sessionScope["com.javaweb.el"].name}
</body>
</html>
