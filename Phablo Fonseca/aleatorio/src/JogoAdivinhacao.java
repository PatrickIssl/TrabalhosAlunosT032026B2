package JogoAdivinhacao;

import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int numeroSecreto = random.nextInt(10) + 1;
        int chute;
        int tentativas = 0;

        System.out.println("Adivinhe o número de 1 a 10");

        do {
            System.out.print("Digite seu chute: ");
            chute = scanner.nextInt();
            tentativas++;

            if (chute > numeroSecreto) {
                System.out.println("Chute mais baixo");
            } else if (chute < numeroSecreto) {
                System.out.println("Chute mais alto");
            } else {
                System.out.println("Parabéns, você acertou o número em: " + tentativas + " tentativas");
            }

        } while (chute != numeroSecreto);

        scanner.close();
    }
}