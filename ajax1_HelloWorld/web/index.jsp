<%--
  Created by IntelliJ IDEA.
  User: Firewine
  Date: 2018/11/25
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript">

      window.onload = function () {
          //1. 获取a节点，并为其添加onclick响应函数
          document.getElementsByTagName("a")[0].onclick = function (ev) {

              //3. 创建一个XMLHttpRequest对象
              var request = new XMLHttpRequest();

              //4. 准备发送请求的数据：url
              var url = this.href + "?time=" + new Date();
              var method = "GET";

              //5.调用XMLHttpRequest 对象的open方法
              request.open(method,url);

              //6.调用XMLHTTPRequest 对象的send方法
              request.send(null);

              //7. 为XMLRequest 对象添加onreadystatechange 相应函数
              request.onreadystatechange = function (ev1) {
                  alert(request.readyState);
                  //8. 判断相应是否完成：XMLHTTPRequest 对象的readyState 属性值为4的时候
                  //9. 再判断相应是否可用；XMLHTTPRequest 对象 status 属性值为200
                  if (request.readyState == 4){
                      if (request.status == 200 || request.status == 304){
                          //10. 打印响应结果：resonanseText
                          alert(request.responseText);
                      }
                  }
              }
              return false;
          }
      }
    </script>
  </head>
  <body>

  <a href="helloAjax.txt">HelloAjax</a>
  </body>
</html>
