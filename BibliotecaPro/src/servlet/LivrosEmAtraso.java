package servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmprestimoDAO;
import logica.Logica;
import models.Emprestimo;

public class LivrosEmAtraso implements Logica{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Emprestimo> emprestimo = new EmprestimoDAO().getListaAtraso();
		request.setAttribute("emprestimos", emprestimo);

		return "atraso-emprestimo.jsp"; 
	}
}