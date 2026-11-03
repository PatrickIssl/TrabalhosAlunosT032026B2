package fag.objetos;

public class Livro 
{
	private String titulo;
	private String autor;
	private int paginas;
	private boolean emprestado;
	private int diasEmprestado;
	
	public Livro() {
	}
	
	public Livro(String titulo, String autor, int paginas, boolean emprestado, int diasEmprestado)
	{
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
		this.emprestado = emprestado;
		this.diasEmprestado = diasEmprestado;
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

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}


	public boolean isEmprestado() {
		return emprestado;
	}

	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}
	
	public int getdiasEmprestado() {
		return diasEmprestado;
	}
	
	public void setdiasEmprestado(int diasEmprestado) {
		this.diasEmprestado = diasEmprestado;
	}
}
