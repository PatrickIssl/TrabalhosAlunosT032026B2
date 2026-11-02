package atividade04;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do dono do cofrinho: ");
        String dono = sc.nextLine();

        double meta = lerValor(sc, "Meta de economia (R$): ");

        Cofrinho cofrinho = new Cofrinho(dono, meta);
        cofrinho.exibirSaldo();

        int quantidade = (int) lerValor(sc, "Quantos depósitos deseja fazer? ");
        for (int i = 1; i <= quantidade; i++) {
            double valor = lerValor(sc, "Valor do depósito " + i + " (R$): ");
            cofrinho.depositar(valor);
        }
        cofrinho.exibirSaldo();

        double retirada = lerValor(sc, "Valor que deseja retirar (R$): ");
        cofrinho.retirar(retirada);
        cofrinho.exibirSaldo();


        cofrinho.verificarMeta();

        sc.close();
    }

    private static double lerValor(Scanner sc, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = sc.nextLine().trim().replace(",", ".");
            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número.");
            }
        }
    }
}