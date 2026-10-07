import java.util.Scanner;

public class Caixa {

	static Scanner scan = new Scanner(System.in);

	static double saldo = 0;

	public static void main(String[] args) {

		String senhaC = "1234";
		int tent = 0;
		boolean certo = false;
		while (tent <= 3) {
			System.out.println("digite sua senha: ");
			String senhaDigi = scan.nextLine();
			if (senhaDigi.equals(senhaC)) {
				certo = true;
				System.out.println("Acesso liberado!");

				int op = 0;
				while (op != 4) {
					System.out.println("Escolha uma opcao:");
					System.out.println("1 - Consultar saldo");
					System.out.println("2 - Depositar dinheiro");
					System.out.println("3 - Sacar dinheiro");
					System.out.println("4 - Sair");
					op = scan.nextInt();
					scan.nextLine();

					if (op == 1) {

						consul();

					}
					if (op == 2) {
						depo();

					}
					if (op == 3) {
						saca();
					}

					if (op == 4) {

						fim();
					}

					if (op > 4) {

						erros();

					}
				}

			} else {
				tent++;
				System.out.println("Senha incorreta");
				System.out.println("Tente novamente");

			}
		}
		if (certo == false) {

			System.out.println("Acesso Bloqueado atingiu o limite de tentativas");

		}

	}

	public static void saca() {
		System.out.println("Valor a sacar:");
		double saca = scan.nextDouble();

		if (saca <= 0) {

			System.out.println("Valor nao aceito");

		} else if (saca > 500) {
			System.out.println("limite diario excedido!");
		} else if (saca < saldo) {
			saldo -= saca;
			System.out.println("saque efetuado");
		} else {
			System.out.println("saldo insuficiente");
		}

	}

	public static void depo() {
		System.out.println("Valor a depositar:");
		double depo = scan.nextDouble();
		if (depo <= 0) {

			System.out.println("Valor nao aceito");
		} else {
			saldo += depo;
			System.out.println("Valor depositado");
		}
	}

	public static void consul() {
		System.out.println("Seu saldo e: R$ " + saldo);
	}

	public static void fim() {
		System.out.println("Operacao finalizada");

	}

	public static void erros() {
		System.out.println("Operacao Invalida");
	}
}
