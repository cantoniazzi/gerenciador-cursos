package com.gerenciador.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author Cássio
 */
public class Conexao {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String usuario = "carlos";
    private static final String senha = "tadeu";
    private static final String stringConexao = "jdbc:oracle:thin:@oracle.inf.poa.ifrs.edu.br:1521:XE";
   
    public static Connection getConexao() throws SQLException {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(stringConexao, "carlos", "tadeu");
			System.out.println("Obtendo conexão...");
		return conn;
		} catch (ClassNotFoundException e) {
			String errorMsg = "Driver não encontrado";
			throw new SQLException(errorMsg, e);
		} catch (SQLException e) {
			String errorMsg = "Erro ao obter a conexão";
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
