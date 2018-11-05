<%@ page import="java.util.Date" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: xyjwork
  Date: 2018/11/3
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
      Date date = new Date();
      request.setAttribute("date", date);

      request.setAttribute("salary", 12345.67);
  %>

  <%--
  <fmt:bundle basename="i18n">
      <fmt:message key="date"></fmt:message>:
      <fmt:formatDate value="${date }"/>,
      <fmt:message key="salary"></fmt:message>:
      <fmt:formatNumber value="${salary }"></fmt:formatNumber>
  </fmt:bundle>
  <br><br>
  --%>

  <%
      String code = request.getParameter("code");

      if(code != null){
          if("en".equals(code)){
              session.setAttribute("locale", Locale.US);
          }else if("zh".equals(code)){
              session.setAttribute("locale", Locale.CHINA);
          }

      }
  %>

  <c:if test="${sessionScope.locale != null }">
      <fmt:setLocale value="${sessionScope.locale }"/>
  </c:if>

  <fmt:setBundle basename="i18n"/>

  <fmt:message key="date"></fmt:message>:
  <fmt:formatDate value="${date }" dateStyle="FULL"/>,
  <fmt:message key="salary"></fmt:message>:
  <fmt:formatNumber value="${salary }" type="currency"></fmt:formatNumber>
  <br><br>

  <a href="index.jsp?code=en">English</a>
  <a href="index.jsp?code=zh">中文</a>

  </body>
</html>
