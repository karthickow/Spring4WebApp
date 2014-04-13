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
		<title><spring:message code="expired.session.page.title"/></title>
	</head>
	
	<body>
		<h2 id="banner"><spring:message code="expired.session.page.banner"/></h2>
		<hr/>
		<p>
			<c:if test="${error == true}">
				<b class="message"><spring:message code="expired.session.page.error.message"/></b>
			</c:if>
		</p>
		
		<p>
			<a href="${pageContext.request.contextPath}/"><spring:message code="login.page.link"/></a><br/>
		</p>
	</body>
</html>