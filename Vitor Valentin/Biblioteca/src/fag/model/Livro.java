package fag.model;

public class Livro {

    private String titulo;
    private String autor;
    private String editora;
    private String isbn;
    private int anoPublicacao;
    private double preco;
    private int qntdEstoque;
    private int qntdEmprestados;

    public Livro(String titulo, String autor, String editora,  String isbn, int anoPublicacao, double preco) {
        if (preco <= 0) throw new IllegalArgumentException("O preço do livro deve ser maior que zero!");

        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.preco = preco;

        this.qntdEstoque = 0;
        this.qntdEmprestados = 0;
    }

    public double getPreco() {
        return preco;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getAutor() {
        return autor;
    }

    public int getQntdEstoque() {
        return qntdEstoque;
    }

    public String getEditora() {
        return editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getQntdEmprestados() {
        return qntdEmprestados;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void atualizarPreco(double preco) {
        if (preco <= 0) return;
        this.preco = preco;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade <= 0) return;
        qntdEstoque += quantidade;
    }

    public void removerEstoque(int quantidade) {
        if (quantidade <= 0) return;
        if (quantidade > qntdEstoque) return;
        qntdEstoque -= quantidade;
    }

    public void emprestar(int quantidade) {
        if (quantidade <= 0) return;
        if (quantidade > qntdEstoque) return;
        qntdEmprestados += quantidade;
        qntdEstoque -= quantidade;
    }

    public void devolver(int quantidade) {
        if (quantidade <= 0) return;
        if (quantidade > qntdEmprestados) return;
        qntdEmprestados -= quantidade;
        qntdEstoque += quantidade;
    }
}
