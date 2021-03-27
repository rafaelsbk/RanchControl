package model;
//Classe onde possui as caracteristicas do animal
public class Animal {
	private int idAnimal;
	private String tipoAnimal;
	private String nomeAnimal;
	private int idadeAnimal;
	private float pesoAnimal;
	private String vacina;
	private int idBaiaPertence;
	private String nomeBaiaPertence;
	

	public String getNomeBaiaPertence() {
		return nomeBaiaPertence;
	}
	public void setNomeBaiaPertence(String nomeBaiaPertence) {
		this.nomeBaiaPertence = nomeBaiaPertence;
	}
	public int getIdBaiaPertence() {
		return idBaiaPertence;
	}
	public void setIdBaiaPertence(int idBaiaPertence) {
		this.idBaiaPertence = idBaiaPertence;
	}
	public float getPesoAnimal() {
		return pesoAnimal;
	}
	public void setPesoAnimal(float pesoAnimal) {
		this.pesoAnimal = pesoAnimal;
	}
	
	public int getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}
	public String getTipoAnimal() {
		return tipoAnimal;
	}
	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}
	public String getNomeAnimal() {
		return nomeAnimal;
	}
	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}
	public int getIdadeAnimal() {
		return idadeAnimal;
	}
	public void setIdadeAnimal(int idadeAnimal) {
		this.idadeAnimal = idadeAnimal;
	}
	public String getVacina() {
		return vacina;
	}
	public void setVacina(String vacina) {
		this.vacina = vacina;
	}

}
 