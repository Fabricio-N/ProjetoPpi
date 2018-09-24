package servlet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LivroDAO;
import logica.Logica;
import models.Livro;

public class AdicionarLivro implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Livro livro = new Livro();
		LivroDAO dao = new LivroDAO();
				
		String idTexto = request.getParameter("id");

		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String editora = request.getParameter("editora");
		String anoEdicao = request.getParameter("anoEdicao");
		int anoPublicacao = Integer.parseInt(request.getParameter("anoPublicacao"));

				
		livro.setTitulo(titulo);
		livro.setAutor(autor);
		livro.setEditora(editora);
		livro.setAnoEdicao(anoEdicao);
		livro.setAnoPublicacao(anoPublicacao);
		
		dao.adicionar(livro);

		List<Livro> livros = dao.getLista();
		request.setAttribute("livros", livro);

		return "mvc?logica=ListarLivros";
	}

}
