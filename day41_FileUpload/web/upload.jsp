<%--
  Created by IntelliJ IDEA.
  User: xyjwork
  Date: 2018/10/31
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="uploadServlet" method="post" enctype="multipart/form-data">//二进制的数据上传

        File: <input type="file" name="file"/>
        <br>
        <br>
        Desc:<input type="text" name="desc"/>
        <br>
        <br>
        <input type="submit" value="Submit"/>


    </form>
</body>
</html>
