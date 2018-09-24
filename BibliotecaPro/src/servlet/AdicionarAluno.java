package servlet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlunoDAO;
import logica.Logica;
import models.Aluno;

public class AdicionarAluno implements Logica {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Aluno aluno = new Aluno();
		AlunoDAO dao = new AlunoDAO();
				
		

		String nome = request.getParameter("nome");
		String matricula = request.getParameter("matricula");
		String endereco = request.getParameter("endereco");
		String cpf = request.getParameter("cpf");
		String dataTexto = request.getParameter("dataTexto");

		Calendar dataDeNascimento = null;
		try {
			Date datatemporaria = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
			dataDeNascimento = Calendar.getInstance();
			dataDeNascimento.setTime(datatemporaria);
		} catch (ParseException e) {
			e.printStackTrace();
		}
				
		aluno.setNome(nome);
		aluno.setMatricula(matricula);
		aluno.setCpf(cpf);
		aluno.setEndereco(endereco);
		aluno.setDataNascimento(dataDeNascimento);
		
		dao.inserir(aluno);

		List<Aluno> alunos = dao.getLista();
		request.setAttribute("alunos", aluno);
		return "mvc?logica=ListarAlunos";
	}
}