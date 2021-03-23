package persistence;

//import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Baias;

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
	
} 
