<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ include file="bootstrap/css.jsp"%>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastros de Restaurante</title>

<link rel="stylesheet" type="text/css" href="resources/style.css" />

</head>
<body>

	<%@ include file="menu.jsp"%>
	<div class="container text-center">
		<h1 class="mb-5 mt-3">Restaurantes Cadastrados</h1>
		

		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg }</div>
		</c:if>

		<c:if test="${not empty erro }">

			<div class="alert alert-danger">${erro}</div>

		</c:if>
		
	
		<section  class="row d-flex justify-content-around"> 
		<c:forEach items="${restaurantes }" var="c">
		<article class="mb-5 col-12 col-md-4">
		<div class="card ">
			<div class="card-body ">
				<h3 class="card-title text-center">${c.nomeRestaurante }</h3>
			</div>
			<list class="d-flex justify-content-center">
			<ul class="list-group list-group-flush text-center col-md-11">
				<li class="list-group-item"><span class="fs-5">Tipo de
						comida</span><br>${c.comida.descricaoComida }</li>
				<li class="list-group-item"><span class="fs-5">Frete
						mínimo</span><br>${c.valorFrete }</li>
				<li class="list-group-item"><span class="fs-5">Tempo de
						Entrega</span><br>${c.tempoEntrega }</li>
				<li class="list-group-item"><span class="fs-5">Pedido
						mínimo</span><br>${c.valorPedido }</li>
				<li class="list-group-item"><span class="fs-5">Nome
						Responsável</span><br>${c.nomeResponsavel }</li>
				<li class="list-group-item"><span class="fs-5">Email
						Responsável</span><br>${c.emailResponsavel }</li>
				<li class="list-group-item"><span class="fs-5">CNPJ</span><br>${c.cnpj }</li>
				<li class="list-group-item"><span class="fs-5">Regiao</span><br>${c.regiao }</li>


			</ul>
			</list>
			<div class="card-body">
				<c:url value="restaurante" var="link">
					<c:param name="acao" value="abrir-form-edicao" />
					<c:param name="codigo" value="${c.idRestaurante}" />
				</c:url> 
					<a href="${link}" class="btn botao-login card-link  shadow-none col-12 col-md-12">Editar</a>	
			</div>
		</div>
		</article> 
	</c:forEach>
		</section>
	
</div>










	<%@ include file="bootstrap/js.jsp"%>


	<!-- Modal -->
	<div class="modal fade" id="excluirCodigo" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Exclusăo</h5>
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