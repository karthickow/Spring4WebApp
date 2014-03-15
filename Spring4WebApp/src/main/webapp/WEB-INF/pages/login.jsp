<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login Page</title>
		<style type="text/css">
			.errorblock{
				color: #ff0000;
				background-color: aqua;
				border: 3px solid #ff0000;
				padding: 8px;
				margin: 16px;
			}
		</style>
	</head>
	
	<body onload="document.f.j_username.focus();" bgcolor="blue">
		<h3>Login with Username and Password (Custom Page)</h3>
		<c:if test="${SPRING_SECURITY_LAST_EXCEPTION!=null }">
			<div class="errorblock">
				Your login attempt was not successful, try again.<br/>				
				Caused : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message }
			</div>
		</c:if>
		
		<form id="f" name="f" action='<c:url value="j_spring_security_check"/>' method="post">
			<table>
				<tr>
					<td>User:</td>
					<td>
						<input type="text" id="j_username" name="j_username">
					</td>
				</tr>
				
				<tr>
					<td>Password:</td>
					<td>
						<input type="password" id="j_password" name="j_password">
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<input name="submit" id="submit" type="submit" value="Submit">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="reset" id="reset" name="reset">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>