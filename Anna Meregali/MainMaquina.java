package avaliacao;

import java.util.Scanner;

public class MainMaquina {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MaquinaRefrigerante maquina = new MaquinaRefrigerante();

        System.out.print("Digite a quantidade inicial de estoque: ");
        int estoqueInicial = scan.nextInt();
        maquina.setQuantidadeEstoque(estoqueInicial);

        int opcao;

        do {
            System.out.println("\n----MENU----");
            System.out.println("1 - Comprar refrigerante");
            System.out.println("2 - Repor estoque");
            System.out.println("3 - Exibir estado da máquina");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();

            if (opcao == 1) {
                System.out.print("Quantos refrigerantes deseja comprar? ");
                int qtd = scan.nextInt();
 
                double valorAPagar = maquina.getPreco() * qtd;
                System.out.println("Valor a pagar: R$ " + valorAPagar);
                
                System.out.print("Quanto você vai pagar? R$ ");
                double valorPago = scan.nextDouble();
                maquina.comprar(qtd, valorPago);
            }
            else if (opcao == 2) {
                System.out.print("Quantas unidades deseja repor? ");
                int qtd = scan.nextInt();
                maquina.reporEstoque(qtd);
            }
            else if (opcao == 3) {
                maquina.exibirEstado();
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
