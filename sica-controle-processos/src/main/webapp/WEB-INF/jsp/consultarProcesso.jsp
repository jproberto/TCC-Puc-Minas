<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Consultar Processos</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1 class="display-4">Consultar Processos</h2>

		<table class="table table-hover table-sm">
			<thead class="thead-light">
				<tr>
					<th scope="col">Título</th>
					<th scope="col">Descrição</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${processos}" var="processo">
					<tr>
						<td>${processo.titulo}</td>
						
						<td>
							<c:set var="descricao" value="${processo.descricao}" />
							<c:choose>
								<c:when test="${fn:length(descricao) gt 80}">
									${fn:substring(descricao, 0, 78)}...
								</c:when>
								<c:otherwise>
									${descricao}
								</c:otherwise>
							</c:choose>
						</td>
						
						<td><a class="btn btn-outline-primary btn-sm" href="/processos/${processo.id}">Detalhar</a></td>
						<td><a class="btn btn-outline-primary btn-sm" href="#">Alterar</a></td>
						<td><a class="btn btn-outline-primary btn-sm" href="#">Excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div>
			<a class="btn btn-primary" href="#">Novo Processo</a>
		</div>	
		
		<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
        <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	</div>
</body>
</html>