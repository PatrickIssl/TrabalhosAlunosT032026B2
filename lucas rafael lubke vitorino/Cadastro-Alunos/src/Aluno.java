public class Aluno {

    private int id;
    private String nome;
    private double nota;

    public Aluno(int id, String nome, double nota) {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
    }

    // criar os getters para pegar o valor
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getNota() {
        return nota;
    }

    // criar os setters para trocar o valor dos atributos
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}