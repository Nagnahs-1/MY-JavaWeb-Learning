<%@ page import="top.soft.bookonline.entity.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书详情页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
    <style type="text/css">
        h2, h3 {
            color: rgb(73, 73, 73);
        }

        #search {
            height: 80px;
            background-color: rgb(246, 246, 241);
            display: flex;
            align-items: center;
            padding-left: 8%;
            margin-bottom: 10px;
        }

        .search-input {
            flex: 0 0 40%;
            height: 35px;
            background-color: #fff;
            border: none;
            border-radius: 3px;
            margin-left: 50px;
        }

        .search-btn {
            width: 35px;
            height: 35px;
            background-color: rgb(155, 154, 143);
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .search-btn img {
            width: 100%;
            height: 100%;
        }

        .col-4 img {
            margin: 10px 5px 20px 5px;
            width: 80%;
        }

        hr {
            width: 90%;
            color: #eee;
            margin-top: 10px;
        }

        .col-6 {
            height: 400px;
            padding-right: 10px;
        }

        .col-6 img {
            width: 100%;
            height: 100%;
            border-radius: 20px;
        }

        /* ... 其他样式保持不变 */

        .book-details {
            display: flex;
            flex-direction: column;
            justify-content: space-between;
        }

        .col-6 {
            height: fit-content; /* 自动根据内容高度调整 */
            padding-right: 10px;
        }

        .col-6 img {
            width: 100%;
            height: auto;
            border-radius: 20px;
        }

        .book-details p {
            font-size: 1.6em; /* 调整文字大小 */
            margin: 0.5em 0; /* 添加上下外边距 */
        }
    </style>
</head>
<body>
    <%
    Book book = (Book) request.getAttribute("book");
    pageContext.setAttribute("book", book);
%>
<div id="top">
    <jsp:include page="top.jsp"/>
</div>
<div id="search">
    <h2>读书时刻</h2>
    <input type="text" placeholder="书名、作者、ISBN" class="search-input">
    <div class="search-btn">
        <img src="${pageContext.request.contextPath}/images/search.png" alt="">
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-8">
            <p style="font-weight: bold;font-size: 22px;color: #232525">${book.name}</p>
            <hr>
            <div class="row">
                <div class="col-4">
                    <img src="${book.cover}" alt="">
                </div>
                <div class="col-6">
                    <div class="book-details">
                        <p>作者：${book.author}</p>
                        <p>价格：${book.price}</p>
                        <p>类别：${book.category}</p>
                        <p>语言：${book.language}</p>
                        <p>出版社：${book.publisher}</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-4">
            <h3>热门标签</h3>
            <hr>
            <img src="${pageContext.request.contextPath}/images/right.png">
        </div>
    </div>
</div>