package servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmprestimoDAO;
import logica.Logica;
import models.Emprestimo;

public class EmprestimoRegis implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Emprestimo> emprestimos = new EmprestimoDAO().getLista();
		request.setAttribute("emprestimos", emprestimos);

		return "emprestimo-regis.jsp"; 
	}

}
