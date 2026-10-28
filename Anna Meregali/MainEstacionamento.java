package avaliacao;

import java.util.Scanner;

public class MainEstacionamento {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite a placa do veículo: ");
        String placa = scan.nextLine();

        System.out.println("Digite o modelo do veículo: ");
        String modelo = scan.nextLine();

        Estacionamento veiculo = new Estacionamento( placa,  modelo);
        int opcao;

        do {
            System.out.println("\n----MENU----");
            System.out.println("1 - Adicionar tempo");
            System.out.println("2 - Calcular valor");
            System.out.println("3 - Exibir resumo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();

            if (opcao == 1) {
                System.out.print("Quantos minutos deseja adicionar? ");
                int minutos = scan.nextInt();
                veiculo.adicionarTempo(minutos);
            }
            else if (opcao == 2) {
                System.out.println("Valor a pagar: R$ " + veiculo.calcularValor());
            }
            else if (opcao == 3) {
                veiculo.exibirResumo();
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