package fag.objetos;

public class Livro {

	private String titulo;
	private String autor;
	private int quantidadeTotal;
	private int quantidadeDisponivel;

	public Livro() {
	}

	public Livro(String titulo, String autor, int quantidadeTotal) {
		this.titulo = titulo;
		this.autor = autor;
		this.quantidadeTotal = quantidadeTotal;
		this.quantidadeDisponivel = quantidadeTotal;
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

	public int getQuantidadeTotal() {
		return quantidadeTotal;
	}

	public int getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}

	public int getQuantidadeEmprestada() {
		return quantidadeTotal - quantidadeDisponivel;
	}

	public boolean setQuantidadeTotal(int novoTotal) {
		int emprestados = getQuantidadeEmprestada();
		if (novoTotal < emprestados) {
			return false;
		}
		this.quantidadeTotal = novoTotal;
		this.quantidadeDisponivel = novoTotal - emprestados;
		return true;
	}

	public boolean emprestar() {
		if (quantidadeDisponivel <= 0) {
			return false;
		}
		quantidadeDisponivel--;
		return true;
	}

	public boolean devolver() {
		if (quantidadeDisponivel >= quantidadeTotal) {
			return false;
		}
		quantidadeDisponivel++;
		return true;
	}
}
