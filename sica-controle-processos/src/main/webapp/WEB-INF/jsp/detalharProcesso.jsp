<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Detalhar Processo</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
			<h1 class="display-4">${processo.titulo}</h1>
			
			<p class="lead">${processo.descricao}</p>
			
			<hr class="my-4">
			
			<p><strong>Periodicidade: </strong> ${processo.periodicidade.valor}</p>
			
			<p><strong>Ativo: </strong> <c:choose><c:when test="${processo.ativo}">Sim</c:when><c:otherwise>Não</c:otherwise></c:choose></p>
			
			<table class="table table-hover table-sm">
				<thead class="thead-light">
					<tr>
						<th scope="col">Atividade</th>
						<th scope="col">Descrição</th>
						<th scope="col">Horário de Execução</th>
						<th scope="col">Nível de Risco</th>
						<th scope="col">Prioridade</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
	
				<tbody>
					<c:forEach items="${processo.atividades}" var="atividade">
						<tr>
							<td>${atividade.nome}</td>
							
							<td>${atividade.descricao}</td>
							
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
			
			<div>
				<a class="btn btn-primary" href="/processos">Voltar</a>
				<a class="btn btn-primary" href="/processos/executar/${processo.id}" onclick="return confirm('Deseja iniciar a execução desse processo?')")>Executar Processo</a>
			</div>
		
		<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
        <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>		
	</div>
</body>
</html>