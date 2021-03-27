package view;

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

        	// Declaracao de variaveis para controle do menu op= menu principal opSec= menu
			int op, opSec = 0, tempId;
			Animal  c;
			Baias b;
			Funcionario f;
			AnimalDAO cA = new AnimalDAO();
			BaiasDAO bA = new BaiasDAO();
			FuncionariosDAO fA = new FuncionariosDAO();
			
			do {
			    System.out.println("----------------------------------");
			    System.out.println("  Bem vindo ao RanchControl");
			    System.out.println("       MENU PRINCIPAL");
			    System.out.println("----------------------------------");
			    System.out.println("1 - Cadastrar");
			    System.out.println("2 - Editar / Alterar");
			    System.out.println("3 - Consultar informacoes");
			    System.out.println("4 - Excluir / Apagar");
			    System.out.println("5 - SAIR");
			    System.out.println("-----------------------------------");
			    System.out.println("Escolha a opcao desejada: ");
			    op = teclado.nextInt();           
			    switch (op) {
case 1:                	
			            System.out.println("1 - Cadastrar Baia/Confinamento");
			            System.out.println("2 - Cadastrar Funcionario");
			            System.out.println("3 - Cadastrar Animal");
			            System.out.println("4 - Retornar para o menu anterior");
			            System.out.println("-----------------------------------");
			            System.out.println("Escolha a informacao que deseja CADASTRAR. ");
			            opSec = teclado.nextInt();

			            switch (opSec) {
			            
			            case 1:// Cadastro da baia                        	
		                	Baias b1 = new Baias();;
		                    System.out.println("Digite o nome da Baia ou Caracteristica");
		                    b1.setNomeBaia(teclado.next());
		                    
		                    System.out.println("Qual a finalidade ou especificao");
		                    b1.setDefinicao(teclado.next());
		                    
		                    System.out.println("Qual a capacidade de animais?");
		                    b1.setCapacidade(teclado.nextInt());
		                   		        
		                    bA.adicionar(b1);
		                    System.out.println("Baia cadastrada com sucesso!");
		                    break;
		                    
			            case 2: // Cadastro do funcionario			                	
			                	f = new Funcionario();
			                	System.out.println("Digite o nome do funcionario");
			                    f.setNome(teclado.next());
			                    
			                    System.out.println("Qual a funcao?");
			                    f.setFuncao(teclado.next());
			                    
			                    System.out.println("Qual a Pertence a baia?");
			                    for (int i=0; i < bA.listar().size(); i++) {
				                       System.out.print("ID: " + bA.listar().get(i).getidBaia() + " Nome Baia: ");
				                 	   System.out.print(bA.listar().get(i).getNomeBaia() + " Definicao: ");
				                 	   System.out.println(bA.listar().get(i).getDefinicao());
				                 	   System.out.println("Capacidade: " + bA.listar().get(i).getCapacidade());
				                 	   System.out.println("----------------------------------------------");                         	                          	   
				                      } 
			                    System.out.println("Digite o id da baia:");
			                    f.setIdBaiaResponsavel(teclado.nextInt());			                  
			                    fA.adicionar(f);                        
			                    break;
			               
			                case 3:// Cadastro do animal
			                	c = new Animal();
			                	System.out.println("Digite o nome do Animal");
			                    c.setNomeAnimal(teclado.next());
			                   
			                    System.out.println("Qual a especie?");
			                    c.setTipoAnimal(teclado.next());
			                                              
			                    System.out.println("Qual a idade do animal?(Em anos)");
			                    c.setIdadeAnimal(teclado.nextInt());                                                      
			                  
			                    System.out.println("Qual o peso do animal?");
			                    c.setPesoAnimal(teclado.nextFloat());			                   
			                    
			                    System.out.println ("Animal pertence a alguma baia?");
			                    int varDecisao;
			                    System.out.println ("0 para sim / 1 Para nao");
			                    varDecisao = teclado.nextInt();
			                    if (varDecisao==0) {
			                    	System.out.println ("A Qual baia o animal pertence?");
			                    	for (int i=0; i < bA.listar().size(); i++) {
					                       System.out.print("ID: " + bA.listar().get(i).getidBaia() + " Nome Baia: ");
					                 	   System.out.print(bA.listar().get(i).getNomeBaia() + " Definicao: ");
					                 	   System.out.println(bA.listar().get(i).getDefinicao());
					                 	   System.out.print("Capacidade: " + bA.listar().get(i).getCapacidade() + " Func.Resp: ");
					                 	   System.out.println(bA.listar().get(i).getIdFuncionarioResponsavel());
					                 	   System.out.println("----------------------------------------------");                         	                          	   
					                      } 
			                    		System.out.println ("Digite o ID da Baia:");
			                    		c.setIdBaiaPertence(teclado.nextInt());
			                    		cA.adicionar(c);
			                    }else {
			                    cA.adicionar(c);
			                    }
			                    break;
			                case 4:
			                	System.out.println("Retornando ao menu principal");
			                	break;
			                default:
			                	System.out.println("Opçao invalida, tente novamente");
			                break;
			            }                  
			            break;                    
case 2:
			            System.out.println("1 - Editar Baia/Confinamento");
			            System.out.println("2 - Editar Funcionarios");
			            System.out.println("3 - Editar Animal");
			            System.out.println("4 - Retornar para o menu anterior");
			            System.out.println("-----------------------------------");
			            System.out.println("Escolha a informacao que deseja EDITAR. ");
			            opSec = teclado.nextInt();

			            switch (opSec) {
			            case 1:// Editar da baia
		                	b = new Baias();
		                    System.out.println("Digite o nome do Baia que voce deseja editar");

		                    System.out.println("Baias cadastradas ate o momento:");
		                    for (int i=0; i < bA.listar().size(); i++) {
		                       System.out.print("ID: " + bA.listar().get(i).getidBaia() + " Nome Baia: ");
		                  	   System.out.print(bA.listar().get(i).getNomeBaia() + " Definicao: ");
		                  	   System.out.println(bA.listar().get(i).getDefinicao());
		                  	   System.out.println("Capacidade: " + bA.listar().get(i).getCapacidade() + " Func.Resp: ");
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
		                    bA.alterar(b);
		                    break;
			            			            
			                case 2: // Editar funcionario
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
			                    System.out.println("Qual a Pertence a baia?");
			                    for (int i=0; i < bA.listar().size(); i++) {
				                       System.out.print("ID: " + bA.listar().get(i).getidBaia() + " Nome Baia: ");
				                 	   System.out.print(bA.listar().get(i).getNomeBaia() + " Definicao: ");
				                 	   System.out.println(bA.listar().get(i).getDefinicao());
				                 	   System.out.print("Capacidade: " + bA.listar().get(i).getCapacidade() + " Func.Resp: ");
				                 	   System.out.println(bA.listar().get(i).getIdFuncionarioResponsavel());
				                 	   System.out.println("----------------------------------------------");                         	                          	   
				                      }
			                    System.out.println("Digite o id da baia:");
			                    f.setIdBaiaResponsavel(teclado.nextInt());
			                    fA.alterar(f);                        			                    
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
			                    System.out.println("Digite o nome do Animal");
			                    c.setNomeAnimal(teclado.next());
			                	System.out.println("Qual a especie?");
			                    c.setTipoAnimal(teclado.next());			                  			                    
			                    System.out.println("Qual a idade do animal?");
			                    c.setIdadeAnimal(teclado.nextInt());                                                      			                  
			                    System.out.println("Qual o peso do animal?");
			                    c.setPesoAnimal(teclado.nextFloat());
			                    System.out.println("Qual a Pertence a baia?");
			                    for (int i=0; i < bA.listar().size(); i++) {
				                       System.out.print("ID: " + bA.listar().get(i).getidBaia() + " Nome Baia: ");
				                 	   System.out.print(bA.listar().get(i).getNomeBaia() + " Definicao: ");
				                 	   System.out.println(bA.listar().get(i).getDefinicao());
				                 	   System.out.print("Capacidade: " + bA.listar().get(i).getCapacidade() + " Func.Resp: ");
				                 	   System.out.println(bA.listar().get(i).getIdFuncionarioResponsavel());
				                 	   System.out.println("----------------------------------------------");                         	                          	   
				                      }
			                    System.out.println("Digite o id da baia:");
			                    c.setIdBaiaPertence(teclado.nextInt());
			                    cA.alterar(c);                                 
			                    break;
			                	default:
			                    	System.out.println("Opçao invalida, tente novamente");
			                    break;
			}
			            break;
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
			                    for (int i = 0; i < fA.listarInner(tempId).size(); i++) {                               
			                        if (fA.listarInner(tempId).get(i).getIdFuncionario() == tempId) {
			                        	System.out.print("ID: " + fA.listarInner(tempId).get(i).getIdFuncionario() + " Nome: ");
			                        	System.out.print(fA.listarInner(tempId).get(i).getNome() + "\nFuncao: ");
			                        	System.out.print(fA.listarInner(tempId).get(i).getFuncao());
			                        	System.out.print(" Id Baia Responsavel: " + fA.listarInner(tempId).get(i).getIdBaiaResponsavel() + "\nNome Baia Responsavel: ");
			                        	System.out.println(fA.listarInner(tempId).get(i).getNomeBaiaResponsavel());
			                        	System.out.println("----------------------------------------------");  
			                        }
			                    }
			                    break;

			                case 2:// Consultar baia - COMPLEMENTAR A BUSCA COM OS ANIMAIS NA BAIA
			                    System.out.println("Baias cadastradas ate o momento:");
			                    for (int i=0; i < bA.listar().size(); i++) {
			                       System.out.print("ID: " + bA.listar().get(i).getidBaia() + " Nome Baia: ");
			                 	   System.out.print(bA.listar().get(i).getNomeBaia() + " Definicao: ");
			                 	   System.out.println(bA.listar().get(i).getDefinicao());
			                 	   System.out.print("Capacidade: " + bA.listar().get(i).getCapacidade());			                 	   
			                 	   System.out.println("----------------------------------------------");                         	                          	   
			                      } 
			                    break;
			                case 3:// Consultar animal
			                   System.out.println("Animais cadastrados ate o momento:");
			                   for (int i=0; i < cA.listar().size(); i++) {
			                       System.out.print("ID: " + cA.listar().get(i).getIdAnimal() + " Nome Animal: ");
			                 	   System.out.print(cA.listar().get(i).getNomeAnimal() + " Especie: ");
			                 	   System.out.println(cA.listar().get(i).getTipoAnimal());
			                 	   System.out.print("Peso: " + cA.listar().get(i).getPesoAnimal() + " Id da Baia: ");
			                 	   System.out.println(cA.listar().get(i).getIdBaiaPertence());
			                 	   System.out.println("----------------------------------------------");                         	                          	   
			                      }             
			                    System.out.println("Diga o Id do animal que deseja consultar:");
			                    tempId = teclado.nextInt();
			                    for (int i = 0; i < cA.listarInner(tempId).size(); i++) {                               
			                        if (cA.listarInner(tempId).get(i).getIdAnimal() == tempId) {
			                        	System.out.print("ID: " + cA.listarInner(tempId).get(i).getIdAnimal() + " Nome Animal: ");
			                        	System.out.print(cA.listarInner(tempId).get(i).getNomeAnimal() + "\nTipoAnimal: ");
			                        	System.out.print(cA.listarInner(tempId).get(i).getTipoAnimal());
			                        	System.out.print(" Peso do Animal: " + cA.listarInner(tempId).get(i).getPesoAnimal() + "\nIdade do animal: ");
			                        	System.out.print(cA.listarInner(tempId).get(i).getIdadeAnimal() + "\nid da Baia: ");
			                        	System.out.print(cA.listarInner(tempId).get(i).getIdBaiaPertence() + " Nome da Baia: ");
			                        	System.out.println(cA.listarInner(tempId).get(i).getNomeBaiaPertence());
			                        	System.out.println("----------------------------------------------");  
			                        }
			                    }                      		                  
			                    break;
			                case 4:
			                	System.out.println("Retornando ao menu principal");
								break;
			                default:
			                	System.out.println("Opçao invalida, tente novamente");
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

			                    System.out.println("UsuÃ¡rios cadastros ate o momento:");
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
			                default:
			                	System.out.println("Opçao invalida, tente novamente");
			                break;
			            }
			            break;
case 5:
System.out.println("Saindo do sistema...");
return;

default:
System.out.println("Opcao invalida, digite a opcao correta!");
break;
			    }        
   } while (op != 5);
		}
    }
    
