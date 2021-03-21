package model;
//Classe onde possui as caracteristicas do animal
public class Animal {
	private int idAnimal;
	private String tipoAnimal;
	private String nomeAnimal;
	private int idadeAnimal;
	private float peso1;
	private float peso2;
	private float peso3;
	private float peso4;
	private float peso5;
	private String vacina;
	
	public float getPeso1() {
		return peso1;
	}
	public void setPeso1(float peso1) {
		this.peso1 = peso1;
	}
	public float getPeso2() {
		return peso2;
	}
	public void setPeso2(float peso2) {
		this.peso2 = peso2;
	}
	public float getPeso3() {
		return peso3;
	}
	public void setPeso3(float peso3) {
		this.peso3 = peso3;
	}
	public float getPeso4() {
		return peso4;
	}
	public void setPeso4(float peso4) {
		this.peso4 = peso4;
	}
	public float getPeso5() {
		return peso5;
	}
	public void setPeso5(float peso5) {
		this.peso5 = peso5;
	}
	private String observacoes;
	private float mediaPeso;
	
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
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public float getMediaPeso() {
		return mediaPeso;
	}
	public void setMediaPeso(float mediaPeso) {
		this.mediaPeso = mediaPeso;
	}
	
}
 