package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connect {
    
	private String caminho;
    private String usuario;
    private String senha;
    private Connection con;
    
    public Connect(String c, String u, String s){
        caminho = c;
        usuario = u;
        senha = s;
    }
    
    public void conectar(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //carregar o driver
            String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
            		   "databaseName=db_RanchControl;user=sa;password=123;";  
            		Connection con = DriverManager.getConnection(connectionUrl);
        }catch(Exception e){
            System.out.println("Erro na conexão: "+e.getMessage());
        }
    }
    public void desconectar(){
        try{
        	con.close();
        }catch(Exception e){
            System.out.println("Erro na desconexão: "+e.getMessage());
        }
    }
    public Connection getConexao(){
        return con;
    }
}
