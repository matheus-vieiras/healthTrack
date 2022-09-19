package br.com.healthtrack.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import br.com.healthtrack.fiap.entities.Pessoa;
import br.com.healthtrack.fiap.jdbc.OracleDBManager;

public class PessoaDAO {

	private Connection conexao;

	public void cadastrar(Pessoa pessoa) {
		PreparedStatement stmt = null;

		try {
			conexao = OracleDBManager.obterConexao();
			String sql = "INSERT INTO T_PESSOA (ID_USUARIO, NOME, ALTURA, DT_NASC, EMAIL, GENERO, SENHA, TELEFONE)"
					+ "VALUES (?,?,?,?,?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, pessoa.getIdUsuario());
			stmt.setString(2, pessoa.getNome());
			stmt.setInt(3, pessoa.getAltura());
			var data = new java.sql.Date(pessoa.getDt_nasc().getTimeInMillis());
			stmt.setDate(4, data);
			stmt.setString(5, pessoa.getEmail());
			stmt.setString(6, pessoa.getGenero());
			stmt.setString(7, pessoa.getSenha());
			stmt.setString(8, pessoa.getTelefone());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public List<Pessoa> listar() {
		List<Pessoa> lista = new ArrayList<Pessoa>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = OracleDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_PESSOA");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idUsuario = rs.getInt("ID_USUARIO");
				String nmPessoa = rs.getString("NOME");
				int altura = rs.getInt("ALTURA");
				java.sql.Date data = rs.getDate("DT_NASC");
				Calendar dtNasc = Calendar.getInstance();
				dtNasc.setTimeInMillis(data.getTime());
				String email = rs.getString("EMAIL");
				String genero = rs.getString("GENERO");
				String senha = rs.getString("SENHA");
				String telefone = rs.getString("TELEFONE");

				var pessoa = new Pessoa(idUsuario, nmPessoa, altura, dtNasc, email, genero, senha, telefone);

				lista.add(pessoa);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	public void remover(int idUsuario) {
		PreparedStatement stmt = null;

		try {
			conexao = OracleDBManager.obterConexao();
			String sql = "DELETE FROM T_PESSOA WHERE ID_USUARIO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idUsuario);
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Pessoa getPessoaByEmail(String email) {
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Pessoa pessoa = null;

		try {
			conexao = OracleDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT FROM T_PESSOA WHERE EMAIL = ?");
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				int idUsuario = rs.getInt("ID_USUARIO");
				String nmPessoa = rs.getString("NOME");
				int altura = rs.getInt("ALTURA");
				java.sql.Date data = rs.getDate("DT_NASC");
				Calendar dtNasc = Calendar.getInstance();
				dtNasc.setTimeInMillis(data.getTime());
				String emailBanco = rs.getString("EMAIL");
				String genero = rs.getString("GENERO");
				String senha = rs.getString("SENHA");
				String telefone = rs.getString("TELEFONE");

				pessoa = new Pessoa(idUsuario, nmPessoa, altura, dtNasc, emailBanco, genero, senha, telefone);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return pessoa;
	}
	
	public boolean verifyIfUserAlreadyExists(String email) {
		Pessoa pessoa = getPessoaByEmail(email);
		
		return Objects.isNull(pessoa) ? false : true;
	}
}
