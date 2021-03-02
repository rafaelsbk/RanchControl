package view;

import java.util.Scanner;

public class Main {


		public static void main (String[] args) {
			Scanner teclado = new Scanner(System.in);
			int op;
			do {
				System.out.println("----------------------------------");
				System.out.println("       MENU PRINCIPAL");
				System.out.println("----------------------------------");
				System.out.println("1 - Cadastrar / Inserir");
				System.out.println("2 - Editar / Alterar");
				System.out.println("3 - Excluir / Apagar");
				System.out.println("4 - SAIR");
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
					System.out.println("Escolha a informação que deseja cadastrar. ");
					
				}
			
			
			
			} while(op!=7);

			
//			
}
}
