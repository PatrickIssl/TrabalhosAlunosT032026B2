package fag;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import fag.objetos.*;

public class Principal {

	static Scanner sc = new Scanner(System.in);
	static List<Livro> livros = new ArrayList<Livro>();
	
	
	public static void main(String[] args) {
	
		mostrarMenu();
		
	}


	public static void mostrarMenu() {
		
		int opc;
		
		do {
			System.out.println("--------------Sistema Biblioteca--------------");
			System.out.println("1 - Adicionar Livro");
			System.out.println("2 - Ver Todos os Livros");
			System.out.println("3 - Apagar Livros");
			System.out.println("4 - Alterar Livros");
			System.out.println("0 - Sair");
			opc = sc.nextInt();
			sc.nextLine();
			
			validarEscolha(opc);
			
		} while (opc != 0);
		

	}

	public static void validarEscolha(int opc) {
		switch (opc) {
		case 1: {
			adicionarLivro();
			break;
		}
		case 2: {
			verLivros();
			break;
		}
		case 3: {
			apagarLivro();
			break;
		}
		case 4: {
			alterarLivro();
			break;
		}
		case 0: {
			System.out.println("Obrigado por usar o sistema!");
			break;
		}
		default:
			System.out.println("Insira uma opção válida!");
		}
		
	}

	public static void alterarLivro() {

		verLivros();
		System.out.println("Qual livro deseja alterar ?");
		int escolha = sc.nextInt();
		sc.nextLine();
		System.out.println();
		if (escolha > livros.size() || escolha < 0){
			System.out.println("Insira um valor válido");
			return;
		}
		Livro livro = livros.get(escolha - 1);
		mostrarMenuDeAlteração(livro);


	}

	public static void mostrarMenuDeAlteração(Livro livro) {

		int opc = 0;

		do {
			System.out.println("Selecione a opção para alterar:");
			System.out.println("1 - Nome");
			System.out.println("2 - Preço");
			System.out.println("3 - Quantidade");
			System.out.println("0 - Sair");
			opc = sc.nextInt();
			sc.nextLine();
			alterarValor(livro,opc);

		}while (opc !=0);


	}

	public static void alterarValor(Livro livro,int opc) {

		switch (opc){

			case 1: {
				System.out.println("Digite o novo nome: ");
				livro.setNome(sc.nextLine());
				System.out.println("Nome alterado com sucesso!");
				break;
			}
			case 2: {
				System.out.println("Digite o novo preço:");
				livro.setPreco(sc.nextDouble());
				sc.nextLine();
				System.out.println("Preço alterado com sucesso!");
				break;
			}
			case 3: {
				System.out.println("Digite a nova quantidade:");
				livro.setPreco(sc.nextInt());
				sc.nextLine();
				System.out.println("Quantidade alterada com sucesso");
				break;
			}
			case 0: {
				System.out.println("Saindo Menu alteração ...\n");
				break;
			}
			default:{
				System.out.println("Digite uma opção válido");
			}

		}


	}

	public static void apagarLivro() {

		verLivros();
		System.out.println("Qual livro deseja apagar ?");
		int opc = sc.nextInt() - 1;
		sc.nextLine();

		if(opc > livros.size() || opc < 0){
			System.out.println("Livro não encontrado!");
			return;
		}
		Livro livro = livros.get(opc);
		System.out.printf("\nLivro selecionado: %s |Valor: %.2f |Quantidade: %d\n",livro.getNome(),livro.getPreco(),livro.getQuantidade());
		System.out.println("Deseja confirmar a exclusão ?: \n 1- Sim \n 2- Não");
		int confirm = sc.nextInt();
		sc.nextLine();
		if(confirm == 1){
			livros.remove(opc);
			System.out.println("Exclusão realizado com sucesso!");
		}
		else {
			System.out.println("Livro não excluido!");
		}

	}

	public static void verLivros() {

		System.out.println("--------------Livros--------------");
		for(int i=0;i<livros.size();i++){
			Livro livro = livros.get(i);
			System.out.printf("%d - %s |Valor: R$%.2f |Quantidade: %d\n\n", i+1, livro.getNome(),livro.getPreco(),livro.getQuantidade());
		}

	}


	public static void adicionarLivro() {
		
		Livro livro = new Livro();
		
		System.out.println("Digite o nome: ");
		livro.setNome(sc.nextLine());

		for(Livro livrofor: livros){
			if(livrofor.getNome().equals(livro.getNome())){
				System.out.println("O livro já existe");
				return;
			}
		}
		System.out.println("Digite o preço: ");
		livro.setPreco(sc.nextDouble());
		sc.nextLine();
		if (livro.getPreco() < 0){
			System.out.println("O valor do produto tem que ser menor do que zero");
			return;
		}

		System.out.println("Digite a quantidade: ");
		livro.setQuantidade(sc.nextInt());
		sc.nextLine();
		if(livro.getQuantidade() < 0){
			System.out.println("A quantidade tem que ser maior que zero");
			return;
		}

		livros.add(livro);
		System.out.println("Livro adicionado com sucesso!\n");
	}

}
