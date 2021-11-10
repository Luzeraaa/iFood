<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastros de Restaurante</title>
<%@ include file="bootstrap/css.jsp"%>
</head>
<body>

	<%@ include file="menu.jsp"%>
	<div class="container">
		<h1>Restaurantes</h1>

		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg }</div>
		</c:if>

		<c:if test="${not empty erro }">

			<div class="alert alert-danger">${erro}</div>

		</c:if>


		<table class="table table-striped">
			<tr>
				<th>Nome</th>
				<th>Frete</th>
				<th>Tempo de Entrega mínimo</th>
				<th>Pedido mínimo</th>
				<th>Responsável</th>
				<th>Email do Responsável</th>
				<th>CNPJ</th>
				<th>Região</th>
				<th></th>
			</tr>
			<c:forEach items="${restaurantes}" var="r">
				<tr>
					<td>${r.nomeRestaurante}</td>
					<td>${r.valorFrete}</td>
					<td>${r.tempoEntrega}</td>
					<td>${r.valorPedido}</td>
					<td>${r.nomeResponsavel}</td>
					<td>${r.emailResponsavel}</td>
					<td>${r.cnpj}</td>
					<td>${r.regiao}</td>
					
					<td><c:url value="restaurante" var="link">
							<c:param name="acao" value="abrir-form-edicao" />
							<c:param name="codigo" value="${r.idRestaurante}" />
						</c:url> <a href="${link}" class="btn btn-primary">Editar</a></td>

				</tr>
			</c:forEach>
		</table>
</div>


	<%@ include file="bootstrap/js.jsp"%>



	<!-- Modal -->
	<div class="modal fade" id="excluirModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<h1>Deseja realmente excluir o produto?</h1>
					<form action="produto" method="post">
						<input type="hidden" name="acao" value="excluir"> <input
							type="hidden" name="codigo" id="codigoExcluir">

						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancelar</button>
						<button type="submit" class="btn btn-danger">Excluir</button>
					</form>

				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>




	<!-- Modal -->
	<div class="modal fade" id="excluirCodigo" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Exclusão</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<h1>Deseja realmente excluir o produto?</h1>

				</div>
				<div class="modal-footer">
					<form action="produto" method="post">

						<input type="hidden" name="acao" value="excluir"> <input
							type="hidden" name="codigo" id="codigoExcluir">

						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancelar</button>
						<button type="submit" class="btn btn-danger">Excluir</button>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>