<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>图书管理系统</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/bookList.css">
</head>
<body>
<div class="container">
    <h2>图书管理系统</h2>
    <p>书籍是人类进步的阶梯</p>
    <!--查询表单-->

    <form id="bookForm" name="bookForm" class="form-inline inputBox" method="post" action="${pageContext.request.contextPath}/book/booklist.html">
        <select class="form-control" name="queryKeyword">
            <option value="bookName">书名</option>
            <option value="bookAuther">作者</option>
            <option value="bookPublish">出版社</option>
        </select>
        <div class="searchBox">
            <input type="text" class="form-control" placeholder="Enter text" name="queryKeywordValue">
            <button type="submit" class="btn btn-primary">搜索</button>
        </div>
        <input type="hidden" name="pageIndex" value="1"/>
    </form>

    <table class="table table-bordered">
        <thead  class="thead-light">
        <tr>
            <th>书名</th>
            <th>作者</th>
            <th>出版社</th>
            <th>页数</th>
            <th>价格</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${bookList}" varStatus="status">
            <tr>
                <td>
                    <span>${book.bookName}</span>
                </td>
                <td>
                    <span>${book.bookAuther}</span>
                </td>
                <td>
                    <span>${book.bookPublish}</span>
                </td>
                <td>
                    <span>${book.bookPage}</span>
                </td>
                <td>
                    <span>${book.bookPrice}</span>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!--分页-->
    <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
    <ul class="pagination">
        <c:if test="${currentPageNo > 1}">
            <li class="page-item">
                <a class="page-link" href="javascript:page_nav(document.forms[0],1);">首页</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="javascript:page_nav(document.forms[0],${currentPageNo-1});">上一页</a>
            </li>
        </c:if>
        <c:if test="${currentPageNo < totalPageCount }">
            <li class="page-item">
                <a class="page-link" href="javascript:page_nav(document.forms[0],${currentPageNo+1 });">下一页</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="javascript:page_nav(document.forms[0],${totalPageCount });">最后一页</a>
            </li>
        </c:if>
        &nbsp;&nbsp;
        <li class="page-info"><span>共${totalCount }条记录&nbsp;&nbsp; ${currentPageNo }/${totalPageCount }页</span></li>
    </ul>
    <a href="${pageContext.request.contextPath}/book/bookadd.html" class="btn btn-primary" role="button">添加图书</a>
</div>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/rollpage.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/index.js"></script>
</body>