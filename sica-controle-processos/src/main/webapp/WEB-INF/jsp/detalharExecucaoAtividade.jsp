<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE HTML>
<html>
<head>
	<title>Detalhar Ocorr�ncia de Execu��o de Processo Miner�rio</title>
	
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
			<h1 class="display-4">${execucaoProcesso.processo.titulo} - ${execucaoAtividade.nome}</h1>
			
			<hr class="my-4">
			
			<p><strong>Hor�rio da Execu��o:</strong> ${localDateTimeFormat.format(execucaoAtividade.horarioExecucao)}</p>
			
			<p><strong>Observa��o da Execu��o:</strong> ${execucaoAtividade.observacao}</p>
			
			<c:if test="${ocorrencia != null}">
				<p><strong>Observa��o da Ocorr�ncia:</strong> ${ocorrencia.observacao}</p>
				
				<p><strong>Tipo:</strong> ${ocorrencia.tipo.valor}</p>
				
				<p><strong>Frequ�ncia:</strong> ${ocorrencia.recorrencia.valor}</p>
				
				<p><strong>Interrompeu a execu��o?</strong> ${ocorrencia.interrompeuExecucao ? "Sim" : "N�o"}</p>
				
				<p><strong>Foi resolvida?</strong> ${ocorrencia.resolvida ? "Sim" : "N�o"}</p>
			</c:if>
			
			<hr class="my-4">
			
			<div>
				<a class="btn btn-primary" href="/controleProcessos/processos/execucao/${execucaoProcesso.id}">Voltar</a>
			</div>
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