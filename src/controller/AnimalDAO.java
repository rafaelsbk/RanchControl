package controller;

//import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import model.Animal;

public class AnimalDAO {
	public void adicionar(Animal animal) {
	
		Connection con = Connect.getConnetion();
		PreparedStatement pstm = null;
		
				try { 
					//String sql = "INSERT INTO Animal (idAnimal, nomeAnimal, tipoAnimal) VALUES (?,?);";
					pstm = con.prepareStatement("INSERT INTO Animal (nomeAnimal, idadeAnimal, tipoAnimal, pesoAnimal) VALUES (?,?,?,?);");
					pstm.setString(1, animal.getNomeAnimal());
					pstm.setInt(2, animal.getIdadeAnimal());
					pstm.setString(3, animal.getTipoAnimal());
					pstm.setFloat(4, animal.getPesoAnimal());
					pstm.execute();
					JOptionPane.showMessageDialog(null, "Adicionado com Sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException ErroSql) {
					JOptionPane.showMessageDialog(null, "Erro ao Adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
				}
		
		
	
	}
	
} 
