<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: XYJ
  Date: 2018/10/6
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Date date = new Date();
        out.print(date);
    %>

    <br><br>
    <%--jsp 表达式--%>
    <%= date%>


    <%
        String ageStr = request.getParameter("age");
        Integer age = Integer.parseInt(ageStr);


        if (age > 18){
    %>
        成人
    <%
        }else {
    %>
        未成人
    <%
        }
    %>

    <%!
        void test(){}
    %>
<%----%>
</body>
</html>
