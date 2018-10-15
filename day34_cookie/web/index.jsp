<%@ page import="java.net.CookieHandler" %><%--
  Created by IntelliJ IDEA.
  User: xyjwork
  Date: 2018/10/14
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

      <%--<%--%>
        <%--//在javaweb 规范中使用cookie类使用cookie--%>



        <%--//1获取Cookie--%>
          <%--Cookie [] cookies = request.getCookies();--%>

          <%--if (cookies != null && cookies.length > 1){--%>
             <%--for (Cookie cookie1 : cookies){--%>
                 <%--out.print(cookie1.getName() + ": " + cookie1.getValue());--%>
                 <%--out.print("<br>");--%>
             <%--}--%>
          <%--}else {--%>
              <%--out.print("没有一个cookie ， 正在创建并返回");--%>
              <%--//1.创建一个Cookie--%>
              <%--Cookie cookie = new Cookie("name","yj");--%>
              <%--//2. 调用response 的一个方法把COokie 传给客户端--%>

              <%--//setMaxAge : 设置Cookie 的最大时效，秒为单位，0 立即删除--%>
              <%--//若为负数，表示不存储，--%>
              <%--cookie.setMaxAge(30);--%>

              <%--//传给客户端--%>
              <%--response.addCookie(cookie);--%>

          <%--}--%>

      <%--%>--%>
      <%
          String name = request.getParameter("name");
          if (name != null && !name.trim().equals("")){
              out.print("Hello : " + name);
              Cookie cookie = new Cookie("name",name);
              cookie.setMaxAge(30);
              response.addCookie(cookie);
          }else {
              Cookie [] cookies = request.getCookies();

              if (cookies != null && cookies.length > 0){
                  for (Cookie cookie : cookies){
                      String cookieName = cookie.getName();
                      if ("name".equals(cookieName)){
                          String val = cookie.getValue();
                          name = val;
                      }
                  }
              }
          }

          if (name != null && !name.trim().equals("")){
              out.print("HEllo :" + name);

          }else {
              response.sendRedirect("login.jsp");
          }
      %>
  

      <form action="index.jsp"></form>

  </body>
</html>
