<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<html>	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta http-equiv="Content-Language" content="English"/>
		<link rel="stylesheet" type="text/css" media="screen" href="resources/css/style.css"/>
		<title>Duplicate Session</title>
	</head>
	
	<body>
		<jsp:include page="menu.jsp" />
		<h1 id="banner">Duplicate Session Page</h1>
		<hr />
		<p>
			<c:if test="${error == true}">
				<b class="message">Duplicate Session Page. Please logout the other session and login again.</b>
			</c:if>
		</p>
		
		<%-- <p>
			<a href="${pageContext.request.contextPath}/">Login</a><br/>
		</p> --%>
	</body>
</html>