package servlet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlunoDAO;
import dao.EmprestimoDAO;
import dao.LivroDAO;
import logica.Logica;
import models.Aluno;
import models.Emprestimo;
import models.Livro;

public class EmprestimoServlet implements Logica {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String livro_titulo = request.getParameter("livro_titulo");
		Livro livro = new LivroDAO().getLivroByTitulo(livro_titulo);

		String aluno_matricula = request.getParameter("aluno_matricula");
		Aluno aluno = new AlunoDAO().getAlunoByMatricula(aluno_matricula);

		LivroDAO livroDao = new LivroDAO();
		AlunoDAO alunoDao = new AlunoDAO();
		Emprestimo e = new Emprestimo();
		EmprestimoDAO dao = new EmprestimoDAO();

		e.setAluno(aluno);
		e.setLivro(livro);
		e.setDataEmprestimo(Calendar.getInstance());

		
		if (livro_titulo == null || livroDao.getLivroByTitulo(livro_titulo) == null) {
			request.setAttribute("message", "Livro nao encontrado");
			return "chamarLivro.jsp";
		} else {
			
			if (aluno_matricula == null || alunoDao.getAlunoByMatricula(aluno_matricula) == null) {
				request.setAttribute("message", "Aluno sem cadastro");
				return "chamarLivro.jsp";
			} else {
					
					if (dao.qtdEmprestimos(aluno)) {
						dao.inserir(e);
						return "mvc?logica=LivrosEmAbertos";
					} else {
						request.setAttribute("message", "Limite de livros atingido");
						return "chamarLivro.jsp";

					} 
					
					}
				}
			}
		}
	

