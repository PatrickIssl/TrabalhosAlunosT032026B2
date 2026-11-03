package fag;

import java.util.Scanner;
import fag.objetos.Livro;
import java.util.ArrayList;
import java.util.List;

public class Principal 
{
	static Scanner scan = new Scanner(System.in);
	static List<Livro> livros = new ArrayList<Livro>();
	
	public static void main(String[] args)
	{
		menu();
	}
	
	public static void menu()
	{
		int escolha = 0;
		do 
		{
			System.out.println("\n---------------Sistema Biblioteca---------------");
			System.out.println("Selecione uma opção a seguir: ");
			System.out.println("1 - Cadastrar Livro");
			System.out.println("2 - Visualizar Estoque");
			System.out.println("3 - Emprestar livro");
			System.out.println("4 - Devolver livro");
			System.out.println("0 - Sair");
			escolha = scan.nextInt();
			scan.nextLine();
			validarEscolha(escolha);
		} while (escolha!= 0);
	}

	private static void validarEscolha(int escolha) 
	{
		switch (escolha) {
		case 1: 
		{
			cadastrarLivro();
			break;
		}
		case 2: 
		{
			estoque();
			break;
		}
		case 3:
		{
			emprestimo();
			break;
		}
		case 4:
		{
			devolver();
			break;
		}
		default:
		{
			System.out.println("Entre com uma opção válida");
		}
		}
	}


	private static void devolver() {
		
		System.out.println("\n---------------Livros Emprestados---------------");
		for (int i = 0; i < livros.size(); i++) {
			Livro livro = livros.get(i);
			
			if(livro.isEmprestado() == true)
			{
				System.out.printf("%d - %s, autor: %s, paginas: %d emprestado: %s\n",i+1, 
						livro.getTitulo(), livro.getAutor(), livro.getPaginas(), livro.isEmprestado() ? "Sim" : "Não");
				System.out.printf("Faltam %d para a devolução\n", livro.getdiasEmprestado());
			}
		}
			
			System.out.println("Qual livro foi devolvido?");
			int devolvido = scan.nextInt();
			scan.nextLine();
			
			Livro livro1 = livros.get(devolvido - 1);
			livro1.setEmprestado(false);
			livro1.setdiasEmprestado(0);
			
			System.out.println("Livro devolvido!");
		}
		
			
	

	private static void emprestimo() {
		estoque();

		System.out.println("Selecione o livro que será emprestado ");
		int escolha = scan.nextInt() - 1;
		scan.nextLine();
		if(escolha >= livros.size() || escolha < 0) {
			System.out.println("Selecione um valor válido");
			return;
		}
		
		Livro livro = livros.get(escolha);
		
		if (livro.isEmprestado()) {
		    System.out.println("Este livro já está emprestado!");
		    return;
		}
		
		System.out.println("Quantos dias será emprestado?");
		int dias = scan.nextInt();
		scan.nextLine();
		
		if(dias <= 0)
		{
			System.out.println("Coloque um valor valido");
			return;
		}
		
		livro.setEmprestado(true);
		livro.setdiasEmprestado(dias);
	}

	private static void estoque() {
		System.out.println();
		System.out.println("---------------Lista livros---------------");
		System.out.println();
		for (int i = 0; i < livros.size(); i++) {
			Livro livro = livros.get(i);
			System.out.printf("%d - %s, autor: %s, paginas: %d emprestado: %s\n",i+1, 
					livro.getTitulo(), livro.getAutor(), livro.getPaginas(), livro.isEmprestado() ? "Sim" : "Não");
			if(livro.isEmprestado() == true)
			{
				System.out.printf("Faltam %d para a devolução\n", livro.getdiasEmprestado());
			}
		}
		
	}

	private static void cadastrarLivro() 
	{
		System.out.println("Entre com o nome do livro: ");
		Livro livro = new Livro();
		
		livro.setTitulo(scan.nextLine());
		
		for (Livro LivroFor: livros) 
		{
			if(LivroFor.getTitulo().equals(livro.getTitulo())) 
			{
				System.out.println("Livro ja cadastrado!");
				return;
			}
		}
		
		System.out.println("Entre com o autor: ");
		livro.setAutor(scan.nextLine());
		
		System.out.println("Entre com o numero de paginas: ");
		livro.setPaginas(scan.nextInt());
		scan.nextLine();
		
		if(livro.getPaginas() < 0) 
		{
			System.out.println("Entre com uma quantidade válida de páginas");
			return;
		}
		
		
		livro.setEmprestado(false);
		livro.setdiasEmprestado(0);
		
		livros.add(livro);
		System.out.println("Total de livros cadastrados: " + livros.size());
		System.out.println("Livro adicionado com sucesso");
		
	}
	
}
