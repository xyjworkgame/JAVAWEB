<%--
  Created by IntelliJ IDEA.
  User: xyjwork
  Date: 2018/11/1
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="uploadServlet" method="post" enctype="multipart/form-data">

    File: <input type="file" name="file"/>
    <br>
    <br>
    Desc: <input type="text" name="desc"/>
    <br>
    <br>

    <input type="checkbox" name="interesting" value="Reading"/>Reading
    <input type="checkbox" name="interesting" value="Party"/>Party
    <input type="checkbox" name="interesting" value="Sports"/>Sports
    <input type="checkbox" name="interesting" value="Shopping"/>Shopping
    <br>
    <br>


    <input type="submit" value="Submit"/>

</form>
</body>
</html>
