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

        window.onload = function (ev) {
            var aNodes = document.getElementsByTagName("a");
            for (var i = 0;i < aNodes.length ; i++){
                aNodes[i].onclick = function (ev1) {
                    var request = new XMLHttpRequest();
                    var method = "GET";
                    var url = this.href;


                    request.open(method,url);
                    request.send(null);



                    request.onreadystatechange = function (ev2) {
                        if (request.readyState == 4){
                            if (request.status == 200 || request.status == 304){
                                document.getElementById("details").innerHTML = request.responseText;
                            }
                        }
                    }
                    return false;
                }
            }
        }
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
