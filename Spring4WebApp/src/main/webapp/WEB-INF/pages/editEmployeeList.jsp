<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta http-equiv="Content-Language" content="English"/>
		<link rel="stylesheet" type="text/css" media="screen" href="resources/css/style.css"/>
	    <title>Employee Management Screen</title>
	</head>
	
	<body>
	  
		<%-- <h2>Employee Management Screen : Maven2 Spring4 hibernate4 Integration Example</h2> <a href='<c:url value="/j_spring_security_logout"/>'>Logout</a> --%>
		<jsp:include page="menu.jsp" />
		 <h1 id="banner">Employee Management Screen</h1>
		<hr/>
		
		<%--<h3>Message : ${message}</h3>
		<h3>Username : ${username}</h3>
		
		<hr/> --%>
		
		<form:form method="post" action="add" commandName="employee">
		  
		    <table>
			    <tr>
			        <td><form:label path="firstname"><spring:message code="label.firstname"/></form:label></td>
			        <td><form:input path="firstname" /></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="lastname"><spring:message code="label.lastname"/></form:label></td>
			        <td><form:input path="lastname" /></td>			       
			    </tr>
			    
			    <tr>
			        <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
			        <td><form:input path="email" /></td>
			         <td><form:errors path="email" cssClass="message"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="telephone"><spring:message code="label.telephone"/></form:label></td>
			        <td><form:input path="telephone" /></td>
			    </tr>
			    
			    <tr>
			        <td colspan="2">
			            <input type="submit" value="<spring:message code="label.add"/>"/>
			        </td>
			    </tr>
			</table>
		</form:form>
		  
		      
		<h3>Employees</h3>
		<c:if  test="${!empty employeeList}">
			<table border="1">
				<tr>
				    <th>Name</th>
				    <th>Email</th>
				    <th>Telephone</th>
				    <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
				</tr>
				<c:forEach items="${employeeList}" var="emp">
				    <tr>
				        <td>${emp.lastname}, ${emp.firstname} </td>
				        <td>${emp.email}</td>
				        <td>${emp.telephone}</td>
				        <td><a href="delete/${emp.id}">delete</a></td>
				    </tr>
				</c:forEach>
			</table>
		</c:if>	
	</body>
</html>