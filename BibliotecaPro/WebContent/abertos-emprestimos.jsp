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
<style>
tr {
	color: black;
	background-color: white;
}
</style>
<body>
	<c:import url="inicio.jsp"></c:import>
	<h2>${message }</h2>
	<table border="10" align="center">
		<thead>
			<tr>
				<th>Livro</th>
				<th>Aluno</th>
				<th>Data do emprestimo</th>
				<th>Devolução</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emprestimo" items="${emprestimos}">


				<tr>

					<td>${emprestimo.livro.titulo}</td>
					<td>${emprestimo.aluno.nome}</td>
					<td>${emprestimo.dataEmprestimo.time }</td>
					<td><a
						href="mvc?logica=DevolucaoLivro&aluno=${e.aluno.id }&livro=${e.livro.id}">Entrega
							do Livro</a></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>



