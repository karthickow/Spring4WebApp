<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<link rel="stylesheet" type="text/css" media="screen" href="resources/css/style.css"/>
		<title>Home</title>
	</head>
	
	<body>
		<jsp:include page="menu.jsp" />
		<h1 id="banner">Home</h1>
		<hr />
		<p>Welcome <span id="username"><%=SecurityContextHolder.getContext().getAuthentication().getName()%></span>!</p>
	</body>
</html>