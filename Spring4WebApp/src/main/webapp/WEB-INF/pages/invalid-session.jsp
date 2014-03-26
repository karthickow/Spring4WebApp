<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Duplicate Session</title>
		<style>
			.error {
				color: red;
			}
		</style>
	</head>
	
	<body>
		<h1>Duplicate Session Page</h1>
		
		<p>
			<c:if test="${error == true}">
				<b class="error">Duplicate Session Page. Please logout the other session and login again.</b>
			</c:if>
		</p>
		
		<p>
			<a href="${pageContext.request.contextPath}/">Home</a><br/>
		</p>
	</body>
</html>