package view;
import java.util.Scanner;
import model.Animal;

public class Main {


		public static void main (String[] args) {
			Scanner teclado = new Scanner(System.in);
			Animal p1 = new Animal();
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
					case 3:
						System.out.println("Digite o nome do Animal");
						teclado.nextLine();
						p1.setNomeAnimal(teclado.nextLine());
						System.out.println("Qual a idade do animal?");
						teclado.nextInt();
						p1.setIdadeAnimal(teclado.nextInt());
						System.out.println("Qual a especie?");
						teclado.nextLine();
						p1.setTipoAnimal(teclado.nextLine());
						
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
