<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
	<title>SICA</title>
	
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
		                <li class="nav-item active"><a class="nav-link" href="/controleProcessos">Home</a></li>
		                <li class="nav-item"><a class="nav-link disabled" href="#">Controle de Ativos</a></li>
		             	<li class="nav-item"><a class="nav-link" href="/controleProcessos/processos">Controle de Processos Minerários</a></li>
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
		<div class="jumbotron">
			<h1 class="display-4">Bem vindo ao SICA!</h1>
			<p class="lead">Navegue pelo menu superior para acessar as funcionalidades.</p>
		
			<hr class="my-4">
			
			<p>O Sistema de Controle Ambiental - SICA tem como objetivo gerenciar os ativos, processos minerários e estados barragens da empresa ao tempo em que se preocupa com a preservação do meio-ambiente e com a segurança das pessoas.</p>
		</div>
	</div>
	
	<footer class="footer">
		<div class="container">
			<span class="text-muted">
				Desenvolvido por João Paulo de Souza Roberto
			</span>
		</div>
	</footer>
</body>
</html>