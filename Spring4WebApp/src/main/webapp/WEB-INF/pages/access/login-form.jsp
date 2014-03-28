<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<link rel="stylesheet" type="text/css" media="screen" href="resources/css/style.css"/>
		<title>Login</title>		
	</head>
	
	<body>
		<p>
			<c:if test="${error == true}">
				<b class="error">Invalid login or password.</b>
			</c:if>
		</p>

		<form class="login-form" action="j_spring_security_check" method="post">
			<fieldset>
				<legend>Login Here</legend>
	
				<p>
					<label for="j_username">Username</label>: 
					<input id="j_username" name="j_username" size="20" maxlength="50" type="text" />
				</p>
	
				<p>
					<label for="j_password">Password</label>: 
					<input id="j_password" name="j_password" size="20" maxlength="50" type="password" />
				</p>
	
				<p>
					<input type="submit" value="Login" />
				</p>
			</fieldset>
		</form>
	<p class="message">${message}</p>
</body>
</html>
