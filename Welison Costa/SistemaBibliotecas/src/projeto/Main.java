package projeto;

class Livro {
    public int codigo;
    public String titulo;
    public boolean disponivel;

    public Livro(int codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = true;
    }
}

class Leitor {
    public int numeroCarteirinha;
    public String nome;
    public int codigoLivroEmprestado;
    public int diaDevolucao;

    public Leitor(int numeroCarteirinha, String nome) {
        this.numeroCarteirinha = numeroCarteirinha;
        this.nome = nome;
        this.codigoLivroEmprestado = 0; 
        this.diaDevolucao = 0;
    }
}

public class Main {

    public static void main(String[] args) {
        
        Livro[] acervo = new Livro[5];
        acervo[0] = new Livro(101, "Dom Casmurro");
        acervo[1] = new Livro(102, "O Senhor dos Aneis");
        acervo[2] = new Livro(103, "Pequeno Principe");

        Leitor[] leitores = new Leitor[5];
        leitores[0] = new Leitor(1, "Ana Silva");
        leitores[1] = new Leitor(2, "Carlos Mendes");

        System.out.println("=== SISTEMA DA BIBLIOTECA ===");
        
        int diaAtual = 5; 
        
        System.out.println("\n--- TENTATIVA DE EMPRESTIMO ---");
        int carteirinhaDigitada = 1;
        int livroEscolhido = 101;

        Leitor leitorEncontrado = null;
        for (int i = 0; i < leitores.length; i++) {
            if (leitores[i] != null && leitores[i].numeroCarteirinha == carteirinhaDigitada) {
                leitorEncontrado = leitores[i];
            }
        }

        Livro livroEncontrado = null;
        for (int i = 0; i < acervo.length; i++) {
            if (acervo[i] != null && acervo[i].codigo == livroEscolhido) {
                livroEncontrado = acervo[i];
            }
        }

        if (leitorEncontrado != null && livroEncontrado != null) {
            if (livroEncontrado.disponivel) {
                
                livroEncontrado.disponivel = false;
                leitorEncontrado.codigoLivroEmprestado = livroEncontrado.codigo;
                leitorEncontrado.diaDevolucao = diaAtual + 14;
                
                System.out.println("Emprestimo aprovado!");
                System.out.println("Leitor(a): " + leitorEncontrado.nome);
                System.out.println("Livro: " + livroEncontrado.titulo);
                System.out.println("Data de hoje: dia " + diaAtual);
                System.out.println("Data limite para devolucao: dia " + leitorEncontrado.diaDevolucao);
                
            } else {
                System.out.println("O livro ja esta emprestado para outra pessoa.");
            }
        } else {
            System.out.println("Erro: Leitor ou Livro nao cadastrado.");
        }

        System.out.println("\n--- DEVOLUCAO ---");
        diaAtual = 22; 
        System.out.println("A leitora voltou na biblioteca no dia " + diaAtual);

        if (leitorEncontrado != null && leitorEncontrado.codigoLivroEmprestado != 0) {
            
            System.out.println("Devolvendo o livro...");
            
            if (diaAtual > leitorEncontrado.diaDevolucao) {
                int diasAtraso = diaAtual - leitorEncontrado.diaDevolucao;
                double multa = diasAtraso * 2.50;
                System.out.println("Atraso detectado de " + diasAtraso + " dias!");
                System.out.println("Valor da multa a pagar: R$ " + multa);
            } else {
                System.out.println("Devolvido no prazo correto. Sem multas.");
            }

            livroEncontrado.disponivel = true;
            leitorEncontrado.codigoLivroEmprestado = 0;
            leitorEncontrado.diaDevolucao = 0;
            
            System.out.println("Processo finalizado. O livro voltou para o acervo.");
        }
    }
}