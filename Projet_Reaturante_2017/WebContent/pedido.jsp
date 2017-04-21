<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<jsp:useBean class="managdBeans.ManagdBeansCardapio" id="mb"></jsp:useBean>
	<jsp:useBean  class="managdBeans.ManagdBeansTabelaPedido" id="mbd" ></jsp:useBean>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc" %>
	
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Pedido</title>
		
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css" />

	</head>
	<body class="container">
	
		<div class="well well-sm">
			<h2>RESTAURANTE</h2>
		</div>
		
		<div class="col-md-12 ">
		
		<a href="gerenciamento.jsp"> <input type="submit" value="Voltar" />
		</a> Para página Inicial    
		
		<div class="row">
			<div class="col-md-7">
				<label>Teste</label>
				
				<table class="table table-bordered"> <!--table-horver -->
					
					<thead>
						<tr>
							<th>Id</th>
							<th>Categoria</th>
							<th>Descrição</th>
							<th>Valor Unitário</th>
							<th>Quantidade</th>
							<th>Disponibilidade</th>
						</tr>
					</thead>
			
					<tbody>
						
						<c:forEach items="${mbd.listaTabelaPedido}" var="cardp" >
							<tr>
							<td>${cardp.idCardapio}</td>
							<td>${cardp.categoria}</td>
							<td>${cardp.descricao}</td>
							<td>
								<fmt:formatNumber value="${cardp.valorUnitario}" type="currency"> </fmt:formatNumber>
							</td>	
							<td>${cardp.quantidade}</td>
							<td>${cardp.disponibilidade}</td>
						<tr/>
						</c:forEach>

				</tbody>
				
				</table>
				
			</div>
						
			<div class="col-md-5" style="widght: 500px; heigth: 100px; overflow: auto;">
				<label>Teste 2</label>
				<table class="table table-bordered">

			<thead >
				<tr>
					<th>Id</th>
					<th>Categoria</th>
					<th>Descrição</th>
					<th>Valor Unitário</th>
					<th>Disponibilidade</th>
				</tr>
			</thead>

			<tbody>

				<c:forEach items="${mb.listagemCardapio}" var="c">

					<tr>
						<td>${c.idCardapio}</td>
						<td>${c.categoria}</td>
						<td>${c.descricao}</td>
						<td>
							<fmt:formatNumber value="${c.valorUnitario}" type="currency"> </fmt:formatNumber>
						</td>	
						<td>${c.disponibilidade}</td>
					<tr/>
						
				</c:forEach>

			</tbody>
		</table>
		
		<div class="col-md-12">
			
		<form name="formularioadd" method="post" action="CardapioServelet?acao=adicionar">
			<div class="col-md-12">
				<div class="col-md-6">
					<label>Codigo</label>
					<input type="text" id="codigo" name="codigo" class="form-control" placeholder="Digite aqui" />
				</div>
				
				<div class="col-md-6">
					<label>Quantidade</label>
						<input type="text" id="quantidade" name="quantidade" class="form-control" placeholder="Digite aqui" />
				</div>
				<br><br>
				<br><br>
							
				<div class="col-md-6">
					<button type="submit" class="btn btn-success">Adicionar</button>
				</div>
			</div>
								
		</form>
		
		<div class="col-md-12" style="padding: 5px">
			
		</div>
		
		<form name="formulariorem" method="post" action="CardapioServelet?acao=remover">
		
			<div class="col-md-12">
										
				<div class="col-md-6">
				
				</div>
				<input type="text" id="codigoRemover" name="codigoRemover" class="form-control"
					 value="${cardapio.idCardapio}" />
				
				<div class="col-md-6">
					<input type="submit" value="Remover" class="btn btn-success" />
				</div>
			</div>
		</form>
		
		</div>
				
		</div>
							
	</div>
	</div>
		
		<h4>${mensagem}</h4>
	</body>
</html>