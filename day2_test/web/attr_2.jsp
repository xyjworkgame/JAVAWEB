<%--
  Created by IntelliJ IDEA.
  User: XYJ
  Date: 2018/10/6
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>attr2</h2>

<br><br>
pageContextAttr : <%= pageContext.getAttribute("pageContextAttr")%>
<br><br>
requestAttr : <%= request.getAttribute("requestAttr")%>
<br><br>
sessionAttr : <%= session.getAttribute("sessionAttr")%>
<br><br>
application : <%= application.getAttribute("applicationAttr")%>

</body>
</html>
