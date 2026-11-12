public class Time {

    private String nome;
    private int vitorias, empates, derrotas, pontos;

    public Time(String nome) {
        this.nome = nome;
    }

    public void registrarVitoria() {
        vitorias++;
        pontos += 3;
    }

    public void registrarEmpate() {
        empates++;
        pontos++;
    }

    public void registrarDerrota() {
        derrotas++;
    }

    public void exibirEstatisticas() {
        System.out.println(nome + " | V: " + vitorias + " E: " + empates + " D: " + derrotas + " | Pontos: " + pontos);
    }

    public static void main(String[] args) {
        Time t1 = new Time("Flamengo");
        Time t2 = new Time("Palmeiras");

        t1.registrarVitoria();
        t1.registrarVitoria();
        t1.registrarDerrota();

        t2.registrarVitoria();
        t2.registrarEmpate();
        t2.registrarDerrota();

        t1.exibirEstatisticas();
        t2.exibirEstatisticas();

        if (t1.pontos > t2.pontos) {
            System.out.println(t1.nome + " tem mais pontos.");
        } else if (t2.pontos > t1.pontos) {
            System.out.println(t2.nome + " tem mais pontos.");
        } else {
            System.out.println("Houve empate na classificação.");
        }
    }
}