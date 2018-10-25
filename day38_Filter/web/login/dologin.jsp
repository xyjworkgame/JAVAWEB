<%--
  Created by IntelliJ IDEA.
  User: XYJ
  Date: 2018/10/25
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //1.获取用户的登录信息
        String username = request.getParameter("username");
        //2.若登录信息完善，则把登录信息放到HTTPSession
        if (username != null && !username.trim().equals("")){
            session.setAttribute(application.getInitParameter("userSessionKey"),username);
            //3.重定向到list.jsp
            response.sendRedirect("list.jsp");
        }else {
            response.sendRedirect("login.jsp");
        }
    %>
</body>
</html>
