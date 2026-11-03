import java.util.Scanner;
public class MainCampeonato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CAMPEONATO DE FUTEBOL ===");

        // Cadastro do primeiro time
        System.out.print("Digite o nome do Primeiro Time: ");
        String nome1 = scanner.nextLine();
        Time time1 = new Time(nome1);

        // Cadastro do segundo time
        System.out.print("Digite o nome do Segundo Time: ");
        String nome2 = scanner.nextLine();
        Time time2 = new Time(nome2);

        // Registro de resultados para o Time 1
        System.out.println("\n--- REGISTRO DE RESULTADOS PARA " + time1.getNome().toUpperCase() + " ---");
        System.out.print("Quantidade de Vitórias: ");
        int v1 = scanner.nextInt();
        for (int i = 0; i < v1; i++) time1.registrarVitoria();

        System.out.print("Quantidade de Empates: ");
        int e1 = scanner.nextInt();
        for (int i = 0; i < e1; i++) time1.registrarEmpate();

        System.out.print("Quantidade de Derrotas: ");
        int d1 = scanner.nextInt();
        for (int i = 0; i < d1; i++) time1.registrarDerrota();

        // Registro de resultados para o Time 2
        System.out.println("\n--- REGISTRO DE RESULTADOS PARA " + time2.getNome().toUpperCase() + " ---");
        System.out.print("Quantidade de Vitórias: ");
        int v2 = scanner.nextInt();
        for (int i = 0; i < v2; i++) time2.registrarVitoria();

        System.out.print("Quantidade de Empates: ");
        int e2 = scanner.nextInt();
        for (int i = 0; i < e2; i++) time2.registrarEmpate();

        System.out.print("Quantidade de Derrotas: ");
        int d2 = scanner.nextInt();
        for (int i = 0; i < d2; i++) time2.registrarDerrota();

        // Exibe o resumo de cada time
        time1.exibirEstatisticas();
        time2.exibirEstatisticas();

        // Comparação da pontuação e líder da classificação
        System.out.println("\nCLASSIFICAÇÃO TIMES FINAL");
        if (time1.getPontos() > time2.getPontos()) {
            System.out.println("LÍDER: " + time1.getNome() + " com " + time1.getPontos() + " pontos!");
        } else if (time2.getPontos() > time1.getPontos()) {
            System.out.println("LÍDER: " + time2.getNome() + " com " + time2.getPontos() + " pontos!");
        } else {
            System.out.println("Houve um EMPATE na classificação! Ambos possuem " + time1.getPontos() + " pontos.");
        }
        System.out.println("                       ");

        scanner.close();
    }
}