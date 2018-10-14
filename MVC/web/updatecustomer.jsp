<%@ page import="com.study.mvcapp.domain.Customer" %>
<%@ page import="com.study.mvcapp.Dao.CriteriaCustomer" %><%--
  Created by IntelliJ IDEA.
  User: xyjwork
  Date: 2018/10/13
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%!

%><%
    Object msg = request.getAttribute("message");
    if (msg != null){
%>
<br>
<span style="color: red; "><%= msg%></span>
<br>
<br>
<%

    }
    Customer customer = (Customer) request.getAttribute("customer");
%>
<form action="update.do" method="post">

    <input type="hidden" name="id" value="<% customer.getId(); %>"/>
    <input type="hidden" name="oldname" value="<% customer.getName(); %>"/>
        <table>
        <tr>
            <td>CustomerName:</td>
            <td><input type="text" name="name"
                       value="<%=  customer.getName()%>"/></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address"
                       value="<%= customer.getAddress()%>"/></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><input type="text" name="phone"
                       value="<%= customer.getPhone()  %>"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Submit"/></td>

        </tr>

    </table>

</form>
</body>
</html>
