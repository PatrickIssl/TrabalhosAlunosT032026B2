package trabalhoSegundoSemestre;

import java.util.Scanner;

public class Time {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seja bem-vindo ao Campeonato!");

        System.out.print("Digite o nome do primeiro time: ");
        String nomeTime1 = sc.nextLine();

        System.out.print("Vitórias do " + nomeTime1 + ": ");
        int vitorias1 = sc.nextInt();
        System.out.print("Empates do " + nomeTime1 + ": ");
        int empates1 = sc.nextInt();
        System.out.print("Derrotas do " + nomeTime1 + ": ");
        int derrotas1 = sc.nextInt();

        System.out.print("Digite o nome do segundo time: ");
        sc.nextLine();
        String nomeTime2 = sc.nextLine();

        System.out.print("Vitórias do " + nomeTime2 + ": ");
        int vitorias2 = sc.nextInt();
        System.out.print("Empates do " + nomeTime2 + ": ");
        int empates2 = sc.nextInt();
        System.out.print("Derrotas do " + nomeTime2 + ": ");
        int derrotas2 = sc.nextInt();

        int pontos1 = vitorias1 * 3 + empates1;
        int pontos2 = vitorias2 * 3 + empates2;

        System.out.println("\nClassificação:");
        System.out.println(nomeTime1 + ": " + pontos1 + " pontos");
        System.out.println(nomeTime2 + ": " + pontos2 + " pontos");

        if (pontos1 > pontos2) {
            System.out.println(nomeTime1 + " possui mais pontos.");
        } else if (pontos2 > pontos1) {
            System.out.println(nomeTime2 + " possui mais pontos.");
        } else {
            System.out.println("Houve empate na classificação.");
        }

        sc.close();
    }
}