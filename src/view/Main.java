package view;
import java.util.Scanner;
import model.Animal; 
import model.Baias;
import model.Funcionario;

public class Main {


		public static void main (String[] args) {
			Scanner teclado = new Scanner(System.in);
			Animal p1 = new Animal();
			Baias b1 = new Baias();
			Funcionario f1 = new Funcionario();
			
			//Declaracao de variaveis para  controle do menu op= menu principal opSec= menu secundario
			int op, opSec;
			
			do {
				System.out.println("----------------------------------");
				System.out.println("  Bem vindo ao RanchControl");
				System.out.println("       MENU PRINCIPAL");
				System.out.println("----------------------------------");
				System.out.println("1 - Cadastrar / Inserir");
				System.out.println("2 - Editar / Alterar");
				System.out.println("3 - Consultar informações");
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
						teclado.nextLine();
						f1.setNome(teclado.nextLine());
						System.out.println("Qual a capacidade?");
						teclado.nextInt();
						f1.setFuncao(teclado.nextLine());
						System.out.println("Funcionario cadastrado com sucesso!");
						//Fazer uma list com os funcionarios
						System.out.println("Escolha o funcionário responsavel pela baia.");
						teclado.nextLine();
						p1.setTipoAnimal(teclado.nextLine());
					case 2:// Cadastro da baia
						System.out.println("Digite o nome da Baia ou Caracteristica");
						teclado.nextLine();
						b1.setNomeBaia(teclado.nextLine());
						System.out.println("Qual a capacidade?");
						teclado.nextInt();
						b1.setCapacidade(teclado.nextInt());
						System.out.println("Qual a finalidade ou especificação");
						teclado.nextLine();
						b1.setDefinicao(teclado.nextLine());
						//Fazer uma list com os funcionarios !!!!!!!!!!!!!!!
						System.out.println("Escolha o funcionário responsavel pela baia.");
						teclado.nextLine();
						p1.setTipoAnimal(teclado.nextLine());
						System.out.println("Funcionario Cadastrado com Sucesso!");
					case 3:// Cadastro do animal
						System.out.println("Digite o nome do Animal");
						teclado.nextLine();
						p1.setNomeAnimal(teclado.nextLine());
						System.out.println("Qual a idade do animal?");
						teclado.nextInt();
						p1.setIdadeAnimal(teclado.nextInt());
						System.out.println("Qual a especie?");
						teclado.nextLine();
						p1.setTipoAnimal(teclado.nextLine());
						System.out.println("O animal é vacinado?");
						teclado.nextLine();
						p1.setTipoAnimal(teclado.nextLine());	
						System.out.println("Animal Cadastrado com Sucesso!");
						
					}
					
				case 2:
					System.out.println("1 - Editar Funcionario");
					System.out.println("2 - Editar Baia/Confinamento");
					System.out.println("3 - Editar Animal");
					System.out.println("4 - Retornar para o menu anterior");
					System.out.println("-----------------------------------");
					System.out.println("Escolha a informação que deseja EDITAR. ");
					opSec = teclado.nextInt();
				
				case 3: 
					System.out.println("1 - Consultar Funcionario");
					System.out.println("2 - Consultar Baia/Confinamento");
					System.out.println("3 - Consultar Animal");
					System.out.println("4 - Retornar para o menu anterior");
					System.out.println("-----------------------------------");
					System.out.println("Escolha a informação que deseja CONSULTAR. ");
					opSec = teclado.nextInt();
							
				case 4:
					System.out.println("1 - Excluir Funcionario");
					System.out.println("2 - Excluir Baia/Confinamento");
					System.out.println("3 - Excluir Animal");
					System.out.println("4 - Retornar para o menu anterior");
					System.out.println("-----------------------------------");
					System.out.println("Escolha a informação que deseja EXCLUIR. ");
					opSec = teclado.nextInt();
							
				}
					
			
			
			} while(op!=7);

			
//			
}
}
