public class Time {
    private String nome;
    private int vitorias;
    private int empates;
    private int derrotas;
    private int pontos;

    public Time(String nome) {
        this.nome = nome;
        this.vitorias = 0;
        this.empates = 0;
        this.derrotas = 0;
        this.pontos = 0;
    }

    public void registrarVitoria() {
        vitorias++;
        pontos += 3;
    }

    public void registrarEmpate() {
        empates++;
        pontos += 1;
    }

    public void registrarDerrota() {
        derrotas++;
    }

    public void exibirEstatisticas() {
        System.out.println("--- " + nome + " ---");
        System.out.println("Vitórias: " + vitorias);
        System.out.println("Empates: " + empates);
        System.out.println("Derrotas: " + derrotas);
        System.out.println("Pontos: " + pontos);
    }

    public String getNome() { return nome; }
    public int getPontos() { return pontos; }

    public static void main(String[] args) {
        Time time1 = new Time("Flamengo");
        Time time2 = new Time("Palmeiras");

        time1.registrarVitoria();
        time1.registrarVitoria();
        time1.registrarEmpate();

        time2.registrarVitoria();
        time2.registrarEmpate();
        time2.registrarDerrota();

        time1.exibirEstatisticas();
        time2.exibirEstatisticas();

        if (time1.getPontos() > time2.getPontos()) {
            System.out.println(time1.getNome() + " possui mais pontos.");
        } else if (time2.getPontos() > time1.getPontos()) {
            System.out.println(time2.getNome() + " possui mais pontos.");
        } else {
            System.out.println("Houve empate na classificação.");
        }
    }
}
