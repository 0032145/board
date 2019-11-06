<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="test" value="나나나"/>
<%// scope="page"가 기본값 %>
${test}<br>

<%@ include file="/WEB-INF/views/common/header.jspf"%>
<%
	pageContext.setAttribute("msg", "난 페이지");
	request.setAttribute("msg", "난 리퀘스트");
	session.setAttribute("msg", "난 세션");
	application.setAttribute("msg", "난 어플리케이션");
	//RequestDispatcher rd = request.getRequestDispatcher("/views/test/2");
	//rd.forward(request, response);
%>
${msg}
<%
	// EL(Expression Language)은 제일 작은 값부터 찾음
%>