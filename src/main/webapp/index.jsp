<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>welcome</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1>HUGO图书管理系统</h1>
        <p>欢迎来到图书管理系统！！！</p>
        <a href="${pageContext.request.contextPath}/book/booklist.html" class="btn btn-info" role="button">进入图书管理系统</a>
    </div>
</div>
</body>
</html>