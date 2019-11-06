<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	안녕하세요
	<br>
	<%
		if (user == null) {
	%>
	<a href="/views/user/login">로그인</a>
	<br> 회원이 아니신가요?
	<br>
	<a href="/views/user/signup">회원가입</a>
	<%
		} else {
	%>
	<a href="/board/list">게시판가기</a>
	<a href="/users/logout">로그아웃</a>
	<%
		}
	%>

</body>
</html>

