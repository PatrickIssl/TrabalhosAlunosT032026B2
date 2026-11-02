package fag.manager;

import fag.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private final ArrayList<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    public boolean cadastrarLivro(Livro livro) {
        if (livro == null) return false;

        if (buscarPorIsbn(livro.getIsbn()) != null) {
            return false;
        }

        livros.add(livro);
        return true;
    }

    public boolean removerLivro(String isbn) {
        Livro livro = buscarPorIsbn(isbn);

        if (livro == null) return false;

        if (livro.getQntdEmprestados() > 0) return false;

        livros.remove(livro);
        return true;
    }

    public boolean atualizarLivro(
            String isbn,
            String titulo,
            String autor,
            String editora,
            String novoIsbn,
            int anoPublicacao,
            double preco
    ) {
        Livro livro = buscarPorIsbn(isbn);

        if (livro == null) return false;
        if (novoIsbn == null || novoIsbn.isBlank()) return false;
        if (preco <= 0) return false;

        Livro existente = buscarPorIsbn(novoIsbn);

        if (existente != null && existente != livro) {
            return false;
        }

        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setEditora(editora);
        livro.setIsbn(novoIsbn);
        livro.setAnoPublicacao(anoPublicacao);
        livro.atualizarPreco(preco);

        return true;
    }

    public Livro buscarPorIsbn(String isbn) {
        if (isbn == null) return null;

        for (Livro livro : livros) {
            if (livro.getIsbn().equalsIgnoreCase(isbn)) {
                return livro;
            }
        }

        return null;
    }

    public List<Livro> buscarPorTitulo(String titulo) {
        ArrayList<Livro> resultado = new ArrayList<>();

        if (titulo == null) return resultado;

        for (Livro livro : livros) {
            if (livro.getTitulo().toLowerCase()
                    .contains(titulo.toLowerCase())) {
                resultado.add(livro);
            }
        }

        return resultado;
    }

    public List<Livro> buscarPorAutor(String autor) {
        ArrayList<Livro> resultado = new ArrayList<>();

        if (autor == null) return resultado;

        for (Livro livro : livros) {
            if (livro.getAutor().toLowerCase()
                    .contains(autor.toLowerCase())) {
                resultado.add(livro);
            }
        }

        return resultado;
    }

    public List<Livro> buscarPorEditora(String editora) {
        ArrayList<Livro> resultado = new ArrayList<>();

        if (editora == null) return resultado;

        for (Livro livro : livros) {
            if (livro.getEditora().toLowerCase()
                    .contains(editora.toLowerCase())) {
                resultado.add(livro);
            }
        }

        return resultado;
    }

    public List<Livro> buscarPorAno(int ano) {
        ArrayList<Livro> resultado = new ArrayList<>();

        for (Livro livro : livros) {
            if (livro.getAnoPublicacao() == ano) {
                resultado.add(livro);
            }
        }

        return resultado;
    }

    public List<Livro> listarLivros() {
        return new ArrayList<>(livros);
    }

    public List<Livro> listarLivrosDisponiveis() {
        ArrayList<Livro> resultado = new ArrayList<>();

        for (Livro livro : livros) {
            if (livro.getQntdEstoque() > 0) {
                resultado.add(livro);
            }
        }

        return resultado;
    }

    public List<Livro> listarLivrosEsgotados() {
        ArrayList<Livro> resultado = new ArrayList<>();

        for (Livro livro : livros) {
            if (livro.getQntdEstoque() == 0) {
                resultado.add(livro);
            }
        }

        return resultado;
    }

    public boolean adicionarEstoque(String isbn, int quantidade) {
        Livro livro = buscarPorIsbn(isbn);

        if (livro == null || quantidade <= 0) {
            return false;
        }

        livro.adicionarEstoque(quantidade);
        return true;
    }

    public boolean removerEstoque(String isbn, int quantidade) {
        Livro livro = buscarPorIsbn(isbn);

        if (livro == null || quantidade <= 0) {
            return false;
        }

        if (quantidade > livro.getQntdEstoque()) {
            return false;
        }

        livro.removerEstoque(quantidade);
        return true;
    }

    public int consultarEstoque(String isbn) {
        Livro livro = buscarPorIsbn(isbn);

        if (livro == null) return -1;

        return livro.getQntdEstoque();
    }

    public int quantidadeLivrosCadastrados() {
        return livros.size();
    }

    public int quantidadeTotalExemplares() {
        int total = 0;

        for (Livro livro : livros) {
            total += livro.getQntdEstoque()
                    + livro.getQntdEmprestados();
        }

        return total;
    }

    public boolean emprestarLivro(String isbn, int quantidade) {
        Livro livro = buscarPorIsbn(isbn);

        if (livro == null || quantidade <= 0) {
            return false;
        }

        if (quantidade > livro.getQntdEstoque()) {
            return false;
        }

        livro.emprestar(quantidade);
        return true;
    }

    public boolean devolverLivro(String isbn, int quantidade) {
        Livro livro = buscarPorIsbn(isbn);

        if (livro == null || quantidade <= 0) {
            return false;
        }

        if (quantidade > livro.getQntdEmprestados()) {
            return false;
        }

        livro.devolver(quantidade);
        return true;
    }

    public int consultarEmprestimos(String isbn) {
        Livro livro = buscarPorIsbn(isbn);

        if (livro == null) return -1;

        return livro.getQntdEmprestados();
    }

    public List<Livro> listarLivrosEmprestados() {
        ArrayList<Livro> resultado = new ArrayList<>();

        for (Livro livro : livros) {
            if (livro.getQntdEmprestados() > 0) {
                resultado.add(livro);
            }
        }

        return resultado;
    }

    public int quantidadeTotalEmprestimos() {
        int total = 0;

        for (Livro livro : livros) {
            total += livro.getQntdEmprestados();
        }

        return total;
    }
}
