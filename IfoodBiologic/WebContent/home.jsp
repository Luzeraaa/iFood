<%@ page import="br.com.ifood.bean.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@500&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="resources/style.css" />
<meta charset="ISO-8859-1">
<title>Ifood BioLogic</title>
<%@ include file="bootstrap/css.jsp"%>



</head>
<body>
	<%@ include file="menu.jsp"%>

	<div class="container">

		<img src="resources/ifood.png" class="rounded mx-auto d-block mt-5 mb-5 img-logo" />

		<div class="text-center">
			<h1>Olá</h1>
			<h2>Somos a BioLogic</h2>
		</div>
		<div class="fonte-especial text-center">
			<h2>Sejam bem vindos, nessa aplicação simples porém eficaz,
				trazemos resultados(querys) que julgamos importante para o Ifood
				para deixar o cliente satisfeito</h2>
		</div>
	</div>


	<footer class="bg-dark text-light text-center pb-2 pt-2">
		<h5>Biologic Inc ©</h5>
	</footer>


	<%@ include file="bootstrap/js.jsp"%>
</body>
</html>