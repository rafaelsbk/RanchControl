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
import model.Baias;
///////////////////////   INSERT OK //////////////////////
	public class BaiasDAO {
	public void adicionar(Baias baias) {
	
		Connection con = Connect.getConnetion();
		PreparedStatement pstm = null;
		///////////////////////   INSERT   //////////////////////
				try { 					
					pstm = con.prepareStatement("INSERT INTO Baias (nomeBaia, definicao, capacidade, idFuncionarioResponsavel) VALUES (?,?,?,?);");
					pstm.setString(1, baias.getNomeBaia());
					pstm.setString(2, baias.getDefinicao());
					pstm.setInt(3, baias.getCapacidade());
					pstm.setInt(4, baias.getIdFuncionarioResponsavel());
					pstm.execute();
					JOptionPane.showMessageDialog(null, "Adicionado com Sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException ErroSql) {
					JOptionPane.showMessageDialog(null, "Erro ao Adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
				}
		/////////////////////////////////////////////////////////			
	}
///////////////////////   UPDATE  ///////////////////////
	public void alterar (Baias baias) {
		Connection con = Connect.getConnetion();
		PreparedStatement pstm = null;
		try { 					
			pstm = con.prepareStatement("UPDATE Baias set nomeBaia=?, capacidade=?, definicao=?, idFuncionarioResponsavel=? where idBaia = ?;");
			pstm.setString(1, baias.getNomeBaia());
			pstm.setInt(2, baias.getCapacidade());
			pstm.setString(3, baias.getDefinicao());
			pstm.setInt(4, baias.getIdFuncionarioResponsavel());
			pstm.setInt(5, baias.getidBaia());
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Adicionado com Sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ErroSql) {
			JOptionPane.showMessageDialog(null, "Erro ao Adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
		}finally{
			Connect.closeConnection(con,pstm);
		}				
	}
///////////////////////   SELECT OK  //////////////////////
	public List<Baias> listar(){

		List<Baias> baias = new ArrayList<>();

	Connection con = Connect.getConnetion();
	PreparedStatement pstm = null;
	ResultSet rs = null; 			
		try {		
			pstm = con.prepareStatement("select * from Baias");
			rs = pstm.executeQuery();		
			while(rs.next()) {
				Baias baia = new Baias();
				baia.setidBaia(rs.getInt("idBaia"));
				baia.setNomeBaia(rs.getString("nomeBaia"));
				baia.setCapacidade(rs.getInt("capacidade"));
				baia.setIdFuncionarioResponsavel(rs.getInt("idFuncionarioResponsavel"));
				baia.setDefinicao(rs.getString("definicao"));
				baias.add(baia);
			}		
		}catch (SQLException ErroSql) {
			JOptionPane.showMessageDialog(null, "Erro ao Listar dados: " + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
		}
		finally{
			Connect.closeConnection(con,pstm,rs);
		}


		return baias;
	}
///////////////////////   DELETE   //////////////////////
	public void remover(Baias baias) {
		Connection con = Connect.getConnetion();
		PreparedStatement pstm;
		try {
			pstm = con.prepareStatement("DELETE FROM Baias where idBaia=?");
			pstm.setInt(1,baias.getidBaia());
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Removido com sucesso: ", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ErroSql) {
			JOptionPane.showMessageDialog(null, "Erro ao Remover: " + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
		}finally{
			Connect.closeConnection(con);
		}

	}	
} 
