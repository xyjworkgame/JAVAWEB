<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/27
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <div style="text-align: center;">

        <br><br>
        <form action="AuthorityServlet?method=getAuthorities" method="post">
            name : <input type="text" name="username">
            <input type="submit" value="Submit">

        </form>


    <c:if test="${requestScope.user != null}">
        ${requestScope.user.username } 的权限是：
        <br><br>

        <form action="AuthorityServlet?method=updateAuthority" method="post">

            <input type="hidden" value="${requestScope.user.username }" name="username"/>

            <c:forEach items="${authorities}" var="auth">
            <c:set value="false" var="flag"></c:set>
                <c:forEach items="${user.authorities }" var="ua">

                    <c:if test="${ua.url == auth.url}">
                        <c:set var="flag" value="true"></c:set>
                    </c:if>

                </c:forEach>
                <c:if test="${flag == true}">

                <input type="checkbox"
                       name="authority"
                       value="${auth.url}" checked="checked"/>${auth.displayName}

                </c:if>
                <c:if test="${flag == false}">

                    <input type="checkbox"
                           name="authority"
                           value="${auth.url}" />${auth.displayName}

                </c:if>
                <br><br>
            </c:forEach>

            <input type="submit" value="update"/>



        </form>


    </c:if>
    </div>
</body>
</html>
