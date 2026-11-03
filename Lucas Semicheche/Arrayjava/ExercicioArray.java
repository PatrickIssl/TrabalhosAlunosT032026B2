package exercicioArray;
import java.util.Scanner;

public class ExercicioArray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double[] notas = new double [5];
		double soma = 0;
		
		for (int i = 0; i < notas.length; i++) {
            System.out.print("Nota do aluno " + (i + 1) + ": ");
            notas[i] = scan.nextDouble();
            soma += notas[i];
        }
		double media = soma / notas.length;

		
		double maiorNota = notas[0];
        double menorNota = notas[0];
        int acimaDaMedia = 0;
        
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > maiorNota) {
                maiorNota = notas[i];
        }
            if (notas[i] < menorNota) {
                menorNota = notas[i];
            }

            if (notas[i] > media) {
                acimaDaMedia++;
            }
        }
        System.out.println("\n--- RESULTADOS ---");
        System.out.printf("Média da turma: %.2f%n", media);
        System.out.println("Alunos acima da média: " + acimaDaMedia);
        System.out.println("Maior nota: " + maiorNota);
        System.out.println("Menor nota: " + menorNota);

        scan.close();
    }
}


