<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<!DOCTYPE HTML>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<c:url value="/allemployees" var="recordsUrl" />
<c:url value="/add" var="addUrl" />
<c:url value="/update" var="editUrl" />
<c:url value="/delete" var="deleteUrl" />

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="Content-Language" content="English"/>
	<link rel='stylesheet' type='text/css' media='screen' href='<c:url value="/resources/css/employee.css"/>' />
	<script type='text/javascript' src='<c:url value="/resources/js/jquery-1.11.0.min.js"/>'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/employee.js"/>'></script>

<title>Employee Records</title>

<script type='text/javascript'>

	$(document).ready(function() {
		toggleForms('hide');
	});

	
	$(function() {
		// init
		urlHolder.records = '${recordsUrl}';
		urlHolder.add = '${addUrl}';
		urlHolder.edit = '${editUrl}';
		urlHolder.del = '${deleteUrl}';
		loadTable();

		$('#newBtn').click(function() {
			toggleForms('new');
			toggleCrudButtons('hide');
		});

		$('#editBtn').click(function() {
			if (hasSelected()) {
				toggleForms('edit');
				toggleCrudButtons('hide');
				fillEditForm();
			}
		});

		$('#reloadBtn').click(function() {
			loadTable();
		});

		$('#deleteBtn').click(function() {
			if (hasSelected()) {
				submitDeleteRecord();
			}
		});

		$('#newForm').submit(function() {
			event.preventDefault();
			submitNewRecord();
		});

		$('#editForm').submit(function() {
			event.preventDefault();
			submitUpdateRecord();
		});

		$('#closeNewForm').click(function() {
			toggleForms('hide');
			toggleCrudButtons('show');
		});

		$('#closeEditForm').click(function() {
			toggleForms('hide');
			toggleCrudButtons('show');
		});
	});
</script>
</head>

<body>

	<jsp:include page="menu.jsp" />
	<h2 id='banner'>Employee Management System</h2>
	<hr />

	<table id='tableEmployees'>
		<caption></caption>
		<thead>
			<tr>
				<th></th>
				<th><label><spring:message code="label.firstname"/></label></th>
				<th><label><spring:message code="label.lastname"/></label></th>
				<th><label><spring:message code="label.email"/></label></th>
				<th><label><spring:message code="label.telephone"/></label></th>
			</tr>
		</thead>
	</table>

	<div id='controlBar'>
		<input type='button' value='New' id='newBtn' /> 
		<input type='button' value='Delete' id='deleteBtn' /> 
		<input type='button' value='Edit' id='editBtn' /> 
		<input type='button' value='Reload' id='reloadBtn' />
	</div>

	<div id='newForm'>
		<form:form commandName="employee">
			<fieldset>
				<legend>Create New Employee</legend>
				<form:label for='firstname' path="firstname"><spring:message code="label.firstname"/></form:label><form:input path="firstname" type='text' id='firstname' /><br />
				<form:label for='lastname' path="lastname"><spring:message code="label.lastname"/></form:label><form:input path="lastname" type='text' id='lastname' /><br />
				<form:label for='email' path="email"><spring:message code="label.email"/></form:label><form:input path="email" type='text' id='email' /><br />
				<form:label for='telephone' path="telephone"><spring:message code="label.telephone"/></form:label><form:input path="telephone" type='text' id='telephone' />
			</fieldset>
			<input type='button' value='Close' id='closeNewForm' /> 
			<input type='submit' value='Submit' />
		</form:form>
	</div>

	<div id='editForm'>
		<form:form id="formEdit" name="formEdit" commandName="employee">
			<fieldset>
				<legend>Edit Record</legend>
				<form:label for='firstname' path="firstname"><spring:message code="label.firstname"/></form:label><form:input path="firstname" type='text' id='editfirstname' /><br />
				<form:label for='lastname' path="lastname"><spring:message code="label.lastname"/></form:label><form:input path="lastname" type='text' id='editlastname' /><br />
				<form:label for='email' path="email"><spring:message code="label.email"/></form:label><form:input path="email" type='text' id='editemail' /><br />
				<form:label for='telephone' path="telephone"><spring:message code="label.telephone"/></form:label><form:input path="telephone" type='text' id='edittelephone' />
			</fieldset>
			<input type='button' value='Close' id='closeEditForm' /> 
			<input type='submit' value='Submit' />
		</form:form>
	</div>

</body>
</html>