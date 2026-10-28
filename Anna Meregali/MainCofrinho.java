package avaliacao;

import java.util.Scanner;

public class MainCofrinho {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        System.out.print("Digite o nome do dono: ");
        String dono = scan.nextLine();
        
        System.out.print("Defina uma meta de economia: ");
        double metaEconomia = scan.nextDouble();

        Cofrinho cofrinho = new Cofrinho(dono, metaEconomia);
        int opcao;

        do {
            System.out.println("\n----MENU----");
            System.out.println("1 - Depositar");
            System.out.println("2 - Retirar");
            System.out.println("3 - Verificar meta");
            System.out.println("4 - Exibir saldo");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha uma opção: ");
            opcao = scan.nextInt();

            if (opcao == 1) {
                System.out.print("Digite o valor do depósito: ");
                double valor = scan.nextDouble();
                cofrinho.depositar(valor);
            } 
            else if (opcao == 2) {
                System.out.print("Digite o valor da retirada: ");
                double valor = scan.nextDouble();
                cofrinho.retirar(valor);
            } 
            else if (opcao == 3) {
                cofrinho.verificarMeta();
            } 
            else if (opcao == 4) {
                cofrinho.exibirSaldo();
            } 
            else if (opcao == 0) {
                System.out.println("Encerrando o programa. Até logo!");
            } 
            else {
                System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scan.close();
    }

}
