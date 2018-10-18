<%--
  Created by IntelliJ IDEA.
  User: xyjwork
  Date: 2018/10/18
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%=session.getAttribute("message") == null ? "":session.getAttribute("message")
    %>
    <form action="<%= request.getContextPath()%>/checkCodeServlet" method="post">

        name: <input type="text" name="name"/>
        checkCode:<input type="text" name="CHECK_CODE_PARAM_NAME"/>
        <img src="<%=request.getContextPath()%>/ValidateColorServlet">
        <input type="submit" value="Submit"/>
    </form>
</body>
</html>
