<%--
  Created by IntelliJ IDEA.
  User: Firewine
  Date: 2018/11/26
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript" src="WEB-INF/scripts/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("a").click(function () {
                //使用load 处理aJax
                var url = this.href;
                var args = {"time" : new Date()};
                $("#content").load(url,args);


                return false;
            });
        });
    </script>
  </head>
  <body>

  <a href="/helloAjax.txt">HelloAjax</a>
  <div id="content"></div>
  </body>
</html>
