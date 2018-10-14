<%@ page import="java.util.List" %>
<%@ page import="com.Servelt.mvc.student" %><%--
  Created by IntelliJ IDEA.
  User: XYJ
  Date: 2018/10/7
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    List<student> stus = (List<student>)request.getAttribute("students");
%>
    <table border="1" cellpadding="10" cellspacing="0">


        <tr>
            <th>flowid</th>
            <th>Type</th>
            <th>IdCard</th>
            <th>ExamCard</th>
            <th>Studentname</th>
            <th>Location</th>
            <th>Grade</th>
            <th>delete</th>

        </tr>
        <%
            for (student student : stus){
        %>
            <tr>
                <td><%= student.getFlowid()%></td>
                <td><%= student.getType()%></td>
                <td><%= student.getIdCard()%></td>
                <td><%= student.getExamCard()%></td>
                <td><%= student.getStudentName()%></td>
                <td><%= student.getLocation()%></td>
                <td><%= student.getGrade()%></td>
                <td><a href="deleteStudent?flowId=<%=student.getFlowid()%>">Delete</a></td>

            </tr>
        <%
            }
        %>
    </table>

</body>
</html>
