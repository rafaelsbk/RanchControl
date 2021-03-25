package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Animal;
import model.Baias;
import model.Funcionario;
import persistence.AnimalDAO; 
import persistence.BaiasDAO;
import persistence.FuncionariosDAO;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // arraylist's
        ArrayList<Funcionario> arrayFuncionarios = new ArrayList<>();
        ArrayList<Animal> arrayAnimal = new ArrayList<>();
        ArrayList<Baias> arrayBaias = new ArrayList<>();
        
        // Declaracao de variaveis para controle do menu op= menu principal opSec= menu
        int op, opSec = 0, tempId, opEdit;
        boolean buscador;
        Animal  c;
        Baias b;
        Funcionario f;
        AnimalDAO cA = new AnimalDAO();
        BaiasDAO bA = new BaiasDAO();
        FuncionariosDAO fA = new FuncionariosDAO();
        String nomeTeste;
        
        do {
            System.out.println("----------------------------------");
            System.out.println("  Bem vindo ao RanchControl");
            System.out.println("       MENU PRINCIPAL");
            System.out.println("----------------------------------");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Editar / Alterar");
            System.out.println("3 - Consultar informacoes");
            System.out.println("4 - Excluir / Apagar");
            System.out.println("5 - Administra�ao de Baias");
            System.out.println("6 - Administra�ao de Animais");
            System.out.println("7 - SAIR");
            System.out.println("-----------------------------------");
            System.out.println("Escolha a opcao desejada: ");
            op = teclado.nextInt();           
            switch (op) {
case 1:                	
                    System.out.println("1 - Cadastrar Funcionario");
                    System.out.println("2 - Cadastrar Baia/Confinamento");
                    System.out.println("3 - Cadastrar Animal");
                    System.out.println("4 - Retornar para o menu anterior");
                    System.out.println("-----------------------------------");
                    System.out.println("Escolha a informacao que deseja CADASTRAR. ");
                    opSec = teclado.nextInt();

                    switch (opSec) {
                        case 1: // Cadastro do funcionario
                        	buscador = false;
                        	f = new Funcionario();
                        	System.out.println("Digite o nome do funcionario");
                            f.setNome(teclado.next());
                            
                            System.out.println("Qual a funcao?");
                            f.setFuncao(teclado.next());

                            fA.adicionar(f);                        
                            break;

                        case 2:// Cadastro da baia                        	
                        	Baias b1 = new Baias();
                        	buscador = false;
                            System.out.println("Digite o nome da Baia ou Caracteristica");
                            b1.setNomeBaia(teclado.next());
                            
                            System.out.println("Qual a finalidade ou especificao");
                            b1.setDefinicao(teclado.next());
                            
                            System.out.println("Qual a capacidade de animais?");
                            b1.setCapacidade(teclado.nextInt());
                           
                            //System.out.println("Escolha o id do funcionario responsavel pela baia.");
                            //System.out.println("Usuarios cadastros ate o momento:");

                            System.out.println("Diga o Id:");
                            tempId = teclado.nextInt();
                            b1.setIdFuncionarioResponsavel(tempId);

                            bA.adicionar(b1);
                            System.out.println("Baia cadastrada com sucesso!");
                            break;

                        case 3:// Cadastro do animal
                        	c = new Animal();
                        	System.out.println("Qual a especie?");
                            c.setTipoAnimal(teclado.next());
                            
                            System.out.println("Digite o nome do Animal");
                            c.setNomeAnimal(teclado.next());

                            System.out.println("Qual a idade do animal?");
                            c.setIdadeAnimal(teclado.nextInt());                                                      
                          
                            System.out.println("Qual o peso do animal?");
                            c.setPesoAnimal(teclado.nextFloat());
                            cA.adicionar(c);                        
                            break;
                        case 4:
                        	System.out.println("Retornando ao menu principal");
                        	break;
                    }                  
                    break;
                    
case 2:
                    System.out.println("1 - Editar Funcionario");
                    System.out.println("2 - Editar Baia/Confinamento");
                    System.out.println("3 - Editar Animal");
                    System.out.println("4 - Retornar para o menu anterior");
                    System.out.println("-----------------------------------");
                    System.out.println("Escolha a informacao que deseja EDITAR. ");
                    opSec = teclado.nextInt();

                    switch (opSec) {
                        case 1: // Editar funcionario
                        	f = new Funcionario();
                            System.out.println("Digite o id do Funcionario que voce deseja editar");

                            System.out.println("Usuarios cadastros ate o momento:");
                            for (int i = 0; i < fA.listar().size(); i++) {
                                System.out.print(" - " + fA.listar().get(i).getNome() + "   id: ");
                                System.out.println(fA.listar().get(i).getIdFuncionario());
                                System.out.println("Funcao: " +fA.listar().get(i).getFuncao());
                            }
                            System.out.println("Diga o Id do funcionario que deseja editar:");
                            tempId = teclado.nextInt();
                            f.setIdFuncionario(tempId);
                        	System.out.println("Qual o nome do funcionario?");
                            f.setNome(teclado.next());
                            
                            System.out.println("Qual a funcao?");
                            f.setFuncao(teclado.next());         
                      
                            fA.alterar(f);                        
                            
                            break;
                                    
                        case 2:// Editar da baia
                        	b = new Baias();
                            System.out.println("Digite o nome do Baia que voce deseja editar");

                            System.out.println("Baias cadastradas ate o momento:");
                            for (int i=0; i < bA.listar().size(); i++) {
                                System.out.print("ID: " + bA.listar().get(i).getidBaia() + " Nome Baia: ");
                          	   System.out.print(bA.listar().get(i).getNomeBaia() + " Definicao: ");
                          	   System.out.println(bA.listar().get(i).getDefinicao());
                          	   System.out.print("Capacidade: " + bA.listar().get(i).getCapacidade() + " Func.Resp: ");
                          	   System.out.println(bA.listar().get(i).getIdFuncionarioResponsavel());
                          	   System.out.println("----------------------------------------------");                         	                          	   
                            }
                            System.out.println("Diga o Id do Baia que deseja editar:");
                            tempId = teclado.nextInt();
                            b.setidBaia(tempId);
                            
                            System.out.println("Digite o nome da Baia ou Caracteristica");
                            b.setNomeBaia(teclado.next());
                            
                            System.out.println("Qual a capacidade de animais?");
                            b.setCapacidade(teclado.nextInt()); 
                            
                            System.out.println("Qual a finalidade ou especificao");
                            b.setDefinicao(teclado.next());
                                                                            
                           
                            //System.out.println("Escolha o id do funcionario responsavel pela baia.");
                            //System.out.println("Usuarios cadastros ate o momento:");

                            System.out.println("Diga o Id do funcionario:");
                            b.setIdFuncionarioResponsavel(teclado.nextInt());                                                     
                            bA.alterar(b);
                            break;
                            
                        	case 3:// Editar da animal
                        	c = new Animal();
                            System.out.println("Digite o nome do Animal que voce deseja editar");
                            System.out.println("Animal cadastrados ate o momento:");
                            for (int i=0; i < cA.listar().size(); i++) {
                         	   System.out.print("ID: " + cA.listar().get(i).getIdAnimal() + " Nome: ");
                         	   System.out.print(cA.listar().get(i).getNomeAnimal() + " Idade: ");
                         	   System.out.print(cA.listar().get(i).getIdadeAnimal() + " Tipo: ");
                         	   System.out.print(cA.listar().get(i).getTipoAnimal() + " Peso: ");
                         	   System.out.println(cA.listar().get(i).getPesoAnimal());
                         	   
                            }
                            System.out.println("Diga o Id do animal que deseja editar:");
                            tempId = teclado.nextInt();
                            c.setIdAnimal(tempId);
                        	System.out.println("Qual a especie?");
                            c.setTipoAnimal(teclado.next());
                            
                            System.out.println("Digite o nome do Animal");
                            c.setNomeAnimal(teclado.next());

                            System.out.println("Qual a idade do animal?");
                            c.setIdadeAnimal(teclado.nextInt());                                                      
                          
                            System.out.println("Qual o peso do animal?");
                            c.setPesoAnimal(teclado.nextFloat());
                            cA.alterar(c);                                 
                            break;
        }            	 
case 3:
                    System.out.println("1 - Consultar Funcionario");
                    System.out.println("2 - Consultar Baia/Confinamento");
                    System.out.println("3 - Consultar Animal");
                    System.out.println("4 - Retornar para o menu anterior");
                    System.out.println("-----------------------------------");
                    System.out.println("Escolha a informacao que deseja CONSULTAR. ");
                    opSec = teclado.nextInt();

                    switch (opSec) {
                        case 1: // Consultar funcionario

                            System.out.println("Usuarios cadastros ate o momento:");
                            for (int i = 0; i < fA.listar().size(); i++) {
                                System.out.print(" - " + fA.listar().get(i).getNome() + "   id: ");
                                System.out.println(fA.listar().get(i).getIdFuncionario());
                                System.out.println("Funcao: " +fA.listar().get(i).getFuncao());
                            }
                            System.out.println("Diga o Id do funcionario que deseja consultar:");
                            tempId = teclado.nextInt();
                            
                            for (int i = 0; i < fA.listar().size(); i++) {
                                if (fA.listar().get(i).getIdFuncionario() == tempId) {
                                	 System.out.println("ID: " + fA.listar().get(i).getIdFuncionario());
                                	 System.out.println("Nome: " + fA.listar().get(i).getNome());
                                     System.out.println("Funcao: " +fA.listar().get(i).getFuncao());
                                }
                            }

                            break;

                        case 2:// Consultar baia - COMPLEMENTAR A BUSCA COM OS ANIMAIS NA BAIA
                            System.out.println("Baias cadastradas ate o momento:");
                            for (int i=0; i < bA.listar().size(); i++) {
                               System.out.print("ID: " + bA.listar().get(i).getidBaia() + " Nome Baia: ");
                         	   System.out.print(bA.listar().get(i).getNomeBaia() + " Definicao: ");
                         	   System.out.println(bA.listar().get(i).getDefinicao());
                         	   System.out.print("Capacidade: " + bA.listar().get(i).getCapacidade() + " Func.Resp: ");
                         	   System.out.println(bA.listar().get(i).getIdFuncionarioResponsavel());
                         	   System.out.println("----------------------------------------------");                         	                          	   
                              }
                            System.out.println("Diga o Id da baia que deseja consultar:");
                            tempId = teclado.nextInt();
                            
                            for (int i = 0; i < bA.listar().size(); i++) {
                                
                                if (bA.listar().get(i).getidBaia() == tempId) {
                                	System.out.print("ID: " + bA.listar().get(i).getidBaia() + " Nome Baia: ");
                                	System.out.print(bA.listar().get(i).getNomeBaia() + " Definicao: ");
                                	System.out.println(bA.listar().get(i).getDefinicao());
                                	System.out.print("Capacidade: " + bA.listar().get(i).getCapacidade() + " Func.Resp: ");
                                	System.out.println(bA.listar().get(i).getIdFuncionarioResponsavel());
                                	System.out.println("----------------------------------------------");  
                                }
                            }
                            break;
                        case 3:// Consultar animal
                           System.out.println("Animais cadastrados ate o momento:");
                           for (int i=0; i < cA.listar().size(); i++) {
                        	   System.out.print("ID: " + cA.listar().get(i).getIdAnimal() + " Nome: ");
                        	   System.out.print(cA.listar().get(i).getNomeAnimal() + " Idade: ");
                        	   System.out.print(cA.listar().get(i).getIdadeAnimal() + " Tipo: ");
                        	   System.out.print(cA.listar().get(i).getTipoAnimal() + " Peso: ");
                        	   System.out.println(cA.listar().get(i).getPesoAnimal());
                        	   
                           };                       		                  
                            break;
                        case 4:
                        	System.out.println("Retornando ao menu principal");
							break;
                    }
                    		
                    break;
                    
case 4:
                    System.out.println("1 - Excluir Funcionario");
                    System.out.println("2 - Excluir Baia/Confinamento");
                    System.out.println("3 - Excluir Animal");
                    System.out.println("4 - Retornar para o menu anterior");
                    System.out.println("-----------------------------------");
                    System.out.println("Escolha a informacao que deseja EXCLUIR. ");
                    opSec = teclado.nextInt();

                    switch (opSec) {
                        case 1: // Excluir funcionario
                        	f = new Funcionario();
                            System.out.println("Digite o id do Funcionario que voce deseja excluir");

                            System.out.println("Usuários cadastros ate o momento:");
                            for (int i = 0; i < fA.listar().size(); i++) {
                                System.out.print(fA.listar().get(i).getNome() + "   id: ");
                                System.out.println(fA.listar().get(i).getIdFuncionario());
                            }
                            System.out.println("Diga o Id do funcionario que deseja excluir:");
                            tempId = teclado.nextInt();

                            f.setIdFuncionario(tempId);
                            fA.remover(f);
                            break;

                        case 2:// Excluir baia
                        	Baias b1 = new Baias();
                            System.out.println("Digite o nome do Animal que voce deseja excluir");
                            System.out.println("Animais cadastrados ate o momento:");
                            for (int i=0; i < bA.listar().size(); i++) {
                            	   System.out.print("ID: " + bA.listar().get(i).getidBaia() + " Nome Baia: ");
                            	   System.out.print(bA.listar().get(i).getNomeBaia() + " Definicao: ");
                            	   System.out.println(bA.listar().get(i).getDefinicao());
                            	   System.out.print("Capacidade: " + bA.listar().get(i).getCapacidade() + " Func.Resp: ");
                            	   System.out.println(bA.listar().get(i).getIdFuncionarioResponsavel());
                            	   System.out.println("----------------------------------------------");                          	                          	   
                               }
                            System.out.println("Diga o Id da Baia que deseja excluir:");
                            tempId = teclado.nextInt();
                            b1.setidBaia(tempId);
                            bA.remover(b1);
                            break;

                        case 3:// Excluir Animal
                        	c = new Animal();
                            System.out.println("Digite o nome do Animal que voce deseja excluir");
                            System.out.println("Animais cadastrados ate o momento:");
                            for (int i=0; i < cA.listar().size(); i++) {
                         	   System.out.print("ID: " + cA.listar().get(i).getIdAnimal() + " Nome: ");
                         	   System.out.print(cA.listar().get(i).getNomeAnimal() + " Idade: ");
                         	   System.out.print(cA.listar().get(i).getIdadeAnimal() + " Tipo: ");
                         	   System.out.print(cA.listar().get(i).getTipoAnimal() + " Peso: ");
                         	   System.out.println(cA.listar().get(i).getPesoAnimal());
                         	   
                            };  
                            System.out.println("Diga o Id do animal que deseja excluir:");
                            tempId = teclado.nextInt();
                            c.setIdAnimal(tempId);
                            cA.remover(c);
                        case 4:
							System.out.println("Retornando ao menu principal");
								break;
                    }

                    break;
case 5:
					System.out.println("---- Administra�ao de Baias ----");
					System.out.println("1 - Inserir animais na baia.");
                    System.out.println("2 - Trocar baia do animal.");
                    System.out.println("3 - Retirar animal da baia.");
                    System.out.println("---------------------------------");
                    opSec = teclado.nextInt();
                    
                    	switch (opSec) {
                    	case 1:
                    		String tempEdit1 = null;
                    		System.out.println("--------------------------");
                    		System.out.println("Qual animal deseja movimentar?");
                    		for (int i = 0; i < arrayAnimal.size(); i++) {
                            	System.out.println("---------------------------------------------------");
                                System.out.print("ID: " + arrayAnimal.get(i).getIdAnimal() + " Nome: ");
                                System.out.print(arrayAnimal.get(i).getNomeAnimal() + " Tipo: ");
                                System.out.println(arrayAnimal.get(i).getTipoAnimal());
                                System.out.println("Idade: " + arrayAnimal.get(i).getIdadeAnimal());
                                System.out.println("---------------------------------------------------");
                            }
                    		System.out.println("Digite o ID do animal.");
                    		tempId = teclado.nextInt();                    		
                    		System.out.println("Para qual baia deseja mover o animal?");
                    		for (int i = 0; i < arrayBaias.size(); i++) {
                            	System.out.println("ID: " + arrayBaias.get(i).getidBaia());
                            	System.out.println("Nome: " + arrayBaias.get(i).getNomeBaia());
                            }
                    		System.out.println("Digite o ID da baia.");
                    		//tempId2 = teclado.nextInt();
                    		for (int i = 0; i < arrayAnimal.size(); i++) {
                                if (arrayBaias.get(i).getIdAnimalBaia() == tempId) {                                       
                                	arrayBaias.get(i).setAnimal(arrayAnimal.get(i));
                                }
                		}
                    		
                    		
                    	}
	
	break;
case 8:
	System.out.println("Saindo do sistema...");
	return;

default:
	System.out.println("Opcao invalida, digite a opcao correta!");
	break;
            }        
    } while (op != 5);
    }
}
    
