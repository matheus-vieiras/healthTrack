package br.com.healthtrack.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.healthtrack.fiap.entities.AtividadeFisica;
import br.com.healthtrack.fiap.jdbc.OracleDBManager;

public class AtividadeFisicaDAO {

	private Connection conexao;

	public void cadastrar(AtividadeFisica atividade) {
		PreparedStatement stmt = null;

		try {
			conexao = OracleDBManager.obterConexao();
			String sql = "INSERT INTO T_ATIVIDADE_FISICA (ID_ATIV_FISICA, NM_ATIV_FISICA, DT_TREINO, TIPO_ATIVIDADE, ID_USUARIO)"
					+ "VALUES (?,?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, atividade.getIdTreino());
			stmt.setString(2, atividade.getNomeTreino());
			var data = new java.sql.Date(atividade.getDtTreino().getTimeInMillis());
			stmt.setDate(3, data);
			stmt.setString(4, atividade.getTipoTreino());
			stmt.setInt(5, atividade.getIdUsuario());

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

	public List<AtividadeFisica> listar() {
		List<AtividadeFisica> lista = new ArrayList<AtividadeFisica>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = OracleDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_ATIVIDADE_FISICA");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idTreino = rs.getInt("ID_ATIV_FISICA");
				String nmTreino = rs.getString("NM_ATIV_FISICA");
				java.sql.Date data = rs.getDate("DT_TREINO");
				Calendar dtTreino = Calendar.getInstance();
				dtTreino.setTimeInMillis(data.getTime());
				String tpTreino = rs.getString("TIPO_ATIVIDADE");
				int idUsuario = rs.getInt("ID_USUARIO");

				var treino = new AtividadeFisica(idTreino, nmTreino, dtTreino, tpTreino, idUsuario);

				lista.add(treino);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;

	}

	public void remover(int idTreino) {
		PreparedStatement stmt = null;

		try {
			conexao = OracleDBManager.obterConexao();
			String sql = "DELETE FROM T_ATIVIDADE_FISICA WHERE ID_ATIV_FISICA = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idTreino);
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
}
