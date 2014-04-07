<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<!DOCTYPE HTML>

<html>	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta http-equiv="Content-Language" content="English"/>
		<link rel="stylesheet" type="text/css" media="screen" href="resources/css/style.css"/>
		<title>Session Expired</title>
	</head>
	
	<body>
		<jsp:include page="menu.jsp" />
		<h2 id="banner">Session Expired</h2>
		<hr/>
		<p>
			<c:if test="${error == true}">
				<b class="message">Your Session Expired. Please login again.</b>
			</c:if>
		</p>
		
		<%-- <p>
			<a href="${pageContext.request.contextPath}/">Login</a><br/>
		</p> --%>
	</body>
</html>