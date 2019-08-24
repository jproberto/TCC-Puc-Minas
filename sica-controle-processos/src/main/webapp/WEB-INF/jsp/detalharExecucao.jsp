<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE HTML>
<html>
<head>
	<title>Detalhar Execução de Processo Minerário</title>
	
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
			<h1 class="display-4">Execução: ${execucaoProcesso.processo.titulo}</h1>
			
			<hr class="my-4">
			
			<p><strong>Início: </strong> ${localDateTimeFormat.format(execucaoProcesso.inicioExecucao)}</p>
			
			<p><strong>Fim: </strong> ${localDateTimeFormat.format(execucaoProcesso.fimExecucao)}</p>
			
			<p><strong>Status: </strong> ${execucaoProcesso.status.valor}</p>
			
			<table class="table table-hover table-sm">
				<thead class="thead-light">
					<tr>
						<th scope="col">Nome</th>
						<th scope="col">Horário</th>
						<th scope="col" class="d-none d-md-block">Observação</th>
						<th scope="col">Ocorrência?</th>
						<th></th>
					</tr>
				</thead>
	
				<tbody>
					<c:forEach items="${execucaoProcesso.execucaoAtividades}" var="atividade" varStatus="indiceAtividade">
						<tr>
							<td>${atividade.nome}</td>
							
							<td>${localDateTimeFormat.format(atividade.horarioExecucao)}</td>
							
							<td class="d-none d-md-block d-lg-none">
								<c:set var="observacao" value="${atividade.observacao}" />
								<c:choose>
									<c:when test="${fn:length(observacao) gt 25}">
										${fn:substring(observacao, 0, 22)}...
									</c:when>
									<c:otherwise>
										${observacao}
									</c:otherwise>
								</c:choose>
							</td>
							
							<td class="d-none d-lg-block d-xl-none">
								<c:set var="observacao" value="${atividade.observacao}" />
								<c:choose>
									<c:when test="${fn:length(observacao) gt 50}">
										${fn:substring(observacao, 0, 48)}...
									</c:when>
									<c:otherwise>
										${observacao}
									</c:otherwise>
								</c:choose>
							</td>
							
							<td class="d-none d-xl-block">
								<c:set var="observacao" value="${atividade.observacao}" />
								<c:choose>
									<c:when test="${fn:length(observacao) gt 80}">
										${fn:substring(observacao, 0, 78)}...
									</c:when>
									<c:otherwise>
										${observacao}
									</c:otherwise>
								</c:choose>
							</td>
							
							<td>
								${atividade.ocorrencia == null ? 'Não' : 'Sim'}
							</td>
							
							<td>
								<a class="btn btn-outline-primary btn-sm" href="/controleProcessos/processos/execucao/${execucaoProcesso.id}/atividade/${indiceAtividade.count - 1}">Detalhar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<hr class="my-4">
			
			<div>
				<a class="btn btn-primary" href="/controleProcessos/processos/${execucaoProcesso.processo.id}">Voltar</a>
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