<%@ page import="java.util.List" %>
<%@ page import="com.javaweb.el.Customers" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: XYJ
  Date: 2018/10/21
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="mytag" uri="http://mycompany.com/mytag/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <mytag:testJspFragment>Helloworld</mytag:testJspFragment>

<br><br>
    <mytag:printUpper time="10">

        avvfgbfs
    </mytag:printUpper>
    <br><br>
    <br><br>
<%
    List<Customers> customers = new ArrayList<>();

    customers.add(new Customers(1,"AAA"));
    customers.add(new Customers(2,"BBB"));
    customers.add(new Customers(3,"CCC"));
    customers.add(new Customers(4,"DDD"));
    customers.add(new Customers(5,"EEE"));

    request.setAttribute("customers",customers);

    Map<String,Customers> customersMap = new HashMap<>();
    customersMap.put("a",customers.get(0));
    customersMap.put("b",customers.get(1));
    customersMap.put("c",customers.get(2));
    customersMap.put("d",customers.get(3));
    customersMap.put("e",customers.get(4));

    request.setAttribute("customerMap",customersMap);
%>
    <!--父标签打印name到控制台-->
    <mytag:parentTag>
        <!--子标签以父标签的标签体存在，子标签把父标签的name属性打印到jsp页面上，-->

    </mytag:parentTag>

    <c:forEach items="${customerMap}" var="cust">
        --${pageScope.cust.key} -- ${cust.value.id} -- ${cust.value.name}<br>
    </c:forEach>
    <br><br>
    <mytag:forEachTag var="cust" items="${requestScope.customers}">
        --${cust.id} -- ${cust.name} <br>
    </mytag:forEachTag>

    <c:choose>
        <c:when test="${param.age > 24}">大学毕业</c:when>
        <c:when test="${param.age > 20}">高中毕业</c:when>
        <c:otherwise>高中以下。。。</c:otherwise>
    </c:choose>

    <mytag:choose>
        <mytag:when test="${param.age > 24}">~大学毕业</mytag:when>
        <mytag:when test="${param.age > 20}">~高中毕业</mytag:when>
        <mytag:otherwise>~高中以下。。。</mytag:otherwise>
    </mytag:choose>

<!-- 使用一个EL 的自定义函数-->
    ${fn:length(param.name)}
<br><br>
<!--测试自定义函数-->
${mytag:concat(param.name1,param.name2 )}

</body>
</html>
