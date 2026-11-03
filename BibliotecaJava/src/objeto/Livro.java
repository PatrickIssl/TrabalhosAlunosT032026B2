package objeto;

public class Livro {
	
	private String nome;
	private String autor;
	private int isbn;
	private int qtd;
	
	
	public Livro() {
	}
	
	public Livro(String nome, String autor, int isbn, int qtd) {
		this.nome = nome;
		this.autor = autor;
		this.isbn = isbn;
		this.qtd = qtd;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	
	}

}


