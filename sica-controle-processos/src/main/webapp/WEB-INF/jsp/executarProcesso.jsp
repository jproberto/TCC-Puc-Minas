<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>
<head>
	<title>Executar Processo Miner�rio</title>
	
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
		             	<li class="nav-item active"><a class="nav-link" href="/controleProcessos/processos">Controle de Processos Miner�rios</a></li>
		             	<li class="nav-item"><a class="nav-link disabled" href="#">Monitoramento de Barragens</a></li>
		                <li class="nav-item"><a class="nav-link disabled" href="#">Seguran�a e Comunica��o</a></li>
		                <li class="nav-item"><a class="nav-link disabled" href="#">Intelig�ncia do Neg�cio</a></li>
		                <li class="nav-item"><a class="nav-link disabled" href="#">Compliance</a></li>
		                <li class="nav-item"><a class="nav-link disabled" href="#">Relat�rios</a></li>
		            </ul>
	    	    </div>
		    </div>
		</nav>
	</header>

	<div class="container">
		<form:form method="post" modelAttribute="execucaoProcessoForm">
			<h1 class="display-4">Executando: ${tituloProcesso}</h1>
			
			<hr class="my-4">
			
			<p><strong>Atividade atual: </strong> ${atividade.nome}</p>
			
			<p><strong>Descri��o:</strong> ${atividade.descricao}</p>
							
			<p><strong>Hor�rio Previsto Para Execu��o:</strong> ${atividade.horarioExecucao}</p>
			
			<p><strong>Hor�rio Atual:</strong> ${localDateTimeFormat.format(horaAtual)}</p>
							
			<p><strong>N�vel de Risco:</strong> ${atividade.nivelRisco.valor}</p>
							
			<p><strong>Prioridade:</strong> ${atividade.prioridade.valor}</p>
			
			<div class="form-group">
				<label for="observacaoExecucaoAtividade"><strong>Observa��o:</strong></label>
				<textarea class="form-control" name="observacaoExecucaoAtividade">${observacaoExecucaoAtividade}</textarea>
			</div>
			
			<hr class="my-4">
							
			<div>
			
				<form:hidden path="idExecucaoProcesso" value="${idExecucaoProcesso}" />
				<form:hidden path="indiceAtividade" value="${indiceAtividade}" />
			
				<c:choose>
					<c:when test="${indiceAtividadeAnterior == -1}">
						<button class="btn btn-secondary" disabled>Anterior</button>
					</c:when>
					<c:otherwise>
						<button class="btn btn-primary" formaction="/controleProcessos/processos/executar/atividadeAnterior">Anterior</button>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${indiceAtividadeProxima == -1}">
						<button class="btn btn-primary" formaction="/controleProcessos/processos/executar/finalizar">
							<span class="d-block d-sm-none">Finalizar</span><span class="d-none d-sm-block">Finalizar Execu��o</span>
						</button>
					</c:when>
					<c:otherwise>
						<button class="btn btn-primary" formaction="/controleProcessos/processos/executar/proximaAtividade">Pr�xima</button>
					</c:otherwise>
				</c:choose>
				
				<hr class="my-4">
				
				<a class="btn btn-danger" data-toggle="collapse" href="#collapseOcorrencia" role="button" aria-expanded="false" aria-controls="collapseOcorrencia">
					<span class="d-block d-sm-none">Ocorr�ncia</span><span class="d-none d-sm-block">Informar Ocorr�ncia</span>
				</a>
				
				<button class="btn btn-danger" formaction="/controleProcessos/processos/executar/interromper" onclick="return confirm('Tem certeza que deseja interromper a execu��o desse processo miner�rio sem informar ocorr�ncia?')")>
					<span class="d-block d-sm-none">Interromper</span><span class="d-none d-sm-block">Interromper Execu��o</span>
				</button>
			</div>
			
			<br />
			
			<div class="collapse espaco-footer" id="collapseOcorrencia">
				<div class="card card-body">
			    	<div class="form-group">
						<label for="observacaoExecucaoAtividade"><strong>Observa��o da Ocorr�ncia:</strong></label>
						<textarea class="form-control" name="observacaoOcorrencia">${observacaoOcorrencia}</textarea>
					</div>
					
					<div>
						<label class="col-3 text-right" for="tipoOcorrencia"><strong>Tipo:</strong></label>
						<c:set var ="tipoOcorrenciaValue" value="${tipoOcorrenciaValue}" />
						<form:select class="col-4" path="tipoOcorrencia">
							<option value="" />
							<c:forEach var="tipo" items="${tiposOcorrencia}">
								<option value="${tipo}" ${tipo == tipoOcorrenciaValue ? 'selected' : ''}>${tipo.valor}</option>					
							</c:forEach>
						</form:select>
					</div>
					
					<div>
						<label class="col-3 text-right" for="recorrenciaOcorrencia"><strong>Frequ�ncia:</strong></label>
						<c:set var ="recorrenciaOcorrenciaValue" value="${recorrenciaOcorrenciaValue}" />
						<form:select class="col-4" path="recorrenciaOcorrencia">
							<option value="" />
							<c:forEach var="recorrencia" items="${recorrenciasOcorrencia}">
								<option value="${recorrencia}" ${recorrencia == recorrenciaOcorrenciaValue ? 'selected' : ''}>${recorrencia.valor}</option>					
							</c:forEach>
						</form:select>
					</div>
					
					<div>
						<label class="col-3 text-right" for="ocorrenciaResolvida"><strong>Resolvida:</strong></label>
						<c:choose>
							<c:when test="${resolvidaValue == true}">
								<c:set var ="checked" value="checked" />
							</c:when>
							<c:otherwise>
								<c:set var ="checked" value="" />
							</c:otherwise>
						</c:choose>
						
						<form:checkbox path="ocorrenciaResolvida" value="${ocorrenciaResolvida}" id="ocorrenciaResolvida" checked="${checked}" />
					</div>
					
					<hr class="my-4">
			    
					<div>	
						<c:choose>
							<c:when test="${indiceAtividadeProxima == -1}">
								<button class="btn btn-primary" formaction="/controleProcessos/processos/executar/ocorrencia/finalizar">
									<span class="d-block d-sm-none">Finalizar</span><span class="d-none d-sm-block">Salvar e Finalizar</span>
								</button>
							</c:when>
							<c:otherwise>
					    		<button class="btn btn-primary" formaction="/controleProcessos/processos/executar/ocorrencia/continuar">
					    			<span class="d-block d-sm-none">Continuar</span><span class="d-none d-sm-block">Salvar e Continuar</span>
					    		</button>
					    	</c:otherwise>
					    </c:choose>
					    <button class="btn btn-primary" formaction="/controleProcessos/processos/executar/ocorrencia/interromper" onclick="return confirm('Tem certeza que deseja interromper a execu��o desse processo miner�rio?')")>
					    	<span class="d-block d-sm-none">Interromper</span><span class="d-none d-sm-block">Salvar e Interromper</span>
					    </button>
					</div>
			    </div>
			</div>
		</form:form>
	</div>
	
	<footer class="footer">
		<div class="container">
			<span class="text-muted">
				Desenvolvido por Jo�o Paulo de Souza Roberto
			</span>
		</div>
	</footer>
		
	<script src="/controleProcessos/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="/controleProcessos/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>