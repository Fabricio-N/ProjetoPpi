<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulário</title>
<link rel="stylesheet" type="text/css" href="css/css.css">
</head>
<style>
label {
	color: DeepPink;
}

form {
	text-align: center;
}

h1 {
	text-shadow: 0 0 0.2em #8f7
}
</style>
<body>

	<c:import url="inicio.jsp"></c:import>


	<form action="mvc?" method="post">
		<h1>Adicionar alunos</h1>
		<input type="hidden" name="logica" value="AdicionarAluno">


		<div>
			<label>Nome: <input type="text" name="nome"></label>
		</div>
		<div>
			<label>Matricula: <input type="text" name="matricula"></label>
		</div>
		<div>
			<label>CPF: <input type="text" name="cpf"></label>
		</div>
		<div>
			<label>Endereço: <input type="text" name="endereco"></label>
		</div>
		<div>
			<label>Data de Nascimento: <input type="text"
				name="dataTexto"></label>
		</div>
		<div>
			<input type="submit" value="AdicionarAluno">
		</div>
	</form>

</body>
</html>