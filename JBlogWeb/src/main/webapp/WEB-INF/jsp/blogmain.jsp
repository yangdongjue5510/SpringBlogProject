<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${blog.title}</title>
    <Link rel="stylesheet" href="css/theme.css">
</head>
<body>
<center>
    <header>
        <h1>${blog.title}</h1>
        <h3>${blog.tag}</h3>
        <div>
            <c:if test="${user == null }">
                <a href="/loginView">로그인</a>
            </c:if>
            <c:if test="${user != null }">
                <a href="/logout">로그아웃</a>
                <c:if test="${blog.blogId == user.userId}">
                    <a href="/blogAdmin/${blog.blogId}">블로그 관리</a>
                </c:if>
            </c:if>
        </div>
        <br>
        <div>
            <h3>카테고리</h3>
            <c:forEach var="category" items="${categoryList}">
                <a href="#">${category.categoryName}</a>
                <br>
            </c:forEach>
        </div>
    </header>
    <div>
        <table border="1" cellpadding="0" cellspacing="0" width="1200">
            <tr>
                <th bgcolor="dodgerblue" width="200">제목</th>
                <th bgcolor="dodgerblue" width="150">날짜</th>
                <th bgcolor="dodgerblue" width="150">작성자</th>
                <th bgcolor="dodgerblue" width="350">내용</th>
                <th bgcolor="dodgerblue" width="150">수정/삭제</th>
            </tr>

            <c:forEach var="post" items="${postList}">
            <tr>
                <td><a href="#"/> ${post.title}</td>
                <td><fmt:formatDate value="${post.createdDate}" pattern="yyyy-MM-dd"/> </td>
                <td>${post.writer }</td>
                <td>${post.content}</td>
                <td>
                    <a href="#">EDIT</a>
                    <span>/</span>
                    <a href="#">DEL</a>
                </td>
            </tr>
            </c:forEach>
    </div>

</center>
</body>
</html>