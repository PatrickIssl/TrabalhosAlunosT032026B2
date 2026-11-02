package fag.objetos;

public class Livro {
	private String nome;
	private int dias;
	private boolean alugado;
	
	public Livro() {
		
	}
	
	public Livro(String nome, int dias, boolean alugado) {
		this.nome = nome;
		this.dias = dias;
		this.alugado = alugado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public boolean isAlugado() {
		return alugado;
	}

	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}
}