
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
            System.out.println("Selecione uma opção a seguir: ");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Visualizar Livros");
            System.out.println("3 - Apagar Livro");
            System.out.println("4 - Alterar Livro");
            System.out.println("0 - Sair");
            escolhaUsuario = scan.nextInt();
            scan.nextLine();
            validarEscolha(escolhaUsuario);
        } while (escolhaUsuario != 0);
    }

    public static void validarEscolha(int escolhaUsuario) {
        switch (escolhaUsuario) {
            case 1:
                cadastrarLivro();
                break;
            case 2:
                visualizarLivros();
                break;
            case 3:
                apagarLivro();
                break;
            case 4:
                alterarLivro();
                break;
            case 0:
                System.out.println("Obrigado por utilizar o sistema!");
                break;
            default:
                System.out.println("Digite uma opção válida!");
        }
    }

    public static void cadastrarLivro() {
        Livro livro = new Livro();

        System.out.println("Digite o título do livro:");
        livro.setTitulo(scan.nextLine());

        // Valida se já existe um livro com o mesmo título
        for (Livro livroFor : livros) {
            if (livroFor.getTitulo().equals(livro.getTitulo())) {
                System.out.println("Livro já cadastrado!");
                return;
            }
        }

        System.out.println("Digite o autor:");
        livro.setAutor(scan.nextLine());

        System.out.println("Digite a quantidade:");
        livro.setQuantidade(scan.nextInt());
        scan.nextLine();

        if (livro.getQuantidade() <= 0) {
            System.out.println("A quantidade tem que ser maior que zero!");
            return;
        }

        livros.add(livro);
        System.out.println("Livro adicionado com sucesso!");
    }

    public static void visualizarLivros() {
        System.out.println();
        System.out.println("---------------Lista de livros---------------");
        System.out.println();
        for (int i = 0; i < livros.size(); i++) {
            Livro livro = livros.get(i);
            System.out.printf("%d - %s, autor: %s, quantidade: %d\n", i + 1, livro.getTitulo(), livro.getAutor(),
                    livro.getQuantidade());
        }
    }

    public static void apagarLivro() {
        visualizarLivros();
        System.out.println("Selecione o livro que deseja excluir: ");
        int escolha = scan.nextInt() - 1;
        scan.nextLine();
        if (escolha >= livros.size() || escolha < 0) {
            System.out.println("Selecione um valor válido!");
            return;
        }
        livros.remove(escolha);
        System.out.println("Livro excluído com sucesso!");
    }

    public static void alterarLivro() {
        visualizarLivros();
        System.out.println("Selecione o livro que deseja alterar: ");
        int escolha = scan.nextInt() - 1;
        scan.nextLine();
        if (escolha >= livros.size() || escolha < 0) {
            System.out.println("Selecione um valor válido!");
            return;
        }
        Livro livro = livros.get(escolha);

        System.out.println("Digite o novo título: ");
        livro.setTitulo(scan.nextLine());
        System.out.println("Digite o novo autor: ");
        livro.setAutor(scan.nextLine());
        System.out.println("Digite a nova quantidade: ");
        livro.setQuantidade(scan.nextInt());
        scan.nextLine();
        System.out.println("Livro alterado com sucesso!");
    }
}