<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
		<link href="${pageContext.request.contextPath}" rel="stylesheet" />
		<title><spring:message code="titre.listtasks"/></title>
		
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th><spring:message code="colonne.description"/></th>
                    <th><spring:message code="colonne.urgent"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listTasks}" var="task">
                    <tr>
                        <td><c:out value="${task.description}"/></td>
                        <td><c:out value="${task.urgent}"/></td>
                        <td>
                        <c:url value="tasks/delete" var="url">
                                <c:param name="idTask" value="${task.id}"/>
                            </c:url>
                            <a href="${url}">
                                <spring:message code="suppression.supprimer.libelle" />
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="/projet-tasks-esgi/add">Ajouter une tâche</a>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
    </body>
</html>