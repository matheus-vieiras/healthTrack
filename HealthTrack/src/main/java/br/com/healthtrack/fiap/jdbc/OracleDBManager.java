package br.com.healthtrack.fiap.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleDBManager {

	public static Connection obterConexao() {
		Connection conexao = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM92450",
					"200799");
			
			System.out.println("Conexão bem-sucedida!");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conexao;
	}

}
