package controller;


import model.Animal;
import model.Baias;
import model.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import controller.Connect;

public class AnimalDAO {
	
	private Connect minhaConexao;

    private final String RELATORIOGERAL = "select * from \"Contato\"";
    
    private final String BUSCAR = "select * from \"Contato\" where \"id\"=?";
    
    private final String RELATORIOESPECIFICO = "select * from \"Contato\" "
            + "where \"telefone\"=?";
    
    private final String INCLUIR = "insert into \"Contato\" (\"id\", \"nome\", "
            + "\"telefone\", \"email\") values (?, ?, ?, ?)";
    private final String EXCLUIR = "delete from \"Contato\" where \"id\"=?";
    private final String ALTERAR = "update \"Contato\" set \"id\"=?, \"nome\"=?, "
            + "\"telefone\"=?, \"email\"=? where \"id\"=?";
    
    public AnimalDAO(){
        minhaConexao = new Connect ("jdbc:sqlserver://localhost:1433/db_RanchControl","sa","123");
    }
    public void inclusao(Animal c){
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao = 
                    minhaConexao.getConexao().prepareStatement(INCLUIR);
            instrucao.setInt(1, c.getIdAnimal());
            instrucao.setString(2, c.getNomeAnimal());
            instrucao.setString(3, c.getTipoAnimal());
            instrucao.setInt(4, c.getIdadeAnimal());
            instrucao.execute();
            minhaConexao.desconectar();
        }catch(Exception e){
            System.out.println("Erro na inclusão: "+e.getMessage());
        }
    }    	
    
	}
