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
		<title>Welcome</title>
	</head>
	<body>
		<!-- Navigation bar -->
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
						<li><a class="navbar-link" href="person/0">person/0</a></li>
						<li><a class="navbar-link" href="person/all">person/all</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- END Navigation bar -->
		
		<button class="btn btn-warning btn-lg btn-block" id="initdb" >Inicia Base de Datos</button>
		
		<form class="form-horizontal">
			<label>Nombre:</label> <input id="nombre" type="text">
			<label>Edad:</label> <input id="edad" type="number">
			<label>Direcci&oacute;n:</label> <input id="direccion" type="text">
			<button class="btn btn-info" type="button">Enviar</button>
		</form>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$('label').addClass('col-sm-2 control-label');
				$('input').addClass('form-control');
				//alert('Documento listo');
				
				$('#initdb').on('click',function(){
					$.ajax({
						url: "<%=request.getContextPath()%>/initdb",
						success:function(datos){
							 console.log('Respuesta: '+datos);
						}
					});
					$(this).fadeOut(3000);
				});
				
				$('.btn-info').on('click',function(){
	
					var nombre = $('#nombre').val();
					var edad = $('#edad').val();
					var direccion = $('#direccion').val();
					var urltocall = "<%=request.getContextPath()%>/person/save?nombre="+nombre+"&edad="+edad+"&direccion="+direccion;
					
					$.ajax({
						url: urltocall,
						success:function(datos){
							 console.log('Respuesta: '+datos);
						}
					});
				});
				
			});
		</script>
	</body>
</html>
