<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="str" value="abc" />
	<c:if test="${str eq 'abc'}">
	str은 abc네
	</c:if>
	<c:if test="${str ne 'abc' }">
	str은 abd가 아니네
	</c:if>
	
	<br>
	
	<c:choose>
		<c:when test="${member.level=='trial'}">
		<li>trial
		</c:when>
		<c:when test="${member.level=='regular'}">
		<li>regular
		</c:when>
		<c:when test="${member.level=='provider'}">
		<li>provider
		</c:when>
		<c:otherwise>
		<li>nothing
		</c:otherwise>
	</c:choose>
	
	<br>
	
	<c:forEach var="var" items="item">
	<tr>
	<td align="right" bgcolor="#ffffff">
	${var}
	</td>
	</c:forEach>
	
	<br>
	
	<c:forEach var="i" begin="1" end="10">
	${i}
	</c:forEach>
	
	<br>
	
	<c:forEach var="i" begin="1" end="10" step="2">
	${i}
	</c:forEach>
	
	<br>
	
	<c:forEach var="i" items="${intArray}" begin="2" end="4">
	[${i}]
	</c:forEach>
	
	
</body>
</html>