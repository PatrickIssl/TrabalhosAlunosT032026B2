import java.util.ArrayList;

class Livro {
    String titulo, autor;
    boolean disponivel = true;

    Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    void exibir() {
        String situacao = disponivel ? "Disponível" : "Emprestado";
        System.out.println(titulo + " | " + autor + " | " + situacao);
    }
}

public class Biblioteca {

    private ArrayList<Livro> livros = new ArrayList<>();

    public void adicionarLivro(String titulo, String autor) {
        livros.add(new Livro(titulo, autor));
    }

    public void listarLivros() {
        for (Livro l : livros) {
            l.exibir();
        }
    }

    private Livro buscar(String titulo) {
        for (Livro l : livros) {
            if (l.titulo.equals(titulo)) {
                return l;
            }
        }
        return null;
    }

    public void emprestar(String titulo) {
        Livro l = buscar(titulo);
        if (l == null) {
            System.out.println("Erro: livro não encontrado.");
        } else if (!l.disponivel) {
            System.out.println("Erro: o livro \"" + titulo + "\" já está emprestado.");
        } else {
            l.disponivel = false;
            System.out.println("Livro \"" + titulo + "\" emprestado com sucesso.");
        }
    }

    public void devolver(String titulo, int diasAtraso) {
        Livro l = buscar(titulo);
        if (l == null) {
            System.out.println("Erro: livro não encontrado.");
        } else if (l.disponivel) {
            System.out.println("Erro: o livro \"" + titulo + "\" não estava emprestado.");
        } else {
            l.disponivel = true;
            System.out.println("Livro \"" + titulo + "\" devolvido.");
            if (diasAtraso > 0) {
                System.out.println("Multa por atraso: R$ " + (diasAtraso * 2.00));
            }
        }
    }

    public static void main(String[] args) {
        Biblioteca b = new Biblioteca();

        b.adicionarLivro("Dom Casmurro", "Machado de Assis");
        b.adicionarLivro("O Cortiço", "Aluísio Azevedo");
        b.adicionarLivro("Iracema", "José de Alencar");

        b.listarLivros();
        System.out.println();

        b.emprestar("Dom Casmurro");
        b.emprestar("Dom Casmurro");
        System.out.println();

        b.devolver("Dom Casmurro", 3);
        System.out.println();

        b.listarLivros();
    }
}
