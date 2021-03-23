package persistence;

//import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Animal;

public class AnimalDAO {
///////////////////////   INSERT: OK   //////////////////////
	public void adicionar(Animal animal) {
	
		Connection con = Connect.getConnetion();
		PreparedStatement pstm = null;
				try { 					
					pstm = con.prepareStatement("INSERT INTO Animal (nomeAnimal, idadeAnimal, tipoAnimal, pesoAnimal) VALUES (?,?,?,?);");
					pstm.setString(1, animal.getNomeAnimal());
					pstm.setInt(2, animal.getIdadeAnimal());
					pstm.setString(3, animal.getTipoAnimal());
					pstm.setFloat(4, animal.getPesoAnimal());
					pstm.execute();
					JOptionPane.showMessageDialog(null, "Adicionado com Sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException ErroSql) {
					JOptionPane.showMessageDialog(null, "Erro ao Adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
				}finally{
					Connect.closeConnection(con,pstm);
				}			
	}
///////////////////////   UPDATE OK  //////////////////////
	public void alterar (Animal animal) {
		Connection con = Connect.getConnetion();
		PreparedStatement pstm = null;
				try { 					
					pstm = con.prepareStatement("UPDATE Animal set tipoAnimal=?, nomeAnimal=?, idadeAnimal=?, pesoAnimal=? where idAnimal = ?;");
					pstm.setString(1, animal.getTipoAnimal());
					pstm.setString(2, animal.getNomeAnimal());
					pstm.setInt(3, animal.getIdadeAnimal());
					pstm.setFloat(4, animal.getPesoAnimal());
					pstm.setInt(5, animal.getIdAnimal());
					pstm.execute();
					JOptionPane.showMessageDialog(null, "Adicionado com Sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException ErroSql) {
					JOptionPane.showMessageDialog(null, "Erro ao Adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
				}finally{
					Connect.closeConnection(con,pstm);
				}				
	}
///////////////////////   SELECT: OK   //////////////////////
	public List<Animal> listar(){
		
		List<Animal> animais = new ArrayList<>();
		
		Connection con = Connect.getConnetion();
		PreparedStatement pstm = null;
		ResultSet rs = null; 			
		try {		
		pstm = con.prepareStatement("select * from Animal");
		rs = pstm.executeQuery();		
		while(rs.next()) {
			Animal animal = new Animal();
			animal.setIdAnimal(rs.getInt("idAnimal"));
			animal.setNomeAnimal(rs.getString("nomeAnimal"));
			animal.setIdadeAnimal(rs.getInt("idadeAnimal"));
			animal.setPesoAnimal(rs.getFloat("pesoAnimal"));
			animal.setTipoAnimal(rs.getString("tipoAnimal"));
			animais.add(animal);
			}		
		}catch (SQLException ErroSql) {
			JOptionPane.showMessageDialog(null, "Erro ao Listar dados: " + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
		}
		finally{
			Connect.closeConnection(con,pstm,rs);
		}
		
		
		return animais;
	}
}
