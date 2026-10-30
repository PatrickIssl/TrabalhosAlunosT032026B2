package fag.objetos;

public class Livro {

	private String titulo;
	private String autor;
	private int ano;
	private int quantidade; // quantos exemplares estão disponíveis na biblioteca
	private int emprestados; // quantos exemplares estão emprestados

	public Livro() {
	}

	public Livro(String titulo, String autor, int ano, int quantidade) {
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.quantidade = quantidade;
		this.emprestados = 0;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getEmprestados() {
		return emprestados;
	}

	public void setEmprestados(int emprestados) {
		this.emprestados = emprestados;
	}

}
