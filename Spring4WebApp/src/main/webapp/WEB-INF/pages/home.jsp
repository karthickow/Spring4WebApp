<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<!DOCTYPE HTML>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta http-equiv="Content-Language" content="English"/>
		<link rel="stylesheet" type="text/css" media="screen" href="resources/css/style.css"/>
		<title><spring:message code="home.page.title"/></title>
	</head>
	
	<body>
		<jsp:include page="menu.jsp" />
		<h1 id="banner"><spring:message code="home.page.banner"/></h1>
		<hr/>
		<p>
			<spring:message code="home.page.welcome"/><span id="username"><%=SecurityContextHolder.getContext().getAuthentication().getName()%></span><spring:message code="home.page.splchar"/>
		</p>
	</body>
</html>