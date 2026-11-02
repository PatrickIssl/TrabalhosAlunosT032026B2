
package fag.objetos;

public class Livro {

    private String titulo;
    private String autor;
    private int anopub;
    private int totalex;
    private int exdisp;

    public Livro() {
    }

    public Livro(String titulo, String autor, int anoPublicacao, int totalExemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.anopub = anoPublicacao;
        this.totalex = totalExemplares;
        this.exdisp = totalExemplares;
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

    public int getAnoPublicacao() {
        return anopub;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anopub = anoPublicacao;
    }

    public int getTotalExemplares() {
        return totalex;
    }

    public void setTotalExemplares(int totalExemplares) {
        this.totalex = totalExemplares;
    }

    public int getExemplaresDisponiveis() {
        return exdisp;
    }

    public void setExemplaresDisponiveis(int exemplaresDisponiveis) {
        this.exdisp = exemplaresDisponiveis;
    }
}
