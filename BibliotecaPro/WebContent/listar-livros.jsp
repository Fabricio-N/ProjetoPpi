<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Livros</title>
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
	<table border="10" align="center">
		<thead>
			<tr>
				<th>Título</th>
				<th>Autor</th>
				<th>Editora</th>
				<th>Edição</th>
				<th>Ano de Publicação</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="livro" items="${livros}">
				<tr>
					<td>${livro.titulo}</td>
					<td>${livro.autor}</td>
					<td>${livro.editora}</td>
					<td>${livro.anoEdicao}</td>
					<td>${livro.anoPublicacao }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>