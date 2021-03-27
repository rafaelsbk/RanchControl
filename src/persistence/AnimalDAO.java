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
///////////////////////   INSERT   //////////////////////
	public void adicionar(Animal animal) {
	
		Connection con = Connect.getConnetion();
		PreparedStatement pstm = null;
				try { 					
					pstm = con.prepareStatement("INSERT INTO Animais (nomeAnimal, idadeAnimal, tipoAnimal, pesoAnimal, idbaiapertence) VALUES (?,?,?,?,?);");
					pstm.setString(1, animal.getNomeAnimal());
					pstm.setInt(2, animal.getIdadeAnimal());
					pstm.setString(3, animal.getTipoAnimal());
					pstm.setFloat(4, animal.getPesoAnimal());
					pstm.setInt(5, animal.getIdBaiaPertence());
					pstm.execute();
					JOptionPane.showMessageDialog(null, "Adicionado com Sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException ErroSql) {
					JOptionPane.showMessageDialog(null, "Erro ao Adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
				}finally{
					Connect.closeConnection(con,pstm);
				}			
	}
///////////////////////   UPDATE  ///////////////////////
	public void alterar (Animal animal) {
		Connection con = Connect.getConnetion();
		PreparedStatement pstm = null;
				try { 					
					pstm = con.prepareStatement("UPDATE animais set nomeAnimal=?, tipoanimal=?, idadeanimal=?, pesoanimal=?, idbaiapertence=? where idanimal = ?");
					pstm.setString(1, animal.getNomeAnimal());
					pstm.setString(2, animal.getTipoAnimal());
					pstm.setInt(3, animal.getIdadeAnimal());
					pstm.setFloat(4, animal.getPesoAnimal());
					pstm.setInt(5, animal.getIdBaiaPertence());
					pstm.setInt(6, animal.getIdAnimal());					
					pstm.execute();
					JOptionPane.showMessageDialog(null, "Adicionado com Sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException ErroSql) {
					JOptionPane.showMessageDialog(null, "Erro ao Adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
				}finally{
					Connect.closeConnection(con,pstm);
				}				
	}
///////////////////////   SELECT   //////////////////////
	public List<Animal> listar(){

		
		List<Animal> animais = new ArrayList<>();
		
		Connection con = Connect.getConnetion();
		PreparedStatement pstm = null;
		ResultSet rs = null; 			
		try {		
		pstm = con.prepareStatement("select * from Animais");
		rs = pstm.executeQuery();		
		while(rs.next()) {
			Animal animal = new Animal();
			animal.setIdAnimal(rs.getInt("idAnimal"));
			animal.setNomeAnimal(rs.getString("nomeAnimal"));
			animal.setIdadeAnimal(rs.getInt("idadeAnimal"));
			animal.setPesoAnimal(rs.getFloat("pesoAnimal"));
			animal.setTipoAnimal(rs.getString("tipoAnimal"));
			animal.setIdBaiaPertence(rs.getInt("idbaiapertence"));
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
///////////////////////   DELETE   //////////////////////
	public void remover(Animal animal) {
		Connection con = Connect.getConnetion();
		PreparedStatement pstm;
		try {
		pstm = con.prepareStatement("DELETE FROM Animais where idAnimal=?");
		pstm.setInt(1,animal.getIdAnimal());
		pstm.execute();
		JOptionPane.showMessageDialog(null, "Removido com sucesso: ", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ErroSql) {
			JOptionPane.showMessageDialog(null, "Erro ao Remover: " + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
		}finally{
			Connect.closeConnection(con);
		}
			
	}
//////////////////////SELECT INNER ///////////////////////
	public List<Animal> listarInner(int tempID){

		List<Animal> animais2 = new ArrayList<>();
		Animal animal2 = new Animal();

		Connection con = Connect.getConnetion();
		PreparedStatement pstm = null;
		ResultSet rs = null; 			
			try {		
				pstm = con.prepareStatement("SELECT animais.*, baias.idbaia, baias.nomebaia FROM Baias\r\n"
						+ "JOIN Animais ON baias.idbaia = animais.idbaiapertence WHERE animais.idanimal = ?");
				pstm.setInt(1,tempID);
				rs = pstm.executeQuery();		
				while (rs.next()) {					
					animal2.setIdAnimal(rs.getInt("idanimal"));
					animal2.setNomeAnimal(rs.getString("nomeanimal"));
					animal2.setTipoAnimal(rs.getString("tipoanimal"));
					animal2.setIdadeAnimal(rs.getInt("idadeanimal"));
					animal2.setPesoAnimal(rs.getFloat("pesoanimal"));
					animal2.setIdBaiaPertence(rs.getInt("idbaia"));
					animal2.setNomeBaiaPertence(rs.getString("nomebaia"));
					animais2.add(animal2);
				}
			}catch (SQLException ErroSql) {
				JOptionPane.showMessageDialog(null, "Erro ao Listar dados: " + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
			}
			finally{
				Connect.closeConnection(con,pstm,rs);
			}

			return animais2;
}	
}
