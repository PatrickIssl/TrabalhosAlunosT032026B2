package avaliacao;

import java.util.Scanner;

public class Avaliacao {

	public static void main(String[] args) {
		int digito = 0;
		double saldo = 0;
		double saldofinal = 0;
		double deposito = 0;
		double sacar = 0;
		double valorsacar = 0;
		Scanner scanner = new Scanner(System.in);
		while (digito != 4) {
			System.out.println("Caixa eletronico\n");
			System.out.println("\n");
			System.out.println("Opcoes: \n");
			System.out.println("Para Consultar saldo digite 1 \n");
			System.out.println("Para Depositar dinheiro digite 2 \n");
			System.out.println("Para Sacar dinheiro digite 3\n");
			System.out.println("Para Sair digite 4\n");
			System.out.println(": \n");

			digito = scanner.nextInt();
			System.out.println("Voce inseriu \n" + digito);

			if (digito == 1) {
				System.out.println("resultado: \n");
				System.out.println("mostrar o saldo R$ %2.f\n" + saldo);
			}
			if (digito == 2) {
				System.out.println("adicionar saldo: \n");
				deposito = scanner.nextDouble();
				if (deposito == 0) {

					System.out.println("Valor incorreto insira um valor acima de 0\n");

				} else {
					saldo = saldo + deposito;
					System.out.println("saldo final R$ %f\n" + deposito);
				}
			}
				if (digito == 3) {
	  
					System.out.printf("saldo final R$ %.2f%n" + saldo);
					System.out.println("valor a sacar: \n");
					sacar = scanner.nextDouble();
					if (sacar > 500) {
						
						System.out.println("Maximo de valor possivel de sacar 500R$, inserir outro valor\n");
					} else {
					saldo = saldo - sacar;
					System.out.println("valorsacar R$ %f\n" + saldo);
					
	
						
					}

				if (digito == 4) {
					System.out.println("Fim\n");
				}
			

		}

	}
}
}