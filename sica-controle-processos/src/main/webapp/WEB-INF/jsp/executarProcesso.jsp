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
			
			<p><strong>Descrição:</strong> ${atividade.descricao}</p>
							
			<p><strong>Horário Previsto Para Execução:</strong> ${atividade.horarioExecucao}</p>
			
			<!-- colocar alguo sobre estar no horário ou atrasado? -->
							
			<p><strong>Nível de Risco:</strong> ${atividade.nivelRisco.valor}</p>
							
			<p><strong>Prioridade:</strong> ${atividade.prioridade.valor}</p>
			
			<div class="form-group">
				<label for="observacaoExecucaoAtividade"><strong>Observação:</strong></label>
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
						<button class="btn btn-primary" formaction="/processos/executar/finalizar">Finalizar Execução</button>
					</c:when>
					<c:otherwise>
						<button class="btn btn-primary" formaction="/processos/executar/proximaAtividade">Próxima</button>
					</c:otherwise>
				</c:choose>
				
				<hr class="my-4">
				
				<button class="btn btn-danger" data-toggle="collapse" data-target="#collapseOcorrencia" aria-expanded="false" aria-controls="collapseOcorrencia">
					Informar Ocorrência
				</button>
				
			
				<button class="btn btn-danger" formaction="/processos/executar/interromper" onclick="return confirm('Tem certeza que deseja interromper a execução desse processo sem informar ocorrência?')")>Interromper Execução</button>
			</div>
		</form:form>
			
		<form>	
			<div class="collapse" id="collapseOcorrencia">
				<div class="card card-body">
			    	<i>formulário para campos da ocorrência</i>
			    	
			    	<c:choose>
						<c:when test="${atividadeProxima == -1}">
							<a class="btn btn-primary" href="/processos/finalizarExecucao/${processo.id}">Salvar e Finalizar</a>
						</c:when>
						<c:otherwise>
			    			<a class="btn btn-primary" href="/processos/executar/${processo.id}?atividade=${atividadeProxima}">Salvar e Continuar</a>
			    		</c:otherwise>
			    	</c:choose>
			    	<a class="btn btn-primary" href="#" onclick="return confirm('Tem certeza que deseja interromper a execução desse processo?')")>Salvar e Interromper</a>
			    </div>
			</div>
		</form>
		
		<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
        <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	</div>
</body>
</html>