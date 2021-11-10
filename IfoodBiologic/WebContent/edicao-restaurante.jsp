<%@ page import="br.com.ifood.bean.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualização de Restaurante</title>
<%@ include file="bootstrap/css.jsp"%>

</head>
<body>
	<%@ include file="menu.jsp"%>

	<div class="container">
		<h1>Edição do Restaurante</h1>
		
		<c:if test="${not empty msg }">
		<div class="alert alert-success">
		${msg }	
		</div>
	</c:if>
	
	<c:if test="${not empty erro }">
	
	<div class="alert alert-danger">
		${erro}
	</div>
	
	</c:if>

		<form action="restaurante" method="post">
			<input type="hidden" value="editar" name="acao"> 
			<input type="hidden" value="${restaurante.idRestaurante}" name="codigo">

			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Restaurante</label>
					<input type="text" class="form-control"
					value="${restaurante.nomeRestaurante }" id="nomeRestaurante" name="restaurante">
			</div>

			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Valor do Frete</label>
					 <input type="text" class="form-control"
					value="${restaurante.valorFrete } " id=" frete" name="frete">
			</div>
			
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">tempo de Entrega</label>
				<input type="text" class="form-control"
					value="${restaurante.tempoEntrega }" id="entrega" name="tempoEntrega">
			</div>

			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Valor do Pedido</label> <input type="text" class="form-control"
					value="${restaurante.valorPedido}" id="
					dataFabricacao" name="pedidoMinimo">
			</div>

			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Nome do Responsavel</label> <input type="text" class="form-control"
					value="${restaurante.nomeResponsavel}" id="
					dataFabricacao" name="responsavel">
			</div>
			
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Email do Responsavel</label> <input type="text" class="form-control"
					value="${restaurante.emailResponsavel}" id="
					dataFabricacao" name="emailResponsavel">
			</div>
			
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">CNPJ</label> <input type="text" class="form-control"
					value="${restaurante.cnpj}" id="
					dataFabricacao" name="cnpj">
			</div>
			
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Região</label> <input type="text" class="form-control"
					value="${restaurante.regiao}" id="
					dataFabricacao" name="regiao">
			</div>
		
			
			<div class="form-group">
				<label for="id-categoria"> Tipo de comida</label>
				<select name="comida" id="id-comida" class="form-control">
					<option value="0">Selecione</option>
					<c:forEach items="${comidas}" var="c">
						<c:if test="${c.idComida == restaurante.comida.idComida }">
							<option value = "${c.idComida }" selected>${c.descricaoComida}</option>
						</c:if>
						<c:if test="${c.idComida != restaurante.comida.idComida }">
							<option value ="${c.idComida }">${c.descricaoComida }</option>
						
						</c:if>
					</c:forEach>
				</select>
			</div>
			
			
			
			
			
			
	</br>
	<br>
	<br>
			<input type="submit" class="btn btn-primary" value="Salvar">
			<a href="restaurante?acao=listar" class="btn btn-danger">Cancelar</a>
		</form>
	</div>


	<%@ include file="bootstrap/js.jsp"%>

</body>
</html>