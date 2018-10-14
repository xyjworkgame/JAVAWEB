<%@ page import="java.util.List" %>
<%@ page import="com.study.mvcapp.domain.Customer" %><%--
  Created by IntelliJ IDEA.
  User: XYJ
  Date: 2018/10/7
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript" src="scripts/jquery-3.3.1.js"></script>
      <script type="text/javascript">

          $(function () {
              $(".delete").click(function () {
                  var content = $(this).parent().parent().find("td:eq(1)").text();
                  var flag = confirm("确定要删除"+ content +"信息吗");
                  return flag;
              })
          })

      </script>
  </head>
  <body>

  <form action="query.do" method="post">
    <table>
      <tr>
          <td>CustomerName:</td>
          <td><input type="text" name="name"/></td>
      </tr>
      <tr>
          <td>Address:</td>
          <td><input type="text" name="address"/></td>
      </tr>
      <tr>
          <td>Phone:</td>
          <td><input type="text" name="phone"/></td>
      </tr>
      <tr>
          <td><input type="submit" value="Query"/></td>
          <td><a href="newcustomers.jsp">Add New Customer</a></td>
      </tr>

    </table>

  </form>
  <br><br>
  <br><br>

  <%
    List<Customer> customers = (List<Customer>) request.getAttribute("customers");
    if (customers != null && customers.size() > 0){
        %>


  <hr>
  <br><br>
  <table border="1" cellpadding="0" cellspacing="10">
    <tr>
      <th>ID</th>
      <th>CustomerName</th>
      <th>Address</th>
      <th>Phone</th>
      <th>UPDATE\DELETE</th>
    </tr>
    <%
      for (Customer customer : customers){
          %>

      <tr>
        <td><%= customer.getId()%></td>
        <td><%= customer.getName()%></td>
        <td><%= customer.getAddress()%></td>
        <td><%= customer.getPhone()%></td>
        <td>
            <a href="edit.do?id<%= customer.getId() %>>">UPDATE</a>
            <a href="delete.do?id=<%= customer.getId() %>" class="delete">DELETE</a>
        </td>
      </tr>
    <%
      }
    %>
  <%
    }
  %>
  </body>
</html>
