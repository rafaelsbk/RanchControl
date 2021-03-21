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
    private Connection aPropriaConexao;
    
    public Connect(String c, String u, String s){
        caminho = c;
        usuario = u;
        senha = s;
    }
    
    public void conectar(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //carregar o driver
            aPropriaConexao = DriverManager.getConnection(caminho, usuario, senha); //abrir a conexão
        }catch(Exception e){
            System.out.println("Erro na conexão: "+e.getMessage());
        }
    }
    public void desconectar(){
        try{
        	aPropriaConexao.close();
        }catch(Exception e){
            System.out.println("Erro na desconexão: "+e.getMessage());
        }
    }
    public Connection getConexao(){
        return aPropriaConexao;
    }
}
