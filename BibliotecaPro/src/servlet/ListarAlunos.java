package servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlunoDAO;
import logica.Logica;
import models.Aluno;

public class ListarAlunos implements Logica{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Aluno> alunos = new AlunoDAO().getLista();
		request.setAttribute("alunos", alunos);
		return "listar-alunos.jsp";
	}
}