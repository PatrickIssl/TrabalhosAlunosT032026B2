package fag.objetos;

public class Livro {

	private String titulo;
	private String autor;
	private int anoPublicacao;
	private int exemplares; 
	private int disponiveis; 

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

	public int getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public int getExemplares() {
		return exemplares;
	}


	public void setExemplares(int exemplares) {
		int emprestados = this.exemplares - this.disponiveis;
		this.exemplares = exemplares;
		this.disponiveis = exemplares - emprestados;
		if (this.disponiveis < 0) {
			this.disponiveis = 0;
		}
	}

	public int getDisponiveis() {
		return disponiveis;
	}

	public void setDisponiveis(int disponiveis) {
		this.disponiveis = disponiveis;
	}

	public boolean emprestar() {
		if (disponiveis > 0) {
			disponiveis--;
			return true;
		}
		return false;
	}

	public boolean devolver() {
		if (disponiveis < exemplares) {
			disponiveis++;
			return true;
		}
		return false;
	}
}