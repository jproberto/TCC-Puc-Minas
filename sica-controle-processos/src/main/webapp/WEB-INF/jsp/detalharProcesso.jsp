<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE HTML>
<html>
<head>
	<title>Detalhar Processo</title>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
	<link href="/css/custom.css" rel="stylesheet" type="text/css" />
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-primario">
			<div class="container">
				<a class="navbar-brand" href="/">SICA</a>

				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-collapse" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse wrapper" id="navbar-collapse">
	                <ul class="navbar-nav mr-auto">
		                <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
		                <li class="nav-item"><a class="nav-link disabled" href="#">Controle de Ativos</a></li>
		             	<li class="nav-item active"><a class="nav-link" href="/processos">Controle de Processos Minerários</a></li>
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
			<h1 class="display-4">${processo.titulo}</h1>
			
			<p class="lead">${processo.descricao}</p>
			
			<hr class="my-4">
			
			<p><strong>Periodicidade: </strong> ${processo.periodicidade.valor}</p>
			
			<p><strong>Ativo: </strong> <c:choose><c:when test="${processo.ativo}">Sim</c:when><c:otherwise>Não</c:otherwise></c:choose></p>
			
			<table class="table table-hover table-sm">
				<thead class="thead-light">
					<tr>
						<th scope="col">Atividade</th>
						<th scope="col" class="d-none d-md-block">Descrição</th>
						<th scope="col">Horário</th>
						<th scope="col">Risco</th>
						<th scope="col">Prioridade</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
	
				<tbody>
					<c:forEach items="${processo.atividades}" var="atividade">
						<tr>
							<td>${atividade.nome}</td>
							
							<td class="d-none d-md-block d-lg-none">
								<c:set var="descricao" value="${atividade.descricao}" />
								<c:choose>
									<c:when test="${fn:length(descricao) gt 25}">
										${fn:substring(descricao, 0, 22)}...
									</c:when>
									<c:otherwise>
										${descricao}
									</c:otherwise>
								</c:choose>
							</td>
							
							<td class="d-none d-lg-block d-xl-none">
								<c:set var="descricao" value="${atividade.descricao}" />
								<c:choose>
									<c:when test="${fn:length(descricao) gt 50}">
										${fn:substring(descricao, 0, 48)}...
									</c:when>
									<c:otherwise>
										${descricao}
									</c:otherwise>
								</c:choose>
							</td>
							
							<td class="d-none d-xl-block">
								<c:set var="descricao" value="${atividade.descricao}" />
								<c:choose>
									<c:when test="${fn:length(descricao) gt 80}">
										${fn:substring(descricao, 0, 78)}...
									</c:when>
									<c:otherwise>
										${descricao}
									</c:otherwise>
								</c:choose>
							</td>
						
							<td>${atividade.horarioExecucao}</td>
							
							<td>${atividade.nivelRisco.valor}</td>
							
							<td>${atividade.prioridade.valor}</td>
							
							<td><a class="btn btn-outline-primary btn-sm" href="#">Alterar</a></td>
							<td><a class="btn btn-outline-primary btn-sm" href="#">Excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<c:if test="${!empty execucoes}">
				<p><strong>Últimas Execuções:</strong></p>
				<table class="table table-hover table-sm">
					<thead class="thead-light">
						<tr>
							<th scope="col">Início</th>
							<th scope="col">Fim</th>
							<th scope="col">Situação</th>
							<th></th>
						</tr>
					</thead>
		
					<tbody>
						<c:forEach items="${execucoes}" var="execucao">
							<tr>
								<td>${localDateTimeFormat.format(execucao.inicioExecucao)}</td>
								
								<td>${localDateTimeFormat.format(execucao.fimExecucao)}</td>
								
								<td>${execucao.status.valor}</td>
								
								<td><a class="btn btn-outline-primary btn-sm" href="/processos/execucao/${execucao.id}">Detalhar</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			
			<hr class="my-4">
			
			<div>
				<a class="btn btn-primary" href="/processos">Voltar</a>
				<a class="btn btn-primary" href="/processos/executar/${processo.id}" onclick="return confirm('Deseja iniciar a execução desse processo?')")>Executar Processo</a>
			</div>
	</div>
	
	<footer class="footer">
		<div class="container">
			<span class="text-muted">
				Desenvolvido por João Paulo de Souza Roberto
			</span>
		</div>
	</footer>
		
	<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>