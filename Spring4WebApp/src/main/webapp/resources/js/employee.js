/**
 * Contains custom JavaScript code
 */
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
			row += '</tr>';
			$('#tableEmployees').append(row);
		}

		$('#tableEmployees').data('model', response);
		toggleForms('hide');
	});
}

function submitNewRecord() {
	$.post(urlHolder.add, {
		firstname : $('#firstname').val(),
		lastname : $('#lastname').val(),
		email : $('#email').val(),
		telephone : $('#telephone').val()		
	}, function(response) {
		if (response != null) {
			loadTable();
			toggleForms('hide');
			toggleCrudButtons('show');
			alert('Success! Record has been added.');
		} else {
			alert('Failure! An error has occurred!');
		}
	});
}

function submitDeleteRecord() {
	var selected = $('input:radio[name=index]:checked').val();

	$.post(urlHolder.del, {
		username : $('#tableEmployees').data('model')[selected].username
	}, function(response) {
		if (response == true) {
			loadTable(urlHolder.records);
			alert('Success! Record has been deleted.');
		} else {
			alert('Failure! An error has occurred!');
		}
	});
}

function submitUpdateRecord() {
	$.post(urlHolder.edit, {
		firstname : $('#firstname').val(),
		lastname : $('#lastname').val(),
		email : $('#email').val(),
		telephone : $('#telephone').val()
	}, function(response) {
		if (response != null) {
			loadTable();
			toggleForms('hide');
			toggleCrudButtons('show');
			alert('Success! Record has been edited.');
		} else {
			alert('Failure! An error has occurred!');
		}
	});
}

/*function getRole(role) {
	if (role == 1) {
		return 'Admin';
	} else if (role == 2) {
		return 'Regular';
	} else {
		return 'Unknown';
	}
}*/

function hasSelected() {
	var selected = $('input:radio[name=index]:checked').val();
	if (selected == undefined) {
		alert('Select a record first!');
		return false;
	}

	return true;
}

function fillEditForm(formEdit) {
	var selected = $('input:radio[name=index]:checked').val();
	alert($('#tableEmployees').data('model')[selected].firstname);
	alert($('#editfirstname'));
	$('#editfirstname').val($('#tableEmployees').data('model')[selected].firstname);
	$('#editlastname').val($('#tableEmployees').data('model')[selected].lastname);
	$('#editemail').val($('#tableEmployees').data('model')[selected].email);
	$('#edittelephone').val($('#tableEmployees').data('model')[selected].telephone);
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