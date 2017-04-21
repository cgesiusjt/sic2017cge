<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Crud de Card�pio</title>
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css"/>
	
	<style type="text/css">
		
		body {
		background-color: #E0FFFF;
	}
	</style>
	
</head>

	<body class="container">
	
		<div class="well well-sm">
			<h2>RESTAURANTE</h2>
		</div>
		
		<div class="col-md-12">
			
			<p>
				Selecione a opera��o desejada:
			<p/>
			
			<br/><br/>
		</div>
		
		<div class="col-md-3 panel text-center" >
			<div class="glyphicon glyphicon-blackboard" style="font-size: 3em"></div>
			<br/><br/>
			<a href="cadastroCardapio.jsp" class="btn btn-default btn-block">
				Cadastrar Card�pio
			</a>
		</div>
		
		<div class="col-md-3 panel text-center" >
			<div class="glyphicon glyphicon-tasks" style="font-size: 3em"></div>
			<br/><br/>
			<a href="consultaCardapio.jsp" class="btn btn-default btn-block">
				Consultar Card�pio
			</a>
		</div>
		
		<div class="col-md-3 panel text-center" >
			<div class="glyphicon glyphicon-tasks" style="font-size: 3em"></div>
			<br/><br/>
			<a href="pedido.jsp" class="btn btn-default btn-block">
				Fazer Pedido
			</a>
		</div>
		
		<div class="col-md-3 panel text-center" >
			<div class="glyphicon glyphicon-tasks" style="font-size: 3em"></div>
			<br/><br/>
			<a href="" class="btn btn-default btn-block">
				Relat�rios Gerencias
			</a>
		</div>
		
						
	</body>
</html>


