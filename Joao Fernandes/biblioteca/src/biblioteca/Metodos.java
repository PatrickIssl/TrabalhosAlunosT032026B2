package biblioteca;

import java.util.List;
import java.util.Scanner;

public class Metodos {

    public static void cadastrarProduto(List<String> produtos, List<String> autores, List<String> generos, List<Boolean> statusEmprestimo, Scanner scan) {
        System.out.println("Digite o nome do produto: ");
        produtos.add(scan.nextLine());
        
        System.out.println("Digite o autor do produto: ");
        autores.add(scan.nextLine());
        
        System.out.println("Digite o gênero do produto: ");
        generos.add(scan.nextLine());
        
        statusEmprestimo.add(false);
        
        System.out.println("Produto cadastrado com sucesso!");
    }

    public static void visualizarAcervo(List<String> produtos, List<String> autores, List<String> generos, List<Boolean> statusEmprestimo) {
        if (produtos.isEmpty()) {
            System.out.println("O acervo está vazio.");
            return;
        }
        
        System.out.println("\n--- Acervo ---");
        for (int i = 0; i < produtos.size(); i++) {
            String status = statusEmprestimo.get(i) ? "[Emprestado]" : "[Disponível]";
            System.out.println((i + 1) + " - Título: " + produtos.get(i) + " | Autor: " + autores.get(i) + " | Gênero: " + generos.get(i) + " " + status);
        }
    }

    public static void registrarEmprestimo(List<String> produtos, List<String> autores, List<String> generos, List<Boolean> statusEmprestimo, Scanner scan) {
        visualizarAcervo(produtos, autores, generos, statusEmprestimo);
        if (produtos.isEmpty()) return;

        System.out.println("Digite o número do produto para registrar o empréstimo: ");
        int escolha = scan.nextInt() - 1;
        scan.nextLine(); 

        if (escolha >= 0 && escolha < produtos.size()) {
            if (statusEmprestimo.get(escolha)) {
                System.out.println("Erro: Este produto já está emprestado.");
            } else {
                statusEmprestimo.set(escolha, true);
                System.out.println("Empréstimo registrado com sucesso!");
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }

    public static void registrarDevolucao(List<String> produtos, List<String> autores, List<String> generos, List<Boolean> statusEmprestimo, Scanner scan) {
        visualizarAcervo(produtos, autores, generos, statusEmprestimo);
        if (produtos.isEmpty()) return;

        System.out.println("Digite o número do produto para registrar a devolução: ");
        int escolha = scan.nextInt() - 1;
        scan.nextLine();

        if (escolha >= 0 && escolha < produtos.size()) {
            if (!statusEmprestimo.get(escolha)) {
                System.out.println("Erro: Este produto já está constando como disponível.");
            } else {
                statusEmprestimo.set(escolha, false);
                System.out.println("Devolução registrada com sucesso!");
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }

    public static void alterarProduto(List<String> produtos, List<String> autores, List<String> generos, int escolha, Scanner scan) {
        System.out.println("Nome atual: " + produtos.get(escolha));
        System.out.println("Digite o novo nome para o produto: ");
        produtos.set(escolha, scan.nextLine());
        
        System.out.println("Autor atual: " + autores.get(escolha));
        System.out.println("Digite o novo autor: ");
        autores.set(escolha, scan.nextLine());
        
        System.out.println("Gênero atual: " + generos.get(escolha));
        System.out.println("Digite o novo gênero: ");
        generos.set(escolha, scan.nextLine());
        
        System.out.println("Produto atualizado com sucesso!");
    }
}