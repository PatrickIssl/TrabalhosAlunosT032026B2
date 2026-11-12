import java.util.Scanner;

class Time {
    private String nome;
    private int vitorias;
    private int empates;
    private int derrotas;
    private int pontos;

    public Time (String nome){
        this.nome = nome;
        this.vitorias = 0;
        this.empates = 0;
        this.derrotas = 0;
        this.pontos = 0;
    }

    public void registrarVitoria(){
        vitorias++;
        pontos += 3;
    }

    public void registrarEmpate(){
        empates++;
        pontos += 1;
    }

    public void registrarDerrota(){
        derrotas++;
    }

    public void exibirEstatisticas(){
        System.out.println("Time: " + nome);
        System.out.println("Vitorias: " + vitorias);
        System.out.println("Empates: " + empates);
        System.out.println("Derrotas: " + derrotas);
        System.out.println("Pontos: " + pontos);
    }

    public String getNome(){
        return nome;
    }

    public int getPontos(){
        return pontos;
    }
}

public class Atv03 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nome do time 1:");
        Time time1 = new Time(sc.nextLine());

        System.out.println("Vitorias do time 1:");
        int vitorias1 = Integer.parseInt(sc.nextLine());
        System.out.println("Empates do time 1:");
        int empates1 = Integer.parseInt(sc.nextLine());
        System.out.println("Derrotas do time 1:");
        int derrotas1 = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < vitorias1; i++){
            time1.registrarVitoria();
        }
        for (int i = 0; i < empates1; i++){
            time1.registrarEmpate();
        }
        for (int i = 0; i < derrotas1; i++){
            time1.registrarDerrota();
        }

        System.out.println("Nome do time 2:");
        Time time2 = new Time(sc.nextLine());

        System.out.println("Vitorias do time 2:");
        int vitorias2 = Integer.parseInt(sc.nextLine());
        System.out.println("Empates do time 2:");
        int empates2 = Integer.parseInt(sc.nextLine());
        System.out.println("Derrotas do time 2:");
        int derrotas2 = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < vitorias2; i++){
            time2.registrarVitoria();
        }
        for (int i = 0; i < empates2; i++){
            time2.registrarEmpate();
        }
        for (int i = 0; i < derrotas2; i++){
            time2.registrarDerrota();
        }

        time1.exibirEstatisticas();
        time2.exibirEstatisticas();

        if (time1.getPontos() > time2.getPontos()){
            System.out.println("Mais pontos: " + time1.getNome());
        } else if (time2.getPontos() > time1.getPontos()){
            System.out.println("Mais pontos: " + time2.getNome());
        } else {
            System.out.println("Houve empate na classificacao");
        }

        sc.close();
    }
}
