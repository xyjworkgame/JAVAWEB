<%--
  Created by IntelliJ IDEA.
  User: XYJ
  Date: 2018/10/16
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>Step2:请输入寄送地址和信用卡信息</h4>
<form action="/processStep2" method="post">
    <table cellspacing="10" cellpadding="0" border="1">

        <tr>
            <td colspan="2">寄送信息</td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>寄送地址</td>
            <td><input type="text" name="address"/></td>
        </tr>
        <tr>
            <td colspan="2">信用卡信息</td>
        </tr>
        <tr>
            <td>种类：</td>
            <td>
                <input type="radio" name="cardType" value="visa"/>Visa
                <input type="radio" name="cardType" value="Master"/>Master
            </td>
        </tr>
        <tr>
            <td>卡号：</td>
            <td>
                <input type="text" name="card" />

            </td>
        </tr>
        <tr>

            <td colspan="2"><input type="submit" name="Submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>
