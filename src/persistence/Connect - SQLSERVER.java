package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect {
    	//Para Configurar ao postgres basta alterar as config e descomentar USUARIO E SENHA
		private static String DRIVE = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		private static String URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=db_RanchControl;user=sa;password=123";
		//private static String USUARIO = "sa";
 		//private static String SENHA = "123";

 		public static Connection getConnetion() {
			try {
				Class.forName(DRIVE);
				return DriverManager.getConnection(URL);
			} catch (ClassNotFoundException | SQLException ErroSql) {
				throw new RuntimeException("ERRO! Nao conectou! "+ErroSql);
			}
 		}
 		public static void closeConnection(Connection con) {
 			try { 
 				if(con != null)
 					con.close();
 			} catch (SQLException ErroSql) {
 				throw new RuntimeException("Erro ! Nao foi possivel fechar." + ErroSql);
 			}
 		}
 		
 		public static void closeConnection(Connection con, PreparedStatement pstm) {
 			closeConnection(con);
 			try { 
 				if(pstm != null)
 					pstm.close();
 			} catch (SQLException ErroSql) {
 				throw new RuntimeException("Erro ! Nao foi possivel fechar o PreparedStatement" + ErroSql);
 			}
 		}
 		public static void closeConnection(Connection con, PreparedStatement pstm, ResultSet rs) {
 			closeConnection(con, pstm);
 			try { 
 				if(rs != null)
 					rs.close();
 			} catch (SQLException ErroSql) {
 				throw new RuntimeException("Erro ! Nao foi possivel fechar o Resultset" + ErroSql);
 			}
 		}
 		
}
