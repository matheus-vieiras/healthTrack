package br.com.healthtrack.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.healthtrack.fiap.entities.Peso;
import br.com.healthtrack.fiap.jdbc.OracleDBManager;

public class PesoDAO {

	private Connection conexao;

	public void cadastrar(Peso peso) {
		PreparedStatement stmt = null;

		try {
			conexao = OracleDBManager.obterConexao();
			String sql = "INSERT INTO T_PESO (ID_PESO, PESO, DT_PESAGEM, ID_USUARIO)" + "VALUES (?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, peso.getIdPeso());
			stmt.setDouble(2, peso.getPeso());
			var data = new java.sql.Date(peso.getDt_pesagem().getTimeInMillis());
			stmt.setDate(3, data);
			stmt.setInt(4, peso.getIdUsuario());

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
	
	public void atualizar(Peso peso) {
		PreparedStatement pstmt = null;

		try {
			conexao = OracleDBManager.obterConexao();

            pstmt = conexao.prepareStatement("UPDATE T_PESO " +
                    "SET PESO = ?, DT_PESAGEM = ?" +
                    "WHERE ID_USUARIO = ?");

            pstmt.setDouble(1, peso.getIdUsuario());
            pstmt.setDate(2, new java.sql.Date(peso.getDt_pesagem().getTimeInMillis()));
            pstmt.setInt(3, peso.getIdUsuario());
            pstmt.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conexao.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
	}

	public List<Peso> listar() {
		List<Peso> lista = new ArrayList<Peso>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = OracleDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_PESO");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPeso = rs.getInt("ID_PESO");
				double numPeso = rs.getDouble("PESO");
				java.sql.Date data = rs.getDate("DT_PESAGEM");
				Calendar dtPesagem = Calendar.getInstance();
				dtPesagem.setTimeInMillis(data.getTime());
				int idUsuario = rs.getInt("ID_USUARIO");

				var peso = new Peso(idPeso, numPeso, dtPesagem, idUsuario);

				lista.add(peso);
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
	
	public Peso getPesoByUserId(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Peso peso = null;

		try {
			conexao = OracleDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_PESO WHERE ID_USUARIO = ? ");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			

			while (rs.next()) {
				int idPeso = rs.getInt("ID_PESO");
				double numPeso = rs.getDouble("PESO");
				java.sql.Date data = rs.getDate("DT_PESAGEM");
				Calendar dtPesagem = Calendar.getInstance();
				dtPesagem.setTimeInMillis(data.getTime());
				int idUsuario = rs.getInt("ID_USUARIO");

				peso = new Peso(idPeso, numPeso, dtPesagem, idUsuario);
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
		
		return peso;
	}

	public void remover(int idPeso) {
		PreparedStatement stmt = null;

		try {
			conexao = OracleDBManager.obterConexao();
			String sql = "DELETE FROM T_PESO WHERE ID_PESO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idPeso);
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

}
