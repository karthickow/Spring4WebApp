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
				var checkstr =  confirm('Are you sure you want to delete this?');
				if(checkstr == true){
					CRUD('delete');
				}else{
					return false;
				}
			}
		});

		$('#newSubmit').click(function() {
			if($('#email').val()!=null && $('#email').val()!='')
				CRUD('add');
			else
				alert('<spring:message code="NotEmpty.employee.email"/>');
		});

		$('#editSubmit').click(function() {			
			CRUD('update');
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
	<!-- <hr /> -->

	<table id='tableEmployees'>
		<caption></caption>
		<thead>
			<tr>
				<th scope="col" class="rounded-company"></th>
				<th scope="col" class="rounded-firstname"><label><spring:message code="label.firstname"/></label></th>
				<th scope="col" class="rounded-lastname"><label><spring:message code="label.lastname"/></label></th>
				<th scope="col" class="rounded-email"><label><spring:message code="label.email"/></label></th>
				<th scope="col" class="rounded-telephone"><label><spring:message code="label.telephone"/></label></th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td colspan="4" class="rounded-foot-left"><em>The above	data were populated from database</em></td>
				<td class="rounded-foot-right">&nbsp;</td>
			</tr>
		</tfoot>
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
			<input type='button' value='Close' id='closeNewForm' name='closeNewForm' /> 
			<input type='button' value='Submit' id="newSubmit" name="newSubmit" />
		</form:form>
	</div>

	<div id='editForm'>
		<form:form commandName="employee">
			<fieldset>
				<legend>Edit Record</legend>
				<form:label for='firstname' path="firstname"><spring:message code="label.firstname"/></form:label><form:input path="firstname" type='text' id='editfirstname' /><br />
				<form:label for='lastname' path="lastname"><spring:message code="label.lastname"/></form:label><form:input path="lastname" type='text' id='editlastname' /><br />
				<form:label for='email' path="email"><spring:message code="label.email"/></form:label><form:input path="email" type='text' id='editemail' /><br />
				<form:label for='telephone' path="telephone"><spring:message code="label.telephone"/></form:label><form:input path="telephone" type='text' id='edittelephone' />
				<form:input path="id" type="hidden" id='editEmpId' name='editEmpId'/>
			</fieldset>
			<input type='button' value='Close' id='closeEditForm' name='closeEditForm'/> 
			<input type='button' value='Submit' id="editSubmit" name="editSubmit" />
		</form:form>
	</div>

</body>
</html>