<%@page contentType="text/html; charset=EUC-KR" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="/static/css/theme.css">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>글 목록</title>
</head>
<body>
<center>
    <img src="/static/images/logo.jpg">
    <br>
    <div>
        <a href="/loginView">로그인</a>
        <a href="/blogCreateView">블로그등록</a>
        <a href="/blogMainView">내 블로그로 가기</a>
    </div>

    <!-- 검색 시작 -->
    <form action="/api/blogList" method="post">
        <input name="searchKeyword" type="text"/>
        <div>
            <input type="radio" id="contactChoice1"
                   name="searchCondition" value="title" checked>
            <label for="contactChoice1">블로그 제목</label>

            <input type="radio" id="contactChoice2"
                   name="searchCondition" value="blogTag">
            <label for="contactChoice2">태그</label>

            <input type="radio" id="contactChoice3"
                   name="searchCondition" value="blogger">
            <label for="contactChoice3">블로거</label>
        </div>
        <input type="submit" value="검색"/>
    </form>

    <c:if test="${not empty boardList}">
    <table border="1" cellpadding="0" cellspacing="0" width="700">
        <tr>
            <th width="100">블로그 제목</th>
            <th width="200">블로거</th>
            <th width="150">로고</th>
            <th width="150">상태</th>
            <th width="100">삭제</th>
        </tr>
        <c:forEach var="board" items="${boardList}">
            <tr>
                <td>${board.seq}</td>
                <td align="left"><a href="/board/getBoard?seq=${board.seq}">${board.title}</a></td>
                <td>${board.writer }</td>
                <td><fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd"/></td>
                <td>${board.cnt }</td>
            </tr>
        </c:forEach>
    </table>
    </c:if>


    <br>
</center>
</body>
</html>


