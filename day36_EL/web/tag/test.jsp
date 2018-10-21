<%--
  Created by IntelliJ IDEA.
  User: XYJ
  Date: 2018/10/21
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="utf-8" %>
<!--导入标签库（描述文件）-->
<%@taglib prefix="mytag" uri="http://java.sun.com/jsp/mytag/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<mytag:readFile src="/note"/>
<br>
<mytag:max num1="${param.a}" num2="${param.b}"/>
<br>
<mytag:hello value="${param.name}" count="10"/>
</body>
</html>
