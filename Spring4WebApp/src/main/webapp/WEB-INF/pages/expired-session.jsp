<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" media="screen" href="resources/css/style.css"/>
		<title>Session Expired</title>
	</head>
	
	<body>
		<jsp:include page="menu.jsp" />
		<h2 id="banner">Session Expired</h2>
		<hr />
		<p>
			<c:if test="${error == true}">
				<b class="error">Your Session Expired. Please login again.</b>
			</c:if>
		</p>
		
		<%-- <p>
			<a href="${pageContext.request.contextPath}/">Login</a><br/>
		</p> --%>
	</body>
</html>