<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="titre.addtask"/></title>
    </head>
    <body>
    	<form:form method="post" modelAttribute="creation" action="#">
              <spring:message code="creation.elementtask.libelle.description" />
            <form:input path="description"/>
            <b><i><form:errors path="description" cssclass="error"/></i></b><br>
            <input type="submit"/>
        </form:form>
    <a href="/projet-tasks-esgi/tasks">Retour à la liste</a>
    </body>
</html>