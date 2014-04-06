<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE HTML>	
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta http-equiv="Content-Language" content="English"/>
		<link rel="stylesheet" type="text/css" media="screen" href="resources/css/style.css"/>
		<title>Login</title>
		
		<script type="text/javascript">
			function validate(loginForm){
				var userName = loginForm.j_username.value;
				var password = loginForm.j_password.value;
				
				if(userName!=null && userName==''){
					alert('<spring:message code="username.empty"/>');
					return;
				}
				
				if(password!=null && password==''){
					alert('<spring:message code="password.empty"/>');
					return;
				}
				
				loginForm.submit();
			}
		</script>
				
	</head>
	
	<body onload='document.loginForm.j_username.focus();'>

		<form name="loginForm" id="loginForm" class="login-form" action="j_spring_security_check" method="post">
			<fieldset>
				<legend>Login Here</legend>
	
				<p>
					<label for="j_username">Username</label> 
					<input id="j_username" name="j_username" size="20" maxlength="50" type="text"/>
				</p>
	
				<p>
					<label for="j_password">Password</label> 
					<input id="j_password" name="j_password" size="20" maxlength="50" type="password"/>
				</p>
				
				
				<p>
					<input id="clear" name="clear" type="reset" value="Clear" />
				</p>
				
				<p>
					<input id="login" name="login" type="button" value="Login" onclick="validate(this.form)"/>
				</p>
				
			</fieldset>
		</form>
		<p>
			<%-- <c:if test="${error == true}"> --%>
			<c:if test="${not empty error}">
				<div id="infomessage"  class="message">
					<spring:message code="login.error"/><br />
					${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
				</div>
			</c:if>
		</p>
		<%-- <p class="message">${msg}</p> --%>
		
	</body>
</html>
