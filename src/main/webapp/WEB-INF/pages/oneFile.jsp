<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OneFileUpload</title>
</head>
<body>
    <form action="/onefile" enctype="multipart/form-data" method="post" >
        <input type="file" name="file">
        <%--<input type="text" name="description">--%>
        <input type="submit" value="submit">
    </form>


</body>
</html>
