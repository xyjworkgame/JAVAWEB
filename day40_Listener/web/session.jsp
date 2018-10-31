<%--
  Created by IntelliJ IDEA.
  User: xyjwork
  Date: 2018/10/31
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>Session Page</h4>
<%

    HttpSession session1 = request.getSession(true);

//    session1.setMaxInactiveInterval(10);
//    session1.invalidate();

%>
</body>
</html>
