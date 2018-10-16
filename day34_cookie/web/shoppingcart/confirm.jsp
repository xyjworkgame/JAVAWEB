<%@ page import="java.util.Currency" %>
<%@ page import="com.javaweb.session.Customer" %><%--
  Created by IntelliJ IDEA.
  User: XYJ
  Date: 2018/10/16
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Customer customer = (Customer) session.getAttribute("customer");
    String [] books = (String[]) session.getAttribute("books");
%>
    <table>

        <tr>
            <td>顾客姓名：</td>
            <td><%= customer.getName()%></td>
        </tr>
        <tr>
            <td>地址：</td>
            <td><%= customer.getAddress()%></td>
        </tr>
        <tr>
            <td>卡号：</td>
            <td><%= customer.getCard()%></td>
        </tr>
        <tr>
            <td>卡的类型：</td>
            <td><%= customer.getCardType()%></td>
        </tr>
        <tr>
            <td>books：</td>
            <td>

                <%
                    for(String book : books){
                        out.print(book);
                        out.print("<br>");

                    }
                %>
            </td>



        </tr>

    </table>
</body>
</html>
