package view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import model.Animal;
import model.Baias;
import model.Funcionario;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Animal p1 = new Animal();
        Baias b1 = new Baias();
        Funcionario f1 = new Funcionario();

        // arraylist's
        ArrayList<Funcionario> arrayFuncionarios = new ArrayList<>();
        ArrayList<Animal> arrayAnimal = new ArrayList<>();
        ArrayList<Baias> arrayBaias = new ArrayList<>();

        // Declaracao de variaveis para controle do menu op= menu principal opSec= menu
        // secundario
        int op, opSec, tempId, opEdit;
        do {
            System.out.println("----------------------------------");
            System.out.println("  Bem vindo ao RanchControl");
            System.out.println("       MENU PRINCIPAL");
            System.out.println("----------------------------------");
            System.out.println("1 - Cadastrar / Inserir");
            System.out.println("2 - Editar / Alterar");
            System.out.println("3 - Consultar informa��es");
            System.out.println("4 - Excluir / Apagar");
            System.out.println("5 - SAIR");
            System.out.println("-----------------------------------");
            System.out.println("Escolha a opção desejada: ");
            op = teclado.nextInt();

            switch (op) {
                case 1:
                    System.out.println("1 - Cadastrar Funcionario");
                    System.out.println("2 - Cadastrar Baia/Confinamento");
                    System.out.println("3 - Cadastrar Animal");
                    System.out.println("4 - Retornar para o menu anterior");
                    System.out.println("-----------------------------------");
                    System.out.println("Escolha a informação que deseja CADASTRAR. ");
                    opSec = teclado.nextInt();

                    switch (opSec) {
                        case 1: // Cadastro do funcionario
                            System.out.println("Digite o nome do funcionario");
                            f1.setNome(teclado.next());

                            System.out.println("Qual a funcao?");
                            f1.setFuncao(teclado.next());

                            f1.setIdFuncionario(arrayFuncionarios.size());
                            arrayFuncionarios.add(f1);
                            System.out.println("Funcionario cadastrado com sucesso!");

                            break;

                        case 2:// Cadastro da baia
                            System.out.println("Digite o nome da Baia ou Caracteristica");
                            b1.setNomeBaia(teclado.next());

                            System.out.println("Qual a capacidade?");
                            b1.setCapacidade(teclado.nextInt());

                            System.out.println("Qual a finalidade ou especificação");
                            b1.setDefinicao(teclado.next());

                            System.out.println("Escolha o id do funcionário responsavel pela baia.");
                            System.out.println("Usuários cadastros até o momento:");
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
                            System.out.println("Digite o nome do Animal");
                            p1.setNomeAnimal(teclado.next());

                            System.out.println("Qual a idade do animal?");
                            p1.setIdadeAnimal(teclado.nextInt());

                            System.out.println("Qual a especie?");
                            p1.setTipoAnimal(teclado.next());

                            System.out.println("O animal é vacinado?");
                            p1.setVacina(teclado.next());

                            System.out.println("Qual o peso do animal?");
                            p1.setPeso(teclado.nextFloat());

                            System.out.println("Digite alguma observação sobre o animal");
                            p1.setObservacoes(teclado.next());

                            p1.setIdAnimal(arrayBaias.size());
                            arrayAnimal.add(p1);
                            System.out.println("Animal Cadastrado com Sucesso!");
                            System.out.println(p1);

                            break;
                    }
                    break;
                case 2:
                    System.out.println("1 - Editar Funcionario");
                    System.out.println("2 - Editar Baia/Confinamento");
                    System.out.println("3 - Editar Animal");
                    System.out.println("4 - Retornar para o menu anterior");
                    System.out.println("-----------------------------------");
                    System.out.println("Escolha a informação que deseja EDITAR. ");
                    opSec = teclado.nextInt();

                    switch (opSec) {
                        case 1: // Editar funcionario
                            System.out.println("Digite o id do Funcionário que você deseja editar");

                            System.out.println("Usuários cadastros até o momento:");
                            for (int i = 0; i < arrayFuncionarios.size(); i++) {
                                System.out.print(arrayFuncionarios.get(i).getNome() + "   id: ");
                                System.out.println(arrayFuncionarios.get(i).getIdFuncionario());
                            }
                            System.out.println("Diga o Id do funcionário que deseja editar:");
                            tempId = teclado.nextInt();

                            System.out.println("-------------------------------");
                            System.out.println("O que deseja editar?");
                            System.out.println("1- Nome do funcionário");
                            System.out.println("2- Funcao do funcionário");
                            opEdit = teclado.nextInt();
                            switch (opEdit) {
                                case 1:
                                    System.out.println("Digite o nome do usuário");
                                    for (int i = 0; i < arrayFuncionarios.size(); i++) {
                                        if (arrayFuncionarios.get(i).getIdFuncionario() == tempId) {
                                            String tempEdit1 = teclado.next();
                                            arrayFuncionarios.get(i).setNome(tempEdit1);
                                        }
                                    }
                                    break;

                                case 2:
                                    System.out.println("Digite a função do usuário");
                                    for (int i = 0; i < arrayFuncionarios.size(); i++) {
                                        if (arrayFuncionarios.get(i).getIdFuncionario() == tempId) {
                                            String tempEdit2 = teclado.next();
                                            arrayFuncionarios.get(i).setFuncao(tempEdit2);
                                        }
                                    }
                                    break;

                                default:
                                    break;
                            }

                            break;

                        case 2:// Editar da baia

                            System.out.println("Digite o nome do Baia que você deseja editar");

                            System.out.println("Baias cadastradas até o momento:");
                            for (int i = 0; i < arrayBaias.size(); i++) {
                                System.out.print(arrayBaias.get(i).getNomeBaia() + "   id: ");
                                System.out.println(arrayBaias.get(i).getidBaia());
                            }
                            System.out.println("Diga o Id do Baia que deseja editar:");
                            tempId = teclado.nextInt();

                            System.out.println("-------------------------------");
                            System.out.println("O que deseja editar?");
                            System.out.println("1- Nome da baia");
                            System.out.println("2- Capacidade da baia");
                            System.out.println("3- Definição da baia");
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
                                    System.out.println("Digite a definição da baia");
                                    for (int i = 0; i < arrayBaias.size(); i++) {
                                        if (arrayBaias.get(i).getidBaia() == tempId) {
                                            String tempEdit3 = teclado.next();
                                            arrayBaias.get(i).setDefinicao(tempEdit3);
                                        }
                                    }
                                    break;
                                case 4:
                                    System.out.println("Digite o funcionário responsável");
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
                            System.out.println("Digite o nome do Animal que você deseja editar");

                            System.out.println("Animal cadastrados até o momento:");
                            for (int i = 0; i < arrayAnimal.size(); i++) {
                                System.out.print(arrayAnimal.get(i).getNomeAnimal() + "   id: ");
                                System.out.println(arrayAnimal.get(i).getIdAnimal());
                            }
                            System.out.println("Diga o Id do animal que deseja editar:");
                            tempId = teclado.nextInt();

                            System.out.println("-------------------------------");
                            System.out.println("O que deseja editar?");
                            System.out.println("1- Nome do animal");
                            System.out.println("2- Tipo do animal");
                            System.out.println("3- Idade do animal");
                            System.out.println("4- Peso do animal");
                            System.out.println("5- Animal vacinado ou não");
                            System.out.println("6- Observações do animal");

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
                                            arrayAnimal.get(i).setPeso(tempEdit3);
                                        }
                                    }
                                    break;
                                case 5:
                                    System.out.println("Animal vacinado ou não?");
                                    for (int i = 0; i < arrayAnimal.size(); i++) {
                                        if (arrayAnimal.get(i).getIdAnimal() == tempId) {
                                            String tempEdit3 = teclado.next();
                                            arrayAnimal.get(i).setVacina(tempEdit3);
                                        }
                                    }
                                    break;
                                case 6:
                                    System.out.println("Diga as novas observações?");
                                    for (int i = 0; i < arrayAnimal.size(); i++) {
                                        if (arrayAnimal.get(i).getIdAnimal() == tempId) {
                                            String tempEdit3 = teclado.next();
                                            arrayAnimal.get(i).setVacina(tempEdit3);
                                        }
                                    }
                                    break;           

                                default:
                                    break;
                            }
                    }

                    break;

                case 3:
                    System.out.println("1 - Consultar Funcionario");
                    System.out.println("2 - Consultar Baia/Confinamento");
                    System.out.println("3 - Consultar Animal");
                    System.out.println("4 - Retornar para o menu anterior");
                    System.out.println("-----------------------------------");
                    System.out.println("Escolha a informação que deseja CONSULTAR. ");
                    opSec = teclado.nextInt();

                    switch (opSec) {
                        case 1: // Consultar funcionario

                            System.out.println("Usuários cadastros até o momento:");
                            for (int i = 0; i < arrayFuncionarios.size(); i++) {
                                System.out.print(arrayFuncionarios.get(i).getNome() + "   id: ");
                                System.out.println(arrayFuncionarios.get(i).getIdFuncionario());
                            }
                            System.out.println("Diga o Id do funcionário que deseja consultar:");
                            tempId = teclado.nextInt();
                            
                            for (int i = 0; i < arrayFuncionarios.size(); i++) {
                                if (arrayFuncionarios.get(i).getIdFuncionario() == tempId) {
                                    System.out.println("Nome: "+ arrayFuncionarios.get(i).getNome());
                                    System.out.println("Função: "+ arrayFuncionarios.get(i).getFuncao()); 
                                }
                            }

                            break;

                        case 2:// Consultar baia
                            System.out.println("Baias cadastradas até o momento:");
                            for (int i = 0; i < arrayBaias.size(); i++) {
                                System.out.print(arrayBaias.get(i).getNomeBaia() + "   id: ");
                                System.out.println(arrayBaias.get(i).getidBaia());
                            }
                            System.out.println("Diga o Id da baia que deseja consultar:");
                            tempId = teclado.nextInt();
                            
                            for (int i = 0; i < arrayBaias.size(); i++) {
                                
                                if (arrayBaias.get(i).getidBaia() == tempId) {
                                    System.out.println("Nome: "+ arrayBaias.get(i).getNomeBaia());
                                    System.out.println("Capacidade: "+ arrayBaias.get(i).getCapacidade()); 
                                    System.out.println("Definição: "+ arrayBaias.get(i).getDefinicao());
                                }
                            }

                            break;

                        case 3:// Consultar animal
                            System.out.println("Animais cadastrados até o momento:");
                            for (int i = 0; i < arrayAnimal.size(); i++) {
                                System.out.print(arrayAnimal.get(i).getNomeAnimal() + "   id: ");
                                System.out.println(arrayAnimal.get(i).getIdAnimal());
                            }
                            System.out.println("Diga o Id do animal que deseja consultar:");
                            tempId = teclado.nextInt();
                            
                            for (int i = 0; i < arrayAnimal.size(); i++) {
                                
                                if (arrayAnimal.get(i).getIdAnimal() == tempId) {
                                    System.out.println("Nome: "+ arrayAnimal.get(i).getNomeAnimal());
                                    System.out.println("Tipo: "+ arrayAnimal.get(i).getTipoAnimal()); 
                                    System.out.println("Peso: "+ arrayAnimal.get(i).getPeso());
                                    System.out.println("Vacinado: "+ arrayAnimal.get(i).getVacina());
                                    System.out.println("Idade: "+ arrayAnimal.get(i).getIdadeAnimal());
                                    System.out.println("Observações: "+ arrayAnimal.get(i).getObservacoes());
                                }
                            }

                            break;
                    }

                    break;

                case 4:
                    System.out.println("1 - Excluir Funcionario");
                    System.out.println("2 - Excluir Baia/Confinamento");
                    System.out.println("3 - Excluir Animal");
                    System.out.println("4 - Retornar para o menu anterior");
                    System.out.println("-----------------------------------");
                    System.out.println("Escolha a informação que deseja EXCLUIR. ");
                    opSec = teclado.nextInt();

                    switch (opSec) {
                        // Falta completar o processo lógico
                        case 1: // Excluir funcionario
                            System.out.println("Digite o id do Funcionário que você deseja excluir");

                            System.out.println("Usuários cadastros até o momento:");
                            for (int i = 0; i < arrayFuncionarios.size(); i++) {
                                System.out.print(arrayFuncionarios.get(i).getNome() + "   id: ");
                                System.out.println(arrayFuncionarios.get(i).getIdFuncionario());
                            }
                            System.out.println("Diga o Id do funcionário que deseja excluir:");
                            tempId = teclado.nextInt();

                            for (int i = 0; i < arrayFuncionarios.size(); i++) {
                                if (arrayFuncionarios.get(i).getIdFuncionario() == tempId) {
                                    arrayFuncionarios.remove(i);
                                }
                            }

                            break;

                        case 2:// Excluir baia

                            System.out.println("Digite o id da baia que você deseja excluir");

                            System.out.println("Baias cadastradas até o momento:");
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

                        case 3:// Excluir Animal
                            System.out.println("Digite o nome do Animal que você deseja excluir");

                            System.out.println("Animais cadastrados até o momento:");
                            for (int i = 0; i < arrayAnimal.size(); i++) {
                                System.out.print(arrayAnimal.get(i).getNomeAnimal() + "   id: ");
                                System.out.println(arrayAnimal.get(i).getIdAnimal());
                            }
                            System.out.println("Diga o Id do Baia que deseja excluir:");
                            tempId = teclado.nextInt();
                            
                            for (int i = 0; i < arrayAnimal.size(); i++) {
                                if (arrayAnimal.get(i).getIdAnimal() == tempId) {
                                    arrayAnimal.remove(i);
                                }
                            }
                    }
                    break;
            }
        } while (op != 5);
    }
}
