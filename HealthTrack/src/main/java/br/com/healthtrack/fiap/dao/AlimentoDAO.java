package br.com.healthtrack.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.healthtrack.fiap.entities.Alimento;
import br.com.healthtrack.fiap.jdbc.OracleDBManager;

public class AlimentoDAO {

	private Connection conexao;

	public void cadastrar(Alimento alimento) {
		PreparedStatement stmt = null;

		try {
			conexao = OracleDBManager.obterConexao();
			String sql = "INSERT INTO T_ALIMENTO (ID_ALIMENTO, NM_ALIMENTO, TIPO_ALIMENTO, DT_ALIMENTACAO, ID_USUARIO) "
					+ "VALUES (?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, alimento.getIdAlimento());
			stmt.setString(2, alimento.getNmAlimento());
			stmt.setString(3, alimento.getTipoAlimento());
			java.sql.Date data = new java.sql.Date(alimento.getDtAlimentacao().getTimeInMillis());
			stmt.setDate(4, data);
			stmt.setInt(5, alimento.getIdUsuario());

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

	public List<Alimento> listar() {
		List<Alimento> lista = new ArrayList<Alimento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = OracleDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_ALIMENTO");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idAlimento = rs.getInt("ID_ALIMENTO");
				String nmAlimento = rs.getString("NM_ALIMENTO");
				String tpAlimento = rs.getString("TIPO_ALIMENTO");
				java.sql.Date data = rs.getDate("DT_ALIMENTACAO");
				Calendar dtAlimento = Calendar.getInstance();
				dtAlimento.setTimeInMillis(data.getTime());
				int idUsuario = rs.getInt("ID_USUARIO");

				var alimento = new Alimento(idAlimento, nmAlimento, tpAlimento, dtAlimento, idUsuario);

				lista.add(alimento);
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

	public void remover(int idAlimento) {
		PreparedStatement stmt = null;

		try {
			conexao = OracleDBManager.obterConexao();
			String sql = "DELETE FROM T_ALIMENTO WHERE ID_ALIMENTO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idAlimento);
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

	public Alimento buscarTodosPorCodigo(int codigoBusca) {
		var alimento = new Alimento();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = OracleDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_ALIMENTO WHERE ID_USUARIO = ?");
			stmt.setInt(1, codigoBusca);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int idAlimento = rs.getInt("ID_ALIMENTO");
				String nmAlimento = rs.getString("NM_ALIMENTO");
				String tpAlimento = rs.getString("TIPO_ALIMENTO");
				java.sql.Date data = rs.getDate("DT_ALIMENTACAO");
				Calendar dtAlimentacao = Calendar.getInstance();
				dtAlimentacao.setTimeInMillis(data.getTime());
				int idUsuario = rs.getInt("ID_USUARIO");
				alimento = new Alimento(idAlimento, nmAlimento, tpAlimento, dtAlimentacao, idUsuario);
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
		return alimento;
	}

	public void atualizar(Alimento alimento) {
		PreparedStatement stmt = null;

		try {
			conexao = OracleDBManager.obterConexao();
			String sql = "UPDATE T_ALIMENTO SET NM_ALIMENTO = ?, TIPO_ALIMENTO = ?, DT_ALIMENTACAO = ?, ID_USUARIO = ?, WHERE ID_ALIMENTO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, alimento.getNmAlimento());
			stmt.setString(2, alimento.getTipoAlimento());
			var data = new java.sql.Date(alimento.getDtAlimentacao().getTimeInMillis());
			stmt.setDate(3, data);
			stmt.setInt(4, alimento.getIdUsuario());
			stmt.setInt(5, alimento.getIdAlimento());

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
