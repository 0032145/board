<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>작성시간</th>
		</tr>
		<tbody>

		</tbody>
	</table>
	<button onclick="goPage('/views/board/insert')">글쓰기</button>
	<button onclick="goPage('/users/list')">회원목록보기</button>
	<script>
		window.onload = function() {
			var xhr = new XMLHttpRequest();
			xhr.open('GET', '/board/list');
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						var list = JSON.parse(xhr.responseText);
						var html = '';
						for (var i = 0; i < list.length; i++) {
							html += '<tr>';
							html += '<td>' + list[i].biNum + '</td>';
							html += '<td>' + list[i].biTitle + '</td>';
							html += '<td>' + list[i].uiId + '</td>';
							html += '<td>' + list[i].credat + '</td>';
							html += '<td>' + list[i].cretim + '</td>';
							html += '</tr>';
						}
						document.getElementById('rDiv').innerHTML = html;
					}
				}
			}
			xhr.send();
		}
		function goPage(url) {
			location.href = url;
		}
	</script>
</body>
</html>