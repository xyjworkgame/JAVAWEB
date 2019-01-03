<%--
  Created by IntelliJ IDEA.
  User: Firewine
  Date: 2018/11/25
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript">

      var jsonObject = {
          "name":"xiue",
          "age":12,
          "address":{"city":"shenme","school":"meyou"},
          "teaching":function () {
              alert("javaEE,Android")
          }
      };

      //alert(jsonObject.name)
      //jsonObject.teaching();

      var jsonStr = "{'name':'sss'}";

      //使用eval()方法
      var testStr = "alert('hello eval')";

      //eval可以把一个字符串转为本地的JS代码来执行
     // eval(testStr);

      //把json字符串转为JSON对象
      var  testObject = eval("(" + jsonStr + ")");
      alert(testObject.name);

    </script>
  </head>
  <body>
  <h1>People</h1>
  <ul>
    <li><a href="files/andy.html">Andy</a></li>
    <li><a href="files/richard.html">Richard</a></li>
    <li><a href="files/jeremy.html">jeremy </a></li>
  </ul>

  <div id="details"></div>
  </body>
</html>
