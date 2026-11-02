
package fag;

import java.util.ArrayList;
import java.util.Scanner;
import fag.objetos.Livro;

public class Principal {

    static Scanner scan = new Scanner(System.in);
    static ArrayList<Livro> livros = new ArrayList<>();

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE BIBLIOTECA =====");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Buscar livro");
            System.out.println("4 - Alterar livro");
            System.out.println("5 - Excluir livro");
            System.out.println("6 - Emprestar livro");
            System.out.println("7 - Devolver livro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = lerNumero();

            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    buscarLivro();
                    break;
                case 4:
                    alterarLivro();
                    break;
                case 5:
                    excluirLivro();
                    break;
                case 6:
                    emprestarLivro();
                    break;
                case 7:
                    devolverLivro();
                    break;
                case 0:
                    System.out.println("Sistema encerrado!");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }

        } while (opcao != 0);
    }

    public static int lerNumero() {
        while (!scan.hasNextInt()) {
            System.out.println("Digite um numero valido!");
            scan.nextLine();
        }
        int numero = scan.nextInt();
        scan.nextLine();
        return numero;
    }

    public static void cadastrarLivro() {
        System.out.println("\n--- CADASTRAR LIVRO ---");

        System.out.print("Titulo: ");
        String titulo = scan.nextLine().trim();

        if (titulo.isEmpty()) {
            System.out.println("O titulo nao pode ficar vazio!");
            return;
        }

        if (encontrarLivro(titulo) != null) {
            System.out.println("Este livro ja esta cadastrado!");
            return;
        }

        System.out.print("Autor: ");
        String autor = scan.nextLine().trim();

        if (autor.isEmpty()) {
            System.out.println("O autor nao pode ficar vazio!");
            return;
        }

        System.out.print("Ano de publicacao: ");
        int ano = lerNumero();

        if (ano <= 0) {
            System.out.println("Ano invalido!");
            return;
        }

        System.out.print("Quantidade de exemplares: ");
        int quantidade = lerNumero();

        if (quantidade <= 0) {
            System.out.println("Quantidade invalida!");
            return;
        }

        Livro livro = new Livro(titulo, autor, ano, quantidade);
        livros.add(livro);

        System.out.println("Livro cadastrado com sucesso!");
    }

    public static void listarLivros() {
        System.out.println("\n--- LIVROS DA BIBLIOTECA ---");

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado!");
            return;
        }

        for (int i = 0; i < livros.size(); i++) {
            Livro livro = livros.get(i);

            System.out.println("\nLivro " + (i + 1));
            System.out.println("Titulo: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Ano: " + livro.getAnoPublicacao());
            System.out.println("Total: " + livro.getTotalExemplares());
            System.out.println("Disponiveis: " + livro.getExemplaresDisponiveis());
            System.out.println("Emprestados: " +
                (livro.getTotalExemplares() - livro.getExemplaresDisponiveis()));
        }
    }

    public static Livro encontrarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo.trim())) {
                return livro;
            }
        }
        return null;
    }

    public static Livro selecionarLivro() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado!");
            return null;
        }

        System.out.print("Digite o titulo do livro: ");
        String titulo = scan.nextLine();

        Livro livro = encontrarLivro(titulo);

        if (livro == null) {
            System.out.println("Livro nao encontrado!");
        }

        return livro;
    }

    public static void buscarLivro() {
        System.out.println("\n--- BUSCAR LIVRO ---");

        Livro livro = selecionarLivro();

        if (livro != null) {
            System.out.println("Titulo: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Ano: " + livro.getAnoPublicacao());
            System.out.println("Disponiveis: " +
                livro.getExemplaresDisponiveis());
        }
    }

    public static void alterarLivro() {
        System.out.println("\n--- ALTERAR LIVRO ---");

        Livro livro = selecionarLivro();

        if (livro == null) {
            return;
        }

        System.out.println("1 - Alterar titulo");
        System.out.println("2 - Alterar autor");
        System.out.println("3 - Alterar ano");
        System.out.println("4 - Alterar quantidade total");

        int opcao = lerNumero();

        switch (opcao) {
            case 1:
                System.out.print("Novo titulo: ");
                String titulo = scan.nextLine().trim();

                if (titulo.isEmpty() ||
                    (encontrarLivro(titulo) != null &&
                     encontrarLivro(titulo) != livro)) {
                    System.out.println("Titulo invalido ou ja cadastrado!");
                    return;
                }

                livro.setTitulo(titulo);
                break;

            case 2:
                System.out.print("Novo autor: ");
                String autor = scan.nextLine().trim();

                if (autor.isEmpty()) {
                    System.out.println("Autor invalido!");
                    return;
                }

                livro.setAutor(autor);
                break;

            case 3:
                System.out.print("Novo ano: ");
                int ano = lerNumero();

                if (ano <= 0) {
                    System.out.println("Ano invalido!");
                    return;
                }

                livro.setAnoPublicacao(ano);
                break;

            case 4:
                int emprestados = livro.getTotalExemplares()
                    - livro.getExemplaresDisponiveis();

                System.out.print("Nova quantidade total: ");
                int quantidade = lerNumero();

                if (quantidade < emprestados || quantidade <= 0) {
                    System.out.println("Quantidade invalida!");
                    return;
                }

                livro.setTotalExemplares(quantidade);
                livro.setExemplaresDisponiveis(
                    quantidade - emprestados);
                break;

            default:
                System.out.println("Opcao invalida!");
                return;
        }

        System.out.println("Livro alterado com sucesso!");
    }

    public static void excluirLivro() {
        System.out.println("\n--- EXCLUIR LIVRO ---");

        Livro livro = selecionarLivro();

        if (livro == null) {
            return;
        }

        if (livro.getExemplaresDisponiveis()
                < livro.getTotalExemplares()) {
            System.out.println("Existem exemplares emprestados!");
            return;
        }

        System.out.print("Confirmar exclusao? 1-Sim / 2-Nao: ");
        int confirmacao = lerNumero();

        if (confirmacao == 1) {
            livros.remove(livro);
            System.out.println("Livro excluido com sucesso!");
        } else {
            System.out.println("Exclusao cancelada!");
        }
    }

    public static void emprestarLivro() {
        System.out.println("\n--- EMPRESTAR LIVRO ---");

        Livro livro = selecionarLivro();

        if (livro == null) {
            return;
        }

        if (livro.getExemplaresDisponiveis() <= 0) {
            System.out.println("Nenhum exemplar disponivel!");
            return;
        }

        livro.setExemplaresDisponiveis(
            livro.getExemplaresDisponiveis() - 1);

        System.out.println("Emprestimo realizado com sucesso!");
    }

    public static void devolverLivro() {
        System.out.println("\n--- DEVOLVER LIVRO ---");

        Livro livro = selecionarLivro();

        if (livro == null) {
            return;
        }

        if (livro.getExemplaresDisponiveis()
                >= livro.getTotalExemplares()) {
            System.out.println("Nao existem exemplares emprestados!");
            return;
        }

        livro.setExemplaresDisponiveis(
            livro.getExemplaresDisponiveis() + 1);

        System.out.println("Devolucao realizada com sucesso!");
    }
}
