<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: XYJ
  Date: 2018/10/4
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
      <%
            Date date = new Date();
          System.out.println(date);
      %>
  <%
      String str = date.toString();

      //没有声明就可以使用的对象 就是隐含对象

      String name = request.getParameter("name");
      System.out.println(name);

      //
      System.out.println(response instanceof HttpServletResponse);

      ServletRequest req = pageContext.getRequest();
      System.out.println(req == request);


      System.out.println(session.getId());

      System.out.println(application.getInitParameter("password"));


      System.out.println(config.getInitParameter("test"));


      out.print("page");

      out.print(this);
      out.print("<br>");
      out.print(page);
  %>
  </body>
</html>
