<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Detalhar Execu��o de Processo</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
			<h1 class="display-4">${execucaoProcesso.processo.titulo}</h1>
			
			<hr class="my-4">
			
			<p><strong>In�cio: </strong> ${localDateTimeFormat.format(execucaoProcesso.inicioExecucao)}</p>
			
			<p><strong>Fim: </strong> ${localDateTimeFormat.format(execucaoProcesso.fimExecucao)}</p>
			
			<p><strong>Status: </strong> ${execucaoProcesso.status.valor}</p>
			
			<table class="table table-hover table-sm">
				<thead class="thead-light">
					<tr>
						<th scope="col">Nome</th>
						<th scope="col">Hor�rio de Execu��o</th>
						<th scope="col">Observa��o</th>
						<th></th>
					</tr>
				</thead>
	
				<tbody>
					<c:forEach items="${execucaoProcesso.execucaoAtividades}" var="atividade">
						<tr>
							<td>${atividade.nome}</td>
							
							<td>${localDateTimeFormat.format(atividade.horarioExecucao)}</td>
							
							<td>${atividade.observacao}</td>
							
							<td>
								<c:if test="${atividade.ocorrencia != null}">
									<a class="btn btn-outline-primary btn-sm" href="#">Detalhar Ocorr�ncia</a>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div>
				<a class="btn btn-primary" href="/processos/${execucaoProcesso.processo.id}">Voltar</a>
			</div>
		
		<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
        <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>		
	</div>
</body>
</html>