<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
	<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<title>Persona</title>
	</head>
	<body>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-auribox" aria-expanded="false">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="<%=request.getContextPath()%>"><span class="glyphicon glyphicon-console" aria-hidden="true"></span></a>
				</div>
				<div class="collapse navbar-collapse" id="navbar-collapse-auribox">
					<ul class="nav navbar-nav">
						<li><a href="<%=request.getContextPath()%>"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home</a></li>
						<c:url value="showMessage.html" var="messageUrl" />					
						<li><a href="${messageUrl}">Greeting</a></li>
						<li><a class="navbar-link" href="<%=request.getContextPath()%>/person/0">person/0</a></li>
						<li><a class="navbar-link" href="<%=request.getContextPath()%>/person/all">person/all</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<h2>Persona</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Edad</th>
					<th>Dirección</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${person.nombre}</td>
					<td>${person.edad}</td>
					<td>${person.direccion}</td>
				</tr>
			</tbody>
		</table>
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	</body>
</html>
