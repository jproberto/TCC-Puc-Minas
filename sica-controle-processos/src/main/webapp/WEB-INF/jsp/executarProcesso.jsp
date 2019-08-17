<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Executar Processo</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<form:form method="post" modelAttribute="execucaoProcessoForm">
			<h1 class="display-4">Executando: ${tituloProcesso}</h1>
			
			<hr class="my-4">
			
			<p><strong>Atividade atual: </strong> ${atividade.nome}</p>
			
			<p><strong>Descri��o:</strong> ${atividade.descricao}</p>
							
			<p><strong>Hor�rio Previsto Para Execu��o:</strong> ${atividade.horarioExecucao}</p>
			
			<!-- colocar alguo sobre estar no hor�rio ou atrasado? -->
							
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
						<button class="btn btn-primary" formaction="/processos/executar/atividadeAnterior">Anterior</button>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${indiceAtividadeProxima == -1}">
						<button class="btn btn-primary" formaction="/processos/executar/finalizar">Finalizar Execu��o</button>
					</c:when>
					<c:otherwise>
						<button class="btn btn-primary" formaction="/processos/executar/proximaAtividade">Pr�xima</button>
					</c:otherwise>
				</c:choose>
				
				<hr class="my-4">
				
				<button class="btn btn-danger" data-toggle="collapse" data-target="#collapseOcorrencia" aria-expanded="false" aria-controls="collapseOcorrencia">
					Informar Ocorr�ncia
				</button>
				
			
				<button class="btn btn-danger" formaction="/processos/executar/interromper" onclick="return confirm('Tem certeza que deseja interromper a execu��o desse processo sem informar ocorr�ncia?')")>Interromper Execu��o</button>
			</div>
		</form:form>
			
		<form>	
			<div class="collapse" id="collapseOcorrencia">
				<div class="card card-body">
			    	<i>formul�rio para campos da ocorr�ncia</i>
			    	
			    	<c:choose>
						<c:when test="${atividadeProxima == -1}">
							<a class="btn btn-primary" href="/processos/finalizarExecucao/${processo.id}">Salvar e Finalizar</a>
						</c:when>
						<c:otherwise>
			    			<a class="btn btn-primary" href="/processos/executar/${processo.id}?atividade=${atividadeProxima}">Salvar e Continuar</a>
			    		</c:otherwise>
			    	</c:choose>
			    	<a class="btn btn-primary" href="#" onclick="return confirm('Tem certeza que deseja interromper a execu��o desse processo?')")>Salvar e Interromper</a>
			    </div>
			</div>
		</form>
		
		<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
        <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	</div>
</body>
</html>