<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
	<title>Consultar Processos Minerários</title>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link href="/controleProcessos/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
	<link href="/controleProcessos/css/custom.css" rel="stylesheet" type="text/css" />
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-primario sticky-top">
			<div class="container">
				<a class="navbar-brand" href="/controleProcessos">SICA</a>

				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-collapse" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse wrapper" id="navbar-collapse">
	                <ul class="navbar-nav mr-auto">
		                <li class="nav-item"><a class="nav-link" href="/controleProcessos">Home</a></li>
		                <li class="nav-item"><a class="nav-link disabled" href="#">Controle de Ativos</a></li>
		             	<li class="nav-item active"><a class="nav-link" href="/controleProcessos/processos">Controle de Processos Minerários</a></li>
		             	<li class="nav-item"><a class="nav-link disabled" href="#">Monitoramento de Barragens</a></li>
		                <li class="nav-item"><a class="nav-link disabled" href="#">Segurança e Comunicação</a></li>
		                <li class="nav-item"><a class="nav-link disabled" href="#">Inteligência do Negócio</a></li>
		                <li class="nav-item"><a class="nav-link disabled" href="#">Compliance</a></li>
		                <li class="nav-item"><a class="nav-link disabled" href="#">Relatórios</a></li>
		            </ul>
	    	    </div>
		    </div>
		</nav>
	</header>

	<div class="container">
		<h1 class="display-4">Consultar Processos Minerários</h1>

		<hr class="my-4">
		
		<form:form method="post" modelAttribute="consultarProcessoForm">
			<div class="form-group wrapper">
				<strong>Título:</strong>
				<input type="text" class="form-control" name="titulo" value="${titulo}" />
			</div>
			
			<button class="btn btn-primary" formaction="/controleProcessos/processos">Consultar</button>
		</form:form>

		<hr class="my-4">
		
		<table class="table table-hover table-sm">
			<thead class="thead-light">
				<tr>
					<th scope="col">Título</th>
					<th class="d-none d-sm-block" scope="col">Descrição</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${processos}" var="processo">
					<tr>
						<td>${processo.titulo}</td>
						
						<td class="d-none d-sm-block d-md-none">
							<c:set var="descricao" value="${processo.descricao}" />
							<c:choose>
								<c:when test="${fn:length(descricao) gt 25}">
									${fn:substring(descricao, 0, 22)}...
								</c:when>
								<c:otherwise>
									${descricao}
								</c:otherwise>
							</c:choose>
						</td>
						
						<td class="d-none d-md-block d-lg-none">
							<c:set var="descricao" value="${processo.descricao}" />
							<c:choose>
								<c:when test="${fn:length(descricao) gt 50}">
									${fn:substring(descricao, 0, 48)}...
								</c:when>
								<c:otherwise>
									${descricao}
								</c:otherwise>
							</c:choose>
						</td>
						
						<td class="d-none d-lg-block d-xl-none">
							<c:set var="descricao" value="${processo.descricao}" />
							<c:choose>
								<c:when test="${fn:length(descricao) gt 80}">
									${fn:substring(descricao, 0, 78)}...
								</c:when>
								<c:otherwise>
									${descricao}
								</c:otherwise>
							</c:choose>
						</td>
						
						<td class="d-none d-xl-block">
							<c:set var="descricao" value="${processo.descricao}" />
							<c:choose>
								<c:when test="${fn:length(descricao) gt 110}">
									${fn:substring(descricao, 0, 107)}...
								</c:when>
								<c:otherwise>
									${descricao}
								</c:otherwise>
							</c:choose>
						</td>
						
						<td><a class="btn btn-outline-primary btn-sm" href="/controleProcessos/processos/${processo.id}">Detalhar</a></td>
						<td><a class="btn btn-outline-primary btn-sm" href="#">Alterar</a></td>
						<td><a class="btn btn-outline-primary btn-sm" href="#">Excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<hr class="my-4">
		
		<div>
			<a class="btn btn-primary" href="#">Novo Processo Minerário</a>
		</div>	
	</div>
	
	<footer class="footer">
		<div class="container">
			<span class="text-muted">
				Desenvolvido por João Paulo de Souza Roberto
			</span>
		</div>
	</footer>
		
	<script src="/controleProcessos/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="/controleProcessos/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>