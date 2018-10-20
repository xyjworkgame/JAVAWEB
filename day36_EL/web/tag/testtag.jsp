<%@ page import="java.util.List" %>

<%@ page import="com.javaweb.el.Customer" %>
<%@ page import="com.javaweb.el.Customer1" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xyjwork
  Date: 2018/10/20
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    
    <!--在页面上对request 中的customer 属性进行遍历，打印id，name，age-->
    <c:forEach items="${requestScope.customers }" var="customer">
        --${customer.id},${customer.name},${customer.age}<br>

    </c:forEach>
    <%--<%--%>
        <%--List<Customer1> customers1 = (List<Customer1>) request.getAttribute("customers");--%>

        <%--if (customers1 != null){--%>
            <%--for (Customer1 customers : customers1){--%>
                <%--%>--%>
        <%--<%= customers.getId()%>,<%= customers.getName()%>,<%= customers.getAge()%><br>--%>
    <%--<%--%>

            <%--}--%>
        <%--}--%>
    <%--%>--%>


</body>
</html>
