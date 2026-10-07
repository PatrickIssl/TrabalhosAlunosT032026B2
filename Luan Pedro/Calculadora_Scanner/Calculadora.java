package Calculadora_Scanner;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {

        int soma, sub, mult, div;
        int operacao = 0;

        Scanner op = new Scanner(System.in);

       while (operacao != 5) {

            System.out.print("\nQual a operação desejada? (1 para adição, 2 para subtração, 3 para multiplicação, 4 para divisão e 5 para encerrar o processo) \n");
            operacao = op.nextInt();

            if (operacao == 1)
            {
                System.out.print("Qual primeiro número da adição? ");
                int n1 = op.nextInt();
                System.out.print("Qual o segundo número? ");
                int n2 = op.nextInt();
                soma = n1 + n2;
                System.out.println("Resultado da operação é: \n" + soma);
            }
            else if (operacao == 2)
            {
                System.out.print("Qual primeiro número da subtração? ");
                int n1 = op.nextInt();
                System.out.print("Qual o segundo número? ");
                int n2 = op.nextInt();
                sub = n1 - n2;
                System.out.println("Resultado da operação é: \n" + sub);
            }
            else if (operacao == 3)
            {
                System.out.print("Qual primeiro número da multiplicação? ");
                int n1 = op.nextInt();
                System.out.print("Qual o segundo número? ");
                int n2 = op.nextInt();
                mult = n1 * n2;
                System.out.println("Resultado da operação é: \n" + mult);
            }
            else if (operacao == 4)
            {
                System.out.print("Qual primeiro número da divisão? ");
                int n1 = op.nextInt();
                System.out.print("Qual o segundo número? ");
                int n2 = op.nextInt();
                div = n1 / n2;
                System.out.println("Resultado da operação é: \n" + div);
            }
            else if (operacao == 5)
            {
                System.out.println("Operação entrando em processo de encerramento... ");
            }
            else
            {
                System.out.println("Opção inválida, tente novamente!");
            }
        }
    }
}