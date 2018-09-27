<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加图书</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/bookAdd.css">
</head>
<body>

<div class="container">
    <h2>添加新书</h2>
    <form class="form-horizontal " role="form" method="post" action="${pageContext.request.contextPath}/book/bookAddSave.html">
        <div class="form-group">
            <label for="bookName" class="control-label">书名</label>
            <div class="">
                <input type="text" class="form-control" id="bookName" name="bookName" placeholder="请输入书名">
            </div>
        </div>
        <div class="form-group">
            <label for="author" class="control-label">作者</label>
            <div class="">
                <input type="text" class="form-control" id="author" name="author" placeholder="请输入作者">
            </div>
        </div>
        <div class="form-group">
            <label for="publish" class="control-label">出版社</label>
            <div class="">
                <input type="text" class="form-control" id="publish" name="publish" placeholder="请输入出版社">
            </div>
        </div>
        <div class="form-group">
            <label for="pageCount" class="control-label">页数</label>
            <div class="">
                <input type="text" class="form-control" id="pageCount" name="pageCount" placeholder="请输入页数">
            </div>
        </div>
        <div class="form-group">
            <label for="price" class="control-label">价格</label>
            <div class="">
                <input type="text" class="form-control" id="price" name="price" placeholder="请输入价格">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">提交</button>
        <button type="reset" class="btn btn-default">重置</button>
        <a class="btn btn-default" href="${pageContext.request.contextPath}/book/booklist.html" role="button">返回</a>
    </form>
</div>

</body>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</html>