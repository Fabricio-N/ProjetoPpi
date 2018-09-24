package servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LivroDAO;
import logica.Logica;
import models.Livro;

public class ListarLivros implements Logica{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Livro> livros = new LivroDAO().getLista();
		request.setAttribute("livros", livros);
		return "listar-livros.jsp";
	}
}