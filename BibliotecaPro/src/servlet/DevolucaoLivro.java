package servlet;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmprestimoDAO;
import logica.Logica;
import models.Emprestimo;

public class DevolucaoLivro implements Logica {
		@Override
		public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
			EmprestimoDAO dao = new EmprestimoDAO();
			long livro = Long.parseLong(request.getParameter("livro"));
			long aluno = Long.parseLong(request.getParameter("aluno"));
			if(dao.devolucao(livro, aluno)) {
				return "mvc?logica=EmprestimoRegis";
				
			}else {
				return "erro";
			}
			
		}

}
