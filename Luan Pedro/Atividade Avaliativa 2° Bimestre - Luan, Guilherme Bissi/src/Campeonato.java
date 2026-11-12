    public class Campeonato {
        private String nome;
        private int vitoria;
        private int empates;
        private int derrotas;
        private int pontos;

    public Campeonato (String nome) {
        vitoria = 0;
        empates = 0;
        derrotas = 0;
        pontos = 0;
        this.nome = nome;
        }

    public void registrarVitoria() {
        vitoria++;
        pontos += 3;
    }

    public void registrarEmpates() {
        empates++;
        pontos += 1;
    }

    public void registrarDerrotas() {
        derrotas++;
    }

    public int registrarPontos() {
        return pontos;
    }

    public String registrarNome() {
        return nome;
    }

    public void exibirEstatisticas() {
        System.out.println("Time: " + nome);
        System.out.println("Vitorias: " + vitoria);
        System.out.println("Pontuacao total: " + pontos + " pts");
    }

    public static void main(String[] args) {
        Campeonato timeA = new Campeonato("Gremio");
        Campeonato timeB = new Campeonato("Internacional");

        timeA.registrarVitoria();
        timeA.registrarVitoria();
        timeA.registrarVitoria();
        timeA.registrarEmpates();
        timeA.registrarEmpates();
        timeA.registrarDerrotas();

        timeB.registrarVitoria();
        timeB.registrarEmpates();
        timeB.registrarDerrotas();

        timeA.exibirEstatisticas();
        timeB.exibirEstatisticas();

        if (timeA.registrarPontos() > timeB.registrarPontos()) {
            System.out.println("O " + timeA.registrarNome() + " tem mais pontos na classificação!");
        } else if (timeB.registrarPontos() > timeA.registrarPontos()) {
            System.out.println("O " + timeB.registrarNome() + " tem mais pontos na classificação!");
        } else {
            System.out.println("Houve um empate na classificação entre os times!");
        }
    }

    }
