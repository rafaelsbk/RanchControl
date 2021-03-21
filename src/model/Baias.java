package model;


public class Baias {
	private int idBaia;
	private String nomeBaia;
	private int capacidade;
	private String definicao;
	private int idFuncionarioResponsavel;
	private int idAnimalBaia;
	private Animal animal;
	
	public int getIdAnimalBaia() {
		return idAnimalBaia;
	}
	public void setIdAnimalBaia(int idAnimalBaia) {
		this.idAnimalBaia = idAnimalBaia;
	}
	public int getidBaia() {
		return idBaia;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public void setidBaia(int idBaia) {
		this.idBaia = idBaia;
	}
	
	public String getNomeBaia() {
		return nomeBaia;
	}
	public void setNomeBaia(String nomeBaia) {
		this.nomeBaia = nomeBaia;
	}
	
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public String getDefinicao() {
		return definicao;
	}
	public void setDefinicao(String definicao) {
		this.definicao = definicao;
	}
	
	public int getIdFuncionarioResponsavel(){
		return idFuncionarioResponsavel;
	}

	public void setIdFuncionarioResponsavel(int idFuncionarioResponsavel){
		this.idFuncionarioResponsavel = idFuncionarioResponsavel;
	}   
} 
