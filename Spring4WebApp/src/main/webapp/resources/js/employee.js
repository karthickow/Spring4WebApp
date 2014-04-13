var urlHolder = new Object();

function loadTable() {
	
	$.get(urlHolder.records, function(response) {
		
		$('#tableEmployees').find('tbody').remove();

		for ( var i = 0; i < response.length; i++) {			
			var row = '<tr>';
			row += '<td><input type="radio" name="index" id="index" value="' + i + '"></td>';
			row += '<td>' + response[i].firstname + '</td>';
			row += '<td>' + response[i].lastname + '</td>';
			row += '<td>' + response[i].email + '</td>';
			row += '<td>' + response[i].telephone + '</td>';
			row += '<input type="hidden" name="editEmpId" id="editEmpId" value="' + response[i].id;
			row += '</tr>';
			$('#tableEmployees').append(row);
		}

		$('#tableEmployees').data('model', response);
		toggleForms('hide');
	});
}

function CRUD(action, successMsg, failureMsg){
	var urlAction = new Object();
	var content = new Object(); 
	
	if(action=='add'){
		urlAction = urlHolder.add;		
		content = {
			firstname : $('#firstname').val(),
			lastname : $('#lastname').val(),
			email : $('#email').val(),
			telephone : $('#telephone').val()
		};
	}
	
	if(action=='update'){
		urlAction = urlHolder.edit;		
		content = {
			firstname : $('#editfirstname').val(),
			lastname : $('#editlastname').val(),
			email : $('#editemail').val(),
			telephone : $('#edittelephone').val(),
			id : $('#editEmpId').val()
		};
	}
	
	if(action=='delete'){
		urlAction = urlHolder.del;
		var selected = $('input:radio[name=index]:checked').val();
		content = {
			firstname : $('#tableEmployees').data('model')[selected].firstname,
			lastname :$('#tableEmployees').data('model')[selected].lastname,
			email : $('#tableEmployees').data('model')[selected].email,
			telephone : $('#tableEmployees').data('model')[selected].telephone,
			id : $('#tableEmployees').data('model')[selected].id
		};
	}
	
	$.ajax({
		headers : {
			'Accept' : 'application/json',
			'Content-Type' : 'application/json'
		},
		url : urlAction,
		type : 'POST',
		data : JSON.stringify(content),
		dataType : 'json',
		success : function(response, textStatus, jqXHR) {
			if (response != null) {
				if(action=='add' || action=='update'){
					loadTable();
					toggleForms('hide');
					toggleCrudButtons('show');
				}
				else if(action=='delete'){
					loadTable();
				}
				alert(successMsg);
			} else {
				alert(failureMsg);
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert(jqXHR + ' ' + textStatus + ' ' + errorThrown);
		}
	});
}

function hasSelected(msg) {
	var selected = $('input:radio[name=index]:checked').val();
	if (selected == undefined) {
		alert(msg);
		return false;
	}

	return true;
}

function fillEditForm() {
	var selected = $('input:radio[name=index]:checked').val();
	$('#editfirstname').val($('#tableEmployees').data('model')[selected].firstname);
	$('#editlastname').val($('#tableEmployees').data('model')[selected].lastname);
	$('#editemail').val($('#tableEmployees').data('model')[selected].email);
	$('#edittelephone').val($('#tableEmployees').data('model')[selected].telephone);
	$('#editEmpId').val($('#tableEmployees').data('model')[selected].id);
}

function resetNewForm() {
	$('#firstname').val('');
	$('#lastname').val('');
	$('#email').val('');
	$('#telephone').val('');
}

function resetEditForm() {
	$('#editfirstname').val('');
	$('#editlastname').val('');
	$('#editemail').val('');
	$('#edittelephone').val('');
}

function toggleForms(id) {
	if (id == 'hide') {
		$('#newForm').hide();
		$('#editForm').hide();

	} else if (id == 'new') {
		resetNewForm();
		$('#newForm').show();
		$('#editForm').hide();

	} else if (id == 'edit') {
		resetEditForm();
		$('#newForm').hide();
		$('#editForm').show();
	}
}

function toggleCrudButtons(id) {
	if (id == 'show') {
		$('#newBtn').removeAttr('disabled');
		$('#editBtn').removeAttr('disabled');
		$('#deleteBtn').removeAttr('disabled');
		$('#reloadBtn').removeAttr('disabled');

	} else if (id == 'hide') {
		$('#newBtn').attr('disabled', 'disabled');
		$('#editBtn').attr('disabled', 'disabled');
		$('#deleteBtn').attr('disabled', 'disabled');
		$('#reloadBtn').attr('disabled', 'disabled');
	}
}