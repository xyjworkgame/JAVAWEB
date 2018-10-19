<%@ page import="com.javaweb.el.Customer" %><%--
  Created by IntelliJ IDEA.
  User: xyjwork
  Date: 2018/10/19
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:useBean id="customer"
                 class="com.javaweb.el.Customer"
                 scope="request"/>
    <jsp:setProperty name="customer" property="age" value="10"/>
    <%--<jsp:setProperty name="customer" property="*"/>--%>
    <%--通过* 可以给任何一个属性值赋值--%>
    age:<jsp:getProperty name="customer" property="age" />
    <%--<%--%>
        <%--customer.getAge();--%>
        <%--customer.setAge(10);--%>
    <%--%>--%>
    <%--<%--%>
        <%--//1.从scope（session） 中获取id 属性值，赋给class--%>
        <%--//类型的id变量--%>

        <%--Customer customer = (Customer)session.getAttribute("customer");--%>
        <%--//2.若属性值为null，则利用反射创建一个新的对象，把对象赋给id，并--%>
        <%--//为属性名让如到scope（session） 中--%>
        <%--if (){--%>
            <%--customer = (Customer) Class.forName("com.javaweb.javabean").newInstance();--%>

            <%--session.setAttribute("customer",customer);--%>
        <%--}--%>
    <%--%>--%>

</body>
</html>
