<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Executar Processo</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<form method="post">
			<h1 class="display-4">Executando: ${processo.titulo}</h1>
			
			<hr class="my-4">
			
			<p><strong>Atividade atual: </strong> ${atividade.nome}</p>
			
			<p><strong>Descri��o:</strong> ${atividade.descricao}</p>
							
			<p><strong>Hor�rio Previsto Para Execu��o:</strong> ${atividade.horarioExecucao}</p>
			
			<!-- colocar alguo sobre estar no hor�rio ou atrasado? -->
							
			<p><strong>N�vel de Risco:</strong> ${atividade.nivelRisco.valor}</p>
							
			<p><strong>Prioridade:</strong> ${atividade.prioridade.valor}</p>
			
			<div class="form-group">
				<label for="observacaoExecucaoAtividade"><strong>Observa��o:</strong></label>
				<textarea class="form-control" name="observacaoExecucaoAtividade">${execucaoAtividade.observacao}</textarea>
			</div>
			
			<hr class="my-4">
							
			<div>
				<input type="hidden" name="idProcesso" value="${processo.id }">
			
				<button class="btn btn-primary" formaction="/processos/teste"></button>
			
				<c:choose>
					<c:when test="${atividadeAnterior == -1}">
						<button class="btn btn-secondary" disabled>Anterior</button>
					</c:when>
					<c:otherwise>
						<a class="btn btn-primary" href="/processos/executar/${processo.id}?atividade=${atividadeAnterior}">Anterior</a>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${atividadeProxima == -1}">
						<a class="btn btn-primary" href="/processos/finalizarExecucao/${processo.id}">Finalizar Execu��o</a>
					</c:when>
					<c:otherwise>
						<a class="btn btn-primary" href="/processos/executar/${processo.id}?atividade=${atividadeProxima}">Pr�xima</a>
					</c:otherwise>
				</c:choose>
				
				<hr class="my-4">
				
				<a class="btn btn-danger" data-toggle="collapse" href="#collapseOcorrencia" role="button" aria-expanded="false" aria-controls="collapseOcorrencia">
					Informar Ocorr�ncia
				</a>
				
			
				<a class="btn btn-danger" href="#" onclick="return confirm('Tem certeza que deseja interromper a execu��o desse processo sem informar ocorr�ncia?')")>Interromper Execu��o</a>
			</div>
		</form>
			
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