<%--
  Created by IntelliJ IDEA.
  User: NOVE
  Date: 2019/12/9
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>hello world</h2>

    <input type="button" value="异步请求服务器" onclick="getLabelsPost()">
    <span id="span1"></span>
    <span id="span2"></span>
    <br>


</body>
</html>
<script >
    //定义类
    class TestClass {
        constructor(a, b) {
            this.a = a;
            this.b = b;
        }

        toString() {
            return '(' + this.username + ', ' + this.password + ')';
        }
    }

    function fn1() {


        var xmlHttp = new XMLHttpRequest();

        xmlHttp.onreadystatechange = function() {
            document.getElementById("span2").innerHTML= document.getElementById("span2").innerHTML+"</br>"+xmlHttp.readyState+" "+xmlHttp.status;
            //当状态变化时处理的事情

            if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {

                //5.接收响应信息

                var data = xmlHttp.responseText;

                // alert(data);

                document.getElementById("span1").innerHTML=data;

            }

        }

        xmlHttp.open("GET", "http://localhost:8081/ajaxServlet?username=zhangsan", false);
        xmlHttp.send();

        // xmlhttp.open("POST","http://localhost:8081/ajaxServlet",false);
        // xmlhttp.send();


    }
    function GetXmlHttpObject(){
        if (window.XMLHttpRequest){
// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
        }else{// code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        return xmlhttp;
    }
    function getLabelsPost() {
        xmlHttp = GetXmlHttpObject();
        if (xmlHttp == null) {
            alert('您的浏览器不支持AJAX！');
            return;
        }
        var url = "http://localhost:8081/ajaxServlet";
        xmlhttp.open("POST", url, true);
        xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlhttp.send("username=lisi");
        xmlHttp.onreadystatechange = function () {
            document.getElementById("span2").innerHTML = document.getElementById("span2").innerHTML + "</br>" + xmlHttp.readyState + " " + xmlHttp.status;

            if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {

                //5.接收响应信息

                var data = xmlHttp.responseText;

                // alert(data);

                document.getElementById("span1").innerHTML = data;

            }

        }
    }









    function fn2() {
        var params = {
            username: "zhangsan",
        };
        $.ajax({
            url: "http://localhost:8081/ajaxServlet", // 目标资源
            cache: false, //true 如果当前请求有缓存的话，直接使用缓存。如果该属性设置为 false，则每次都会向服务器请求
            async: false, //默认是true，即为异步方式
            data: params,
            dataType: "text", // 服务器响应的数据类型
            type: "GET", // 请求方式
            success: function (data) {
                console.log(data)
                document.getElementById("span1").innerHTML=data;
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
                //通常情况下textStatus和errorThrown只有其中一个包含信息
                document.getElementById("span1").innerHTML=XMLHttpRequest+" "+textStatus+" "+errorThrown;
            }

        });

    }

</script>