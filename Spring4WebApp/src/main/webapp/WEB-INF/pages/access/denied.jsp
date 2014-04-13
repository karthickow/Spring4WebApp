<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<!DOCTYPE HTML>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta http-equiv="Content-Language" content="English"/>
		<link rel="stylesheet" type="text/css" media="screen" href="resources/css/style.css"/>
		<title><spring:message code="denied.page.title"/></title>
	</head>
	
	<body>
		<h2 id="banner"><spring:message code="denied.page.banner"/></h2>
		<hr/>
		<p class="message"><spring:message code="denied.page.error.message"/></p>
		<p>
			<a href="${pageContext.request.contextPath}/"><spring:message code="login.page.link"/></a><br />
		</p>
	</body>
</html>