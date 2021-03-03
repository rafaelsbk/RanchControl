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

        //arraylist's
        ArrayList<Funcionario> arrayFuncionarios = new ArrayList<>();
        ArrayList<Animal> arrayAnimal = new ArrayList<>();
        ArrayList<Baias> arrayBaias = new ArrayList<>();

        //Declaracao de variaveis para  controle do menu op= menu principal opSec= menu secundario
        int op, opSec, tempId;

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
                        case 1: //Cadastro do funcionario
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

                            //Fazer uma list com os funcionarios !!!!!!!!!!!!!!!
                            System.out.println("Escolha o id do funcionário responsavel pela baia.");
                            System.out.println("Usuários cadastros até o momento:");
                            for (int i = 0; i < arrayFuncionarios.size(); i++) {
                                System.out.print(arrayFuncionarios.get(i).getNome() + "   id: ");
                                System.out.println(arrayFuncionarios.get(i).getIdFuncionario());
                            }
                            System.out.println("Diga o Id:");
                            tempId = teclado.nextInt();

                            for (int i = 0; i < arrayFuncionarios.size(); i++) {
                                if (arrayFuncionarios.get(i).getIdFuncionario() == tempId) {
                                    b1.setFuncionarioResponsavel(arrayFuncionarios.get(i).getNome());
                                } else {
                                    System.out.println("Funcionário não encontrado");
                                }
                            }

                            break;

                        case 3:// Cadastro do animal
                            System.out.println("Digite o nome do Animal");
                            p1.setNomeAnimal(teclado.next());

                            System.out.println("Qual a idade do animal?");
                            p1.setIdadeAnimal(teclado.nextInt());

                            System.out.println("Qual a especie?");
                            p1.setTipoAnimal(teclado.next());

                            System.out.println("O animal é vacinado?");
                            p1.setTipoAnimal(teclado.next());

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
                    System.out.println("Escolha a informa��o que deseja EDITAR. ");
                    opSec = teclado.nextInt();

                    break;

                case 3:
                    System.out.println("1 - Consultar Funcionario");
                    System.out.println("2 - Consultar Baia/Confinamento");
                    System.out.println("3 - Consultar Animal");
                    System.out.println("4 - Retornar para o menu anterior");
                    System.out.println("-----------------------------------");
                    System.out.println("Escolha a informa��o que deseja CONSULTAR. ");
                    opSec = teclado.nextInt();

                    break;

                case 4:
                    System.out.println("1 - Excluir Funcionario");
                    System.out.println("2 - Excluir Baia/Confinamento");
                    System.out.println("3 - Excluir Animal");
                    System.out.println("4 - Retornar para o menu anterior");
                    System.out.println("-----------------------------------");
                    System.out.println("Escolha a informa��o que deseja EXCLUIR. ");
                    opSec = teclado.nextInt();

                    switch (opSec) {
                        case 1: //Excluir funcionario
                            System.out.println("Digite o nome do funcionario");
                            f1.setNome(teclado.next());

                            System.out.println("Qual a funcao?");
                            f1.setFuncao(teclado.next());

                            System.out.println("Funcionario cadastrado com sucesso!");

                            //Fazer uma list com os funcionarios
                            System.out.println("Escolha o funcionário responsavel pela baia.");
                            p1.setTipoAnimal(teclado.next());

                            break;

                        case 2:// Cadastro da baia
                            System.out.println("Digite o nome da Baia ou Caracteristica");
                            b1.setNomeBaia(teclado.next());

                            System.out.println("Qual a capacidade?");
                            b1.setCapacidade(teclado.nextInt());

                            System.out.println("Qual a finalidade ou especificação");
                            b1.setDefinicao(teclado.next());

                            //Fazer uma list com os funcionarios !!!!!!!!!!!!!!!
                            System.out.println("Escolha o funcionário responsavel pela baia.");
                            p1.setTipoAnimal(teclado.next());
                            System.out.println("Funcionario Cadastrado com Sucesso!");

                            break;

                        case 3:// Cadastro do animal
                            System.out.println("Digite o nome do Animal");
                            p1.setNomeAnimal(teclado.next());

                            System.out.println("Qual a idade do animal?");
                            p1.setIdadeAnimal(teclado.nextInt());

                            System.out.println("Qual a especie?");
                            p1.setTipoAnimal(teclado.nextLine());

                            System.out.println("O animal é vacinado?");
                            p1.setTipoAnimal(teclado.nextLine());
                            System.out.println("Animal Cadastrado com Sucesso!");

                            break;

                    }
                    break;
            }
        } while (op != 7);
    }
}
