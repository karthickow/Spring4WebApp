<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<c:url value="home" var="homeUrl"/>
<c:url value="user" var="userUrl"/>
<c:url value="admin" var="adminUrl"/>
<c:url value="employee" var="empUrl"/>
<c:url value="logout" var="logoutUrl"/>

<div class="menu">
	<ul>
		<security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_MODERATOR', 'ROLE_USER')">
			<li><a href="${pageContext.request.contextPath}/${homeUrl}"><spring:message code="menu.page.homeurl"/></a></li>
		</security:authorize>
		
		<security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_MODERATOR', 'ROLE_USER')">
			<li><a href="${pageContext.request.contextPath}/${userUrl}"><spring:message code="menu.page.userurl"/></a></li>
		</security:authorize>
		
		<security:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="${pageContext.request.contextPath}/${adminUrl}"><spring:message code="menu.page.adminurl"/></a></li>
		</security:authorize>
		
		<security:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="${pageContext.request.contextPath}/${empUrl}"><spring:message code="menu.page.empurl"/></a></li>
		</security:authorize>
		
		<security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_MODERATOR', 'ROLE_USER')">
			<li><a href="${pageContext.request.contextPath}/${logoutUrl}"><spring:message code="menu.page.logouturl"/></a></li>
		</security:authorize>
	</ul>
	<span id="menu-username"><%=SecurityContextHolder.getContext().getAuthentication().getName()%></span>
	<br style="clear:left"/>
</div>