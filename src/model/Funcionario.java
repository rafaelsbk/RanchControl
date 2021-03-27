package model;

public class Funcionario {
	private int idFuncionario;
	private String nome;
	private String funcao;
	private int idBaiaResponsavel;
	private String nomeBaiaResponsavel;
	
	public String getNomeBaiaResponsavel() {
		return nomeBaiaResponsavel;
	}
	public void setNomeBaiaResponsavel(String nomeBaiaResponsavel) {
		this.nomeBaiaResponsavel = nomeBaiaResponsavel;
	}
	public int getIdBaiaResponsavel() {
		return idBaiaResponsavel;
	}
	public void setIdBaiaResponsavel(int idBaiaResponsavel) {
		this.idBaiaResponsavel = idBaiaResponsavel;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
}
