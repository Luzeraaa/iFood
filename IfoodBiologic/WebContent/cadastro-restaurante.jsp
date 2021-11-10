<%@ page import="br.com.ifood.bean.*" language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Produtos</title>
<%@ include file="bootstrap/css.jsp"%>

</head>
<body>



	<%@ include file="menu.jsp"%>

	<div class ="container">
	<h1>Cadastro de Restaurantes</h1>


	<c:if test="${not empty msg}">
		<div class="alert alert-success">
		${msg}	
		</div>
	</c:if>
	
	<c:if test="${not empty erro }">
	
	<div class="alert alert-danger">
		${erro}
	</div>
	
	</c:if>


	<form action="restaurante" method="post">
	<input type="hidden" value="cadastrar" name="acao">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Nome do Restaurante</label> 
				<input type="text" class="form-control" id="restaurante" name ="restaurante">
			</div>
			
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Valor do Frete</label>
				<input type="text" class="form-control" id="frete" name="frete">
			</div>
			
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Tempo de Entrega</label>
				<input type="text" class="form-control" id="tempoEntrega" name="tempoEntrega">
			</div>
			
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Pedido Mínimo</label>
				<input type="text" class="form-control" id="pedidoMinimo" name="pedidoMinimo">
			</div>
			
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Nome do Responsável</label>
				<input type="text" class="form-control" id="responsavel" name="responsavel">
			</div>
			
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Email do Responsavel</label>
				<input type="text" class="form-control" id="emailResponsavel" name="emailResponsavel">
			</div>
			
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">CNPJ</label>
				<input type="text" class="form-control" id="cnpj" name="cnpj">
			</div>
			
				<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Região</label>
				<input type="text" class="form-control" id="regiao" name="regiao">
			</div>
			
			<div class="form-group">
				<label for="id-comida"> Tipo de Comida</label>
				<select name="comida" id="id-categoria" class="form-control">
					<option value="0">Selecione</option>
					<c:forEach items="${comidas}" var="c">
						<c:if test="${c.idComida == restaurante.comida.idComida}">
							<option value="${c.idComida}" selected="${c.nome} }">${c.nome}</option>
						</c:if>
						<c:if test="${c.idComida != restaurante.comida.idcomida}">
							<option value="${c.idComida}">${c.nome}</option>
						</c:if>
					</c:forEach>
				</select>
			</div>

			
		
			<br>
			<input type="submit" class="btn btn-primary" value="Salvar">
		</form>
</div>


	<%@ include file="bootstrap/js.jsp"%>

</body>
</html>