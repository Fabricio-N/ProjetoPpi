
<style>

body {
   background-image: url("https://catracalivre.com.br/wp-content/uploads/2013/08/livros4.jpg");
  
}


ul {

	border:5px solid;
	list-style-type: none;
	margin: 10;
	padding: 10;
	overflow: hidden;
	background-color: #20B2AA;
}

li {
	float: left;
}

li a {
    
	display: block;
	color: black;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover:not (.active ) {
	background-color: #20B2AA;
}


</style>




<ul>

  <li><a class="active" href="adicionar-aluno.jsp">Adicionar Aluno</a></li>
  <li><a href="adicionar-livro.jsp">Adicionar Livro</a></li>
  <li><a href="mvc?logica=ListarAlunos">Lista de Alunos</a></li>
  <li><a href="mvc?logica=ListarLivros">Lista de Livros</a></li>
  <li><a href="chamarLivro.jsp">Fazer Empréstimos</a></li>
  <li><a href="mvc?logica=EmprestimoRegis">Registro de Empréstimos</a></li>
  <li><a href="mvc?logica=LivrosEmAtraso">Empréstimos Atrasados</a></li>
  <li><a href="mvc?logica=LivrosEmAbertos">Empréstimos Ativos</a></li>

</ul>


