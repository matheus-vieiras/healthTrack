package br.com.healthtrack.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.healthtrack.fiap.entities.Imc;
import br.com.healthtrack.fiap.jdbc.OracleDBManager;

public class ImcDAO {

	private Connection conexao;

	public void cadastrar(Imc imc) {
		PreparedStatement stmt = null;

		try {
			conexao = OracleDBManager.obterConexao();
			String sql = "INSERT INTO T_IMC (ID_IMC, IMC, DT_IMC, ID_USUARIO)" + "VALUES (?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, imc.getIdImc());
			stmt.setDouble(2, imc.getImc());
			var data = new java.sql.Date(imc.getDtImc().getTimeInMillis());
			stmt.setDate(3, data);
			stmt.setInt(4, imc.getIdUsuario());

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

	public List<Imc> listar() {
		List<Imc> lista = new ArrayList<Imc>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = OracleDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_IMC");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idImc = rs.getInt("ID_IMC");
				double numImc = rs.getDouble("IMC");
				java.sql.Date data = rs.getDate("DT_IMC");
				Calendar dtImc = Calendar.getInstance();
				dtImc.setTimeInMillis(data.getTime());
				int idUsuario = rs.getInt("ID_USUARIO");

				var imc = new Imc(idImc, numImc, dtImc, idUsuario);

				lista.add(imc);
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

	public void remover(int idImc) {
		PreparedStatement stmt = null;

		try {
			conexao = OracleDBManager.obterConexao();
			String sql = "DELETE FROM T_IMC WHERE ID_IMC = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idImc);
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
