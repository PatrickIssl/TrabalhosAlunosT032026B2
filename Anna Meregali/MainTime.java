package avaliacao;

import java.util.Scanner;

public class MainTime {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Digie o nome do time 1: ");
		String nome1 = scan.nextLine();
		Time time1 = new Time(nome1);

        System.out.print("Digite o nome do time 2: ");
        String nome2 = scan.nextLine();
        Time time2 = new Time(nome2);

        System.out.println("\nResultados de " + time1.nome);
        System.out.print("Quantas vitórias? ");
        int vitoria1 = scan.nextInt();
        for (int i = 0; i < vitoria1; i++) {
            time1.registrarVitoria();
        }
        System.out.print("Quantos empates? ");
        int empate1 = scan.nextInt();
        for (int i = 0; i < empate1; i++) {
            time1.registrarEmpate();
        }
        System.out.print("Quantas derrotas? ");
        int derrota1 = scan.nextInt();
        for (int i = 0; i < derrota1; i++) {
            time1.registrarDerrota();
        }
        
        System.out.println("\nResultados de " + time2.nome);
        System.out.print("Quantas vitórias? ");
        int vitoria2 = scan.nextInt();
        for (int i = 0; i < vitoria2; i++) {
            time2.registrarVitoria();
        }
        System.out.print("Quantos empates? ");
        int empate2 = scan.nextInt();
        for (int i = 0; i < empate2; i++) {
            time2.registrarEmpate();
        }
        System.out.print("Quantas derrotas? ");
        int derrota2 = scan.nextInt();
        for (int i = 0; i < derrota2; i++) {
            time2.registrarDerrota();
        }
        
        System.out.println("\nESTATÍSTICAS: ");
        time1.exibirEstatisticas();
        time2.exibirEstatisticas();

        if (time1.pontos > time2.pontos) {
            System.out.println(time1.nome + " tem mais pontos!");
        } 
        else if (time2.pontos > time1.pontos) {
            System.out.println(time2.nome + " tem mais pontos!");
        } 
        else {
            System.out.println("Houve empate na classificação!");
        }
        scan.close();
	}

}
