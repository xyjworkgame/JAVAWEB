<%--
  Created by IntelliJ IDEA.
  User: xyjwork
  Date: 2018/10/16
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h4>Step1:选择要购买的图书：</h4>

    <form action="processStep1" method="post">
        <table>
            <tr>
                <td>书名</td>
                <td>购买</td>

            </tr>
            <tr>
                <td>java</td>
                <td><input type="checkbox" name="book" value="java"/></td>
            </tr>
            <tr>
                <td>oracle</td>
                <td><input type="checkbox" name="book" value="oracle"/></td>
            </tr>
            <tr>
                <td>structs</td>
                <td><input type="checkbox" name="book" value="structs"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit"/>
                </td>
            </tr>

        </table>

    </form>
</body>
</html>
