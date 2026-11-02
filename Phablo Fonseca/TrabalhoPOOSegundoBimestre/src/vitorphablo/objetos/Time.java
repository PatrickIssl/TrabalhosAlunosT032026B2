package vitorphablo.objetos;

public class Time {
    private String nome;
    private int vitorias;
    private int derrotas;
    private int empates;
    private int pontos;

    public Time(String nome) {
        this.nome = nome;
        this.vitorias = 0;
        this.derrotas = 0;
        this.empates = 0;
        this.pontos = 0;
    }

    public void registrarVitoria() {
        this.vitorias++;
        this.pontos += 3;
    }

    public void registrarEmpate() {
        this.empates++;
        this.pontos += 1;
    }

    public void registrarDerrota() {
        this.derrotas++;
    }

    public void exibirEstatisticas() {
        System.out.println("=-=-= ESTATISTICAS =-=-=");
        System.out.println("Vitorias: " + vitorias);
        System.out.println("Empates: " + empates);
        System.out.println("Derrotas: " + derrotas);
        System.out.println("Pontos: " + pontos);
    }
}
