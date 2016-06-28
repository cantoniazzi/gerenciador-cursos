package com.gerenciador.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author C�ssio
 */
public class Conexao {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
    private static final String stringConexao = "";
   
    public static Connection getConexao() throws SQLException {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(stringConexao, "", "");
			System.out.println("Obtendo conex�o...");
		return conn;
		} catch (ClassNotFoundException e) {
			String errorMsg = "Driver n�o encontrado";
			throw new SQLException(errorMsg, e);
		} catch (SQLException e) {
			String errorMsg = "Erro ao obter a conex�o";
			throw new SQLException(errorMsg, e);
		}
    }	

    public static void close(Connection conn) {
        try {
            if (conn != null) {
                    conn.close();
            }
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
}
