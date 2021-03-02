package model;
//Classe onde possui as caracteristicas do animal
public class Animal {
	private int idAnimal;
	private String tipoAnimal;
	private String nomeAnimal;
	private int idadeAnimal;
	private float peso;
	private float pesoEvolucao;
	private String vacina;
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
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getPesoEvolucao() {
		return pesoEvolucao;
	}
	public void setPesoEvolucao(float pesoEvolucao) {
		this.pesoEvolucao = pesoEvolucao;
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
 