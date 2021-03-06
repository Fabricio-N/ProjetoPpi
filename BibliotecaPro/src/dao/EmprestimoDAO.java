package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import models.Aluno;
import models.Emprestimo;
import models.Livro;

public class EmprestimoDAO {
	private Connection connection;

	public EmprestimoDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Emprestimo emprestimo) {

		String query = "insert into emprestimos (aluno, livro, dataEmprestimo, dataDevolucao) values (?, ?, ?, ?);";

		try {
			PreparedStatement p = connection.prepareStatement(query);

			Calendar calendario = Calendar.getInstance();
			Long calendarioEF = calendario.getTimeInMillis();

			p.setLong(1, emprestimo.getAluno().getId());
			p.setLong(2, emprestimo.getLivro().getId());
			p.setDate(3, new java.sql.Date(calendarioEF));
			p.setDate(4, new java.sql.Date(calendarioEF));

			p.execute();
			p.close();
			System.out.println("Salvo com sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
		return false;
	}

	public boolean qtdEmprestimos(Aluno aluno) throws SQLException {

		try {
			PreparedStatement stmt = connection
					.prepareStatement("select * from emprestimos where aluno = ? and dataDevolucao IS NULL;");
			stmt.setLong(1, aluno.getId());
			ResultSet rs = stmt.executeQuery();
			int cont = 0;
			while (rs.next()) {
				cont++;
			}
			stmt.close();
			if (cont > 2) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public List<Emprestimo> getListaAbertos() {
		try {

			List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
			PreparedStatement stmt = connection
					.prepareStatement("select * from emprestimos where dataDevolucao is null;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Emprestimo emprestimo = new Emprestimo();
				
				Livro livro = new LivroDAO().getLivroByID(rs.getLong("livro"));
				emprestimo.setLivro(livro);
				Aluno aluno = new AlunoDAO().getAlunoByID(rs.getLong("aluno"));
				emprestimo.setAluno(aluno);
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataEmprestimo"));
				emprestimo.setDataEmprestimo(data);

				if (rs.getDate("dataDevolucao") != null) {
					Calendar dataDevolucao = Calendar.getInstance();
					dataDevolucao.setTime(rs.getDate("dataDevolucao"));
					emprestimo.setDataDevolucao(dataDevolucao);
				}

				emprestimos.add(emprestimo);
			}

			stmt.close();
			return emprestimos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Emprestimo> getListaAtraso() {
		try {

			List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
			PreparedStatement stmt = connection
					.prepareStatement("select * from emprestimos where dataDevolucao is null and dataEmprestimo < ?;");
			Emprestimo emprestimo = new Emprestimo();

			Calendar dataEmprestimo = Calendar.getInstance();
			emprestimo.setDataEmprestimo(dataEmprestimo);

			dataEmprestimo.add(Calendar.DAY_OF_YEAR, -14);

			stmt.setDate(1, new Date(dataEmprestimo.getTimeInMillis()));

			ResultSet rs = stmt.executeQuery();

			rs.close();
			stmt.close();
			return emprestimos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Emprestimo> getLista() {
		try {

			List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
			PreparedStatement stmt = connection.prepareStatement("select * from emprestimos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Emprestimo emprestimo = new Emprestimo();

				Aluno aluno = new AlunoDAO().getAlunoByID(rs.getLong("aluno"));
				emprestimo.setAluno(aluno);
				Livro livro = new LivroDAO().getLivroByID(rs.getLong("livro"));
				emprestimo.setLivro(livro);

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataEmprestimo"));
				emprestimo.setDataEmprestimo(data);

				if (rs.getDate("dataDevolucao") != null) {
					Calendar data2 = Calendar.getInstance();
					data2.setTime(rs.getDate("dataDevolucao"));
					emprestimo.setDataDevolucao(data2);
				}
				emprestimos.add(emprestimo);
			}
			rs.close();
			stmt.close();
			return emprestimos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public boolean devolucao(long aluno, long livro) {
		Calendar cal = Calendar.getInstance();
		Long cal1 = cal.getTimeInMillis();
		String sql = "update emprestimos set dataDevolucao=? where aluno=? and livro=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDate(1, new java.sql.Date(cal1));
			stmt.setLong(2, aluno);
			stmt.setLong(3, livro);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Emprestimo getEmprestimoByID(Long id) {
		try {

			Emprestimo emprestimo = null;
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimos where id=?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			AlunoDAO alunoDAO = new AlunoDAO();
			LivroDAO livroDAO = new LivroDAO();
			while (rs.next()) {
				emprestimo = new Emprestimo();
				emprestimo.setId(rs.getLong("id"));
				emprestimo.setAluno(alunoDAO.getAlunoByID(id));
				emprestimo.setLivro(livroDAO.getLivroByID(id));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataDevolucao"));
				emprestimo.setDataEmprestimo(data);

			}
			rs.close();
			stmt.close();
			return emprestimo;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

}
