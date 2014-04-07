<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<c:url value="/" var="homeUrl"/>
<c:url value="user" var="userUrl"/>
<c:url value="admin" var="adminUrl"/>
<c:url value="logout" var="logoutUrl"/>

<div class="menu">
	<ul>
		<li><a href="${homeUrl}">Home</a></li>
		<security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_MODERATOR')">
			<li><a href="${userUrl}">User</a></li>
		</security:authorize>
		<security:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="${adminUrl}">Admin</a></li>
		</security:authorize>

		<li><a href="${logoutUrl}">Logout</a></li>
	</ul>
	<span id="menu-username"><%=SecurityContextHolder.getContext().getAuthentication().getName()%></span>
	<br style="clear:left"/>
</div>