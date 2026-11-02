
package fag;

import fag.manager.Biblioteca;
import fag.model.Livro;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Biblioteca biblioteca =
            new Biblioteca();

    public static void main(String[] args) {
        menuPrincipal();
        scanner.close();
    }

    private static void pausar() {
        System.out.println("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }

    private static void cabecalho(String titulo) {
        System.out.println("========================================");
        System.out.println("\t\t\t" + titulo);
        System.out.println("========================================\n");
    }

    private static int lerInt(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("[-] Digite um número inteiro válido.");
            }
        }
    }

    private static double lerDouble(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim()
                    .replace(",", ".");

            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("[-] Digite um valor válido.");
            }
        }
    }

    private static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine().trim();
    }

    private static String lerTextoObrigatorio(String mensagem) {
        while (true) {
            String valor = lerTexto(mensagem);

            if (!valor.isBlank()) {
                return valor;
            }

            System.out.println("[-] Este campo é obrigatório.");
        }
    }

    private static void menuPrincipal() {
        int opcao;

        do {
            cabecalho("MENU PRINCIPAL");

            System.out.println("1. Cadastrar livro");
            System.out.println("2. Atualizar livro");
            System.out.println("3. Remover livro");
            System.out.println("4. Buscar livros");
            System.out.println("5. Listar livros");
            System.out.println("6. Gerenciar estoque");
            System.out.println("7. Empréstimos");
            System.out.println("8. Relatórios");
            System.out.println("0. Sair");

            System.out.println("\n----------------------------------------");

            opcao = lerInt("Selecione uma opção: ");

            switch (opcao) {
                case 1 -> cadastrarLivro();
                case 2 -> atualizarLivro();
                case 3 -> removerLivro();
                case 4 -> menuBuscar();
                case 5 -> menuListar();
                case 6 -> menuEstoque();
                case 7 -> menuEmprestimos();
                case 8 -> menuRelatorios();
                case 0 -> {
                    System.out.println("Encerrando o sistema...");
                }
                default -> {
                    System.out.println("[-] Opção inválida.");
                    pausar();
                }
            }

        } while (opcao != 0);
    }

    private static void cadastrarLivro() {
        cabecalho("CADASTRAR LIVRO");

        String titulo = lerTextoObrigatorio("Título: ");
        String autor = lerTextoObrigatorio("Autor: ");
        String editora = lerTextoObrigatorio("Editora: ");
        String isbn = lerTextoObrigatorio("ISBN: ");

        int ano = lerInt("Ano de publicação: ");
        double preco = lerDouble("Preço: R$ ");

        try {
            Livro livro = new Livro(
                    titulo,
                    autor,
                    editora,
                    isbn,
                    ano,
                    preco
            );

            if (biblioteca.cadastrarLivro(livro)) {
                System.out.println("\n[+] Livro cadastrado com sucesso!");
            } else {
                System.out.println("\n[-] Já existe um livro com este ISBN.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("\n[-] Erro ao cadastrar: " + e.getMessage());
        }

        pausar();
    }

    private static void atualizarLivro() {
        cabecalho("ATUALIZAR LIVRO");

        String isbn = lerTextoObrigatorio("Informe o ISBN do livro: ");

        Livro livro = biblioteca.buscarPorIsbn(isbn);

        if (livro == null) {
            System.out.println("\n[-] Livro não encontrado.");
            pausar();
            return;
        }

        System.out.println("\nLivro encontrado!");
        exibirLivro(livro);

        System.out.println("\n----------------------------------------");
        System.out.println("Atualize os campos abaixo.");
        System.out.println("Deixe em branco para manter o valor atual.");
        System.out.println("----------------------------------------\n");

        String titulo = lerTexto(
                "Título [" + livro.getTitulo() + "]: "
        );

        String autor = lerTexto(
                "Autor [" + livro.getAutor() + "]: "
        );

        String editora = lerTexto(
                "Editora [" + livro.getEditora() + "]: "
        );

        String novoIsbn = lerTexto(
                "ISBN [" + livro.getIsbn() + "]: "
        );

        String anoInput = lerTexto(
                "Ano de publicação [" + livro.getAnoPublicacao() + "]: "
        );

        String precoInput = lerTexto(
                "Preço [" + livro.getPreco() + "]: R$ "
        );

        if (titulo.isBlank()) titulo = livro.getTitulo();
        if (autor.isBlank()) autor = livro.getAutor();
        if (editora.isBlank()) editora = livro.getEditora();
        if (novoIsbn.isBlank()) novoIsbn = livro.getIsbn();

        int ano = livro.getAnoPublicacao();
        double preco = livro.getPreco();

        try {
            if (!anoInput.isBlank()) {
                ano = Integer.parseInt(anoInput);
            }

            if (!precoInput.isBlank()) {
                preco = Double.parseDouble(
                        precoInput.replace(",", ".")
                );
            }

        } catch (NumberFormatException e) {
            System.out.println("\n[-] Valor numérico inválido.");
            pausar();
            return;
        }

        System.out.println("\n----------------------------------------");
        System.out.println("CONFIRMAÇÃO DAS ALTERAÇÕES");
        System.out.println("----------------------------------------");

        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Editora: " + editora);
        System.out.println("ISBN: " + novoIsbn);
        System.out.println("Ano: " + ano);
        System.out.println("Preço: R$ " + preco);

        String confirmar = lerTexto("\nConfirmar alterações? (S/N): ");

        if (!confirmar.equalsIgnoreCase("S")) {
            System.out.println("\n[!] Atualização cancelada.");
            pausar();
            return;
        }

        boolean sucesso = biblioteca.atualizarLivro(
                isbn,
                titulo,
                autor,
                editora,
                novoIsbn,
                ano,
                preco
        );

        if (sucesso) {
            System.out.println("\n[+] Livro atualizado com sucesso!");
        } else {
            System.out.println("\n[-] Não foi possível atualizar o livro.");
            System.out.println("Verifique os dados e possíveis ISBN duplicados.");
        }

        pausar();
    }

    private static void removerLivro() {
        cabecalho("REMOVER LIVRO");

        String isbn = lerTextoObrigatorio("Informe o ISBN: ");

        Livro livro = biblioteca.buscarPorIsbn(isbn);

        if (livro == null) {
            System.out.println("\n[-] Livro não encontrado.");
            pausar();
            return;
        }

        exibirLivro(livro);

        String confirmar = lerTexto(
                "\nDeseja realmente remover este livro? (S/N): "
        );

        if (confirmar.equalsIgnoreCase("S")) {
            if (biblioteca.removerLivro(isbn)) {
                System.out.println("\n[+] Livro removido!");
            } else {
                System.out.println(
                        "\n[-] Não foi possível remover. " +
                                "Existem exemplares emprestados."
                );
            }
        } else {
            System.out.println("\n[!] Operação cancelada.");
        }

        pausar();
    }

    private static void menuBuscar() {
        int opcao;

        do {
            cabecalho("BUSCAR LIVROS");

            System.out.println("1. Buscar por ISBN");
            System.out.println("2. Buscar por título");
            System.out.println("3. Buscar por autor");
            System.out.println("4. Buscar por editora");
            System.out.println("5. Buscar por ano");
            System.out.println("0. Voltar");

            opcao = lerInt("\nSelecione uma opção: ");

            switch (opcao) {
                case 1 -> {
                    cabecalho("BUSCAR POR ISBN");

                    String isbn = lerTextoObrigatorio("ISBN: ");
                    Livro livro = biblioteca.buscarPorIsbn(isbn);

                    if (livro != null) {
                        exibirLivro(livro);
                    } else {
                        System.out.println("\n[-] Livro não encontrado.");
                    }

                    pausar();
                }

                case 2 -> {
                    cabecalho("BUSCAR POR TÍTULO");

                    String titulo = lerTextoObrigatorio("Título: ");

                    exibirLista(biblioteca.buscarPorTitulo(titulo));
                    pausar();
                }

                case 3 -> {
                    cabecalho("BUSCAR POR AUTOR");

                    String autor = lerTextoObrigatorio("Autor: ");

                    exibirLista(biblioteca.buscarPorAutor(autor));
                    pausar();
                }

                case 4 -> {
                    cabecalho("BUSCAR POR EDITORA");

                    String editora = lerTextoObrigatorio("Editora: ");

                    exibirLista(biblioteca.buscarPorEditora(editora));
                    pausar();
                }

                case 5 -> {
                    cabecalho("BUSCAR POR ANO");

                    int ano = lerInt("Ano: ");

                    exibirLista(biblioteca.buscarPorAno(ano));
                    pausar();
                }

                case 0 -> {
                    // Voltar
                }

                default -> {
                    System.out.println("[-] Opção inválida.");
                    pausar();
                }
            }

        } while (opcao != 0);
    }

    private static void menuListar() {
        int opcao;

        do {
            cabecalho("LISTAR LIVROS");

            System.out.println("1. Todos os livros");
            System.out.println("2. Livros disponíveis");
            System.out.println("3. Livros esgotados");
            System.out.println("4. Livros emprestados");
            System.out.println("0. Voltar");

            opcao = lerInt("\nSelecione uma opção: ");

            switch (opcao) {
                case 1 -> exibirLista(biblioteca.listarLivros());
                case 2 -> exibirLista(biblioteca.listarLivrosDisponiveis());
                case 3 -> exibirLista(biblioteca.listarLivrosEsgotados());
                case 4 -> exibirLista(biblioteca.listarLivrosEmprestados());
                case 0 -> {
                    continue;
                }
                default -> System.out.println("[-] Opção inválida.");
            }

            if (opcao != 0) pausar();

        } while (opcao != 0);
    }

    private static void menuEstoque() {
        int opcao;

        do {
            cabecalho("GERENCIAR ESTOQUE");

            System.out.println("1. Adicionar exemplares");
            System.out.println("2. Remover exemplares");
            System.out.println("3. Consultar estoque");
            System.out.println("0. Voltar");

            opcao = lerInt("\nSelecione uma opção: ");

            switch (opcao) {
                case 1 -> {
                    cabecalho("ADICIONAR ESTOQUE");

                    String isbn = lerTextoObrigatorio("ISBN: ");
                    int quantidade = lerInt("Quantidade: ");

                    if (biblioteca.adicionarEstoque(isbn, quantidade)) {
                        System.out.println("\n[+] Estoque atualizado!");
                    } else {
                        System.out.println("\n[-] Operação não realizada.");
                    }

                    pausar();
                }

                case 2 -> {
                    cabecalho("REMOVER ESTOQUE");

                    String isbn = lerTextoObrigatorio("ISBN: ");
                    int quantidade = lerInt("Quantidade: ");

                    if (biblioteca.removerEstoque(isbn, quantidade)) {
                        System.out.println("\n[+] Estoque atualizado!");
                    } else {
                        System.out.println(
                                "\n[-] Operação inválida. " +
                                        "Verifique o ISBN e a quantidade disponível."
                        );
                    }

                    pausar();
                }

                case 3 -> {
                    cabecalho("CONSULTAR ESTOQUE");

                    String isbn = lerTextoObrigatorio("ISBN: ");
                    int quantidade = biblioteca.consultarEstoque(isbn);

                    if (quantidade >= 0) {
                        System.out.println(
                                "\nExemplares disponíveis: " + quantidade
                        );
                    } else {
                        System.out.println("\n[-] Livro não encontrado.");
                    }

                    pausar();
                }

                case 0 -> {
                    // Voltar
                }

                default -> {
                    System.out.println("[-] Opção inválida.");
                    pausar();
                }
            }

        } while (opcao != 0);
    }

    private static void menuEmprestimos() {
        int opcao;

        do {
            cabecalho("GERENCIAR EMPRÉSTIMOS");

            System.out.println("1. Realizar empréstimo");
            System.out.println("2. Registrar devolução");
            System.out.println("3. Consultar empréstimos de um livro");
            System.out.println("4. Listar livros emprestados");
            System.out.println("5. Consultar total de empréstimos");
            System.out.println("0. Voltar");

            opcao = lerInt("\nSelecione uma opção: ");

            switch (opcao) {
                case 1 -> {
                    cabecalho("REALIZAR EMPRÉSTIMO");

                    String isbn = lerTextoObrigatorio("ISBN: ");
                    int quantidade = lerInt("Quantidade: ");

                    if (biblioteca.emprestarLivro(isbn, quantidade)) {
                        System.out.println("\n[+] Empréstimo realizado!");
                    } else {
                        System.out.println(
                                "\n[-] Não foi possível realizar o empréstimo. " +
                                        "Verifique o ISBN e o estoque disponível."
                        );
                    }

                    pausar();
                }

                case 2 -> {
                    cabecalho("REGISTRAR DEVOLUÇÃO");

                    String isbn = lerTextoObrigatorio("ISBN: ");
                    int quantidade = lerInt("Quantidade: ");

                    if (biblioteca.devolverLivro(isbn, quantidade)) {
                        System.out.println("\n[+] Devolução registrada!");
                    } else {
                        System.out.println(
                                "\n[-] Não foi possível registrar a devolução. " +
                                        "Verifique o ISBN e a quantidade emprestada."
                        );
                    }

                    pausar();
                }

                case 3 -> {
                    cabecalho("CONSULTAR EMPRÉSTIMOS");

                    String isbn = lerTextoObrigatorio("ISBN: ");
                    int quantidade = biblioteca.consultarEmprestimos(isbn);

                    if (quantidade >= 0) {
                        System.out.println(
                                "\nExemplares emprestados: " + quantidade
                        );
                    } else {
                        System.out.println("\n[-] Livro não encontrado.");
                    }

                    pausar();
                }

                case 4 -> {
                    cabecalho("LIVROS EMPRESTADOS");

                    exibirLista(biblioteca.listarLivrosEmprestados());
                    pausar();
                }

                case 5 -> {
                    cabecalho("TOTAL DE EMPRÉSTIMOS");

                    System.out.println(
                            "Exemplares emprestados: " +
                                    biblioteca.quantidadeTotalEmprestimos()
                    );

                    pausar();
                }

                case 0 -> {

                }

                default -> {
                    System.out.println("[-] Opção inválida.");
                    pausar();
                }
            }

        } while (opcao != 0);
    }

    private static void menuRelatorios() {
        cabecalho("RELATÓRIOS DA BIBLIOTECA");

        int quantidadeLivros = biblioteca.quantidadeLivrosCadastrados();
        int exemplares = biblioteca.quantidadeTotalExemplares();
        int emprestados = biblioteca.quantidadeTotalEmprestimos();

        int disponiveis = exemplares - emprestados;

        double valorTotal = 0;

        for (Livro livro : biblioteca.listarLivros()) {
            valorTotal += livro.getPreco() *
                    (livro.getQntdEstoque() + livro.getQntdEmprestados());
        }

        System.out.println("Livros cadastrados: " + quantidadeLivros);
        System.out.println("Total de exemplares: " + exemplares);
        System.out.println("Exemplares disponíveis: " + disponiveis);
        System.out.println("Exemplares emprestados: " + emprestados);

        System.out.printf(
                "\nValor total do acervo: R$ %.2f%n",
                valorTotal
        );

        pausar();
    }

    private static void exibirLivro(Livro livro) {
        System.out.println("\n----------------------------------------");
        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor());
        System.out.println("Editora: " + livro.getEditora());
        System.out.println("ISBN: " + livro.getIsbn());
        System.out.println("Ano: " + livro.getAnoPublicacao());

        System.out.printf("Preço: R$ %.2f%n", livro.getPreco());

        System.out.println(
                "Estoque: " + livro.getQntdEstoque()
        );

        System.out.println(
                "Emprestados: " + livro.getQntdEmprestados()
        );

        System.out.println("----------------------------------------");
    }

    private static void exibirLista(List<Livro> livros) {
        if (livros.isEmpty()) {
            System.out.println("\n[-] Nenhum livro encontrado.");
            return;
        }

        System.out.println("\nLivros encontrados: " + livros.size());

        for (Livro livro : livros) {
            exibirLivro(livro);
        }
    }
}