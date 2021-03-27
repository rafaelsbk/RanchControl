package persistence;

//import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Funcionario;

///////////////////////   INSERT //////////////////////
	public class FuncionariosDAO {
	public void adicionar(Funcionario funcionarios) {
	
		Connection con = Connect.getConnetion();
		PreparedStatement pstm = null;
				try { 					
					pstm = con.prepareStatement("INSERT INTO Funcionarios (nomeFuncionario, funcaoFuncionario, idbaiaresponsavel) VALUES (?,?,?);");
					pstm.setString(1, funcionarios.getNome());
					pstm.setString(2, funcionarios.getFuncao());
					pstm.setInt(3, funcionarios.getIdBaiaResponsavel());
					
					pstm.execute();
					JOptionPane.showMessageDialog(null, "Adicionado com Sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException ErroSql) {
					JOptionPane.showMessageDialog(null, "Erro ao Adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
				}
		/////////////////////////////////////////////////////////			
	}
///////////////////////   UPDATE  ///////////////////////
	public void alterar (Funcionario funcionarios) {
		Connection con = Connect.getConnetion();
		PreparedStatement pstm = null;
		try { 					
			pstm = con.prepareStatement("UPDATE Funcionarios set nomeFuncionario=?, idbaiaresponsavel=?, funcaoFuncionario=? where idFuncionario= ?;");
			pstm.setString(1, funcionarios.getNome());			
			pstm.setInt(2, funcionarios.getIdBaiaResponsavel());
			pstm.setString(3, funcionarios.getFuncao());
			pstm.setInt(4, funcionarios.getIdFuncionario());
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Adicionado com Sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ErroSql) {
			JOptionPane.showMessageDialog(null, "Erro ao Adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
		}finally{
			Connect.closeConnection(con,pstm);
		}				
	}
///////////////////////   SELECT  //////////////////////
	public List<Funcionario> listar(){

	List<Funcionario> funcionarios = new ArrayList<>();

	Connection con = Connect.getConnetion();
	PreparedStatement pstm = null;
	ResultSet rs = null; 			
		try {		
			pstm = con.prepareStatement("select * from Funcionarios order by idfuncionario asc");
			rs = pstm.executeQuery();		
			while(rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
				funcionario.setNome(rs.getString("nomeFuncionario"));
				funcionario.setFuncao(rs.getString("funcaoFuncionario"));
				funcionarios.add(funcionario);
			}		
		}catch (SQLException ErroSql) {
			JOptionPane.showMessageDialog(null, "Erro ao Listar dados: " + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
		}
		finally{
			Connect.closeConnection(con,pstm,rs);
		}


		return funcionarios;
	}
///////////////////////   DELETE   //////////////////////
	public void remover(Funcionario funcionarios) {
		Connection con = Connect.getConnetion();
		PreparedStatement pstm;
		try {
			pstm = con.prepareStatement("DELETE FROM Funcionarios where IdFuncionario=?");
			pstm.setInt(1,funcionarios.getIdFuncionario());
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Removido com sucesso: ", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ErroSql) {
			JOptionPane.showMessageDialog(null, "Erro ao Remover: " + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
		}finally{
			Connect.closeConnection(con);
		}

	}
//////////////////////SELECT INNER ///////////////////////
	public List<Funcionario> listarInner(int tempID){

		List<Funcionario> funcionarios2 = new ArrayList<>();
		Funcionario funcionario2 = new Funcionario();

		Connection con = Connect.getConnetion();
		PreparedStatement pstm = null;
		ResultSet rs = null; 			
		try {		
			pstm = con.prepareStatement("SELECT funcionarios.*, baias.nomeBaia FROM funcionarios\r\n"
					+ "JOIN Baias ON baias.idbaia = funcionarios.idbaiaresponsavel WHERE funcionarios.idFuncionario = ?");
			pstm.setInt(1,tempID);
			rs = pstm.executeQuery();		
			while (rs.next()) {					
				funcionario2.setIdFuncionario(rs.getInt("idfuncionario"));
				funcionario2.setNome(rs.getString("nomefuncionario"));
				funcionario2.setFuncao(rs.getString("funcaofuncionario"));
				funcionario2.setIdBaiaResponsavel(rs.getInt("idbaiaresponsavel"));
				funcionario2.setNomeBaiaResponsavel(rs.getString("nomebaia"));
				funcionarios2.add(funcionario2);
			}
		}catch (SQLException ErroSql) {
			JOptionPane.showMessageDialog(null, "Erro ao Listar dados: " + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
		}
		finally{
			Connect.closeConnection(con,pstm,rs);
		}

		return funcionarios2;
	}
} 
