package view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import model.Animal;
import model.Baias;
import model.Funcionario;
import controller.AnimalDAO; 

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // arraylist's
        ArrayList<Funcionario> arrayFuncionarios = new ArrayList<>();
        ArrayList<Animal> arrayAnimal = new ArrayList<>();
        ArrayList<Baias> arrayBaias = new ArrayList<>();
        
        // Declaracao de variaveis para controle do menu op= menu principal opSec= menu
        int op, opSec = 0, tempId, opEdit, tempId2;
        boolean buscador;
        Animal  c;
        AnimalDAO cA = new AnimalDAO();
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
                        	Funcionario f1 = new Funcionario();
                            System.out.println("Digite o nome do funcionario");
                            f1.setNome(teclado.next());
                            nomeTeste = f1.getNome();                            	
            				if(!arrayFuncionarios.isEmpty()) {
            					for(int i=0; i<arrayFuncionarios.size(); i++) {
            						if(arrayFuncionarios.get(i).getNome().equals(nomeTeste)) {
            							buscador = true;
            						}
            					}
            				}
            				if(buscador) {
            					System.out.println("Funcionario com esse nome ja cadastrado "+nomeTeste);
            					System.out.println("Retornando para o menu inicial...");
            					break;
            				} 
            				
                            System.out.println("Qual a funcao?");
                            f1.setFuncao(teclado.next());

                            f1.setIdFuncionario(arrayFuncionarios.size());
                            arrayFuncionarios.add(f1);
                            System.out.println("Funcionario cadastrado com sucesso!");

                            break;

                        case 2:// Cadastro da baia                        	
                        	Baias b1 = new Baias();
                        	buscador = false;
                            System.out.println("Digite o nome da Baia ou Caracteristica");
                            b1.setNomeBaia(teclado.next());
                            nomeTeste = b1.getNomeBaia();
                            if(!arrayBaias.isEmpty()) {
            					for(int i=0; i<arrayBaias.size(); i++) {
            						if(arrayBaias.get(i).getNomeBaia().equals(nomeTeste)) {
            							buscador = true;
            						}
            					}
            				}
            				if(buscador) {
            					System.out.println("Baia ja cadastrado com esse nome "+nomeTeste);
            					System.out.println("Retornando para o menu inicial...");
            					break;
            				} 
                            System.out.println("Qual a capacidade de animais?");
                            b1.setCapacidade(teclado.nextInt());
                           

                            System.out.println("Qual a finalidade ou especificao");
                            b1.setDefinicao(teclado.next());

                            System.out.println("Escolha o id do funcionario responsavel pela baia.");
                            System.out.println("Usuarios cadastros ate o momento:");
                            for (int i = 0; i < arrayFuncionarios.size(); i++) {
                                System.out.print(arrayFuncionarios.get(i).getNome() + "   id: ");
                                System.out.println(arrayFuncionarios.get(i).getIdFuncionario());
                            }
                            System.out.println("Diga o Id:");
                            tempId = teclado.nextInt();
                            b1.setIdFuncionarioResponsavel(tempId);

                            b1.setidBaia(arrayBaias.size());
                            arrayBaias.add(b1);
                            System.out.println("Baia cadastrada com sucesso!");

                            break;

                        case 3:// Cadastro do animal
                        	c = new Animal();
                        	buscador = false;
                        	//System.out.println("Digite o ID do Animal");
                            //c.setIdAnimal(teclado.nextInt());
                            
                            System.out.println("Digite o nome do Animal");
                            c.setNomeAnimal(teclado.next());

                            System.out.println("Qual a idade do animal?");
                            c.setIdadeAnimal(teclado.nextInt());
                            
                            System.out.println("Qual a especie?");
                            c.setTipoAnimal(teclado.next());

                            //System.out.println("O animal � vacinado?");
                            //c.setVacina(teclado.next());

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
                            System.out.println("Digite o id do Funcionario que voce deseja editar");

                            System.out.println("Usuarios cadastros ate o momento:");
                            for (int i = 0; i < arrayFuncionarios.size(); i++) {
                                System.out.print(" - " + arrayFuncionarios.get(i).getNome() + "   id: ");
                                System.out.println(arrayFuncionarios.get(i).getIdFuncionario());
                                System.out.println("Funcao: " +arrayFuncionarios.get(i).getFuncao());
                            }
                            System.out.println("Diga o Id do funcionario que deseja editar:");
                            tempId = teclado.nextInt();

                            System.out.println("-------------------------------");
                            System.out.println("O que deseja editar?");
                            System.out.println("1- Nome do funcionario");
                            System.out.println("2- Funcao do funcionario");
                            opEdit = teclado.nextInt();
                            switch (opEdit) {
                            	case 1:
                                    System.out.println("Digite o nome do usuario");
                                    for (int i = 0; i < arrayFuncionarios.size(); i++) {
                                        if (arrayFuncionarios.get(i).getIdFuncionario() == tempId) {
                                            String tempEdit1 = teclado.next();
                                            arrayFuncionarios.get(i).setNome(tempEdit1);
                                        }
                                    }
                                    break;

                                case 2:
                                    System.out.println("Digite a funcao do usuario");
                                    for (int i = 0; i < arrayFuncionarios.size(); i++) {
                                        if (arrayFuncionarios.get(i).getIdFuncionario() == tempId) {
                                            String tempEdit2 = teclado.next();
                                            arrayFuncionarios.get(i).setFuncao(tempEdit2);
                                        }
                                    }
                                    break;

                                default:
                                	System.out.println("Digite a op�ao correta, Tente novamente!");
                                    break;
                            }

                            break;

                        case 2:// Editar da baia

                            System.out.println("Digite o nome do Baia que voce deseja editar");

                            System.out.println("Baias cadastradas ate o momento:");
                            for (int i = 0; i < arrayBaias.size(); i++) {
                                System.out.print(" - " + arrayBaias.get(i).getNomeBaia() + " id: ");
                                System.out.print(arrayBaias.get(i).getidBaia() + " Capacidade: ");
                                System.out.println(arrayBaias.get(i).getCapacidade()+ "Definicao: ");
                                System.out.println(arrayBaias.get(i).getDefinicao());
                                System.out.println("Definicao: " + arrayBaias.get(i).getIdFuncionarioResponsavel());
                                
                            }
                            System.out.println("Diga o Id do Baia que deseja editar:");
                            tempId = teclado.nextInt();

                            System.out.println("-------------------------------");
                            System.out.println("O que deseja editar?");
                            System.out.println("1- Nome da baia");
                            System.out.println("2- Capacidade da baia");
                            System.out.println("3- Definicao da baia");
                            System.out.println("4- Funcionário responsável");
                            opEdit = teclado.nextInt();
                            switch (opEdit) {
                                case 1:
                                    System.out.println("Digite o nome da baia");
                                    for (int i = 0; i < arrayBaias.size(); i++) {
                                        if (arrayBaias.get(i).getidBaia() == tempId) {
                                            String tempEdit1 = teclado.next();
                                            arrayBaias.get(i).setNomeBaia(tempEdit1);
                                        }
                                    }
                                    break;

                                case 2:
                                    System.out.println("Digite a capacidade da baia");
                                    for (int i = 0; i < arrayBaias.size(); i++) {
                                        if (arrayBaias.get(i).getidBaia() == tempId) {
                                            int tempEdit2 = teclado.nextInt();
                                            arrayBaias.get(i).setCapacidade(tempEdit2);
                                        }
                                    }
                                    break;
                                case 3:
                                    System.out.println("Digite a defini�o da baia");
                                    for (int i = 0; i < arrayBaias.size(); i++) {
                                        if (arrayBaias.get(i).getidBaia() == tempId) {
                                            String tempEdit3 = teclado.next();
                                            arrayBaias.get(i).setDefinicao(tempEdit3);
                                        }
                                    }
                                    break;
                                case 4:
                                    System.out.println("Digite o id do funcionario responsavel");                              
                                    System.out.println("Usuarios cadastros ate o momento:");
                                    for (int i = 0; i < arrayFuncionarios.size(); i++) {
                                        System.out.print(arrayFuncionarios.get(i).getNome() + "   id: ");
                                        System.out.println(arrayFuncionarios.get(i).getIdFuncionario());
                                    }
                                    for (int i = 0; i < arrayBaias.size(); i++) {
                                        if (arrayBaias.get(i).getidBaia() == tempId) {
                                            int tempEdit4 = teclado.nextInt();
                                            arrayBaias.get(i).setIdFuncionarioResponsavel(tempEdit4);
                                        }
                                    }
                                    break;

                                default:
                  
                                    break;
                            }

                            break;

                        	case 3:// Editar da animal
                            System.out.println("Digite o nome do Animal que voce deseja editar");

                            System.out.println("Animal cadastrados ate o momento:");
                            for (int i = 0; i < arrayAnimal.size(); i++) {
                            	System.out.println("---------------------------------------------------");
                                System.out.print("ID: " + arrayAnimal.get(i).getIdAnimal() + " Nome: ");
                                System.out.print(arrayAnimal.get(i).getNomeAnimal() + " Tipo: ");
                                System.out.println(arrayAnimal.get(i).getTipoAnimal());
                                System.out.println("Idade: " + arrayAnimal.get(i).getIdadeAnimal());
                                System.out.println("Peso " + arrayAnimal.get(i).getPesoAnimal());
                                System.out.println("Peso " + arrayAnimal.get(i).getPeso2());
                                System.out.println("Peso " + arrayAnimal.get(i).getPeso3());
                                System.out.println("Peso " + arrayAnimal.get(i).getPeso4());
                                System.out.println("Peso " + arrayAnimal.get(i).getPeso5());
                                System.out.println("Vacina: " + arrayAnimal.get(i).getVacina());
                                System.out.println("---------------------------------------------------");
                            }
                            System.out.println("Diga o Id do animal que deseja editar:");
                            tempId = teclado.nextInt();

                            System.out.println("-------------------------------");
                            System.out.println("O que deseja editar?");
                            System.out.println("1- Nome do animal");
                            System.out.println("2- Tipo do animal");
                            System.out.println("3- Idade do animal");
                            System.out.println("4- Peso do animal");
                            System.out.println("5- Animal vacinado ou nao");
                            System.out.println("6- Retornar ao menu principal");

                            opEdit = teclado.nextInt();
                            switch (opEdit) {
                                case 1:
                                    System.out.println("Digite o nome do animal");
                                    for (int i = 0; i < arrayAnimal.size(); i++) {
                                        if (arrayAnimal.get(i).getIdAnimal() == tempId) {
                                            String tempEdit1 = teclado.next();
                                            arrayAnimal.get(i).setNomeAnimal(tempEdit1);
                                        }
                                    }
                                    break;

                                case 2:
                                    System.out.println("Digite o novo tipo do animal");
                                    for (int i = 0; i < arrayAnimal.size(); i++) {
                                        if (arrayAnimal.get(i).getIdAnimal() == tempId) {
                                            String tempEdit2 = teclado.next();
                                            arrayAnimal.get(i).setTipoAnimal(tempEdit2);
                                        }
                                    }
                                    break;
                                case 3:
                                    System.out.println("Digite a nova idade do animal");
                                    for (int i = 0; i < arrayAnimal.size(); i++) {
                                        if (arrayAnimal.get(i).getIdAnimal() == tempId) {
                                            int tempEdit3 = teclado.nextInt();
                                            arrayAnimal.get(i).setIdadeAnimal(tempEdit3);
                                        }
                                    }
                                    break;
                                case 4:
                                    System.out.println("Digite o novo peso do animal");
                                    for (int i = 0; i < arrayAnimal.size(); i++) {
                                        if (arrayAnimal.get(i).getIdAnimal() == tempId) {
                                            int tempEdit3 = teclado.nextInt();
                                            arrayAnimal.get(i).setPesoAnimal(tempEdit3);
                                        }
                                    }
                                    break;
                                case 5:
                                    System.out.println("Animal vacinado ou nao?");
                                    for (int i = 0; i < arrayAnimal.size(); i++) {
                                        if (arrayAnimal.get(i).getIdAnimal() == tempId) {
                                            String tempEdit3 = teclado.next();
                                            arrayAnimal.get(i).setVacina(tempEdit3);
                                        }
                                    }
                                    break;
                                
                                case 6:
                                	System.out.println("Retornando ao menu principal");
                                	break;
                            }
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
                            for (int i = 0; i < arrayFuncionarios.size(); i++) {
                            	System.out.println("ID: " + arrayFuncionarios.get(i).getIdFuncionario());
                                System.out.println("Nome: " + arrayFuncionarios.get(i).getNome());
                            }
                            System.out.println("Diga o Id do funcionario que deseja consultar:");
                            tempId = teclado.nextInt();
                            
                            for (int i = 0; i < arrayFuncionarios.size(); i++) {
                                if (arrayFuncionarios.get(i).getIdFuncionario() == tempId) {
                                	 System.out.println("ID: " + arrayFuncionarios.get(i).getIdFuncionario());
                                	 System.out.println("Nome: " + arrayFuncionarios.get(i).getNome());
                                     System.out.println("Funcao: " +arrayFuncionarios.get(i).getFuncao());
                                }
                            }

                            break;

                        case 2:// Consultar baia
                            System.out.println("Baias cadastradas ate o momento:");
                            for (int i = 0; i < arrayBaias.size(); i++) {
                            	System.out.println("ID: " + arrayBaias.get(i).getidBaia());
                            	System.out.println("Nome: " + arrayBaias.get(i).getNomeBaia());
                            }
                            System.out.println("Diga o Id da baia que deseja consultar:");
                            tempId = teclado.nextInt();
                            
                            for (int i = 0; i < arrayBaias.size(); i++) {
                                
                                if (arrayBaias.get(i).getidBaia() == tempId) {
                                	 System.out.println("ID: " + arrayBaias.get(i).getidBaia());
                                	 System.out.println("Nome: " + arrayBaias.get(i).getNomeBaia());                                     
                                     System.out.println("Capacidade: " + arrayBaias.get(i).getCapacidade());
                                     System.out.println("Definicao: " + arrayBaias.get(i).getDefinicao());
                                     System.out.println("Funcionario responsavel:" + arrayBaias.get(i).getIdFuncionarioResponsavel());
                                }
                            }

                            break;

                        case 3:// Consultar animal
                            System.out.println("Animais cadastrados ate o momento:");
                            for (int i = 0; i < arrayAnimal.size(); i++) {
                            	System.out.println("ID: " + arrayAnimal.get(i).getIdAnimal());
                                System.out.println("Nome: " + arrayAnimal.get(i).getNomeAnimal());
                            }
                            System.out.println("Diga o Id do animal que deseja consultar:");
                            tempId = teclado.nextInt();
                            
                            for (int i = 0; i < arrayAnimal.size(); i++) {
                                
                                if (arrayAnimal.get(i).getIdAnimal() == tempId) {
                                    System.out.println("Nome: "+ arrayAnimal.get(i).getNomeAnimal());
                                    System.out.println("Tipo: "+ arrayAnimal.get(i).getTipoAnimal()); 
                                    System.out.println("Peso: "+ arrayAnimal.get(i).getPesoAnimal());
                                    System.out.println("Vacinado: "+ arrayAnimal.get(i).getVacina());
                                    System.out.println("Idade: "+ arrayAnimal.get(i).getIdadeAnimal());
                                }
                            }

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
                            System.out.println("Digite o id do Funcionario que voce deseja excluir");

                            System.out.println("Usuários cadastros ate o momento:");
                            for (int i = 0; i < arrayFuncionarios.size(); i++) {
                                System.out.print(arrayFuncionarios.get(i).getNome() + "   id: ");
                                System.out.println(arrayFuncionarios.get(i).getIdFuncionario());
                            }
                            System.out.println("Diga o Id do funcionario que deseja excluir:");
                            tempId = teclado.nextInt();

                            for (int i = 0; i < arrayFuncionarios.size(); i++) {
                                if (arrayFuncionarios.get(i).getIdFuncionario() == tempId) {
                                    arrayFuncionarios.remove(i);
                                }
                            }

                            break;

                        case 2:// Excluir baia

                            System.out.println("Digite o id da baia que voce deseja excluir");

                            System.out.println("Baias cadastradas ate o momento:");
                            for (int i = 0; i < arrayBaias.size(); i++) {
                                System.out.print(arrayBaias.get(i).getNomeBaia() + "   id: ");
                                System.out.println(arrayBaias.get(i).getidBaia());
                            }
                            System.out.println("Diga o Id do Baia que deseja excluir:");
                            tempId = teclado.nextInt();

                            for (int i = 0; i < arrayBaias.size(); i++) {
                                if (arrayBaias.get(i).getidBaia() == tempId) {
                                    arrayBaias.remove(i);
                                }
                            }
                            break;

                        case 3:// Excluir Animal
                            System.out.println("Digite o nome do Animal que voce deseja excluir");

                            System.out.println("Animais cadastrados ate o momento:");
                            for (int i = 0; i < arrayAnimal.size(); i++) {
                                System.out.print(arrayAnimal.get(i).getNomeAnimal() + "   id: ");
                                System.out.println(arrayAnimal.get(i).getIdAnimal());
                            }
                            System.out.println("Diga o Id do animal que deseja excluir:");
                            tempId = teclado.nextInt();
                            
                            for (int i = 0; i < arrayAnimal.size(); i++) {
                                if (arrayAnimal.get(i).getIdAnimal() == tempId) {
                                    arrayAnimal.remove(i);
                                }
                            }
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
                    		tempId2 = teclado.nextInt();
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
    
