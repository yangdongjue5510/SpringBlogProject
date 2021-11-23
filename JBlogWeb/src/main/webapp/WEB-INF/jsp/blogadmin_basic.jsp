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
            </c:if>
            <a href="/blogMain/${blog.blogId}">내 블로그 메인</a>
        </div>
        <br>
    </header>
    <div>
        <a>기본 설정</a>
        <a href="#">카테고리</a>
        <a href="#">글작성</a>
    </div>
    <form action="#" method="post">
        <div>
            <span>블로그 제목 :</span>
            <input type="text" value="${blog.title}"/>
        </div>
        <div>
            <span>블로그 태그 :</span>
            <input type="text" value="${blog.tag}"/>
        </div>
        <div>
            <span>메인페이지 포스트 :</span>
            <input type="text" value="${blog.cntDisplayPost}"/>
        </div>
        <div>
            <span>로고 이미지 :</span>
            <img src="/static/images/j2eelogo.jpg"/>
        </div>
        <input type="submit" value="확인"></input>
    </form>

</center>
</body>
</html>