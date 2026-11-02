package fag;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import fag.objetos.Livro;

public class Principal {
    static Scanner scan = new Scanner(System.in);
    static List<Livro> livros = new ArrayList<Livro>();

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        int escolhaUsuario = 0;
        do {
            System.out.println("\n---------------Sistema Biblioteca---------------");
            System.out.println("Selecione uma opcao:");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Visualizar livros");
            System.out.println("3 - Apagar livro");
            System.out.println("4 - Alterar livro");
            System.out.println("5 - Emprestar livro");
            System.out.println("6 - Devolver livro");
            System.out.println("0 - Sair");
            escolhaUsuario = scan.nextInt();
            scan.nextLine();
            validarEscolha(escolhaUsuario);
        } while (escolhaUsuario != 0);
    }

    public static void validarEscolha(int escolhaUsuario) {
        switch (escolhaUsuario) {
            case 1: { cadastrarLivro(); break; }
            case 2: { visualizarLivros(); break; }
            case 3: { apagarLivro(); break; }
            case 4: { alterarLivro(); break; }
            case 5: { emprestarLivro(); break; }
            case 6: { devolverLivro(); break; }
            case 0: { System.out.println("Obrigado por utilizar o sistema!"); break; }
            default: System.out.println("Digite uma opcao valida!");
        }
    }

    public static void cadastrarLivro() {
        Livro livro = new Livro();
        System.out.println("Digite o titulo do livro:");
        livro.setTitulo(scan.nextLine());

        for (Livro livroFor : livros) {
            if (livroFor.getTitulo().equals(livro.getTitulo())) {
                System.out.println("Livro ja cadastrado!");
                return;
            }
        }

        System.out.println("Digite o autor:");
        livro.setAutor(scan.nextLine());
        System.out.println("Digite a quantidade:");
        livro.setQuantidade(scan.nextInt());
        scan.nextLine();

        if (livro.getQuantidade() < 0) {
            System.out.println("A quantidade nao pode ser negativa!");
            return;
        }
        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    public static void visualizarLivros() {
        System.out.println("\n---------------Lista de livros---------------");
        for (int i = 0; i < livros.size(); i++) {
            Livro livro = livros.get(i);
            System.out.printf("%d - %s, autor: %s, quantidade: %d%n",
                    i + 1, livro.getTitulo(), livro.getAutor(), livro.getQuantidade());
        }
    }

    public static void apagarLivro() {
        visualizarLivros();
        System.out.println("Selecione o livro que deseja excluir:");
        int escolha = scan.nextInt() - 1;
        scan.nextLine();
        if (escolha >= livros.size() || escolha < 0) {
            System.out.println("Selecione um valor valido!");
            return;
        }
        Livro livro = livros.get(escolha);
        System.out.println("Deseja excluir " + livro.getTitulo() + "? 1 - Sim / 2 - Nao");
        int confirmacao = scan.nextInt();
        scan.nextLine();
        if (confirmacao == 1) {
            livros.remove(escolha);
            System.out.println("Livro excluido com sucesso!");
        } else {
            System.out.println("Livro nao excluido!");
        }
    }

    public static void alterarLivro() {
        visualizarLivros();
        System.out.println("Selecione o livro que deseja alterar:");
        int escolha = scan.nextInt() - 1;
        scan.nextLine();
        if (escolha >= livros.size() || escolha < 0) {
            System.out.println("Selecione um valor valido!");
            return;
        }
        Livro livro = livros.get(escolha);
        mostrarMenuAlterarLivro(livro);
    }

    public static void mostrarMenuAlterarLivro(Livro livro) {
        int escolha = 0;
        do {
            System.out.println("1 - Titulo");
            System.out.println("2 - Autor");
            System.out.println("3 - Quantidade");
            System.out.println("0 - Sair");
            escolha = scan.nextInt();
            scan.nextLine();
            alterarValor(livro, escolha);
        } while (escolha != 0);
    }

    public static void alterarValor(Livro livro, int escolha) {
        if (escolha == 1) {
            System.out.println("Digite o novo titulo:");
            livro.setTitulo(scan.nextLine());
            System.out.println("Titulo alterado!");
        } else if (escolha == 2) {
            System.out.println("Digite o novo autor:");
            livro.setAutor(scan.nextLine());
            System.out.println("Autor alterado!");
        } else if (escolha == 3) {
            System.out.println("Digite a nova quantidade:");
            int quantidade = scan.nextInt();
            scan.nextLine();
            if (quantidade < 0) {
                System.out.println("Quantidade invalida!");
                return;
            }
            livro.setQuantidade(quantidade);
            System.out.println("Quantidade alterada!");
        }
    }

    public static void emprestarLivro() {
        visualizarLivros();
        System.out.println("Selecione o livro para emprestar:");
        int escolha = scan.nextInt() - 1;
        scan.nextLine();
        if (escolha >= livros.size() || escolha < 0) {
            System.out.println("Selecione um valor valido!");
            return;
        }
        Livro livro = livros.get(escolha);
        if (livro.getQuantidade() > 0) {
            livro.setQuantidade(livro.getQuantidade() - 1);
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Livro indisponivel!");
        }
    }

    public static void devolverLivro() {
        visualizarLivros();
        System.out.println("Selecione o livro para devolver:");
        int escolha = scan.nextInt() - 1;
        scan.nextLine();
        if (escolha >= livros.size() || escolha < 0) {
            System.out.println("Selecione um valor valido!");
            return;
        }
        Livro livro = livros.get(escolha);
        livro.setQuantidade(livro.getQuantidade() + 1);
        System.out.println("Livro devolvido com sucesso!");
    }
}
