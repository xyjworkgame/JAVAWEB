<%--
  Created by IntelliJ IDEA.
  User: xyjwork
  Date: 2018/11/1
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        $(function () {
            //1.获取#addFIle，并为其添加click响应函数
            var i = 2;
            $("#addFile").click(function () {
                $("#br").before("<tr class='file'><td>File"
                    + i + ":</td><td><input type='file' name='file"
                    + i + "'/></td></tr>"
                    + "<tr class='desc'><td>Desc"
                    + i + ":</td><td><input type='text' name='desc"
                    + i + "'/><button id='delete"
                    + i + "'>删除</button></td></tr>");

                fds
                i++;
            })
            //2.利用jQUrey 生成，注意数字的写法,并把他们都#br前面
            //其中删除按钮可以删除当前的file和desc相关的结点
            /*
                File:<input>
             */


        })
        
    </script>
</head>
<body>
<span style="color: red; ">${msg}</span>
<br><br>

<form action="fileuploadservlet" method="post" enctype="multipart/form-data">

    <table>
        <tr class="file">
            <td>File1:</td>
            <td><input type="file" name="file1"/></td>
        </tr>
        <tr class="desc">
            <td>Desc1:</td>
            <td><input type="text" name="desc1"/></td>
        </tr>

        <tr>
            <td><input type="submit" id="submit" value="提交"/></td>
            <td><button id="addFile">新增一个附件</button></td>
        </tr>
    </table>

</form>
</body>
</html>
