<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<title><spring:message code="titre.listtasks" /></title>

</head>
<body class="blue lighten-4">
	<div id="modal-task-add" class="modal">
		<div class="modal-content">
			<h4>Ajout d'une tâche</h4>
			<br>
			<div class="row">
				<form action="/projet-tasks-esgi/tasks" method="post">
					Description : <input type="text" name="description"><br>
					<div class="row">
						<label class="col s3"> <input name="priority" value=1
							type="radio" checked /> <span>Basse</span>
						</label> <label class="col s3"> <input name="priority" value=2
							type="radio" /> <span>Moyenne</span>
						</label> <label class="col s3"> <input name="priority" value=3
							type="radio" /> <span>Haute</span>
						</label> <label class="col s3"> <input name="priority" value=4
							type="radio" /> <span>Urgente</span>
						</label>
					</div>
					<input type="submit" value="Submit">
				</form>
			</div>
		</div>
	</div>
	<div id="modal-task-edit" class="modal">
		<div class="modal-content">
			<h4>Modification d'une tâche</h4>
			<br>
			<div class="row">
				<form action="/projet-tasks-esgi/tasks/modify" method="post">
					<input type="hidden" id="idTask" name="idTask" value="" />
					Description : <input type="text" id="descriptionTask"
						name="description"><br>
					<div class="row" id="priorityTask">
						<label class="col s3"> <input id="radio1" name="priority"
							value=1 type="radio" /> <span>Basse</span>
						</label> <label class="col s3"> <input id="radio2" name="priority"
							value=2 type="radio" /> <span>Moyenne</span>
						</label> <label class="col s3"> <input id="radio3" name="priority"
							value=3 type="radio" /> <span>Haute</span>
						</label> <label class="col s3"> <input id="radio4" name="priority"
							value=4 type="radio" /> <span>Urgente</span>
						</label>
					</div>
					<input type="submit" value="Submit">
				</form>
			</div>
		</div>
	</div>
	<div id="modal-task-urgent" class="modal">
		<div class="modal-content">
			<h4>Tâches urgentes</h4>
			<br>
			<table border="1" class="striped centered">
				<thead>
					<tr>
						<th><spring:message code="colonne.description" /></th>
						<th><spring:message code="colonne.priority" /></th>
						<th><spring:message code="colonne.creation" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${urgentTasks}" var="task">
						<tr>
							<spring:message code="priority.${task.priority}" var="priority" />
							<td><c:out value="${task.description}" /></td>
							<td><c:out value="${priority}" /></td>
							<td><c:out value="${task.creation}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div id="global" class="row">
		<div class="col s12 m10 offset-m1">
			<div class="card">
				<div class="card-action blue lighten-1 white-text">
					<h3 class="center-align">Liste des tâches de l'ESGI</h3>
				</div>
				<div class="card-content">
					<table border="1" class="striped centered">
						<thead>
							<tr>
								<th><spring:message code="colonne.description" /> <c:url
										value="/tasks" var="url">
										<c:param name="orderType" value="${forOrderDescription}" />
										<c:param name="orderColumn" value="description" />
									</c:url> <a href="${url}" class="btn-floating btn-small blue lighten-1"><i
										class="material-icons">${iconDescription}</i></a></th>
								<th><spring:message code="colonne.priority" /> <c:url
										value="/tasks" var="url">
										<c:param name="orderType" value="${forOrderPriority}" />
										<c:param name="orderColumn" value="priority" />
									</c:url> <a href="${url}" class="btn-floating btn-small blue lighten-1"><i
										class="material-icons">${iconPriority}</i></a></th>
								<th><spring:message code="colonne.creation" /></th>
								<th><spring:message code="colonne.delete" /></th>
								<th><spring:message code="colonne.modify" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listTasks}" var="task">
								<tr>
									<input type="hidden" class="idTask" value="${task.id}" />
									<input type="hidden" class="priorityTask"
										value="${task.priority}" />
									<input type="hidden" class="descriptionTask"
										value="${task.description}" />
									<spring:message code="priority.${task.priority}" var="priority" />
									<td><c:out value="${task.description}" /></td>
									<td><c:out value="${priority}" /></td>
									<td><c:out value="${task.creation}" /></td>
									<td><c:url value="/tasks/delete" var="url">
											<c:param name="idTask" value="${task.id}" />
										</c:url> <a href="${url}" class="btn-floating btn-small"><i
											class="material-icons red">delete</i></a></td>
									<td><a class="btn-floating btn-small edit-button"><i
											class="material-icons blue">mode_edit</i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="fixed-action-btn">
		<a class="btn-floating btn-large blue lighten-1"> <i
			class="large material-icons">arrow_upward</i>
		</a>
		<ul>
			<li><a class="btn-floating green modal-trigger"
				href="#modal-task-add"> <i class="large material-icons">add</i>
			</a></li>
			<li><a href="#modal-task-urgent" class="btn-floating red modal-trigger"><i class="material-icons">access_time</i></a></li>
		</ul>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script>
		$(document).ready(function() {
			$('.modal').modal();
			$('select').formSelect();
			$('.fixed-action-btn').floatingActionButton();

			var instance = M.Modal.getInstance($("#modal-task-edit"));

			$(".edit-button").click(function() {
				var id;
				var description;
				var priority;
				$(this).parent().parent().each(function() {
					id = $(this).find(".idTask").val();
					description = $(this).find(".descriptionTask").val();
					priority = $(this).find(".priorityTask").val();
				});

				$("#descriptionTask").val(description);
				$("#idTask").val(id);
				instance.open();
				$("#radio" + priority).prop("checked", true).trigger("click");

			});
		});
	</script>
	<c:if test="${error!=null}">
		<script>
			swal("${error}");
		</script>
	</c:if>
</body>
</html>