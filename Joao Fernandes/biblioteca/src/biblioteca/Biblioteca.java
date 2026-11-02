package biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

	static Scanner scan = new Scanner(System.in);
	static List<String> produtos = new ArrayList<>();
	static List<String> autores = new ArrayList<>();
	static List<String> generos = new ArrayList<>();
	static List<Boolean> statusEmprestimo = new ArrayList<>();
	
	public static void main(String[] args) {
		mostrarMenu();
	}

    public static void mostrarMenu() {
        int escolhaUsuario = 0;

        do {
			System.out.println("\n---------------Sistema Estoque---------------");
			System.out.println("Selecione uma opção a seguir: ");
			System.out.println("1 - Cadastrar produto");
			System.out.println("2 - Visualizar Acervo");
			System.out.println("3 - Registrar Empréstimo");
			System.out.println("4 - Registrar Devolução");
            System.out.println("5 - Alterar produto");
			System.out.println("0 - Sair");
			
			escolhaUsuario = scan.nextInt();
			scan.nextLine();
			
			validarEscolha(escolhaUsuario);
			
        } while (escolhaUsuario != 0);
	}

    public static void validarEscolha(int escolhaUsuario) {
            switch (escolhaUsuario) {
                case 1:
                    Metodos.cadastrarProduto(produtos, autores, generos, statusEmprestimo, scan);
                    break;
                case 2:
                    Metodos.visualizarAcervo(produtos, autores, generos, statusEmprestimo);
                    break;
                case 3:
                    Metodos.registrarEmprestimo(produtos, autores, generos, statusEmprestimo, scan);
                    break;
                case 4:
                    Metodos.registrarDevolucao(produtos, autores, generos, statusEmprestimo, scan);
                    break;
                case 5:
                    alterarProduto();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Digite uma opção válida.");
                    break;
            }
    }
    
    public static void alterarProduto() {
		Metodos.visualizarAcervo(produtos, autores, generos, statusEmprestimo);
		if (produtos.isEmpty()) return;
		
		System.out.println("Selecione a opção que deseja alterar: ");
		int escolha = scan.nextInt() - 1;
		scan.nextLine();
		
		if(escolha >= produtos.size() || escolha < 0) {
			System.out.println("Selecione um valor válido!");
			return;
		}
		
		Metodos.alterarProduto(produtos, autores, generos, escolha, scan);
    }
}