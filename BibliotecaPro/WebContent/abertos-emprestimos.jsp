<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Lista de emprestimos abertos</title>
<link rel="stylesheet" type="text/css" href="css/css.css">
</head>
<body>
	<c:import url="inicio.jsp"></c:import>
	<h2>${message }</h2>
	<table border="10">
		<thead>
			<tr>
				<th>Livro</th>
				<th>Matr�cula</th>
				<th>Data do emprestimo</th>
				<th>Devolu��o</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="e" items="${emprestimos}">


				<tr>

					<td>${e.livro.titulo}</td>
					<td>${e.aluno.matricula}</td>
					<td>${e.dataEmprestimo.time }</td>
					<td><a href="mvc?logica=DevolucaoLivro&aluno=${e.aluno.id }&livro=${e.livro.id}">Entrega do Livro</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>



