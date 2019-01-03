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

        window.onload = function () {
            var aNodes = document.getElementsByTagName("a");
            for (var i = 0;i < aNodes.length ; i++){
                aNodes[i].onclick = function (ev1) {
                    var request = new XMLHttpRequest();
                    var method = "GET";
                    var url = this.href;


                    request.open(method,url);
                    request.send(null);



                    request.onreadystatechange = function () {
                        if (request.readyState == 4){
                            if (request.status == 200 || request.status == 304){
                                 //1. 结果为XML格式，所以需要使用resoinseXML来获取
                                var result = request.responseXML;
                                //2.结果不能直接使用，必须先创建对应的结点，再把结点加入到#details中
                                //目标格式为：
                                /*
                                  <h2><a href="">ANdy budd</a></h2>.....
                                 */
                                var name = result.getElementsByTagName("name")[0].firstChild.nodeValue;
                                var website = result.getElementsByTagName("website")[0].firstChild.nodeValue;
                                var email = result.getElementsByTagName("email")[0].firstChild.nodeValue;

                                // alert(name);
                                // alert(website);
                                // alert(email);

                                var aNode = document.createElement("a");
                                aNode.appendChild(document.createTextNode(name));
                                aNode.href = "mailto :" + email;

                                var h2Node = document.createElement("h2");
                                h2Node.appendChild(aNode);

                                var aNode2 = document.createElement("a");
                                aNode2.appendChild(document.createTextNode(website));
                                aNode2.href = website;

                                var detailsNode = document.getElementById("details");
                                detailsNode.innerHTML = null;
                                detailsNode.appendChild(h2Node);
                                detailsNode.appendChild(aNode2);
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
