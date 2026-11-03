public class Time {
    private String nome;
    private int vitorias;
    private int empates;
    private int derrotas;
    private int pontos;

    // Construtor correto: recebe APENAS o nome ao criar o time
    public Time(String nome) {
        this.nome = nome;
        this.vitorias = 0;
        this.empates = 0;
        this.derrotas = 0;
        this.pontos = 0;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVitorias() {
        return vitorias;
    }

    public int getEmpates() {
        return empates;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getPontos() {
        return pontos;
    }

    // Métodos para registrar os resultados
    public void registrarVitoria() {
        this.vitorias++;
        this.pontos += 3; // Regra: +3 pontos
    }

    public void registrarEmpate() {
        this.empates++;
        this.pontos += 1; // Regra: +1 ponto
    }

    public void registrarDerrota() {
        this.derrotas++; // Regra: +0 pontos
    }

    // Exibir estatísticas
    public void exibirEstatisticas() {
        System.out.println("\n--- ESTATÍSTICAS DO TIME: " + this.nome.toUpperCase() + " ---");
        System.out.println("Vitórias: " + this.vitorias);
        System.out.println("Empates:  " + this.empates);
        System.out.println("Derrotas: " + this.derrotas);
        System.out.println("Pontos Totais: " + this.pontos);
        System.out.println("----------------------------------------");
    }
}